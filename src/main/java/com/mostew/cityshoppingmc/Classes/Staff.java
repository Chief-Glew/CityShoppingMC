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
public class Staff extends User
{

    private String position;
    private double salary;

    // Getters
    public String getPosition()
    {
        return position;
    }

    public double getSalary()
    {
        return salary;
    }

    // Setters
    public void setPosition(String position)
    {
        this.position = position;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    // Zero Constructor
    public Staff()
    {
        position = "";
        salary = 0.00;
    }

    // Overloaded Constructor
    public Staff(int id, String username, String password, String firstName,
            String lastName, String position, double salary)
    {
        super(id, username, password, firstName, lastName);
        this.position = position;
        this.salary = salary;
    }

    // Methods
    @Override
    public String displayGreeting()
    {
        return "Welcome Staff Member!";
    }
}
