package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static GCD gcdCalculator;
    private static Solution solution;
    private static ASolution amazon;


    public static void main(String[] args){

        gcdCalculator = new GCD();
        solution = new Solution();
        amazon = new ASolution();


        testIsBalance();
//        testQueue();

        /*
         * Amazon solution
         * testlengthSubsequenceShoppers();
         * testMinumTime();
         *
         * */

//        testGDC();
//        testSolution();
//        testShortesDistance();
//        testhourglassSum();
//        testRotateToLeft();
//        testRotateToRigth();
//        testSumatoria();
//        testFibonacci();
//        testKlargest();
//        testKtoys();
//        testActivityNotifications();

    }

    private static void testIsBalance() {

//        try {
//
//            File testCase = new File("/home/santiagopanizza/Escritorio/Test_case.txt");
//            File result = new File("/home/santiagopanizza/Escritorio/Test_case_result.txt");
//
//            BufferedReader testBuffer = new BufferedReader(new FileReader(testCase));
//            BufferedReader resultBuffer = new BufferedReader(new FileReader(result));
//
//            String readLine = "";
//            String output = "";
//            System.out.println("Reading file using Buffered Reader");
//
//            while ((readLine = testBuffer.readLine()) != null) {
//                output = solution.isBalanced(readLine);
//                if(output.compareTo(resultBuffer.readLine()) != 0){
//                    System.out.println(readLine);
//                    System.out.println(output);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        solution.isBalanced("))");
    }

    private static void testQueue() {

        QueueImp<Integer> q = new QueueImp<>(4);

        q.put(1);
        q.put(2);
        q.get();
        q.put(3);
        q.get();
        q.put(4);
        q.put(5);
        q.get();
        q.get();
        q.get();
        q.put(6);
    }

    private static void testActivityNotifications() {

        int[] expenditure = new int[]{1,2,3,45,6,3,24,5,6,78,65,43,2,2,4,4};

        Integer result = solution.activityNotifications(expenditure, 4);
        System.out.println("number of notification: "+result);

        result = solution.activityNotifications(expenditure, 2);
        System.out.println("number of notification: "+result);
    }

    private static void testKtoys() {
        int[] prices = new int[]{10,13,2,4,56,10};

        solution.maximumToys(prices,500);
    }

    private static void testKlargest() {
        int[] vec = new int[]{1,43,235,6,7,899,23,457,2,4,6,6668,135,2,};

        solution.kLargest(vec,4);
    }

    private static void testFibonacci() {

        for (int i = 0; i < 10; i++) {
            System.out.print(" "+solution.fibonacci(i));
        }
    }

    private static void testSumatoria() {
        Integer n = 10;
        Long val = solution.sumatoria(n);

        System.out.println("---------------------");
        System.out.println(n+"-Sum: " + val);
    }

    private static void testRotateToRigth() {
        int[] vec = new int[]{1,2,3,4};
        System.out.println("start: "+Arrays.toString(vec));

        System.out.println("-----------------------------------");
        System.out.println("TO THE RIGHT");
        int[] result = solution.rotRigt(vec,0);
        System.out.println("result d0: "+ Arrays.toString(result));
        result = solution.rotRigt(vec,1);
        System.out.println("result d1: "+ Arrays.toString(result));
        result = solution.rotRigt(vec,2);
        System.out.println("result d2: "+ Arrays.toString(result));
        result = solution.rotRigt(vec,3);
        System.out.println("result d3: "+ Arrays.toString(result));
        result = solution.rotRigt(vec,4);
        System.out.println("result d4: "+ Arrays.toString(result));
    }

    private static void testRotateToLeft() {
        int[] vec = new int[]{1,2,3,4};
        System.out.println("start: "+Arrays.toString(vec));


        System.out.println("TO THE LEFT");
        int[] result = solution.rotLeft(vec,0);
        System.out.println("result d0: "+ Arrays.toString(result));
        result = solution.rotLeft(vec,1);
        System.out.println("result d1: "+ Arrays.toString(result));
        result = solution.rotLeft(vec,2);
        System.out.println("result d2: "+ Arrays.toString(result));
        result = solution.rotLeft(vec,3);
        System.out.println("result d3: "+ Arrays.toString(result));
        result = solution.rotLeft(vec,4);
        System.out.println("result d4: "+ Arrays.toString(result));
    }

    private static void testhourglassSum() {

//        1, 1, 1, 0, 0, 0
//        0, 1, 0, 0, 0, 0
//        1, 1, 1, 0, 0, 0
//        0, 0, 2, 4, 4, 0
//        0, 0, 0, 2, 0, 0
//        0, 0, 1, 2, 4, 0

//        -1, -1,  0, -9, -2, -2
//        -2, -1, -6, -8, -2, -5
//        -1, -1, -1, -2, -3, -4
//        -1, -9, -2, -4, -4, -5
//        -7, -3, -3, -2, -9, -9
//        -1, -3, -1, -2, -4, -5

//      int[] tab = {12, 1, 21, 8};
//      int min = Arrays.stream(tab).min().getAsInt();

        int[][] input = new int[][] {new int[]{-1, -1,  0, -9, -2, -2},
                                     new int[]{-2, -1, -6, -8, -2, -5},
                                     new int[]{-1, -1, -1, -2, -3, -4},
                                     new int[]{-1, -9, -2, -4, -4, -5},
                                     new int[]{-7, -3, -3, -2, -9, -9},
                                     new int[]{-1, -3, -1, -2, -4, -5},
                                    };


        System.out.println(Arrays.deepToString(input));
        System.out.println("The maxSum is: "+ solution.hourglassSum(input));
        System.out.println("The maxSum is: "+ solution.hourglassSum2(input));

    }

    private static void testSolution() {
        List<Integer> result = null;

        solution = new Solution();

        int[] e1 = new int[]{1,0,0,0,0,1,0,0};
        int[] e2 = new int[]{1,0,0,0,0,1,0,0};

        result = solution.cellCompete(e1,1);
        System.out.println(result);
        result = solution.cellCompete(e2,2);
        System.out.println(result);
    }


    public static void testGDC() {

        System.out.println("----------------------------");

        int result = gcdCalculator.calculateGCD(15,150);
        System.out.println("result for 150,15: " + result);

        int[] t1 = new int[]{2, 3, 4, 5, 6};
        int[] t2 = new int[]{2, 4, 6, 8, 10};
        int[] t3 = new int[]{8, 4, 16, 20, 40};

        result =gcdCalculator.generalizedGCD(5, t1);
        System.out.println("result for "+ Arrays.toString(t1)+": "+ result);

        result =gcdCalculator.generalizedGCD(5, t2);
        System.out.println("result for "+ Arrays.toString(t2)+": "+result);

        result =gcdCalculator.generalizedGCD(5, t3);
        System.out.println("result for "+ Arrays.toString(t3)+": "+result);

    }

    public static void testShortesDistance(){

        int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
        int[] testArray2 = {3, 56, 540, 1, 34, 3, 67, 5};

        int result = solution.shortestDistance(testArray);
        System.out.println("closest distance: " + result); // Expected result is 1 (the 2 closest numbers are 98 and 99)

        result = solution.shortestDistance(testArray2);
        System.out.println("closest distance: " + result);
    }

/***************************************************************************************************/
    private static void testlengthSubsequenceShoppers() {
        List<Character> shoppers = new ArrayList<Character>();

        shoppers.add('a');
        shoppers.add('b');
        shoppers.add('c');

        List<Character> shoppers4 = new ArrayList<Character>();

        shoppers4.add('z');
        shoppers4.add('z');
        shoppers4.add('c');
        shoppers4.add('b');
        shoppers4.add('z');
        shoppers4.add('c');
        shoppers4.add('h');
        shoppers4.add('f');
        shoppers4.add('i');
        shoppers4.add('h');
        shoppers4.add('i');


        System.out.println(shoppers4.toString());
        List<Integer> result = amazon.lengthSubsequenceShoppers(shoppers4);
        System.out.println("-------------------------");
        System.out.println(result.toString());

    }

    private static void testMinumTime() {
        List<Integer> files = new ArrayList<Integer>();
        files.add(8);
        files.add(4);
        files.add(6);
        files.add(12);

        int result = amazon.minimumTime(4, files);
        System.out.println("Time:"+ result);
    }

}
