package com.ExerOne;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	int[][] ticket = new int[5][5];
    TicketGenerator(ticket);
        for (int j = 0; j < 5; j++) {
            int[] array = new int[5];
            for (int i = 0; i < 5; i++) {
                array[i] = ticket[i][j];
            }
            array = SortingFunction(array);
            for (int i = 0; i < 5; i++) {
                ticket[i][j] = array[i];
            }
        }


     ticket[2][2] = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("% 3d|",ticket[i][j]);
            }
            System.out.println();
        }

    }
    public static int[][] TicketGenerator(int[][] array){
        array = FirstColFiller(array);
        array = SecondColFiller(array);
        array = ThirdColFiller(array);
        array = FourthColFiller(array);
        array = FifhthColFiller(array);
        return array;
    }

    public static int[][] FirstColFiller(int[][] array){
        ArrayList<Integer> list = new ArrayList<>();
        int random = -1;
       list.add(random);
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 1; j++) {
                do{
                    random = RandomGenerator(1,15);
                }
                while (list.contains(random));
              array[i][j]=random;
              list.add(random);
            }
        }
        return array;
    }

    public static int[][] SecondColFiller(int[][] array){
        ArrayList<Integer> list = new ArrayList<>();
        int random = -1;
        list.add(random);
        for (int i = 0; i < 5 ; i++) {
            for (int j = 1; j < 2; j++) {
                do{
                    random = RandomGenerator(16,30);
                }
                while (list.contains(random));
                array[i][j]=random;
                list.add(random);
            }
        }
        return array;
    }

    public static int[][] ThirdColFiller(int[][] array){

        ArrayList<Integer> list = new ArrayList<>();
        int random = -1;
        list.add(random);
        for (int i = 0; i < 5 ; i++) {
            for (int j = 2; j < 3; j++) {

                    do{
                        random = RandomGenerator(31,45);
                    }
                    while (list.contains(random));
                    array[i][j]=random;
                    list.add(random);
                }

        }
        return array;
    }

    public static int[][] FourthColFiller(int[][] array){
        ArrayList<Integer> list = new ArrayList<>();
        int random = -1;
        list.add(random);
        for (int i = 0; i < 5 ; i++) {
            for (int j = 3; j < 4; j++) {
                do{
                    random = RandomGenerator(46,60);
                }
                while (list.contains(random));
                array[i][j]=random;
                list.add(random);
            }
        }
        return array;
    }

    public static int[][] FifhthColFiller(int[][] array){
        ArrayList<Integer> list = new ArrayList<>();
        int random = -1;
        list.add(random);
        for (int i = 0; i < 5 ; i++) {
            for (int j = 4; j < 5; j++) {
                do{
                    random = RandomGenerator(61,75);
                }
                while (list.contains(random));
                array[i][j]=random;
                list.add(random);
            }
        }
        return array;
    }

    public static int RandomGenerator(int start, int end){
        Random random = new Random();
        int  randomNum = (int)Math.floor(Math.random()*(end-start+1)+start);
        return randomNum;
    }

    public static int[] SortingFunction(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }



}
