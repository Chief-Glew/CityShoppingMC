/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author mcarr
 */
public class OrderLine 
{
    private int orderLineId;
    private String orderName;
    private Product product;
    private boolean isClothing;
    private int quantity;
    private double lineTotal;
    private int orderId;

 
    public int getOrderLineId() 
    {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) 
    {
        this.orderLineId = orderLineId;
    }
    
    
    public String getOrderName()
    {
        return orderName;
    }
    
    public void setOrderName(String orderName)
    {
        this.orderName = orderName;
    }
//    public boolean getIsClothing()
//    {
//        return isClothing;
//    }
//    
//    public void setIsClothing(boolean isClothing)
//    {
//        this.isClothing = isClothing;
//    }
    
    public Product getProduct()
    {
        return product;
    }
    
    public void setProduct(Product product)
    {
        this.product = product;
    }
    

    
    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public double getLineTotal() 
    {
        return lineTotal;
    }

    public void setLineTotal(double lineTotal) 
    {
        this.lineTotal = lineTotal;
    }
    
    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }
    
    public int getOrderId()
    {
        return orderId;
    }
    
    public OrderLine()
    {
        orderLineId = 0;
        product = new Product();
        isClothing = false;
        quantity = 0;
        lineTotal = 0.00;
    }
    
/*String orderName,
    boolean isClothing
    */
   
    public OrderLine(int orderLineId, Product product, int quantity, double lineTotal, int orderId) 
    {
        this.orderLineId = orderLineId;
        this.orderName = orderName;
        this.product= product;
        this.isClothing = isClothing;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
        this.orderId = orderId;
    }
    

     
        public OrderLine(String orderName, Product product, boolean isClothing, int quantity, double lineTotal) 
    {
        this.orderName = orderName;
        this.product = product;
        this.isClothing = isClothing;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }
        
    public OrderLine(int orderLineId,Product product,  int quantity, double lineTotal) 
    {
        this.orderLineId = orderLineId;
        this.orderName = orderName;
        this.product = product;
        this.isClothing = isClothing;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }
    

     

    //Changes the output for toString()
    public String toString()
    {
           return "Product ID:" + product.getProductID() +  " |Name: " +
                    orderName + "|Price: " + product.getPrice() + "|Quantity: " + quantity + "|Total: " + lineTotal;
    }
    
    
}
