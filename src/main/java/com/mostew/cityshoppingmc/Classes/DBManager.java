/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostew.cityshoppingmc.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Morna
 */
public class DBManager
{

    private String url = "jdbc:ucanaccess://Data\\\\CityShopping.accdb";

    private String driver = "net.ucanaccess.jdbc.UcanaccessDriver";

    public void testConnection()
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            System.out.println("Test Suceeded");
        }

        catch (Exception ex)
        {
            System.out.println("Test failed");
        }
    }

    // CUSTOMERS DB
    // takes int a customer object and saves it
    public void saveCustomer(Customer cust)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO customers "
                    + "(username, password, firstName, lastName, "
                    + "addressLine1, addressLine2, town, postcode, isRegistered)"
                    + " VALUES('" + cust.getUsername() + "', '" + cust.getPassword() + "', '"
                    + cust.getFirstName() + "', '" + cust.getLastName() + "', '" + cust.getAddressline1()
                    + "', '" + cust.getAddressLine2() + "', '" + cust.getTown() + "', '" + cust.getPostcode()
                    + "', '" + cust.getIsRegistered() + "')");

            conn.close();
            System.out.println("Customer saved");

        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Customer not saved");
        }
    }
    // loads a customer object from passing in a username parameter
    public Customer loadCustomer(String cName)
    {
        Customer cust = new Customer();
        try
        {
            int id;
            String cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode;
            boolean cIsRegistered;
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT * FROM customers WHERE username = '" + cName + "'");
            while (rec.next())
            {
                id = rec.getInt("ID");
                cUsername = rec.getString("username");
                cPassword = rec.getString("password");
                cFirstName = rec.getString("firstName");
                cLastName = rec.getString("lastName");
                cAddressLine1 = rec.getString("addressLine1");
                cAddressLine2 = rec.getString("addressLine2");
                cTown = rec.getString("town");
                cPostcode = rec.getString("postcode");
                cIsRegistered = rec.getBoolean("isRegistered");

                cust = new Customer(id, cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode, cIsRegistered);
                cust.setId(id);
                //cust.setUsername(cUsername);
            }

            System.out.println("Customer is loaded");
        }

        catch (Exception ex)
        {
            System.out.println("No Customers to load");
            System.out.println(ex.getMessage());
        }

        return cust;

    }
    // loads the customers username
    public String loadCustomerUsername(int customerID)
    {
        String cUsername = "";

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT username FROM customers WHERE ID =  " + customerID);
            while (rec.next())
            {

                cUsername = rec.getString("username");

            }

            System.out.println("Customer is loaded");
            return cUsername;
        }

        catch (Exception ex)
        {
            System.out.println("No Customers to load");
            System.out.println(ex.getMessage());
        }

        return cUsername;

    }
    // loads all customers into a hashmap
    public HashMap<Integer, Customer> loadAllCustomers()
    {
        HashMap<Integer, Customer> customers = new HashMap<>();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            int id;
            String cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode;
            boolean cIsRegistered;
            Customer cust = new Customer();
            ResultSet rec = st.executeQuery("SELECT * FROM customers");
            while (rec.next())
            {
                id = rec.getInt("ID");
                cUsername = rec.getString("username");
                cPassword = rec.getString("password");
                cFirstName = rec.getString("firstName");
                cLastName = rec.getString("lastName");
                cAddressLine1 = rec.getString("addressLine1");
                cAddressLine2 = rec.getString("addressLine2");
                cTown = rec.getString("town");
                cPostcode = rec.getString("postcode");
                cIsRegistered = rec.getBoolean("isRegistered");

                cust = new Customer(id, cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode, cIsRegistered);
                customers.put(id, cust);
            }
            return customers;
        }

        catch (Exception e)
        {
            System.out.println("No Customers to load");
            System.out.println(e.getMessage());
            return customers;
        }

    }
    // loads all customers with their orders
    public HashMap<Integer, Customer> loadCustomersOrders()
    {
        HashMap<Integer, Customer> custs = new HashMap<>();
        DBManager db = new DBManager();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            int customerId;
            HashMap<Integer, Order> orders = new HashMap<>();
            String cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode;
            boolean cIsRegistered;

            ResultSet rec = st.executeQuery("SELECT * FROM customers");
            while (rec.next())
            {
                Customer cust = new Customer();
                customerId = rec.getInt("ID");
                cUsername = rec.getString("username");
                cPassword = rec.getString("password");
                cFirstName = rec.getString("firstName");
                cLastName = rec.getString("lastName");
                cAddressLine1 = rec.getString("addressLine1");
                cAddressLine2 = rec.getString("addressLine2");
                cTown = rec.getString("town");
                cPostcode = rec.getString("postcode");
                cIsRegistered = rec.getBoolean("isRegistered");

                cust.setUsername(cUsername);
                cust.setPassword(cPassword);
                cust.setFirstName(cFirstName);
                cust.setLastName(cLastName);
                cust.setAddressLine1(cAddressLine1);
                cust.setAddressLine2(cAddressLine2);
                cust.setTown(cTown);
                cust.setPostcode(cPostcode);
                cust.setIsRegistered(cIsRegistered);

                orders = db.loadAllOrdersForCustomer(customerId);
                cust.setOrders(orders);

                custs.put(customerId, cust);

                //custs.put(, cust);
            }
            System.out.println("Customers with orders loaded");
            return custs;

        }

        catch (Exception ex)
        {
            System.out.println("No Customers to load");
            System.out.println(ex.getMessage());
        }

        return custs;
    }
    // load customer using customer ID
    public Customer loadCustomer(int customerID)
    {
        Customer cust = new Customer();
        try
        {
            int id;
            String cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode;
            boolean cIsRegistered;
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT * FROM customers WHERE ID = " + customerID);
            while (rec.next())
            {
                id = rec.getInt("ID");
                cUsername = rec.getString("username");
                cPassword = rec.getString("password");
                cFirstName = rec.getString("firstName");
                cLastName = rec.getString("lastName");
                cAddressLine1 = rec.getString("addressLine1");
                cAddressLine2 = rec.getString("addressLine2");
                cTown = rec.getString("town");
                cPostcode = rec.getString("postcode");
                cIsRegistered = rec.getBoolean("isRegistered");

                cust = new Customer(id, cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode, cIsRegistered);
            }

            System.out.println("Customer is loaded");
        }

        catch (Exception ex)
        {
            System.out.println("No Customers to load");
            System.out.println(ex.getMessage());
        }

        return cust = new Customer();
    }
    // load all customers without orders
    public HashMap<String, Customer> loadCustomers()
    {
        HashMap<String, Customer> custs = new HashMap<>();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String cUsername, cPassword, cFirstName, cLastName, cAddressLine1, cAddressLine2, cTown, cPostcode;
            boolean cIsRegistered;

            ResultSet rec = st.executeQuery("SELECT * FROM customers");
            while (rec.next())
            {
                Customer cust = new Customer();

                cUsername = rec.getString("username");
                cPassword = rec.getString("password");
                cFirstName = rec.getString("firstName");
                cLastName = rec.getString("lastName");
                cAddressLine1 = rec.getString("addressLine1");
                cAddressLine2 = rec.getString("addressLine2");
                cTown = rec.getString("town");
                cPostcode = rec.getString("postcode");
                cIsRegistered = rec.getBoolean("isRegistered");

                cust.setUsername(cUsername);
                cust.setPassword(cPassword);
                cust.setFirstName(cFirstName);
                cust.setLastName(cLastName);
                cust.setAddressLine1(cAddressLine1);
                cust.setAddressLine2(cAddressLine2);
                cust.setTown(cTown);
                cust.setPostcode(cPostcode);
                cust.setIsRegistered(cIsRegistered);

                custs.put(cUsername, cust);

                //custs.put(, cust);
            }
            System.out.println("Customers loaded");
            return custs;

        }

        catch (Exception ex)
        {
            System.out.println("No Customers to load");
            System.out.println(ex.getMessage());
        }

        return custs;
    }
    // edit customers with the customer object parameter
    public void editCustomers(Customer cust)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE customers SET username = '" + cust.getUsername() + "', password = '" + cust.getPassword()
                    + "', firstName = '" + cust.getFirstName() + "', lastName = '" + cust.getLastName()
                    + "', addressLine1 = '" + cust.getAddressline1() + "' , addressLine2 = '" + cust.getAddressLine2()
                    + "', town = '" + cust.getTown() + "', postcode = '" + cust.getPostcode() + "' WHERE username = '" + cust.getUsername() + "'");

            System.out.println("Customer updated");
        }

        catch (Exception ex)
        {
            System.out.println("Customer not updated");
        }
    }
    // Delete customers with the customer parameter
    public void deleteCustomers(Customer cust)
    {
        try
        {
            DBManager db = new DBManager();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            HashMap<Integer, Order> orders = db.loadAllOrdersForCustomer(cust.getId());
            db.deleteAllOrderLines(cust, orders);
            db.deleteOrders(orders);
            //st.executeQuery("DELETE FROM customers WHERE username = '" + cust.getUsername() +"'");

            System.out.println("Customer deleted");
            conn.close();
        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Customer has not been deleted");
        }
    }
    // PRODUCTS DB
    // load product with the productName parameter
    public Product loadProduct(String prodName)
    {
        Product prod = new Product();

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            String cName;
            double cPrice;
            int cProductID, cStockLevel;

            ResultSet rec = st.executeQuery("SELECT ID, productName, price, stockLevel FROM Products WHERE productName = '" + prodName + "'");
            while (rec.next())
            {
                cProductID = rec.getInt("ID");
                cName = rec.getString("productName");
                cPrice = rec.getDouble("price");
                cStockLevel = rec.getInt("stockLevel");

                prod.setProductId(cProductID);
                prod.setProductName(cName);
                prod.setPrice(cPrice);
                prod.setStockLevel(cStockLevel);

            }

            System.out.println("Cloth loaded");
            return prod;
        }

        catch (Exception ex)
        {
            System.out.println("No Clothing to load");
            System.out.println(ex.getMessage());
        }

        return prod;
    }
    // edit product with the product object parameter
    public void editProducts(Product prod)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE Products SET productName = '" + prod.getProductName()
                    + "', price = '" + prod.getPrice() + "', stockLevel = '" + prod.getStockLevel()
                    + "' WHERE ID = '" + prod.getProductID() + "'");

            System.out.println("Product updated");
        }

        catch (Exception ex)
        {
            System.out.println("Product not updated");
        }
    }
    // save products with the product parameter
    public void saveProducts(Product prod)
    {

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO Products "
                    + "(productName, price, stockLevel)"
                    + " VALUES('" + prod.getProductName() + "', " + prod.getPrice()
                    + ", " + prod.getStockLevel() + ")");

            conn.close();

            System.out.println("Product saved");

        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Product not saved");
        }
    }
    // find productID with the product object paremeter
    public int prodId(Product prod)
    {
        int prodId = -1;
        try
        {

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT ID FROM products WHERE productName = '" + prod.getProductName() + "'");
            while (rec.next())
            {
                prodId = rec.getInt("ID");
                return prodId;

            }
            System.out.println("Product ID found.");

        }

        catch (Exception ex)
        {
            System.out.println(ex);
            System.out.println("Product ID could not be found");
            return -1;
        }

        return prodId;

    }

    // CLOTHING DB
    // save clothing with the clothing object parameter
    public void saveClothing(Clothing cloth)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO Products "
                    + "( productName, price, stockLevel, measurement)"
                    + " VALUES('" + cloth.getProductName() + "', " + cloth.getPrice()
                    + ", " + cloth.getStockLevel() + " , '" + cloth.getMeasurement() + "')");

        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Clothing not saved");
        }
    }
    // load a clothing object with productname
    public Clothing LoadClothing(String prodName)
    {
        Clothing cloth = new Clothing();

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            String cName, cMeasurement;
            double cPrice;
            int cProductID, cStockLevel;

            ResultSet rec = st.executeQuery("SELECT ID, productName, price, stockLevel, measurement FROM Products WHERE productName = '" + prodName + "'");
            while (rec.next())
            {
                cProductID = rec.getInt("ID");
                cName = rec.getString("productName");
                cPrice = rec.getDouble("price");
                cStockLevel = rec.getInt("stockLevel");
                cMeasurement = rec.getString("measurement");

                cloth.setProductId(cProductID);
                cloth.setProductName(cName);
                cloth.setPrice(cPrice);
                cloth.setStockLevel(cStockLevel);
                cloth.setMeasurement(cMeasurement);
            }

            System.out.println("Cloth loaded");
            return cloth;
        }

        catch (Exception ex)
        {
            System.out.println("No Clothing to load");
            System.out.println(ex.getMessage());
        }

        return cloth;
    }
    // load all clothing into a clothing hashmap
    public HashMap<Integer, Clothing> loadAllClothing()
    {
        HashMap<Integer, Clothing> clothes = new HashMap<>();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String cName, cMeasurement;
            double cPrice;
            int cProductID, cStockLevel;

            ResultSet rec = st.executeQuery("SELECT ID, productName, price, stockLevel, measurement FROM products WHERE size = 0");
            while (rec.next())
            {
                Clothing cloth = new Clothing();
                cProductID = rec.getInt("ID");
                cName = rec.getString("productName");
                cPrice = rec.getDouble("price");
                cStockLevel = rec.getInt("stockLevel");
                cMeasurement = rec.getString("measurement");

                cloth.setProductId(cProductID);
                cloth.setProductName(cName);
                cloth.setPrice(cPrice);
                cloth.setStockLevel(cStockLevel);
                cloth.setMeasurement(cMeasurement);
                clothes.put(cProductID, cloth);

                //custs.put(, cust);
            }
            System.out.println("Clothing loaded");
            return clothes;

        }

        catch (Exception ex)
        {
            System.out.println("No Clothing to load");
            System.out.println(ex.getMessage());
        }

        return clothes;
    }
    // Edit clothing using the clothing object parameter
    public void editClothing(Clothing cloth)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Products SET productName = '" + cloth.getProductName()
                    + "', price = '" + cloth.getPrice() + "', stockLevel = '" + cloth.getStockLevel()
                    + "', measurement = '" + cloth.getMeasurement() + "' WHERE ID = '" + cloth.getProductID() + "'");

            System.out.println("Clothing updated");
        }

        catch (Exception ex)
        {
            System.out.println("Clothing not updated");
        }
    }
    // delete clothing using the clothing object parameter
    public void deleteClothing(Clothing cloth)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            st.executeUpdate("DELETE from Products WHERE ID = '" + cloth.getProductID() + "'");
            System.out.println("Clothing deleted");
            conn.close();
        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Clothing has not been deleted");
        }
    }

    // FOOTWEAR DB
    // save footwear to the database using a footwear object parameter
    public void saveFootwear(Footwear shoe)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO Products "
                    + "(productName, price, stockLevel, size)"
                    + " VALUES('" + shoe.getProductName() + "', " + shoe.getPrice()
                    + ", " + shoe.getStockLevel() + " , " + shoe.getSize() + ")");

            System.out.println("Clothing saved");
        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Footwear not saved");
        }
    }
    // load footwear object using string product name parameter
    public Footwear loadFootwear(String prodName)
    {
        Footwear shoe = new Footwear();

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            String fName;
            double fPrice;
            int fProductID, fStockLevel, fSize;

            ResultSet rec = st.executeQuery("SELECT ID, productName, price, stockLevel, size FROM Products WHERE productName = '" + prodName + "'");
            while (rec.next())
            {
                fProductID = rec.getInt("ID");
                fName = rec.getString("productName");
                fPrice = rec.getDouble("price");
                fStockLevel = rec.getInt("stockLevel");
                fSize = rec.getInt("size");

                shoe.setProductId(fProductID);
                shoe.setProductName(fName);
                shoe.setPrice(fPrice);
                shoe.setStockLevel(fStockLevel);
                shoe.setSize(fSize);
            }

            System.out.println("Shoe loaded");
            return shoe;
        }

        catch (Exception ex)
        {
            System.out.println("No Shoe to load");
            System.out.println(ex.getMessage());
        }

        return shoe;
    }
    //Load all footwear from the database into a footwear hashmap
    public HashMap<Integer, Footwear> loadAllFootwear()
    {
        HashMap<Integer, Footwear> shoes = new HashMap<>();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String fName;
            double fPrice;
            int fProductID, fStockLevel, fSize;

            ResultSet rec = st.executeQuery("SELECT ID, productName, price, stockLevel, size FROM Products WHERE measurement IS NULL");
            while (rec.next())
            {
                Footwear shoe = new Footwear();
                fProductID = rec.getInt("ID");
                fName = rec.getString("productName");
                fPrice = rec.getDouble("price");
                fStockLevel = rec.getInt("stockLevel");
                fSize = rec.getInt("size");

                shoe.setProductId(fProductID);
                shoe.setProductName(fName);
                shoe.setPrice(fPrice);
                shoe.setStockLevel(fStockLevel);
                shoe.setSize(fSize);
                shoes.put(fProductID, shoe);

                //custs.put(, cust);
            }
            System.out.println("Footwear loaded");
            return shoes;

        }

        catch (Exception ex)
        {
            System.out.println("No Footwear to load");
            System.out.println(ex.getMessage());
        }

        return shoes;
    }
    // edit footwear by using a footwear object parameter
    public void editFootwear(Footwear shoe)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE Products SET productName = '" + shoe.getProductName()
                    + "', price = '" + shoe.getPrice() + "', stockLevel = '" + shoe.getStockLevel()
                    + "', size = '" + shoe.getSize() + "' WHERE ID = '" + shoe.getProductID() + "'");

            System.out.println("Clothing updated");
        }

        catch (Exception ex)
        {
            System.out.println("Clothing not updated");
        }
    }
    // delete footwear using an footwear object parameter
    public void deleteFootwear(Footwear shoe)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            st.executeUpdate("DELETE from Products WHERE ID = '" + shoe.getProductID() + "'");
            System.out.println("Footwear deleted");
            conn.close();
        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Footwear has not been deleted");
        }
    }
    // save an orderLine using a productId, productName quantity and line total
    public void saveOrderLine(int productId, String productName, int quantity, double lineTotal)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO OrderLines "
                    + "(productID, productName, quantity, lineTotal)"
                    + " VALUES(" + productId + ", '" + productName + "' , " + quantity + ", " + lineTotal + ")");

            conn.close();
            System.out.println("Order line saved");
        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Orderline not saved");
        }
    }
    // edit the orderID from the orderline table using orderId and ordername
    public void editOrderOlID(int orderId, String orderName)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE OrderLines SET orderID = " + orderId
                    + " WHERE productName = '" + orderName + "'");

            System.out.println("OrderID in OrderLines updated");
        }

        catch (Exception ex)
        {
            System.out.println("OrderID in OrderLines not updated");
            System.out.println(ex.getMessage());
        }

    }
    // edit the orderID from hashmap of orderlines from the orderLine ID
    public void editOrderOlsID(int orderID, HashMap<Integer, OrderLine> ols)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            for (OrderLine o : ols.values())
            {
                st.executeUpdate("UPDATE OrderLines SET orderID = " + orderID
                        + " WHERE ID = " + o.getOrderLineId() + "");
            }

            System.out.println("OrderID in OrderLines updated");
        }

        catch (Exception ex)
        {
            System.out.println("OrderID in OrderLines not updated");
            System.out.println(ex.getMessage());
        }

    }
    // load a hashmap of orderlines with no orderID value
    public HashMap<Integer, OrderLine> loadOrderLinesNoOrderID()
    {
        HashMap<Integer, OrderLine> ols = new HashMap<>();
        DBManager db = new DBManager();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            int orderLineId, productId, quantity, orderId;
            String productName;

            double lineTotal;
            Product prod = new Product();

            ResultSet rec = st.executeQuery("SELECT * FROM OrderLines WHERE orderID = 0");
            while (rec.next())
            {
                OrderLine ol = new OrderLine();
                orderLineId = rec.getInt("ID");
                productId = rec.getInt("productID");
                productName = rec.getString("productName");

                quantity = rec.getInt("quantity");
                lineTotal = rec.getDouble("lineTotal");
                orderId = rec.getInt("orderID");
                System.out.println(orderId);

                System.out.println(productName);
                prod = db.loadProduct(productName);
                prod.setProductId(productId);
                prod.setProductName(productName);
                ol.setProduct(prod);

                ol.setOrderLineId(orderLineId);
                ol.setOrderName(productName);

                ol.setQuantity(quantity);
                ol.setLineTotal(lineTotal);
                ol.setOrderId(orderId);
                System.out.println("OrderLine " + ol.getOrderName());
                System.out.println("Orderline loaded Id: " + ol.getOrderId());
                ols.put(orderLineId, ol);

            }

            System.out.println("OrderLines loaded");
            return ols;

        }

        catch (Exception ex)
        {
            System.out.println("No OrderLines to load");
            System.out.println(ex.getMessage());
        }

        return ols;
    }
    // load a hashmap of orderlines with a specific orderID
    public HashMap<Integer, OrderLine> loadAllOrderLinesOrderID(int orderID)
    {
        HashMap<Integer, OrderLine> ols = new HashMap<>();
        DBManager db = new DBManager();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            int orderLineId, productId, quantity;
            String productName;

            double lineTotal;
            Product prod = new Product();

            ResultSet rec = st.executeQuery("SELECT * FROM OrderLines WHERE orderID = " + orderID);
            while (rec.next())
            {
                OrderLine ol = new OrderLine();
                orderLineId = rec.getInt("ID");
                productId = rec.getInt("productID");
                productName = rec.getString("productName");

                quantity = rec.getInt("quantity");
                lineTotal = rec.getDouble("lineTotal");
                orderID = rec.getInt("orderID");

                prod = db.loadProduct(productName);
                ol.setProduct(prod);
                prod.setProductId(productId);
                prod.setProductName(productName);
                ol.setOrderLineId(orderLineId);
                ol.setOrderName(productName);
                ol.setQuantity(quantity);
                ol.setLineTotal(lineTotal);
                ol.setOrderId(orderID);

                ols.put(orderLineId, ol);

            }

            System.out.println("orderLines loaded");
            return ols;

        }

        catch (Exception ex)
        {
            System.out.println("loadAllOrderLinesOrderID() not loaded");
            System.out.println(ex.getMessage());
        }

        return ols;
    }
    // load a hashmap of orderlines with a specific orderID
    public HashMap<Integer, OrderLine> loadAllOrderLinesCust(int orderID)
    {
        HashMap<Integer, OrderLine> ols = new HashMap<>();
        DBManager db = new DBManager();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            int orderLineId, productId, quantity, orderId;
            String productName;

            double lineTotal;
            Product prod = new Product();

            ResultSet rec = st.executeQuery("SELECT * FROM OrderLines WHERE orderID IN (SELECT ID FROM orders WHERE orderID = " + orderID + ")");
            while (rec.next())
            {
                OrderLine ol = new OrderLine();
                orderLineId = rec.getInt("ID");
                productId = rec.getInt("productID");
                productName = rec.getString("productName");

                quantity = rec.getInt("quantity");
                lineTotal = rec.getDouble("lineTotal");
                orderId = rec.getInt("orderID");

                prod = db.loadProduct(productName);
                prod.setProductId(productId);
                prod.setProductName(productName);
                ol.setProduct(prod);

                ol.setOrderLineId(orderLineId);
                ol.setOrderName(productName);

                ol.setQuantity(quantity);
                ol.setLineTotal(lineTotal);
                ol.setOrderId(orderId);

                ols.put(orderLineId, ol);

            }

            System.out.println("loadAllOrderLinesCust() loaded");
            return ols;

        }

        catch (Exception ex)
        {
            System.out.println("loadAllOrderLinesCust() not loaded");
            System.out.println(ex.getMessage());
        }

        return ols;
    }
    // load all orderlines in the database into a hashmap
    public HashMap<Integer, OrderLine> loadAllOrderLines()
    {
        HashMap<Integer, OrderLine> ols = new HashMap<>();
        DBManager db = new DBManager();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            int orderLineId, productId, quantity, orderId;
            String productName;

            double lineTotal;
            Product prod = new Product();

            ResultSet rec = st.executeQuery("SELECT * FROM OrderLines");
            while (rec.next())
            {
                OrderLine ol = new OrderLine();
                orderLineId = rec.getInt("ID");
                productId = rec.getInt("productID");
                productName = rec.getString("productName");

                quantity = rec.getInt("quantity");
                lineTotal = rec.getDouble("lineTotal");
                orderId = rec.getInt("orderID");

                prod = db.loadProduct(productName);
                ol.setProduct(prod);

                ol.setOrderLineId(orderLineId);
                ol.setOrderName(productName);

                ol.setQuantity(quantity);
                ol.setLineTotal(lineTotal);
                ol.setOrderId(orderId);

                ols.put(orderLineId, ol);

            }

            System.out.println("OrderLines loaded");
            return ols;

        }

        catch (Exception ex)
        {
            System.out.println("No OrderLines to load");
            System.out.println(ex.getMessage());
        }

        return ols;
    }
    // load an orderline object using ordername
    public OrderLine loadOrderLine(String orderName)
    {
        OrderLine orderLine = new OrderLine();
        DBManager db = new DBManager();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            int orderLineId, productId, quantity, orderId;

            double lineTotal;
            Product prod = new Product();

            ResultSet rec = st.executeQuery("SELECT * FROM OrderLines WHERE productName = '" + orderName + "'");
            while (rec.next())
            {

                orderLineId = rec.getInt("ID");
                productId = rec.getInt("productID");
                orderName = rec.getString("productName");

                quantity = rec.getInt("quantity");
                lineTotal = rec.getDouble("lineTotal");
                orderId = rec.getInt("orderID");

                prod = db.loadProduct(orderName);
                orderLine = new OrderLine(orderLineId, prod, quantity, lineTotal, orderId);
                orderLine.setProduct(prod);

            }

            System.out.println("OrderLines loaded");
            return orderLine;

        }

        catch (Exception ex)
        {
            System.out.println("No OrderLines to load");
            System.out.println(ex.getMessage());
        }

        return orderLine;
    }


    // delete an orderline from the database using an orderline object parameter
    public void deleteOrderLine(OrderLine ol)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            st.executeUpdate("DELETE from OrderLines WHERE ID = '" + ol.getOrderLineId() + "'");

            conn.close();
        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Orderline has not been deleted");
        }

        System.out.println("OrderLine deleted");
    }
    // load a hashmap of completed orders from the database using a customer object and a hashmap of orders
    public HashMap<Integer, Order> findCustCompleteOrderLines(Customer cust, HashMap<Integer, Order> orders)
    {
        HashMap<Integer, OrderLine> orderLines = new HashMap<>();
        try
        {
            DBManager db = new DBManager();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT ID, orderTotal, status orderDate  FROM orders WHERE status = 'Complete' AND customerID = " + cust.getId());
            while (rec.next())
            {

                int orderId = rec.getInt("ID");
                double orderTotal = rec.getDouble("orderTotal");
                String date = rec.getString("orderDate");
                String status = rec.getString("status");
                Order order = new Order(orderId, date, cust.getUsername(), orderTotal, status);
                orders.put(orderId, order);

            }
            System.out.println("Complete OrderLines found ");
            return orders;

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Complete OrderLines not found");
            System.out.println("findCustCompleteOrderLines()");
        }
        return orders;
    }
    // load a hashmap of completed orders from the database using a customer object and a hashmap of orders
    public HashMap<Integer, Order> findCustIncompleteOrderLines(Customer cust, HashMap<Integer, Order> orders)
    {
        HashMap<Integer, OrderLine> orderLines = new HashMap<>();
        try
        {
            DBManager db = new DBManager();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();

            ResultSet rec = st.executeQuery("SELECT ID, orderTotal, status orderDate  FROM orders WHERE status = 'Incomplete' AND customerID = " + cust.getId());
            while (rec.next())
            {
                //int orderId, String orderDate, String username, double orderTotal, String status
                int orderId = rec.getInt("ID");
                double orderTotal = rec.getDouble("orderTotal");
                String date = rec.getString("orderDate");
                String status = rec.getString("status");
                Order order = new Order(orderId, date, cust.getUsername(), orderTotal, status);
                orders.put(orderId, order);

            }
            System.out.println("Incomplete OrderLines found ");

            //"(SELECT o.ID FROM [Orders] o WHERE o.ID = ol.orderID AND o.status = 'Incomplete' AND o.customerID = " + cust.getId()+ ") FROM OrderLines ol");      
            // + "FROM OrderLines WHERE orderID IN 
//        ResultSet rec = st.executeQuery("SELECT * FROM OrderLines WHERE ol.orderID IN "
//                                    + "(SELECT orderID FROM Orders "
//                                    + "WHERE status = 'Incomplete' AND customerID = " + cust.getId()+ ")");
//        ResultSet rec = st.executeQuery("SELECT OrderLines.ID, OrderLines.productName, OrderLines.quantity, OrderLines.linetotal, OrderLines.orderID " +
//                                        "FROM OrderLines ON Orders JOIN OrderLines.orderID = Orders.ID"
//                                      + "WHERE Orders.status = 'Incomplete' AND Orders.customerID = " + cust.getId());
//            int orderLineID = rec.getInt("ID");
//            int quantity = rec.getInt("quantity");
//            String productName = rec.getString("productName");
//            Product prod = db.loadProduct(productName);
//            double lineTotal = rec.getDouble("lineTotal");
//            int orderId = rec.getInt("orderID");
//            OrderLine orderLine = new OrderLine(orderLineID,prod,quantity,lineTotal, orderId);
//            orderLines.put(orderLineID, orderLine);
            return orders;

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Incomplete OrderLines not found \n" + ex.getMessage());
            System.out.println("findCustIncompleteOrderLines()");
        }
        return orders;
    }
    // deletes all orderlines specific to a particular customer
    // uses findCompleteOrderlines and findIncompleteOrderlines
    // with the incomplete orderline the quanity that got taken is put back in the stock
    public void deleteAllOrderLines(Customer cust, HashMap<Integer, Order> orders)
    {
        try
        {
            HashMap<Integer, OrderLine> orderLines = new HashMap<>();
            DBManager db = new DBManager();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            HashMap<Integer, Order> incompleteOrders = db.findCustIncompleteOrderLines(cust, orders);
            for (Order order : incompleteOrders.values())
            {
                orderLines = db.loadAllOrderLinesCust(order.getOrderId());
            }
            for (OrderLine orderLine : orderLines.values())
            {
                Product prod = orderLine.getProduct();
                int newStock = orderLine.getProduct().getStockLevel() + orderLine.getQuantity();
                prod.setStockLevel(newStock);
                db.editProducts(prod);
                st.executeUpdate("DELETE from OrderLines WHERE orderID = " + orderLine.getOrderId());
            }

            System.out.println("Incomplete orders deleted");
            HashMap<Integer, Order> completeOrders = db.findCustCompleteOrderLines(cust, orders);
            for (Order order : completeOrders.values())
            {
                orderLines = db.loadAllOrderLinesCust(order.getOrderId());
            }
            for (OrderLine orderLine : orderLines.values())
            {

                st.executeUpdate("DELETE from OrderLines WHERE orderID = " + orderLine.getOrderId());
            }

            System.out.println("Complete orders deleted");
        }

        catch (Exception ex)
        {
            System.out.println("Deleting all customer orders failed \n" + ex.getMessage());
            System.out.println("deleteAllOrderLines()");
        }
    }
    // daves an order using the order object and customer ID
    public void saveOrders(Order order, int customerId)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO Orders "
                    + "(customerID, orderDate, orderTotal, status)"
                    + " VALUES(" + customerId + ", '" + order.getOrderDate() + "', " + order.getOrderTotal() + " , '" + order.getStatus() + "')");

            conn.close();
            System.out.println("Order line saved");
        }

        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    // load an order object using the parameter date
    public Order loadOrder(String date)
    {
        DBManager db = new DBManager();
        Order order = new Order();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            HashMap<Integer, OrderLine> orderLines = new HashMap<>();
            int orderID, custID;

            Customer cust = new Customer();
            double total = 0.00;
            String status = "";
            ResultSet rec = st.executeQuery("SELECT * FROM Orders WHERE orderDate = '" + date + "'");
            while (rec.next())
            {
                orderID = rec.getInt("ID");
                custID = rec.getInt("customerID");
                date = rec.getString("orderDate");
                total = rec.getDouble("orderTotal");
                status = rec.getString("status");
                String username = db.loadCustomerUsername(custID);
                orderLines = db.loadAllOrderLinesOrderID(orderID);
                order = new Order(orderID, date, username, total, status);
            }

            return order;
        }

        catch (Exception ex)
        {
            System.out.println("Order id not found");
            System.out.println(ex.getMessage());
        }
        return order;

    }
    // loads all orders to a hashmap of orders
    public HashMap<Integer, Order> loadAllOrders()
    {
        HashMap<Integer, Order> orders = new HashMap<>();
        DBManager db = new DBManager();
        try
        {
            int orderID, custID;
            Customer cust = new Customer();
            String date;
            double total;
            String status;
            HashMap<Integer, OrderLine> orderLines = new HashMap<>();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT ID, customerID, orderDate, orderTotal, status FROM Orders ");

            while (rec.next())
            {
                orderID = rec.getInt("ID");
                custID = rec.getInt("customerID");
                date = rec.getString("orderDate");
                total = rec.getDouble("orderTotal");
                status = rec.getString("status");

                orderLines = db.loadAllOrderLinesOrderID(orderID);

                String username = db.loadCustomerUsername(custID);
                Order order = new Order(orderID, date, username, total, status);
                order.setOrderLines(orderLines);
                orders.put(orderID, order);
            }
            System.out.println("Orders loaded");
            return orders;
        }

        catch (Exception ex)
        {
            System.out.println("Orders not loaded");
            System.out.println(ex.getMessage());
        }

        return orders;
    }
    // loads all orders for a customer uses the parameter customerID
    public HashMap<Integer, Order> loadAllOrdersForCustomer(int customerID)
    {
        HashMap<Integer, Order> cOrders = new HashMap<>();
        DBManager db = new DBManager();
        try
        {
            int orderID, custId;
            String date;
            Customer cust = new Customer();
            double total = 0.00;
            String status = "";
            HashMap<Integer, OrderLine> orderLines = new HashMap<>();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rec = st.executeQuery("SELECT ID, customerID, orderDate, orderTotal, status FROM Orders WHERE customerID = " + customerID);

            while (rec.next())
            {
                orderID = rec.getInt("ID");
                custId = rec.getInt("customerID");
                date = rec.getString("orderDate");
                total = rec.getDouble("orderTotal");
                status = rec.getString("status");
                orderLines = db.loadAllOrderLinesOrderID(orderID);
                String username = db.loadCustomerUsername(customerID);
                System.out.println(username);
                Order order = new Order(orderID, date, username, total, status);
                order.setOrderLines(orderLines);
                cOrders.put(orderID, order);
            }
            System.out.println("loadAllOrdersForCustomer()loaded");

            return cOrders;
        }

        catch (Exception ex)
        {
            System.out.println("loadAllOrdersForCustomer() not loaded");
            System.out.println(ex.getMessage());
        }

        return cOrders;
    }
    // deletes orders using a hashmap of orders
    public void deleteOrders(HashMap<Integer, Order> orders)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            for (Order order : orders.values())
            {
                st.executeUpdate("DELETE from Orders WHERE ID = " + order.getOrderId());

            }
            System.out.println("Orders deleted");
        }

        catch (Exception e)
        {
            System.out.println("Orders deleted");
            e.getMessage();
        }

    }

}
