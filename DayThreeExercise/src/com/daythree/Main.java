package com.daythree;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FizzBuzz();
        Table();
        int key = RandomKey();
        System.out.println(key);
        System.out.println(WordChanging(key));
        Something();
    }


    public static void FizzBuzz(){
        for (int i = 1; i <= 100 ; i++) {
            if (i % 3 == 0){
                System.out.print(" Fizz ");
                continue;
            }
            if (i % 5 == 0){
                System.out.print(" Buzz ");
                continue;
            }
            else
            {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println();
    }

    public static void Table(){
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(j + " * " + i + " = " + (i*j));
            }
        }
    }

    public static char[] WordChanging(int key) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write the message here : ");
        String input = scanner.nextLine();
        char[] conv = input.toCharArray();
        char[] secured = new char[conv.length];
        String change = "";
        for (int i = 0; i < conv.length; i++) {
            if (conv[i] != ' ') {
                int charAsNumb = conv[i] + key;
                char converted = (char) charAsNumb;
                secured[i] = converted;
            }
            else {
                secured[i] = ' ';
            }
        }
        return secured;
    }

    public static int RandomKey(){
        Random random = new Random();
        int min = 1;
        int max = 26;
        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
        return randomInt;
    }

    public static void Something(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input : ");
        int sum = 0;
        String input = sc.nextLine();
        while (!input.equals("q")){
            int current =  Integer.parseInt(input);
            sum += current;
            System.out.print("Enter input : ");
            input = sc.nextLine();
        }
        System.out.println("The sum is " + sum);

    }
}
