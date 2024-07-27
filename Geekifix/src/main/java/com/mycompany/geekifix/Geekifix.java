/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.geekifix;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Geekifix {

    public static void main(String[] args) {
//        List<Integer> linkedList = new LinkedList<>();
//        
//        linkedList.insert(10);
//        linkedList.insert(20);
//        linkedList.insert(30);
//        linkedList.insert(40);
//        
//        linkedList.traverse();
//        
//        linkedList.remove(20);
//        
//        System.out.println();
//        
//        linkedList.traverse();
        
        Stack<Integer> linkedStack = new LinkedStack<>();
        
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        
        linkedStack.pop();
        
        while(!linkedStack.isEmpty()){
            System.out.print(linkedStack.pop() + " ");
        }
        
    }
}
