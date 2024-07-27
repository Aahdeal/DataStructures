/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentblock4;

import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Server {
    protected double serviceTime;
    protected double averageST;
    protected double serviceEnd;
    protected boolean available;
    protected char ID;
    protected Client client;
            //Constructor
    public Server(char ID){
        this.ID = ID;
        client = null;
        available = true;
    }
            //Getters and Setters
    public Client getClient() {
        return client;
    }

    public double getAverageST() {
        return averageST;
    }

    public void setAverageST(double averageST) {
        this.averageST = averageST;
    }
    

    public char getID() {
        return ID;
    }

    public void setID(char ID) {
        this.ID = ID;
    }

    
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }  

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public double getServiceEnd() {
        return serviceEnd;
    }
        //Method to start serving
    public void startServing(Client client, int time, Queue<Client> waitList){
        this.client = client;
        available = false;  //sets server status to unavailable
        client.setServiceStart(time);   //sets clients serviceStart 
        serviceEnd = time + serviceTime; //sets time for service to end
        //iterator to print current queue after sservice starts
        System.out.print("\tClient Queue: [ ");
        for (Iterator<Client> it = waitList.iterator(); it.hasNext();) {
            int ID = it.next().getID(); 
            System.out.print("#"+ID +" ");
        }
        System.out.print("]\n");
        
        System.out.println("Server " + ID + " started serving Client #" + client.getID() + " at time "+time);
    } 
        //method to stop serving
    public void stopServing( int time){
        client.setServiceEnd((int) serviceEnd); //sets the clients service end
        available = true; //this server becomes available
        if (time == client.getServiceEnd()){ //checks if its time for service to end
            System.out.println("Server " + ID + " stopped serving Client #" + client.getID() + " at time "+time);
            this.client = null; //rempves client from this server
        }
    } 
}
