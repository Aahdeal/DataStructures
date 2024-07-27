/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentblock4;
/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Client {
    protected int arrivalTime;
    protected int serviceStart;
    protected int serviceEnd;
    protected int ID;
    protected int nextArrival;
    protected int interArrivalTime;
    //Constructor
    public Client(int ID, int nextArrival){
        this.ID = ID;
        arrivalTime = nextArrival;
        System.out.println("#" + ID + " arrived at time "+ arrivalTime);
    }
    //getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void setTime(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    
    public int getArrivalTime(){
        return arrivalTime;
    }

    public int getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(int serviceStart) {
        this.serviceStart = serviceStart;
    }

    public int getServiceEnd() {
        return serviceEnd;
    }

    public void setServiceEnd(int serviceEnd) {
        this.serviceEnd = serviceEnd;
    }  
}
