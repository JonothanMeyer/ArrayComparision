
/**
 * Write a description of class ArrayListAdd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;
public class ArrayListAdd
{

     public void fill() //this will fill the array/ArrayList with int's
    {
       int FIVE_MIL = 10;
       ArrayList<Integer> ArrayList;
       ArrayList = new ArrayList<Integer>(FIVE_MIL);
       int someNumber = 0;
           Random randomGenerator = new Random();
       long startTime = System.currentTimeMillis();
      for (int i=0;i<10;i++)
       {
        someNumber = randomGenerator.nextInt(10);
        ArrayList.add(someNumber);
        }
       ArrayList.add(randomGenerator.nextInt(1000));
       long endTime = System.currentTimeMillis();
       long elapsedTime = (endTime - startTime);
       boolean filled = ArrayList.isEmpty();
       System.out.println("How large the ArrayList is: " + ArrayList.size());
       
       System.out.println("No elements in ArrayList: " + filled);
       System.out.println("Element in ArrayList at index 0: " + ArrayList.get(0));
       System.out.println("Time to fill an ArrayList: " + elapsedTime);
      //System.out.println("Some random number: " + randomGenerator.nextInt(10));
      System.out.println("Now in fill method");
      
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------
        public static void main (String[] args) //Driver
    {
     ArrayListAdd comparison = new ArrayListAdd();
     comparison.fill();
     //comparison.incriment();
     //comparison.search();
     //comparison.expand();
     System.out.println("------------------------------------------------------------------------END OF CYCLE----------------------------------------------------------------");
     
    }
}
