package com.company;
import java.util.*;

import static java.util.stream.Collectors.joining;


public class ArrayPractice {

    // Takes an integer array and returns a sorted integer array
    public static int[] BubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        boolean swapped = true;

        // We want to keep iterating through the array until there are no swaps on a pass through
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return arr;
    }


    public static List<Integer> ReverseList(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        List<Integer> reversedArr  = new ArrayList<Integer>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            reversedArr.add(arr.get(i));
        }

        return reversedArr;
    }

    //An hourglass in A is a subset of values with indices falling in this pattern in A's graphical representation:
    //
    //  a b c
    //    d
    //  e f g
    //
    // This function returns the maximum hourglass sum in the given 2d array
    public static int hourGlassSum(Integer[][] arr) {

        /*
            arr[0][0] is the top left cell of an hour glass
            I need to sum the following:
            top row:
                arr[i][j]
                arr[i][j+1]
                arr[i][j+2]
            middle value:
                arr[i+1][j+1]
            bottom row:
                arr[i+2][j]
                arr[i+2][j+1]
                arr[i+2][j+2]
        */

        if (arr.length <= 1)
            return 0;

        int largestHourGlassSum = 0;
        int hourGlassSum = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                hourGlassSum += arr[i][j];
                hourGlassSum += arr[i][j + 1];
                hourGlassSum += arr[i][j + 2];
                hourGlassSum += arr[i + 1][j + 1];
                hourGlassSum += arr[i + 2][j];
                hourGlassSum += arr[i + 2][j + 1];
                hourGlassSum += arr[i + 2][j + 2];

                if (hourGlassSum > largestHourGlassSum)
                    largestHourGlassSum = hourGlassSum;

                hourGlassSum = 0;
            }
        }

        return largestHourGlassSum;
    }




    public static void main(String[] args) {

        // BubbleSort section
        int [] arr = new int[]{10, 20, 40, 2, 90, 1, 8, 78, 42, 21};
        System.out.println("Unsorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        int [] sorted = BubbleSort(arr);
        System.out.println("");
        System.out.println("Sorted array: ");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("");

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////

        // Reversing a List<Integer>
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : arr) {
            intList.add(i);
        }

        List<Integer> reversedList = ReverseList(intList);

        System.out.println("");
        System.out.println("Original Array : ");
        for (int i : intList) {
            System.out.print(i + " ");
        }

        System.out.println("");
        System.out.println("Reversed Array : ");
        for (int i : reversedList) {
            System.out.print(i + " ");
        }

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////

        System.out.println("");
        System.out.println("");
        //Finding the hourglass sum of a 2d array
        Integer[][] hourglass = new Integer[6][6];
        Random rand = new Random();

        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                hourglass[i][j] = rand.nextInt(10);
            }
        }

        System.out.println("Original 2d Array: ");
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                System.out.print(hourglass[i][j] + " ");
            }
        }

        int largest_hour_glass_sum = hourGlassSum(hourglass);
        System.out.println("");
        System.out.println("Largest hour glass sum is: " + largest_hour_glass_sum);

    }
}
