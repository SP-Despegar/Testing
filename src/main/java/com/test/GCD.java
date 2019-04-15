package com.test;

/*
* Encontrar el maximo comun divisor:
*
* TEST CASE 1:
* num: 5
* arr: [2,3,4,5,6]
*
* TEST CASE 2:
* num: 5
* arr: [2,4,6,8,10]
*
* */
public class GCD {

    public int generalizedGCD(int num, int[] arr){
        int maxGCD = arr[0];
        int inGDC = 1;
        for (int out = 0; out < (num + 1) / 2  ; out++) {
            for (int in = 0; in < num; in++) {
                inGDC = calculateGCD(arr[out],arr[in]);
                maxGCD = calculateGCD(inGDC,maxGCD);
                System.out.println("j:"+in +" - arr[out]:" + arr[out] +" - arr[in]:"+ arr[in] + " - gdc:" + inGDC);
            }
            System.out.println("---------------------");
            if (maxGCD == 1) break;
        }
        return maxGCD;
    }

    public int calculateGCD(int num1, int num2){
        return num2 == 0 ? num1 : calculateGCD(num2, num1%num2);
    }
}
