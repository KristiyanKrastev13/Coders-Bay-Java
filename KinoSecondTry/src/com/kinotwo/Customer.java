package com.kinotwo;

import java.util.ArrayList;

public class Customer {
    public ArrayList<String> Food;

    public void setMoney(double money) {
        if(Money - money > 0)
               Money -=money;
        else
            System.out.println("Not enought money");
    }

    public double Money;
    public int Ticket;
    public String Movie;

    public Customer(String movie,double money, int ticket) {
        Money = money;
        Ticket = ticket;
        Movie = movie;
        Food = new ArrayList<>();
    }
    public Customer() {

    }
}
