/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentblock4;

import java.util.Queue;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Question2 {
    //Creating random number generators
    static SecureRandom rndServer = new SecureRandom();
    static SecureRandom rndClient = new SecureRandom();
    
    public static void main(String[] args){
        //instantiating compulsory values
        final int numServers = 3;
        final int numClients = 12;
        final int meanServiceTime = 25;
        final int interArrivalTime = 4;
        //creating and instantiating variables to be used
        int t =0; //time
        int nextArrival = 0; //next client arrival time
        int clientsArrived = 1;   //numm of clients arrived
        char ID = 'A'; //server ID
        //creating client and server array
        Server[] server = new Server[numServers];
        Client[] client = new Client[numClients];
        //creating client queue
        Queue<Client> waitList = new LinkedList<>();
        //display
        System.out.println("Number of servers:\t\t" + numServers);
        System.out.println("Number of clients:\t\t" + numClients);
        System.out.println("Mean service time:\t\t" + meanServiceTime);
        System.out.println("Mean intervarrival time:\t" + interArrivalTime);
        //setting time for first arrival
        nextArrival += rndClient.nextExponential()*interArrivalTime;
        //for loop to add servers
        for(int i = 0; i<numServers; i++){
            Server thisServer = new Server(ID);
            server[i]= thisServer;  //adds to server array
            thisServer.setAverageST(rndServer.nextExponential()*meanServiceTime); //sets average service time for this server
            System.out.printf("%s%c%s%2.1f%n","Mean service time for Server ",ID,": ",thisServer.getAverageST() );
            ID++; //increments ID
        }
        //while loop for client arrivals Question 2.1
        do{
            if(t == nextArrival){ //if time = client arriving now
                newClient(clientsArrived, nextArrival, waitList, client); //add client to waitlist
                clientsArrived++; //increment amount of clients arrived
                nextArrival += rndClient.nextExponential()*interArrivalTime; //set next arrival time
                updateServer(t, numServers, meanServiceTime, server, waitList); //update server
                t++; //increase time
            }
            else {t++;} //if not time for client to arrive, increment time
            updateServer(t, numServers, meanServiceTime, server, waitList); //checls queue and updates if necessary
            stopService(t, numServers, server);  //checks time and stops service if necessary         
        }while(clientsArrived <= numClients); //end of while loop
        //while loop to check if clients are still waiting
        while(!waitList.isEmpty()){
            updateServer(t, numServers, meanServiceTime, server, waitList); //checls queue and updates if necessary
            stopService(t, numServers, server); //checks time and stops service if necessary 
            t++; //increments time
        }   
        //checks if any servers arent available
        double x = t;
        for(int i = 0; i < numServers;i++){
            if(!server[i].isAvailable()){
                x = server[i].getServiceEnd();
                break;
            }
        }
        //stops the server when their service is done
        while(t <= x){
            stopService(t,numServers,server);
            t++;
        }
        
    }
    //iterator to print the items in the queue
    public static void printQueue(Queue<Client> waitList){
        System.out.print("\tClient Queue: [ ");
        for (Iterator<Client> it = waitList.iterator(); it.hasNext();) {
            int ID = it.next().getID(); 
            System.out.print("#"+ID +" ");
        }
        System.out.print("]\n");
    }
    //update server method
    public static void updateServer(int t, int numServers, int meanServiceTime, Server[] server, Queue<Client> waitList){
        for(int i =0; i < numServers; i++){ //loops through server
            if((server[i].isAvailable())&&(waitList.peek()!=null)){ //finds available server and checks if the list isnt empty
               server[i].setServiceTime((int) (rndServer.nextExponential()*meanServiceTime)); //sets service time
               server[i].startServing(waitList.poll(), t, waitList); //starts serving
               break;
            }
        }
    }
    //method to add client to waitlist
    public static void newClient(int clientsArrived, int nextArrival, Queue<Client> waitList, Client[] client){               
        Client currentClient = new Client(clientsArrived, nextArrival); 
        client[clientsArrived-1] = currentClient; // add to array
        waitList.offer(currentClient);         // adds client to waitlist
        printQueue(waitList);                    // prints waitlist
    }
    //method to stop serving
    public static void stopService(int t, int numServers, Server[] server){
        for(int i =0; i < numServers; i++){ //loops through servers
            if(!server[i].isAvailable()){ //checks if not available
                if(server[i].getServiceEnd() == t){ //if time = when service ends
                   server[i].stopServing(t); //stops service
                   server[i].setAvailable(true); //sets server to available
               }
            }
        }            
    }    
    }

