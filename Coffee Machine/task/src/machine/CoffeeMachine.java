package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Starting to make a coffee\n" + "Grinding coffee beans\n" +
                "Boiling water\n" + "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" + "Pouring some milk into the cup\n" +
                "Coffee is ready!");

        System.out.println("How many cups of coffee you will need: ");
        int n = input.nextInt();

        System.out.println("For " + n + " cups of coffee you will need: \n" +
                            water(n) + " ml of water\n" + milk(n) + " ml of milk\n" +
                            coffeeBeans(n) + " g of coffee beans");

    }

    public static int water(int n) {
        return 200 * n;
    }

    public static int milk(int n) {
        return 50 * n;
    } 

    public static int coffeeBeans(int n) {
        return 15 * n;
    }

}
