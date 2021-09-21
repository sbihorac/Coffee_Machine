package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] inventory = new int[5];
        inventory[0] = 400;     // water
        inventory[1] = 540;     // milk
        inventory[2] = 120;     // coffee beans
        inventory[3] = 9;       // disposable cups
        inventory[4] = 550;     // money

        System.out.println("The coffee machine has: \n" + "400 ml of water\n" +
                "540 ml of milk\n" + "120 g of coffee beans\n" +
                "9 disposable cups\n" + "$550 of money");

        System.out.println("Write action (buy, fill, take): ");
        String option = input.next();
        String action = "";
        switch (option){
            case "buy":
                 action = buy(inventory);
                break;
            case "fill":
                action = fill(inventory);
                break;
            case "take":
                System.out.println("I gave you $500");
                action = take(inventory);
                break;
            default:
                System.out.println("That is not an option");
        }
        System.out.println(action);
    }

    public static String buy (int[] inventory){
        Scanner input = new Scanner(System.in);

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int pick = input.nextInt();
        switch (pick) {
            case 1:
                inventory[0] -= 250;
                inventory[2] -= 16;
                inventory[3] -= 1;
                inventory[4] += 4;
                break;


            case 2:
                inventory[0] -= 350;
                inventory[1] -= 75;
                inventory[2] -= 20;
                inventory[3] -= 1;
                inventory[4] += 7;
                break;

            case 3:
                inventory[0] -= 200;
                inventory[1] -= 100;
                inventory[2] -= 12;
                inventory[3] -= 1;
                inventory[4] += 6;
                break;
            default:
                System.out.println("There is no such option");
                break;
        }

        String remnant = "The coffee machine has: \n" + inventory[0]  + " ml of water\n" + inventory[1] +
                " ml of milk\n" + inventory[2] + " g of coffee beans\n" + inventory[3] +
                " disposable cups\n" + "$" + inventory[4] + " of money";

        return remnant;
    }

    public static String fill(int[] inventory) {
        Scanner input = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add: ");
        int extraWater = input.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int extraMilk = input.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int extraCoffeeBeans = input.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int extraDisposableCups = input.nextInt();

        inventory[0] += extraWater;             // water
        inventory[1] += extraMilk;              // milk
        inventory[2] += extraCoffeeBeans;       // coffee beans
        inventory[3] += extraDisposableCups;    // disposable cups

        String remnant = "The coffee machine has: \n" + inventory[0] + " ml of water\n" + inventory[1] +
                " ml of milk\n" + inventory[2] + " g of coffee beans\n" + inventory[3] +
                " disposable cups\n" + "$" + inventory[4] + " of money";

        return remnant;
    }

    public static String take(int[] inventory){

        inventory[4] -= inventory[4];
        String remnant = "The coffee machine has: \n" + inventory[0] + " ml of water\n" + inventory[1] +
                " ml of milk\n" + inventory[2] + " g of coffee beans\n" + inventory[3] +
                " disposable cups\n" + "$" + inventory[4] + " of money";

        return remnant;
    }

}