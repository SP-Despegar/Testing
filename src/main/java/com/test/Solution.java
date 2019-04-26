package com.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    String isBalanced(String s) {
        String result = "YES";

        Stack<Character> stack = new Stack<>();

        HashMap<Character,Character> mapOfClosing = new HashMap<>();
        HashMap<Character,Character> mapOfOpen  = new HashMap<>();

        mapOfClosing.put(')','(');
        mapOfClosing.put('}','{');
        mapOfClosing.put(']','[');

        mapOfOpen.put('(','(');
        mapOfOpen.put('{','{');
        mapOfOpen.put('[','[');

        Character c = null;

        for (int i = 0; i < s.length(); i++) {

            c = mapOfClosing.get(s.charAt(i));
            if(c != null){
                if( ! stack.empty() ){
                    if(c.compareTo(stack.pop()) != 0){
                        result = "NO";
                        break;
                    }
                }else{
                    result = "NO";
                    break;
                }
            }

            c = mapOfOpen.get(s.charAt(i));
            if(c != null){
                stack.push(c);
            }
            c = null;
        }

        if( !stack.empty()) result = "NO";

        return result;
    }

    int activityNotifications(int[] expenditure, int window) {
        
        Integer notifications = 0;
        Float sum = Float.valueOf(0);

        for (int i = 0; i < expenditure.length; i++) {

            if( i < window ){
                sum = sum + expenditure[i];
                continue;
            }

            if( expenditure[i] >= (( sum / window ) * 2)){
                notifications = notifications + 1;
            }

            System.out.println("--------------");
            System.out.println("avg: "+(( sum / window ) * 2));
            System.out.println("[i]: " + expenditure[i]);
            System.out.println("[i-d]: " + expenditure[i-window]);

            sum = sum - expenditure[i - window];
            sum = sum + expenditure[i];

        }
        return notifications;
    }

    int activityNotificationsMean(int[] expenditure, int window) {
        /**
         * Este metodo utiliza el promedio, no el valor medio...
         * */
        Integer notifications = 0;
        Float sum = Float.valueOf(0);

        for (int i = 0; i < expenditure.length; i++) {

            if( i < window ){
                sum = sum + expenditure[i];
                continue;
            }

            if( expenditure[i] >= (( sum / window ) * 2)){
                notifications = notifications + 1;
            }

            System.out.println("--------------");
            System.out.println("avg: "+(( sum / window ) * 2));
            System.out.println("[i]: " + expenditure[i]);
            System.out.println("[i-d]: " + expenditure[i-window]);

            sum = sum - expenditure[i - window];
            sum = sum + expenditure[i];

        }
        return notifications;
    }

    List<Integer> cellCompete(int[] states, int days){

        int[] innerState = states;
        for (int day = 0; day < days; day++) {
            System.out.println("-------DAY "+(day + 1)+"----------");
            innerState = updateStates(innerState);

        }

        return Arrays.stream(innerState).boxed().collect(Collectors.toList());
    }

    int[] updateStates(int[] states) {

        int[] result = states.clone() ;

        result[0] = states[0] == 1 ? 0 : 1;
        result[states.length -1 ] = result[states.length - 1] == 1 ? 0 : 1 ;

        for (int i = 1; i < states.length - 1; i++){
            if( (states[i-1] == 0 && states[i+1] == 0) || (states[i-1] == 1 && states[i+1] == 1)){
                result[i] = 0 ;
            }else{
                result[i] = 1;
            }
        }
        System.out.println("old:"+Arrays.toString(states)+" -new:"+Arrays.toString(result));
        return result;
    }

    int shortestDistance(int[] numbers){

        Arrays.sort(numbers);
        System.out.println("sorted: "+Arrays.toString(numbers));
        int minDistance;

        if( numbers.length > 1) {
            minDistance = numbers[1] - numbers[0];
        }else {
            // show error
            minDistance = 0;
        }

        for (int i = 1; i < numbers.length; i++) {
            minDistance = Math.min(numbers[i] - numbers[i-1],minDistance);
        }

        return minDistance;
    }


    // Complete the hourglassSum function below.
    int hourglassSum(int[][] input) {

        int height = input.length;
        int width = input[0].length;

        List<Integer> sums = new ArrayList<>();

        int tmp = 0;
        for (int i = 0; i < height - 2; i++) {
            for (int j = 0; j < width - 2; j++) {

                System.out.println(input[i][j] +""+ input[i][j+1] +""+ input[i][j+2] );
                System.out.println(" "+ input[i+1][j+1] +" ");
                System.out.println(input[i+2][j] +""+ input[i+2][j+1] +""+ input[i+2][j+1]);

                tmp = input[i][j] + input[i][j+1] + input[i][j+2] +
                                        input[i+1][j+1] +
                          input[i+2][j] + input[i+2][j+1] + input[i+2][j+2];
                System.out.println("Max sum: " + tmp);
                sums.add(tmp);
            }
            System.out.println("---------------------------");
        }

        Collections.sort(sums);
        return sums.get(sums.size()-1);
    }

     int hourglassSum2(int[][] input) {

        int height = input.length;
        int width = input[0].length;
        Integer max = null;
        int tmp = 0;

        for (int i = 0; i < height - 2; i++) {
            for (int j = 0; j < width - 2; j++) {

                System.out.println(input[i][j] +""+ input[i][j+1] +""+ input[i][j+2] );
                System.out.println(" "+ input[i+1][j+1] +" ");
                System.out.println(input[i+2][j] +""+ input[i+2][j+1] +""+ input[i+2][j+1]);

                tmp = input[i][j] + input[i][j+1] + input[i][j+2] +
                                        input[i+1][j+1] +
                          input[i+2][j] + input[i+2][j+1] + input[i+2][j+2];
                System.out.println("Max sum: " + tmp);

                if( max == null){
                    max = tmp;
                }else {
                    max = max.compareTo(tmp);
                }
            }
            System.out.println("---------------------------");
        }

        return max;
    }

    // Complete the rotLeft function below.
     int[] rotLeft(int[] arr, int d) {

        int[] result = arr.clone();

        if( (d % arr.length) > 0){
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[ (i+d) % arr.length];
            }
        }

        return result;
    }
     int[] rotRigt(int[] arr, int d) {

        int[] result = arr.clone();

        if( (d % arr.length) > 0){
            for (int i = 0; i < arr.length; i++) {
                if( (i-d) < 0){
                    result[i] = arr[ i-d + arr.length];
                }else {
                    result[i] = arr[i-d];
                }
            }
        }

        return result;
    }

     Long sumatoria(int i) {

        Long nValue = 0L;
        if(i>1){
            nValue =+ i + sumatoria(i - 1);
        }else{
            nValue = nValue + 1;
        }

        return nValue;
    }

     Long fibonacci(int n) {
        if(n == 0) return 0L;
        if(n == 1) return 1L;
        return fibonacci(n-2) + fibonacci(n-1);
    }

     void kLargest(int[] vec, int k) {

        Arrays.sort(vec);

        for (int i = 0; i < k; i++) {
            System.out.println("Element"+i+": "+vec[vec.length - 1 - i]);
        }

    }

     void maximumToys(int[] prices, int money) {
//// To boxed array
//        Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
//        Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );
//
//// To boxed list
//        List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
//        List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );

        List<Integer> aux = IntStream.of(prices)
                                    .boxed()
//                                    .sorted(Comparator.reverseOrder())
                                    .sorted()
                                    .distinct()
                                    .collect( Collectors.toList());

        Integer numberOfToys = 0;
        System.out.println("Initial array: "+Arrays.toString(prices));
        System.out.println("Ordered: " + aux.toString());
        System.out.println("Money to spend: " + money);

        for (Integer price : aux) {
            money -= price;
            if(money<0) break;
            numberOfToys += 1;
        }

        System.out.println("Maximum number of Toys: "+numberOfToys);
    }


    /**
  * POCO PERFORMANTE
  *
  * static int[] rotLeft(int[] arr, int d) {
  *     int[] result = arr.clone();
  *     for (int i = 0; i < d % arr.length; i++) {
  *         result = rotateLeftOnce(result);
  *     }
  *     return result;
  * }
  *
  * static int[] rotateLeftOnce(int[] arr) {
  *     int[] result = arr.clone();
  *
  *     for (int i = arr.length-1; i > 0; i--) {
  *         result[i-1] = arr[i];
  *     }
  *
  *     result[arr.length-1] = arr[0];
  *     return result;
  * }
 */

}
