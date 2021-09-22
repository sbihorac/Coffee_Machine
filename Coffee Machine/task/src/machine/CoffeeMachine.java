package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] contents = new int[5];
        contents[0] = 400;                  // water
        contents[1] = 540;                  // milk
        contents[2] = 120;                  // coffee beans
        contents[3] =   9;                  // disposable cups
        contents[4] = 550;                  // money ($)


        String option;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            option = input.next();
            switch (option) {
                case "buy":
                    buy(contents);
                    break;
                case "fill":
                    fill(contents);
                    break;
                case "take":
                    System.out.println(take(contents));
                    break;
                case "remaining":
                    System.out.println(remaining(contents));
                    break;
                case "exit":
                    break;
            }
        } while (!option.equals("exit"));
    }
    public static void fill(int[] contents) {
        Scanner input = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add: ");
        int extraWater = input.nextInt();
        contents[0] += extraWater;          // adding water

        System.out.println("Write how many ml of milk you want to add: ");
        int extraMilk = input.nextInt();
        contents[1] += extraMilk;           // adding milk

        System.out.println("Write how many grams of coffee beans you want to add: ");
        int extraCoffeeBeans = input.nextInt();
        contents[2] += extraCoffeeBeans;    // adding coffee beans

        System.out.println("Write how many disposable cups you want to add: ");
        int extraDisposableCups = input.nextInt();
        contents[3] += extraDisposableCups; // adding disposable cups



    }

    public static String take (int[] contents) {

        String tell = "I gave you $" + contents[4];
        contents[4] -= contents[4];
        return tell;

    }

    public static String remaining(int[] contents) {


        return "The coffee machine has:\n" + contents[0] + " ml of water\n" + contents[1] +
                " ml of milk\n" + contents[2] + " g of coffee beans\n" + contents[3] +
                " disposable cups\n" +"$" + contents[4] + " of money";

    }

    public static void buy(int[] contents) {

        Scanner input = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,\n" +
                           " back - to main menu:");
        // do this with the for loop within switch statement:

        String pick = input.next();

        switch (pick){
            case "1":
                int needWater = 250, needCoffeeBeans = 16, cost = 4;
                if (contents[0] < needWater || contents[2] < needCoffeeBeans || contents[3] < 1) {
                    System.out.println("Sorry, not enough resources!");
                } else {
                    System.out.println("I have enough resources, making you coffee!");
                    contents[0] -= needWater; contents[2] -= needCoffeeBeans; contents[3] -= 1;
                    contents[4] += cost;
                }
                break;
            case "2":
                 needWater = 350; int needMilk = 75; needCoffeeBeans = 20; cost = 7;
                if (contents[0] < needWater || contents[1] < needMilk || contents[2] < needCoffeeBeans ||
                        contents[3] < 1) {
                System.out.println("Sorry, not enough resources!");
                } else {
                    System.out.println("I have enough resources, making you coffee!");
                    contents[0] -= needWater; contents[1] -= needMilk; contents[2] -= needCoffeeBeans;
                    contents[3] -= 1; contents[4] += cost;
                }
                break;
            case "3":
                needWater = 200; needMilk = 100; needCoffeeBeans = 12; cost = 6;
                if (contents[0] < needWater || contents[1] < needMilk || contents[2] < needCoffeeBeans ||
                        contents[3] < 1) {
                    System.out.println("Sorry, not enough resources!");
                } else {
                    System.out.println("I have enough resources, making you coffee!");
                    contents[0] -= needWater; contents[1] -= needMilk; contents[2] -= needCoffeeBeans;
                    contents[3] -= 1; contents[4] += cost;
                }
                break;
            case "back":
                break;
        }
        
    }

}




