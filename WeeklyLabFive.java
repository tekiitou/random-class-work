package compsci;


import java.util.*;

/*
Pretty simple program. Takes users amount in, then lets them select
what they want to convert it. Then uses methods to do so and outputs it
Nothin too crazy
 */

/* teki

Algorithm :
1. Output options
2. Accept user input
2a. Loop until they enter a valid input (1-4)
3. Take users US dollar amount to convert
3a. Loop until they enter a positive amount above 0;
4. Depending on the input, run the according functions calculation
5. Output the converted amount
6. Loop from step one until a 4 input is given, in which case exit

 */
public class WeeklyLabFive {

    public static double calcAmount(double a, double b) {   //calculated amount for later
        return (a * b);
    }
    public static double Euro(double a) {
        return a * 0.952248;
    }
    public static double Pesos(double a) {
        return a * 17.7132;
    }
    public static double Yen(double a) {
        return a * 149.402;
    }
    public static int getMenuChoice() {
        Scanner input = new Scanner(System.in);
        int select = input.nextInt();       //take choice input

        while ((select < 1) || (select > 4)) {
            System.out.println("Invalid Entry : Must be between 1 - 4");
            select = input.nextInt();
        }

        return select;
    }

    public static double dollarAmount() {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter the number of US Dollars you would like to convert");     //take input for amt to convert
        double amount = input.nextDouble();
        while (amount <= 0) {             //user must enter number above 0
            System.out.println("Invalid Entry : Must be a positive integer (above 0)");
            amount = input.nextDouble();
        }
        return amount;
    }


    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("***************************************");      //output options
            System.out.println("1. Convert to Euro");
            System.out.println("2. Convert to Mexican Pesos");
            System.out.println("3. Convert to Japanese Yen");
            System.out.println("4. Exit Program");
            double converted = 0.0;
            String type = " ";

            choice = getMenuChoice();

            if ( choice == 4 ) {     //checks if user wants to exit
                break;
            }

            double american = dollarAmount();       //sets dollar amount to convert

            if ( choice == 1 ) {
                //Euro Selected
                converted = Euro(american);         //convert to Euro
                type = "Euro";
            }
            else if ( choice == 2 ) {
                //Pesos Selected
                converted = Pesos(american);         //convert to Pesos
                type = "Mexican Pesos";
            }
            else if ( choice == 3 ) {
                //Yen Selected
                converted = Yen(american);         //convert to Yen
                type = "Japanese Yen";
            }

            System.out.print(american + " US Dollars : ");      //output values at the end
            System.out.printf("%,.2f", converted);              //round to hundreth
            System.out.println(" " + type + "\n");


        }  while ( choice != 4);        //exits when 4 is selected

        System.out.println("Thank you for using the program");
        System.out.println("***************************************");
    }


}
