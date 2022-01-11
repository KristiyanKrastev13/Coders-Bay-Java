package com.daytwo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.print("Enter a number: ");
       // int number = sc.nextInt();
        //NumberInfo(number);
       //System.out.print("Enter a Hour : ");
       //int hour = sc.nextInt();
       //WorkHours(hour);
        System.out.print("Enter a grade: ");
        int grade = sc.nextInt();
        System.out.println(Grades(grade));



    }
    public static void NumberInfo(int numb){
        boolean isEven = false;
        int luckyNumb = 7;
        if (numb % 2 == 0){
            isEven = true;
        }
        else{
            isEven = false;
        }
        System.out.println("ist the number even? : " + isEven);
        System.out.println("ist the number odd? : " + !isEven);

        if (numb == luckyNumb){
            System.out.println("You got the lucky number");
        }
        else {
            System.out.println("This is not the magic number");
        }
        if (numb > -10 && numb < 10){
            System.out.println("The number is only 1 digit");
        }
        else{
            System.out.println("The number is 2 digits");
        }
    }

    public static void WorkHours(int hour)
    {
        if (hour > 7 && hour < 16)
        {
            if (hour > 11 && hour < 13)
            {
                System.out.println("We are in a lunch break");}
            else{
            System.out.println("We are working at the given hour");}
        }
        else
        {
            System.out.println("We are closed at the given hour");
        }
    }
    public static String Grades(int grade) {
        String result = "X";
        switch (grade) {
            case 1:
                result = "Very good";
                break;
            case 2:
                result = "Good";
                break;
            case 3:
                result = "Satisfactory";
                break;
            case 4:
                result = "Sufficient";
                break;
            case 5:
                result = "Not sufficient";
                break;

            default:
                result = "Wrong input is given!";
                break;
        }
        return result;

    }
}
