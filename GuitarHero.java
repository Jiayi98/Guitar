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
public class GuitarHero {
    public static final int NUM_STRING = 37;
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        //create and initialize an array of 37 GuitarString objects. 
        GuitarString[] stringList = new GuitarString[NUM_STRING];
        for(int i = 0; i < NUM_STRING; i++){
            double concert =  440 * Math.pow(1.05956, (i-24));
            stringList[i] = new GuitarString(concert);
        }

        final double TEXT_POS_X = .2;
        final double TEXT_POS_Y = .5;
        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Type the keyboard to play!");

        play(stringList, keyboard);
    }
    //Play the guitar.
    private static void play(GuitarString[] stringList, String keyboard) {        // the main input loop
        while (true) {
            //check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                //the user types this character
                char key = StdDraw.nextKeyTyped();

                //pluck the corresponding string if user typed correctly.
                if(keyboard.contains(key+"")){
                    int index = keyboard.indexOf(key);
                    stringList[index].pluck();
                }
            }

            // compute the superposition of the samples
            // advance the simulation of each guitar string
            double sample = 0.0;
            for(int i = 0; i < NUM_STRING; i++){
                sample += stringList[i].sample();
                stringList[i].tic();
            }
            StdAudio.play(sample);    // send the result to standard audio
        }

    }

}
