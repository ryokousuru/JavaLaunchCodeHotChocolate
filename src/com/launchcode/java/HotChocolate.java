package com.launchcode.java;

import java.util.concurrent.TimeUnit;

public class HotChocolate {

    public static final double tooHot = 185;
    public static final double tooCold = 158;

    public static void drinkHotChocolate(double cocoaTemp) throws TooHotException, TooColdException, InterruptedException {
        if (cocoaTemp >= tooHot) {
            throw new TooHotException();
        } else if (cocoaTemp <= tooCold) {
            throw new TooColdException();
        }
    }

    public static void main(String[] args) throws TooHotException, TooColdException, InterruptedException{
        // write your code here
        double currentCocoaTemp = 290;
        boolean wrongTemp = true;
        while (wrongTemp) {
            try {
                drinkHotChocolate(currentCocoaTemp);
                System.out.println("The cocoa was really yummy!");
                wrongTemp = false;
            } catch (TooHotException e1) {
                System.out.println("Way too hot!!");
                currentCocoaTemp = currentCocoaTemp - 5;
            } catch (TooColdException e2) {
                System.out.println("Needs to be warmed up a little.");
                currentCocoaTemp = currentCocoaTemp + 5;
            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("I drank it all up.");
    }
}

