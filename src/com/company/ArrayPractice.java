package com.company;
import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


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

    }
}
