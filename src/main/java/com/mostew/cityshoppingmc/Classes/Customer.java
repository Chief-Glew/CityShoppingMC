/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostew.cityshoppingmc.Classes;

import java.util.HashMap;

/**
 *
 * @author 30137568
 */
public class Customer extends User
{

    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private Order order;
    private HashMap<Integer, Order> orders;
    private boolean isRegistered;

    //Getters
    public String getAddressline1()
    {
        return addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public String getTown()
    {
        return town;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public HashMap<Integer, Order> getOrders()
    {
        return orders;
    }

    public boolean getIsRegistered()
    {
        return isRegistered;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public void setTown(String town)
    {
        this.town = town;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public void setOrders(HashMap<Integer, Order> orders)
    {
        this.orders = orders;
    }

    public void setIsRegistered(boolean isRegistered)
    {
        this.isRegistered = isRegistered;
    }

    public Customer()
    {
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";
        isRegistered = false;
    }

    public Customer(int id, String username, String password, String firstName,
            String lastName, String addressLine1, String addressLine2,
            String town, String postcode, boolean isRegistered)
    {
        super(id, username, password, firstName, lastName);
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.postcode = postcode;
        this.isRegistered = isRegistered;
    }

    //Methods
    @Override
    public String displayGreeting()
    {
        return "Welcome Customer!";
    }

    public void addOrder(Order o)
    {
        if (orders.containsKey(o.getOrderId()))
        {
            System.out.println("There is already an order with this order number. Cannot be added.");

        }

        else
        {
            orders.put(o.getOrderId(), o);
            System.out.println("Order added");
        }
    }

}
