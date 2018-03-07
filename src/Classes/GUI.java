/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author mcarr
 */
public class GUI//final
{
   
   
    DBManager db = new DBManager();
    String error = "EMPTY1971";

    public boolean isEmpty(int index)
    {
        if (index < 0)
        {

            return true;
        }
        else
        {
            return false;
        }
    }
    public void success(JLabel label, Object obj, String action)
    {
        String name = obj.getClass().getName();
        switch (name)
        {
            case "Classes.Clothing":

                label.setText("Clothing has been " + action + ".");
                break;

            case "Classes.Footwear":

                label.setText("Footwear has been " + action + ".");
                break;

            case "Classes.OrderLine":
                label.setText("Orderline has been " + action + ".");
                break;

            case "Classes.Order":
                label.setText("Order has been " + action + ".");
                break;

            default:
                label.setText("Please select an object");
                break;
        }
    }
    public void warning(JLabel label, Object obj, String action)
    {
        
        String name = obj.getClass().getName();
        switch (name)
        {
            case "Classes.Clothing":

                label.setText("Please select clothing to be " + action + ".");
                break;

            case "Classes.Footwear":

                label.setText("Please select footwear to be " + action + ".");
                break;

            case "Classes.OrderLine":
                label.setText("Please select order line to be " + action + ".");
                break;

            case "Classes.Order":
                label.setText("Please select order to be " + action + ".");
                break;

            default:
                label.setText("Please select an object");
                break;
        }

    }

    public void renameColumn(JTable table, int index, String columnName)
    {
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setHeaderValue(columnName);
        th.repaint();
    }

    public void clearRows(int rowCount, DefaultTableModel dtm)
    {
        if (rowCount > 0)
        {
            dtm.setRowCount(0);
        }
    }

    public void populateClothes(String[] data, HashMap<Integer, Clothing> clothes, DefaultTableModel dtm, JTable table)
    {
        clearRows(dtm.getColumnCount(), dtm);
        for (int key : clothes.keySet())
        {
            data[0] = "" + clothes.get(key).getProductID();
            data[1] = "" + clothes.get(key).getProductName();
            data[2] = "" + clothes.get(key).getPrice();
            data[3] = "" + clothes.get(key).getStockLevel();
            data[4] = clothes.get(key).getMeasurement();

            dtm.addRow(data);
        }
        table.setModel(dtm);
    }

    public void populateShoes(String[] data, HashMap<Integer, Footwear> shoes, DefaultTableModel dtm, JTable table)
    {
        clearRows(dtm.getColumnCount(), dtm);
        for (int key : shoes.keySet())
        {
            data[0] = "" + shoes.get(key).getProductID();
            data[1] = "" + shoes.get(key).getProductName();
            data[2] = "" + shoes.get(key).getPrice();
            data[3] = "" + shoes.get(key).getStockLevel();
            data[4] = "" + shoes.get(key).getSize();

            dtm.addRow(data);
        }
        table.setModel(dtm);
    }

    public void populateOrderLines(String[] data, HashMap<Integer, OrderLine> orderLines, DefaultTableModel dtm, JTable table)
    {
        clearRows(dtm.getColumnCount(), dtm);
        for (int key : orderLines.keySet())
        {
            data[0] = "" + orderLines.get(key).getProduct().getProductID();
            data[1] = "" + orderLines.get(key).getProduct().getProductName();
            data[2] = "" + orderLines.get(key).getQuantity();
            data[3] = "£" + orderLines.get(key).getLineTotal();

            dtm.addRow(data);
        }

        table.setModel(dtm);
    }

    public void populateOrders(String[] data, HashMap<Integer, Order> orders, DefaultTableModel dtm, JTable table)
    {
        clearRows(dtm.getColumnCount(), dtm);
        for (int key : orders.keySet())
        {
            data[0] = "" + orders.get(key).getUsername();
            data[1] = "" + orders.get(key).getOrderId();
            data[2] = "" + orders.get(key).getOrderDate();
            data[3] = "£" + orders.get(key).getOrderTotal();
            data[4] = "" + orders.get(key).getStatus();

            dtm.addRow(data);
        }

        table.setModel(dtm);
    }

    public Clothing findClothing(JTable table)
    {
        Clothing cloth = new Clothing();
        int index = table.getSelectedRow();
        if (isEmpty(index) == false)
        {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            String productName = dtm.getValueAt(index, 1).toString();
            cloth = db.LoadClothing(productName);
            return cloth;
        }
        else
        {
            
            
            cloth.setProductName(error);
            return cloth;
        }
    }

    public Footwear findFootwear(JTable table)
    {
        Footwear shoe = new Footwear();
        int index = table.getSelectedRow();
        if (isEmpty(index) == false)
        {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            String productName = dtm.getValueAt(index, 1).toString();
            shoe = db.loadFootwear(productName);
            return shoe;
        }
        else
        {
            
            shoe.setProductName(error);
            return shoe;
        }

    }

    public OrderLine findOrderLine(JTable table)
    {
        OrderLine orderLine = new OrderLine();
        int index = table.getSelectedRow();
        if (isEmpty(index) == false)
        {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            String productName = dtm.getValueAt(index, 1).toString();
            orderLine = db.loadOrderLine(productName);
            
            return orderLine;
        }
        else
        {
            
            orderLine.setOrderName(error);
            return orderLine;
        }

    }

    public Order findOrder(JTable table)
    {
        Order order = new Order();
        int index = table.getSelectedRow();
        if (isEmpty(index) == false)
        {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            String date = dtm.getValueAt(index, 2).toString();
            order = db.loadOrder(date);
            return order;
        }
        else
        {
            order.setOrderDate(error);
            return order;
        }
    }
    
    public GUI()
    {
        
    }
}
