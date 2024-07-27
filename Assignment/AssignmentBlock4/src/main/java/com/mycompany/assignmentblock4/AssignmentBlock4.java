/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignmentblock4;

import java.util.Scanner; // Util for user input

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class AssignmentBlock4 {
    //main mehtod
    public static void main(String[] args) {
       int n = 5;                       // instantiating number of banks
       int limit = 201;                 // instantiating limit for bank value
       
       boolean cont = true;             
       Scanner input = new Scanner(System.in);
       int in;
       // assigning data to object and array
       while(cont){                     
           Bank[] bank = new Bank[5];       //declaring bank array
       //instantiating banks
       bank[0] = new Bank(0,0);
       bank[1] = new Bank(1,0);
       bank[2] = new Bank(2,0);
       bank[3] = new Bank(3,0);
       bank[4] = new Bank(4,0);
       //creating 2D array and instantiating it
       double[][] borrowers = new double[5][6];
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
       //creates object from evaluateSafety class
       evaluateSafety test = new evaluateSafety(5,201, bank, borrowers);
       
       boolean loop = true;       
       while(loop){             //creating user display to answer questions
       System.out.println(
               """
                      
                Welcome to Bank Safety Identifier:
                Please choose an option: (Enter relevant number)
                1 - Question 1.1: Program to find all unsafe banks
                2 - Question 1.2 & 1.3: evaluateSafety class that handles unsafe banks
                3 - Question 1.4: getBorrowers method that displays who borrowed money from each bank
                4 - Reset Values
                5 - End Program."""
       );
       
       in = input.nextInt();
       switch(in){
           case 1 -> { //Answers question 1.1
               q1_1(bank, borrowers, n, limit);
               System.out.println("Would you like to conitnue? 1 - yes / 2 - end program");
               in = input.nextInt();
               if (in != 1){loop = false; cont = false;}
           }
           case 2 -> { //Answers question 1.2 and 1.3
               test.evaluate(); //calls evaluate method from evaluateSafety
               System.out.println("Would you like to conitnue? 1 - yes / 2 - end program");
               in = input.nextInt();
               if (in != 1){loop = false; cont = false;}
           }
           case 3 -> { //Answers question 1.4
               test.getBorrowers();
               System.out.println("Would you like to conitnue? 1 - yes / 2 - end program");
               in = input.nextInt();
               if (in != 1){loop = false; cont = false;}
           }
           case 4 -> {cont = true; loop = false;}
           case 5 -> {loop = false; cont = false;}
       }
       }
       }
    }

    //Question 1.1 solution using 2 for loops
    public static void q1_1(Bank[] bank, double[][] borrowers, int n, int limit){
        for (int i = 0; i < n; i++){
           for (int j=0;j<n;j++){
               bank[i].setValue(bank[i].getValue()+borrowers[i][j]);
               //finds total assets of bank
           }
           if (bank[i].getValue()<limit){ //checks if total assets < limit
               for(int x = 0; x<n;x++){
                   borrowers[x][i] = 0; //sets corresponding loans to 0
               }
           }
       }
       
       String unsafe = "Unsafe banks are ";
       //displays unsafe banks
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
}
