/*
* This program generates 250 random numbers in an array
* and allows the user to search the array for a number.
*
* @author  Cameron Teed
* @version 0.5
* @since   2021-05-07
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

final class BinarySearch {
  private BinarySearch() {
    // Prevent instantiation
    // Optional: throw an exception e.g. AssertionError
    // if this ever *is* called
    throw new IllegalStateException("Cannot be instantiated");
  }

  /**
  * The min number for array.
  */
  public static final int MIN = 0;
  /**
  * The max number for array.
  */
  public static final int MAX = 999;
  /**
  * The number of elements in the array.
  */
  public static final int ARRAY_SIZE = 250;

  /**
  * Function finds the index of a number, using Binary Search recursively.
  *
  * @param userArray
  * @param userNumber
  * @param lowIndex
  * @param highIndex
  * @return binarySearch
  */
  public static int binarySearch(final int[] userArray, final int userNumber,
                                   final int lowIndex, final int highIndex) {
    // Checks to see if number is in the index
    if (lowIndex > highIndex) {
      // Returns -1
      return -1;
    } else {
      // Finds the middle of the index
      int midIndex = (lowIndex + highIndex) / 2;
      // Check if the indexed number is less than the user number
      if (userArray[midIndex] < userNumber) {
        // Returns the lowest index number + 1
        return binarySearch(userArray, userNumber, lowIndex + 1, highIndex);
      // Check if the indexed number is greater than the user number
      } else if (userArray[midIndex] > userNumber) {
        // Returns the highest index number - 1
        return binarySearch(userArray, userNumber, lowIndex, highIndex - 1);
      } else {
        // Returns where the index number is located
        return midIndex;
      }
    }
  }

  public static void main(final String[] args) {
    System.out.println("Binary Search Program");
    try {
      // Initializing the random class
      Random randNumber = new Random();

      // Initializing array of numbers
      int[] randomNumberArray = new int[ARRAY_SIZE];

      // Adding numbers to the array
      for (int counter = 0; counter < randomNumberArray.length; counter++) {
        randomNumberArray[counter] = randNumber.nextInt(MAX) + 1;
      }

      // Sorting the array
      int[] numberArray = randomNumberArray;
      Arrays.sort(numberArray);

      System.out.print("\nSorted list of numbers:\n");
      for (int element: numberArray) {
        String padded = String.format("%03d", element);
        System.out.print(padded + ", ");
      }
      System.out.print("\n\n");

      // Getting user input as to what number they wish to search for
      Scanner userInput = new Scanner(System.in);
      System.out.print("What number are you searching for in the array");
      System.out.print(" (integer between 0 and 999): ");
      int searchNumber = userInput.nextInt();
      userInput.close();
      System.out.println();

      // Ensuring the user inputs an appropriate integer
      if (searchNumber > MAX || searchNumber < MIN) {
        throw new Exception();
      } else {
        // Using binary search to find the user's chosen number in the array
        int searchResult = binarySearch(numberArray, searchNumber,
                                         0, numberArray.length - 1);
        // Checks if user inputted an indexed number
        if (searchResult > -1) {
          // Outputing the results of the search
          System.out.println("Your number is in index: " + searchResult);
        } else {
          // Outputing the results of the search
          System.out.println("Your number is not in the index. ");
        }
        // Outputs Done
        System.out.println();
        System.out.println();
        System.out.println("Done");
      }

      // Catches and tells the user that an error occured
    } catch (Exception e) {
      System.out.println();
      System.out.println("ERROR: Invalid Input");
    }
  }
}
