/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostew.cityshoppingmc.Classes;

/**
 *
 * @author 30137568
 */
public class Clothing extends Product
{

    private String measurement;

    //Getters and Setters
    public String getMeasurement()
    {
        return measurement;
    }

    public void setMeasurement(String measurement)
    {
        this.measurement = measurement;
    }

    //Zero Constructor
    public Clothing()
    {
        measurement = "";
    }

    public Clothing(int productID, String productName, double price, int stockLevel, String measurement)
    {
        super(productID, productName, price, stockLevel);
        this.measurement = measurement;
    }

    public Clothing(String productName, double price, int stockLevel, String measurement)
    {
        super(productName, price, stockLevel);
        this.measurement = measurement;
    }


}
