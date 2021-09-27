package machine;

public class realMachine {
    public static void main (String[] args){


        String[] contents = new String[5];
        contents[0] = "400";                  // water
        contents[1] = "540";                  // milk
        contents[2] = "120";                  // coffee beans
        contents[3] =   "9";                  // disposable cups
        contents[4] = "550";

        CoffeeMachine.service(contents);
    }
}
