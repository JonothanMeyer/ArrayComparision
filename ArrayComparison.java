
/**
 * Program Name: Array Comparison
 * Author: Jonothan Meyer
 * Date Submitted: 2/6/18
 * Description: This program investigates whether array's or ArrayList's are faster in the operations: fill, incriment, and search. It does this by seeing the amount of time
 *              needed in order for the two variable types to preform each function.
 * 
 * Input/Output: Input: None
 *               Output: display's on the screen the results of how long an array, and an ArrayList took to preform each operation previously listed.
 *               
 * Assumptions and Limitations: Needs a computer with a fair amount of processing power in order to run.
 * References and Sources: Methods found in the JAVA API library. Also review from "Introduction to Programming with JAVA" by John Dean and Raymond Dean, Published by
 * McGraw-Hill 2008
 */

import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner; //testing
public class ArrayComparison
{
    final int FIVE_MIL = 5000000; //List size for ArrayList1 & ArrayList2 in expand method
    final int N = 10000000; //constants to be used for array/ArrayList size.
    double timeArray, timeArrayList;
    private ArrayList<Integer> ArrayList;
    int someNumber = 0; //randomly generated number
    DecimalFormat realFormatter, indexFormatter; 
    Random randomGenerator;
    int[] Array = new int[N];

    
    public ArrayComparison()         // constructor to create object
    {
     realFormatter = new DecimalFormat("0.00");
     indexFormatter = new DecimalFormat("0,000");
     ArrayList = new ArrayList<Integer>(N);
     int[] Array = new int[N];
     randomGenerator = new Random();
     fill();
     incriment();
     search();
     expand();
     
    }
    
    public void fill() //this will fill the array/ArrayList with int's
    {
      //System.out.println("Now in fill method");
      long startTime = System.currentTimeMillis();     // milliseconds
      for (int j=0; j<10;j++) {
      for (int i=0; i<Array.length;i++)
      {
       someNumber = randomGenerator.nextInt(100);
       Array[i] = someNumber;
       //System.out.println(Array[i]);
        } //end i for loop
    } //end j for loop
       long endTime = System.currentTimeMillis();     // milliseconds
       double elapsedTime = (endTime - startTime)/1000.00; // find total time and convert to seconds for an array
       double arrayTime = elapsedTime;
       
       startTime = System.currentTimeMillis();
             for (int j=0; j<10;j++) {
       for (int i=0;i<N;i++)
       {
        someNumber = randomGenerator.nextInt(100);
        ArrayList.add(i,someNumber);
        } //end i for loop
       ArrayList.clear();
    } //end j for loop
       endTime = System.currentTimeMillis();
       elapsedTime = (endTime - startTime)/1000.00;
       double arrayListTime = elapsedTime;
       
       System.out.println("Fill race, N = " + indexFormatter.format(N));
       System.out.println("array fill:     " + realFormatter.format(arrayTime) + " seconds");
       System.out.println("ArrayList fill: " + realFormatter.format(arrayListTime) + " seconds\n");

       /*System.out.println("Some random number: " + randomGenerator.nextInt(10));-----------All used for debugging/checking
        *System.out.println("Element in ArrayList at index 0: " + ArrayList.get(0));
        *boolean filled = ArrayList.isEmpty();
        *System.out.println("No elements in ArrayList: " + filled);*/

    }
    
    public void incriment() //incriments every element in the array by one
    {
      //System.out.println("Now in incriment method");
      ArrayList.clear();
      for (int i=0; i<Array.length;i++)//           Fills a new Array with random numbers
      {
       someNumber = randomGenerator.nextInt(100);
       Array[i] = someNumber;
        } 
      for (int i=0;i<N;i++) //                      Fills a new ArrayList with random numbers
      {
        someNumber = randomGenerator.nextInt(100);
        ArrayList.add(i,someNumber);
        }
      //System.out.println("Value of Array at index 4: " + Array[5]); ------------checking to see value of an index position*** (testing)
      //System.out.println("Value of ArrayList at index 4: " + ArrayList.get(5)); ------------checking to see value of an index position*** (testing)
      //----------------------------------------The next part inciments the Array and ArrayList by one, and finds the time difference to do so--------------------------------------------
      long startTime = System.currentTimeMillis();     // milliseconds
            for (int j=0; j<30;j++) {
      for (int i=0; i<Array.length;i++)
      {
       Array[i]++;
       //System.out.println(Array[i]);
        } //enf i for loop
    }//end j for loop
       long endTime = System.currentTimeMillis();     // milliseconds
       double elapsedTime = (endTime - startTime)/1000.00; // find total time and convert to seconds for an array
       double arrayTime = elapsedTime;
       
       int arrayListValue = 0;
       startTime = System.currentTimeMillis();
             for (int j=0; j<30;j++) {
       for (int i=0;i<N;i++)
       {
        arrayListValue = ArrayList.get(i);
        arrayListValue++;
        ArrayList.set(i, arrayListValue);
        }//end i for loop
    }//end j for loop
       endTime = System.currentTimeMillis();
       elapsedTime = (endTime - startTime)/1000.00;
       double arrayListTime = elapsedTime;
       //System.out.println("Value after incriment of one to Array at index 4: " + Array[5]); ----------checking to make sure value of previous index position was +1***
       //System.out.println("Value after incriment of one to ArrayList at index 4: " + ArrayList.get(5)); //----------checking to make sure value of previous index position was +1***
       
       System.out.println("Increment race, N = " + indexFormatter.format(N));
       System.out.println("array increment:     " + realFormatter.format(arrayTime) + " seconds");
       System.out.println("ArrayList increment: " + realFormatter.format(arrayListTime) + " seconds\n");

    }
    
