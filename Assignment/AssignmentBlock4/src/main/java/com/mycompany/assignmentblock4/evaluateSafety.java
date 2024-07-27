    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentblock4;

import java.util.LinkedList;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class evaluateSafety {
    protected int n;
    protected int limit;
    double[][] borrowers = new double[5][6];
    Bank[] bank = new Bank[5];
    
    public evaluateSafety(int n, int limit, Bank[] bank, double[][] borrowers){
        this.n = n;
        this.limit = limit;
        this.bank = bank;
        this.borrowers = borrowers;
    }

    public void setBorrowers() {
       borrowers[0][0] = 25;
       borrowers[0][1] = 100.5;
       borrowers[0][4] = 320.5;
       borrowers[1][1] = 125;
       borrowers[1][3] = 85;
       borrowers[1][2] = 40;
       borrowers[2][2] = 175;
       borrowers[2][0] = 125;
       borrowers[2][3] = 75;
       borrowers[3][3] = 75;
       borrowers[3][0] = 125;
       borrowers[4][4] = 181;
       borrowers[4][2] = 125;
    }

    public Bank[] getBank() {
        return bank;
    }

    public void setBank() {
       bank[0] = new Bank(0,0);
       bank[1] = new Bank(1,0);
       bank[2] = new Bank(2,0);
       bank[3] = new Bank(3,0);
       bank[4] = new Bank(4,0);
    }
  
    public void setN(int n) {
        this.n = n;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getN() {
        return n;
    }

    public int getLimit() {
        return limit;
    }
    
    public void evaluate(){
       evaluateSafety test = new evaluateSafety(5, 201, bank, borrowers);
       
       for (int i = 0; i < n; i++){
               for (int j=0; j<n; j++){          
               bank[i].setValue(bank[i].getValue()+borrowers[i][j]);
           }
           test.handleUnsafe(limit, n, test.getBank()[i].getValue(), test.getBank()[i].getID());
       }
       
       String unsafe = "Unsafe banks are ";
       
       for (int i = 0; i < n; i++){
           bank[i].setValue(0);
           for (int j=0;j<n;j++){
               bank[i].setValue(bank[i].getValue()+borrowers[i][j]);
           }
           if (bank[i].getValue()<limit){
               unsafe += bank[i].getID() + " ";
           }
       }
       System.out.println(unsafe);
    }
    
    public int handleUnsafe(int limit, int n, double value, int i){
            if(value<limit){
                for(int x = 0; x<n;x++){
                   borrowers[x][i] = 0;
               }
            }            
        return bank[i].getID();
    }
    
    public void getBorrowers(){
        evaluateSafety test = new evaluateSafety(5, 201, bank, borrowers);
        
        for(int i =0; i<n; i++){
            for(int x =0; x<n; x++){
                //System.out.println(borrowers[i][x]);
                if ((borrowers[i][x] > 0)&&(x!=i)){
                    System.out.println("Bank "+ bank[x].getID() +" borrowed money from Bank " + bank[i].getID());
                }
            }
        }
    }
    
}
