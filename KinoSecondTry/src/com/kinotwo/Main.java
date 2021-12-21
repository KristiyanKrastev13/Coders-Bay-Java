package com.kinotwo;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Movie[] movies = new Movie[4];
        movies[0] = (new Movie("Batman", "3D","23:15", 1, true));
        movies[1] = (new Movie("Superman", "2D","20:15", 2, false));
        movies[2] = (new Movie("Thor", "3D","22:15", 3, true));
        movies[3]= new Movie("Spiderman", "3D", "23:30", 4 , true);

        PrintMovies(movies);
        Scanner scanner = new Scanner(System.in);

        int choose =0;
        do{
            System.out.print("Pick the Number of the available movie you want to watch: ");
            choose = scanner.nextInt();

        }while (choose < 0 || choose > movies.length|| movies[choose].Avaiability == false);


        long minutesTillMovie = 0;
        Customer customer = new Customer();
        boolean isMoviepicked = false;



        if (IsPickCorrect(choose)){
            int ticketNumber = TicketGenerator();
            customer = new Customer(movies[choose].Name, 5, ticketNumber);
            long timeTillMovieStart = TimeTillMovie(movies[choose].Time.trim());
            String timeTo = Convert(timeTillMovieStart);
            minutesTillMovie = timeTillMovieStart;
            System.out.printf("There is " + timeTo +" until " + movies[choose].Name + " stars.");
            System.out.println();
            isMoviepicked = true;
        }
        else{
            System.out.print("Sorry no such movie or movie is not available");
        }
        if (isMoviepicked){
            if (minutesTillMovie > 10){

                String input = "";
                do{
                    System.out.print("Go to shop? (yes/no) :");
                    input = scanner.next();
                }while (!input.equals("yes") && !input.equals("no"));
                if(input.equalsIgnoreCase("yes")) {
                    PrintShop();
                    int buying = 0;
                    do{
                        System.out.println("What whould you like to buy? :");
                        buying = scanner.nextInt();
                    }while( buying < 1 || buying > 3);
                    BuyingProcess(buying, customer);
                    while (true) {
                        System.out.print("Do you want something else? (yes/no)");
                        String anwser = scanner.next();
                        if (anwser.equalsIgnoreCase("yes")) {
                            System.out.print("Pick an item :");
                            int secondpick = scanner.nextInt();
                            if (secondpick > 0 && secondpick < 4) {
                                BuyingProcess(secondpick, customer);
                            } else {
                                System.out.println("wrong pick!");
                            }
                        } else {
                            break;
                        }
                    }
                }

                }
            }
            System.out.printf("The movie %s starts enjoy your stay! %n", customer.Movie);

            if (customer.Food.size() > 0) {
                System.out.print("You have this items to ear during the movie :");
                System.out.println(customer.Food);
            }
        }



    public static void PrintMovies(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {

            System.out.printf(i+ "-> %-10s | %s | %-5s | %s | %-20s",movies[i].Name, movies[i].Type,movies[i].Time,movies[i].Room, movies[i].Avaiability);
            System.out.println();

        }
    }
    public static boolean IsPickCorrect(int numb){
        if(numb <= 2 && numb >=0){
            return true;
        }
        System.out.println("Movie with this number does not exits!");
        return false;
    }
    public static int TicketGenerator(){
        Random rnd = new Random();
        int ticketnumb = rnd.nextInt(100)+100;
        return  ticketnumb;
    }
    public static long TimeTillMovie(String time)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime date = LocalTime.now();
        String text = date.format(formatter);
        LocalTime parsedDate1 = LocalTime.parse(time, formatter);
        LocalTime parsedDate = LocalTime.parse(text, formatter);
        long diffInMinutes = java.time.Duration.between(parsedDate, parsedDate1).toMinutes();
        return  diffInMinutes;
    }

    public static String Convert(long t){
        long hours = t / 60;
        long minutes = Math.abs(t) % 60;
        String result = String.format("%d:%d",hours,minutes);
        return result;
    }
    public  static void PrintShop(){
        System.out.println("1-> M&Ms     |  2.40€");
        System.out.println("2-> Popcorn  |  2.00€");
        System.out.println("3-> Chips    |  1.50€");
    }
    public static void BuySomethingFree(int product, Customer person){
        switch (product){
            case 1: person.Food.add("M&Ms"); break;
            case 2: person.Food.add("Popcorn");break;
            case 3: person.Food.add("Chips"); break;
        }
    }
    public static void BuySomething(int product, Customer customer){
        if(customer.Money > 2.40){
        switch (product){
            case 1: customer.Food.add("M&Ms"); customer.Money -= 2.40; break;
            case 2: customer.Food.add("Popcorn");customer.Money -= 2.00; break;
            case 3: customer.Food.add("Chips"); customer.Money -= 1.50; break;}
        }
        else {
            System.out.println("not enought money");
        }

    }
    public static boolean IsPrime(int number)
    {
        if(number == 1) return false;
        if(number == 2) return true;
        if(number % 2 == 0) return false;
        for(int i = 3; i < number; i += 2)
        {
            if (number % i == 0) return false;
        }
        return true;
    }
    public static boolean GetBonus(int numb){
        if(IsPrime(numb))return  true;
        if(numb % 10 == 0) return true;
        else
            return false;
    }

    public static void BuyingProcess(int numb,Customer customer){
        Scanner scanner = new Scanner(System.in);
        Random rd = new Random();
        int random = rd.nextInt(1001);
        System.out.printf("You got the number %d for the game :", random);

        if(GetBonus(random)){
            System.out.println("You win a free item :)");
            BuySomethingFree(numb,customer);
        }
        else{
            BuySomething(numb,customer);
            System.out.println("Sorry you dont win, maybe next time.");
        }
    }



}
