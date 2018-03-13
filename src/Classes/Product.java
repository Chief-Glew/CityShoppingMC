/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author 30137568
 */
public class Product
{

    private int productID;
    private String productName;
    private double price;
    private int stockLevel;

    //Getters and Setters
    public int getProductID()
    {
        return productID;
    }

    public String getProductName()
    {
        return productName;
    }

    public double getPrice()
    {
        return price;
    }

    public int getStockLevel()
    {
        return stockLevel;
    }

    public void setProductId(int productID)
    {
        this.productID = productID;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setStockLevel(int stockLevel)
    {
        this.stockLevel = stockLevel;
    }

    //Zero Constructor
    public Product()
    {
        productID = 0;
        productName = "";
        price = 0.00;
        stockLevel = 0;
    }

    public Product(int productID, String productName, double price, int stockLevel)
    {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    public Product(String productName, double price, int stockLevel)
    {
        this.productName = productName;
        this.price = price;
        this.stockLevel = stockLevel;
    }
}
