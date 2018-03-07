/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author mcarr
 */
public class Order 
{
    private int orderId;
    private String orderDate;
    private double orderTotal;
    private String status;
    public String username;
    private HashMap <Integer, OrderLine> orderLines;

    public int getOrderId() 
    {
        return orderId;
    }

    public void setOrderId(int orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderDate() 
    {
        return orderDate;
    }

    public void setOrderDate(String orderDate) 
    {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() 
    {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) 
    {
        this.orderTotal = orderTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setCustomer(String username)
    {
        this.username = username;
    }

    public HashMap<Integer, OrderLine> getOrderLines() 
    {
        return orderLines;
    }
    
    public String toString()
    {
        NumberFormat decFormat = new DecimalFormat("#0.00");
        String sFormat = decFormat.format(orderTotal);
        return "Username: " + username + "| OrderID: " + orderId +"| Date: " + orderDate + "| Order Total: £" + sFormat;
    }
    
    
    public void setOrderLines(HashMap<Integer, OrderLine> orderLines) 
    {
        this.orderLines = orderLines;
    }
    public Order()
    {
        orderId = 0;
        orderDate = "";
        orderTotal = 0.00;
        status = "";
        
    }
    public Order(int orderId, Date orderDate, double orderTotal, String status) 
    {
        this.orderId = orderId;
        this.orderDate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(orderDate);
        this.orderTotal = orderTotal;
        this.status = status;
    }
    
     public Order(int orderId, String orderDate, String username, double orderTotal, String status) 
    {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.username = username;
        this.orderTotal = orderTotal;
        this.status = status;
    }
    
    public Order(Date orderDate, double orderTotal, String status)
    {
        this.orderDate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(orderDate);
        this.orderTotal = orderTotal;
        this.status = status;
    }
    
    
}
