package com.bubblesort;

import java.lang.invoke.StringConcatException;

public class Main {

    public static void main(String[] args) {
	int[] array = {6, 2, 3, 1, 22, 5, 13};
    array = BubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
    public static int[] BubbleSort(int[] arr) {
        int trigger = 0;
        while (trigger == 0) {
            trigger = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int saver = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = saver;
                    trigger = 0;
                }
            }
        }
        return arr;
    }
}
