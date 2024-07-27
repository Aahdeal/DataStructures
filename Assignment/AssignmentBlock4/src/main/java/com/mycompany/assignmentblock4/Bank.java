/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentblock4;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Bank {
    protected int ID;
    protected double value;
    
    public Bank(int ID, double value){
        this.ID = ID;
        this.value = value;
    }

    public int getID() {
        return ID;
    }

    public double getValue() {
        return value;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
}
