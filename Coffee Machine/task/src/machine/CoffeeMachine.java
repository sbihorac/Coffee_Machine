package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Starting to make a coffee\n" + "Grinding coffee beans\n" +
                "Boiling water\n" + "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" + "Pouring some milk into the cup\n" +
                "Coffee is ready!");

        System.out.println("Write how many ml of water the coffee machine has: ");
        int hasWater = input.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int hasMilk = input.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int hasCoffeeBeans = input.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int n = input.nextInt();

        String reply = replyBack(n, hasWater, hasMilk, hasCoffeeBeans );

        System.out.println(reply);
        
    }
    public static String replyBack(int n, int hasWater, int hasMilk, int hasCoffeeBeans){
        
        int waterPerCup = 200, milkPerCup = 50, coffeeBeansPerCup = 15;

        // ingredients necessary for n cups:
        int[] nCups = new int[3];
        nCups[0] = n * waterPerCup;                                                 //water
        nCups[1] = n * milkPerCup;                                                  // milk
        nCups[2] = n * coffeeBeansPerCup;                                           // coffee beans

        // how many cups can be made with the ingredients at our disposal:
        int[] maxCups = new int[3];
        maxCups[0] = hasWater / 200;
        maxCups[1] = hasMilk / 50;
        maxCups[2] = hasCoffeeBeans / 15;

        int M = Math.min(Math.min(maxCups[0],maxCups[1]),maxCups[2] );

        // extra cups that the coffee machine can make:
        int[] extraCups = new int[3];
        extraCups[0] = maxCups[0] - n;
        extraCups[1] = maxCups[1] - n;
        extraCups[2] = maxCups[2] - n;

        int N = Math.min(Math.min(extraCups[0],extraCups[1]),extraCups[2]);

        String ans = null;

        if (nCups[0] > hasWater || nCups[1] > hasMilk || nCups[2] > hasCoffeeBeans) {
                ans = "No, I can make only " + M + " cup(s) of coffee";
        } else if (nCups[0] == hasWater && nCups[1] == hasMilk && nCups[2] == hasCoffeeBeans ) {
                ans = "Yes, I can make that amount of coffee";
        } else if (nCups[0] < hasWater && nCups[1] < hasMilk && nCups[2] < hasCoffeeBeans) {
            if (N >= 1) {
                ans = "Yes, I can make that amount of coffee (and even " + N + " more than that)";
            } else if (N == 0) {
                ans = "Yes, I can make that amount of coffee";
            }
        }

        return ans;
    }
}