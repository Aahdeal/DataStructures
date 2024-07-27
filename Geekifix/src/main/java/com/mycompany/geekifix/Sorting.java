/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geekifix;

import java.util.Arrays;

/**
 *
 * @author Aadil <a.asmal101@gmail.com>
 */
public class Sorting {
    public static void main(String[] args){
       Integer[] array = {10,55,-5,34,7,22,19};
//       new SelectionSort<>(array).sort();
//       new InsertionSort<>(array).sort();
//       new MergeSort<>(array).sort();
//       new QuickSort<>(array).sort();
       System.out.println(Arrays.toString(array));
    }
    
    static class SelectionSort<T extends Comparable<T>>{
        private final T[] array;
        public SelectionSort(T[] array){
            this.array = array;
        }
        public void sort(){
            for(int i =0; i<array.length;i++){
                int minIndex = i;
                for(int x = i+1; x<array.length;x++){
                    if(array[x].compareTo(array[minIndex])<0){
                    minIndex = x;                  
                    }   
                }
                if (minIndex !=i){
                    T temp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = temp;
                }
            }
        }
    }
    
    static class InsertionSort<T extends Comparable<T>>{
        private final T[] array;
        public InsertionSort(T[] array){
            this.array = array;
        }
        public void sort(){
            for(int i = 1; i < array.length;i++){
                for(int x = i; x > 0
                        && array[x].compareTo(array[x-1])<0; x--){
                    T temp = array[x];
                    array[x] = array[x-1];
                    array[x-1]=temp;                    
                } 
            }
        }
    }
    
    static class MergeSort<T extends Comparable<T>>{
        private final T array[];
        public MergeSort(T array[]){
            this.array = array;
        }
        public void sort(){          
            mergesort(0,array.length-1);
        } 
        
        private void merge(int low, int middle, int high){
            T[] leftArray = (T[]) new Comparable[middle-low+1];
            T[] rightArray = (T[]) new Comparable[high-middle];
            
            System.arraycopy(array, low, leftArray, 0, leftArray.length);
            System.arraycopy(array, middle+1, rightArray, 0, rightArray.length);
            
            int left = 0;
            int right = 0;
            int count = low;
            
            while(left < leftArray.length && right < rightArray.length){
                if(leftArray[left].compareTo(rightArray[right])<=0){
                    array[count++] = leftArray[left++];
                }else{
                    array[count++] = rightArray[right++];
                }              
            }
            
            while(left<leftArray.length){
                array[count++] = leftArray[left++];
            }
            while(left<leftArray.length){
                array[count++] = rightArray[right++];
            }
        }
        
        private void mergesort(int low, int high){
            if (low>=high){
                return;
            }
            int middle = (low+high)/2;
            mergesort(low,middle);
            mergesort(middle+1,high);
            merge(low,middle,high);
        }
    }
    
    static class QuickSort<T extends Comparable<T>>{
        private final T[] array;       
        public QuickSort(T[] array){
            this.array = array;
        }
        
        public void sort(){
            quicksort(0,array.length-1);
        }
        
        private int partition(int low,int high){
            int pivotIndex = (low+high) / 2;
            swap(pivotIndex,high);
            int count = low;
            for(int i = low; i < high; i++){
                if(array[i].compareTo(array[high])<=0){
                    swap(count,i);
                    count++;
                }
            }
            swap(count,high);
            return count;
        }
        
        private void quicksort(int low, int high){
            if(low>=high){
                return;
            }            
            int pivot = partition(low,high);
            quicksort(low,pivot-1);
            quicksort(pivot+1,high);
        }
        
        private void swap(int first, int second){
            if(first!=second){
                T temp = array[first];
                array[first] = array[second];
                array[second] = temp;
            }
        }
        
    }
}
