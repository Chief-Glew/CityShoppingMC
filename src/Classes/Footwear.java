/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import StaffGUI.*;
/**
 *
 * @author 30137568
 */
public class Footwear extends Product
{
    private int size;
    
    //Getters and Setters
    public int getSize()
    {
        return size;
    }
    
    public void setSize(int size)
    {
        this.size = size;
    }
    
    //Zero Constructor
    public Footwear()
    {
        size = 0;
    }
    
    public Footwear(int productID, String productName, double price, int stockLevel, int size)
    {
        super(productID, productName, price, stockLevel);
        this.size = size;
    }
    
    public Footwear(String productName, double price, int stockLevel, int size)
    {
        super(productName, price, stockLevel);
        this.size = size;
    }
    

    @Override
    //Changes the output for toString()
    public String toString()
{
    return "ID: " + super.getProductID() + "| Name: " +super.getProductName()+ "| Price:" + super.getPrice() + "| StockLevel: " + super.getStockLevel() + "| Size: " + size;
}
            
}
