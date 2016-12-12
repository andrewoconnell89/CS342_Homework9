// File: Quicksort.java
// A Java application to illustrate the use of a quicksort. Part of this work
// is left as an exercise for students using "Data Structures and Other
// Objects with Java" by Michael Main.
 
/******************************************************************************
* The <CODE>Quicksort</CODE> Java application illustrates a quicksort.
* <B>Part of the implementation (the <CODE>partition</CODE> method) is left
* as a student exercise.</B>
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <p><dt><b>Java Source Code for this class (without 
* <CODE>partition</CODE>:</b><dd>
*   <A HREF="../applications/Quicksort.java">
*   http://www.cs.colorado.edu/~main/applications/Quicksort.java
*   </A>
*
* @version
*   Jan 24, 1999
******************************************************************************/
package edu;

import java.util.Arrays;

public class Quicksort
{
   /**
   * The main method illustrates the use of a quicksort to sort a 
   * small array.
   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used 
   * in this implementation.
   **/
   public static void main(String[ ] args)
   {
	   long startTime = System.currentTimeMillis();
	   long endTime = 0;
	   final String BLANKS = "  "; // A String of two blanks
	   int i;                      // Array index

      int size = 900000;
      int[ ] data = new int[size];
      for(int ele=0; ele< data.length; ele++){
    	  	data[ele] = (int)(Math.random()*200000);
      }
      

      // Print the array before sorting:
//      System.out.println("Here is the entire original array:");
//      for (i = 0; i < data.length; i++)
//         System.out.print(data[i] + BLANKS);
//      System.out.println( );

      // Sort the numbers, and print the result with two blanks after each number.
      quicksort(data, 0, data.length);
      
      endTime = System.currentTimeMillis();
      System.out.println(endTime-startTime);
//      System.out.println("I have sorted all but the first and last numbers.");
//      System.out.println("The numbers are now:");
//      for (i = 0; i < data.length; i++)
//         System.out.print(data[i] + BLANKS);
//      System.out.println( );
   }
   
   
   /**
   * This method cannot be used until the student implements 
   * <CODE>partition</CODE>.
   * Sort an array of integers from smallest to largest, using a quicksort
   * algorithm.
   * @param <CODE>data</CODE>
   *   the array to be sorted
   * @param <CODE>first</CODE> 
   *   the start index for the portion of the array that will be sorted
   * @param <CODE>n</CODE>
   *   the number of elements to sort
   * <dt><b>Precondition:</b><dd>
   *   <CODE>data[first]</CODE> through <CODE>data[first+n-1]</CODE> are valid
   *   parts of the array.
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of </CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[first] &lt= data[first+1] &lt= ... &lt= data[first+n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>first+n-1</CODE> is an index beyond the end of the
   *   array.
   * */
   public static void quicksort(int[ ] data, int first, int n){
	   int pivotIndex; // Array index for the pivot element
	   int n1;         // Number of elements before the pivot element
	   int n2;         // Number of elements after the pivot element
      
      if (n > 1)
      {
         // Partition the array, and set the pivot index.
         pivotIndex = partition(data, first, n);
         // Compute the sizes of the two pieces.
         n1 = pivotIndex - first;
         n2 = n - n1 - 1;
        
         // Recursive calls will now sort the two pieces.
         quicksort(data, first, n1);
         quicksort(data, pivotIndex + 1, n2);
      }
   }
   
   private static int partition(int[ ] data, int first, int n)
   // Precondition: n > 1, and data has at least n elements starting at
   // data[first].
   // Postcondition: The method has selected some "pivot value" that occurs
   // in data[first]. . .data[first+n-1]. The elements of data have then been
   // rearranged and the method returns a pivot index so that
   //   -- data[pivot index] is equal to the pivot;
   //   -- each element before data[pivot index] is <= the pivot;
   //   -- each element after data[pivot index] is > the pivot.
   {
	   int pivot = data[first];
	   int tooBigIndex = first + 1;
	   int tooSmallIndex = first + n - 1;
	   
	   // 2. Repeat until the two indexes cross each other 
	   while (tooBigIndex <= tooSmallIndex){
		   // 2a.
		   while( (tooBigIndex < first+n) && (data[tooBigIndex] <= pivot)){
			   tooBigIndex++;
		   }
		   // 2b. 
		   while( data[tooSmallIndex] > pivot){
			   tooSmallIndex--;
		   }
		   // 2c
		   if(tooBigIndex < tooSmallIndex){
			   int a = data[tooBigIndex];
			   int b = data[tooSmallIndex];  
			   data[tooBigIndex] = b;
			   data[tooSmallIndex] = a;
		   }
	   }
	   
	   // 3. Move the pivot element to its correct position at data[tooSmallIndex]
	   // 3a. Move data[tooSmallIndex] to data[first] 
	   data[first] = data[tooSmallIndex];
	   
	   data[tooSmallIndex] = pivot;
	   return tooSmallIndex;
   }

}