    public void search() //searches the array and ArrayList for a value contained within them
    {
      //System.out.println("Now in search method");
      ArrayList.clear();
      int[] SEARCH_COUNT = new int[50];
      int foundArray = 0, foundArrayList = 0;
      for (int i=0;i<50;i++) //                      Fills a new ArrayList with random numbers
      {
        someNumber = randomGenerator.nextInt(100);
        SEARCH_COUNT[i] = someNumber;
        }
      
        
      //Fills Array and ArrayList with the same random value's
            for (int i=0;i<Array.length;i++) //                      Fills ArrayList and Array with the same random number in each index
      {
        someNumber = randomGenerator.nextInt(100);
        ArrayList.add(i,someNumber);
        Array[i] = someNumber;
        }
      //System.out.println("ArrayList value at index 4: " + ArrayList.get(5));
      //System.out.println("Array value at index 4: " + Array[5]); ---------------Checking to make sure the values in Array, and ArrayList are the same.
      
      //Searching within an Array, and an Array list.
      long startTime = System.currentTimeMillis();     // milliseconds
     for (int k=0; k<5;k++) {
      for (int i=0; i<SEARCH_COUNT.length;i++)
      {
        for (int j=0; j<Array.length;j++)
            {
              if (Array[j] == SEARCH_COUNT[i])
              {
                 //foundArray++;
                 /*if (foundArray == 1) {
                     System.out.println("Array #: " + Array[i] + "\nArray index position: " + i); -----------------if loop used for testing
                    }*/
                }
            }//end j for loop
        }//end i for loop
    }//end k for loop
      long endTime = System.currentTimeMillis();     // milliseconds
      double elapsedTime = (endTime - startTime)/1000.00; // find total time and convert to seconds for an array
      double arrayTime = elapsedTime;
      //System.out.println("This is how many times the value in SEARCH_COUNT[i] was found in Array: " + foundArray);    testing
      
      startTime = System.currentTimeMillis();     // milliseconds
       for (int k=0; k<5;k++) {
            for (int i=0; i<50;i++)
      {
        for (int j=0; j<N;j++)
            {
              someNumber = ArrayList.get(j);
              if (someNumber == SEARCH_COUNT[i])
              {
                 //foundArrayList++;
                 /*if (foundArrayList == 1) {
                      //System.out.println("ArrayList:\nSEARCH_COUNT #: " + SEARCH_COUNT[i] + "\nSEARCH_COUNT index position: " + i); ---------if loop used for testing
                      System.out.println("ArrayList #: " + ArrayList.get(i) + "\nArrayList index position: " + i);
                    } */
                }
            }//end j for loop
        }// end i for loop
    }//end k for loop
      endTime = System.currentTimeMillis();     // milliseconds
      elapsedTime = (endTime - startTime)/1000.00; // find total time and convert to seconds for an array
      double arrayListTime = elapsedTime;
      //System.out.println("This is how many times the value in SEARCH_COUNT[i] was for in ArrayList: " + foundArrayList);    testing
      
      
      
      
      System.out.println("Search race, N = " + indexFormatter.format(N));
      System.out.println("array search:     " + realFormatter.format(arrayTime) + " seconds");
      System.out.println("ArrayList search: " + realFormatter.format(arrayListTime) + " seconds\n");
      
    }
    
    public void expand()
    {
      //System.out.println("Now in expand method");
      ArrayList.clear();
      ArrayList<Integer> ArrayList1, ArrayList2;
      ArrayList1 = new ArrayList<Integer>(FIVE_MIL);
      ArrayList2 = new ArrayList<Integer>(10);
      
      long startTime = System.currentTimeMillis();
     for (int j=0; j<25;j++) {
      for (int i=0;i<FIVE_MIL;i++)
       {
        someNumber = randomGenerator.nextInt(100);
        ArrayList1.add(i,someNumber);
        }//end i for loop
      ArrayList1.clear();
    }//end j for loop
      long endTime = System.currentTimeMillis();
      double elapsedTime = (endTime - startTime)/1000.00;
      double arrayList1Time = elapsedTime;
      //System.out.println("ArrayList1 done:" + arrayList1Time); //testing
       
      startTime = System.currentTimeMillis();
     for (int j=0; j<25;j++) {
      for (int i=0;i<FIVE_MIL;i++)
       {
        someNumber = randomGenerator.nextInt(100);
        ArrayList2.add(i,someNumber);
        }//end i for loop
      ArrayList2.clear();
    }//end j for loop
      endTime = System.currentTimeMillis();
      elapsedTime = (endTime - startTime)/1000.00;
      double arrayList2Time = elapsedTime;
      //System.out.println("ArrayList2 done:" + arrayList2Time); //testing
      
      System.out.println("Expand race, N = " + indexFormatter.format(FIVE_MIL));
      System.out.println("array w/o expansion:      " + realFormatter.format(arrayList1Time) + " seconds");
      System.out.println("ArrayList with expansion: " + realFormatter.format(arrayList2Time) + " seconds\n");
           
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public static void main (String[] args) //Driver
    {
    //Scanner input = new Scanner(System.in); //for easily testing
    //String keepGoing = "y"//for testing
     //do {
     ArrayComparison comparison = new ArrayComparison();
     //comparison.fill();
     //comparison.incriment();
     //comparison.search();
     //comparison.expand();
     //System.out.println("------------------------------------------------------------------------END OF CYCLE----------------------------------------------------------------"); testing
     //System.out.println("Do again? (yes/no)"); //for testing
     //keepGoing = input.next(); //for testing
    //} while (keepGoing.equalsIgnoreCase("yes") || keepGoing.equalsIgnoreCase("y")); //for testing
    }
}
