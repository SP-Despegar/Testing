package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class ASolution {

    List<Integer> lengthSubsequenceShoppers(List<Character> inputList)
    {
        List<Integer> result = new ArrayList<>();

        if( areAllUnique(inputList) ){
            for (int i = 0; i < inputList.size(); i++) {
                result.add(1);
            }
            return result;
        }

        Character shopper = null;
        Integer firstAppears = 0;
        Integer lastAppears = 0;
        Integer nextLoop = 0;

        System.out.println("size: "+inputList.size());

        do{
            System.out.println("--------------");
            shopper = inputList.get(firstAppears);
            System.out.println("shopper: "+shopper );

            for (int i = firstAppears; i < inputList.size(); i++) {
                if (inputList.get(i).equals(shopper)) {
                    lastAppears = i;
                }
            }
            System.out.println("first:"+ firstAppears +" last:" +lastAppears);
            System.out.println("groupSize: "+ (lastAppears - firstAppears + 1));

            if( (lastAppears - firstAppears) == 0){
                result.add(inputList.size() - lastAppears +1 );
                break;
            }
            result.add(lastAppears - firstAppears + 1);

            firstAppears = lastAppears +1;
            nextLoop = lastAppears +1;

            System.out.println("next: " + nextLoop);
        } while(nextLoop < inputList.size() - 1);

        return result;
    }

    static <T> boolean areAllUnique(List<T> list){
        return list.stream().allMatch(new HashSet<>()::add);
    }

    int minimumTime(int numOfSubFiles, List<Integer> files)
    {
        List<Integer> sorted = files.stream().sorted().collect(Collectors.toList());
        Iterator<Integer> iterator = sorted.iterator();

        int totalTime = 0;
        int tempTime = 0;

        Integer time = null;
        Integer time2 = null;

        while(sorted.size() > 1){

            System.out.println("list: "+ sorted.toString());
            time = sorted.remove(0);
            time2 = sorted.remove(0);

            tempTime = (time +time2);
            totalTime = totalTime + tempTime;

            sorted = sorted.stream().sorted().collect(Collectors.toList());

            System.out.println("after:"+sorted.toString());
        }

        return totalTime;
    }
    int enhanceMinimumTime(int numOfSubFiles, List<Integer> files)
    {
        List<Integer> sorted = files.stream().sorted().collect(Collectors.toList());


        int totalTime = 0;
        int tempTime = 0;

        Integer time = null;
        Integer time2 = null;
        ListIterator<Integer> iterator = null;

        while(sorted.size() > 1){

            System.out.println("list: "+ sorted.toString());
            time = sorted.remove(0);
            time2 = sorted.remove(0);

            tempTime = (time +time2);
            totalTime = totalTime + tempTime;

            iterator = sorted.listIterator();

            while(iterator.hasNext()){
                if( tempTime <= iterator.next() ){
                    iterator.add(tempTime);
                    break;
                }
            }
            if( !iterator.hasNext() ) iterator.add(tempTime);

            System.out.println("after:"+sorted.toString());
        }

        return totalTime;
    }

}
