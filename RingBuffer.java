/**
 * CS312 Assignment 12.
 *
 * On my honor, <Jiayi Zhou>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Rock Paper Scissors
 *
 *  email address:judyzhou959@utexas.edu
 *  UTEID:jz22393
 *  Unique 5 digit course ID:51410
 *  Grader name:Omer
 *  Number of slip days used on this assignment:0
 */
import java.util.NoSuchElementException;

public class RingBuffer {
    private int maxCapacity;
    private double[] list;
    private int lastIndex;//to indicate which one is the last value's index.

    public RingBuffer(int capacity){
        maxCapacity = capacity;
        list = new double[maxCapacity];
        for(int i = 0; i < maxCapacity; i++){
            list[i] = 0.0;
        }
        lastIndex = -1;
    }
    //return number of items currently in the buffer
    public int size(){
        return lastIndex+1;   
    }
    // is the buffer empty (size equals zero)?
    public boolean isEmpty(){
        return (this.size() == 0);
    }
    // is the buffer full  (size equals capacity)? 
    public boolean isFull(){
        return (this.size() == maxCapacity);
    }
    // add item x to the end (as long as the buffer is not full)
    public void enqueue(double x){
        if(this.isFull()){
            throw new IllegalStateException();
        }
        int index = lastIndex + 1;
        list[index] = x;
        lastIndex++;
    }
    // delete and return item from the front (as long as the buffer is not empty)
    public double dequeue(){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        for(int i = 0; i < lastIndex; i++){
            list[i] = list[i+1];
        }
        list[lastIndex] = 0.0;
        lastIndex--;   
        return list[0];
    }
    // return (but do not delete) item from the front of the buffer
    public double peek(){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return list[0];
    }

    public String toString(){
        String result = "[";
        if(!isEmpty()){
            result += list[0];
            for(int i = 1; i <= lastIndex; i++){
                result = result + ", " + list[i];	
            }	
        }
        result += "]";
        return result;  
    }	

}
