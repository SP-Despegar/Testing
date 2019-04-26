package com.test;

import java.util.ArrayList;

public class QueueImp<T> {

    private final Integer size;
    private T[] elements;

    private ArrayList<Integer> indexFull;
    private ArrayList<Integer> indexEmpty;

    public QueueImp(Integer length){

        this.size = length;
        this.elements = (T[]) new Object[length];

        this.indexFull = new ArrayList<>();
        this.indexEmpty = new ArrayList<>();

        for(int i=0; i<length; i++ ){
            indexEmpty.add(i);
        }
    }

    public T get(){

        T valueToRetrieve;
        if( indexFull.size() > 0){

            Integer index = indexFull.remove(0);
            for (T element : elements) {
                System.out.print(element+" ");
            }
            System.out.println("(get)index: "+index);
            valueToRetrieve = elements[index];
            elements[index] = null;

            indexEmpty.add(index);
        }else{
            throw new RuntimeException("The Queue is empty");
        }
        return valueToRetrieve;
    }

    public void put(T newElement){
        if( indexEmpty.size() > 0){
            for (T element : elements) {
                System.out.print(element+" ");
            }
            Integer index = indexEmpty.remove(0);
            elements[index] = newElement;
            System.out.println("(put)index: "+index);
            indexFull.add(index);
        }else{
            throw new RuntimeException("The Queue is full");
        }
    }

}
