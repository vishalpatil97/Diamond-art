package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void topAndBottomEdges(int size){  // Method for Top and Bottom edge
        mOut.print("+");
        for(int i = 1; i<=2*size; i++){
            mOut.print("-");
        }
        mOut.print("+");
    }
    public void printStr(String str, int size){ // Method for printing string
        for(int i = 1; i<= size; i++){
            mOut.print(str);
        }
    }
    public void headOfDiamond(int size){   // Method for head of Diamond
        mOut.print("|");
        printStr(" ",size-1);
        mOut.print("/\\");
        printStr(" ",size-1);
        mOut.print("|");
    }
    public void bottomOfDiamond(int size){ // Method for bottom of Diamond
        mOut.print("|");
        printStr(" ", size-1);
        mOut.print("\\/");
        printStr(" ", size - 1);
        mOut.print("|");
    }
    public void middleLine(int size){   // Method for middle part
        mOut.print("|<");
        if(size % 2 == 0){
            printStr("-",size*2 - 2);
        }
        else{
            printStr("=",size*2 - 2);
        }
        mOut.print(">|");

    }
    public void upperHalf(int line, int size) { // Upper half of Diamond
        mOut.print("|");
        printStr(" ",size - line + 1);
        mOut.print("/");
       for(int i = 1; i<=line - 2 ;i++) {  // Left side of Diamond
            if (line % 2 == 0) {
                mOut.print("=");  // "=" for even line
            } else {
                mOut.print("-");  // "-" for odd line
            }
        }
        for(int i = 1; i<=line - 2 ;i++) { // Right side of Diamond
            if (line % 2 == 0) {
                mOut.print("=");
            } else {
                mOut.print("-");
            }
        }
        mOut.print("\\");
        printStr(" ",size - line + 1);
        mOut.print("|");

    }
    public void lowerHalf(int line,int size){   // Lower half of Diamond
        mOut.print("|");
        printStr(" ",line - size - 1);
        mOut.print("\\");
        for(int i = 1; i<= 2*size - line ;i++) { // Left side of Diamond
            if (line % 2 == 0) {
                mOut.print("=");    // "=" for even line
            } else {
                mOut.print("-");    // "-" for odd line
            }
        }
        for(int i = 1; i<= 2*size - line ;i++) {  //Right side od Diamond
            if (line % 2 == 0) {
                mOut.print("=");
            } else {
                mOut.print("-");
            }
        }
        mOut.print("/");
        printStr(" ",line - size -1);
        mOut.print("|");

    }
    public void process(int size) {
        int noOfLines = 2*size + 1;
        for(int i = 1; i<=noOfLines; i++){

           if(i == 1 || i == noOfLines ){   // Top and Bottom edges
               topAndBottomEdges(size);
           }
           else if (i == size + 1){         // Middle part
               middleLine(size);
           }
           else if(i == 2 ) {               // Head of diamond
                headOfDiamond(size);
           }
           else if(i == noOfLines - 1){    //bottom of Diamond
               bottomOfDiamond(size);
           }
           else if(i < size + 1){         // Upper half
               upperHalf(i,size);
           }
           else{                         // Lower half
               lowerHalf(i,size);
           }
           mOut.println("");
        }


    }

}
