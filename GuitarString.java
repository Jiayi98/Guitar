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
public class GuitarString {
    private static final int SMPLING_RATE = 44100;
    private double frequency;
    private double[] init;
    private RingBuffer rb;
    private int counter;
    private int n;

    // create a guitar string of the given frequency,
    //using a sampling rate of 44,100
    public GuitarString(double frequency){
        this.frequency = frequency;
        this.n = (int)Math.round(SMPLING_RATE / frequency);
        rb = new RingBuffer(n);
        for(int i = 0; i < n; i++){
            rb.enqueue(0.0);
        }
    }
    // create a guitar string whose size and initial values 
    //are given by the array
    public GuitarString(double[] init){
        this.init = init;
        //creates a RingBuffer of capacity equal to the size of the array
        rb = new RingBuffer(init.length);
        //initializes the contents of the buffer to the values in the array
        for(int i = 0; i < init.length; i++){
            rb.enqueue(init[i]);
        }
    }
    //Replace the N items in the ring buffer with N random values
    //between -0.5 and +0.5.
    public void pluck(){
        for(int i = 0; i < n; i++){
            rb.dequeue();
            double num = Math.random()-0.5;
            rb.enqueue(num);

        }
    }
    // advance the simulation one time step
    public void tic(){
        counter++;
        double num = rb.peek();
        rb.dequeue();
        double adds = 0.5 * (num + rb.peek()) * 0.994;
        rb.enqueue(adds);   
    }
    // return the current sample
    public double sample(){
        return rb.peek();
    }

    // return number of tic() was called    
    public int time(){
        return this.counter;
    }
}
