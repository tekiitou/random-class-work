package compsci;

import java.util.Scanner;

/*
Regular Expression can be kinda annoying to understand, so hopefully
seeing these examples and how they work can aid in your journey towards
getting it  :)
This code is checking the validity of entered things to determine
a certain users account type based off their ID number
 */

public class RegExPractice {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;
        boolean member = false;
        boolean valid;

        System.out.println("Enter your ID Number uwu");



        for (int k = 0; k < 3; k++) {

            text = input.nextLine();

            if (customerNumber(text)) {
                System.out.println("Welcome Customer " + text);
                member = true;
                break;
            }
            else if (employeeNumber(text)) {
                System.out.println("Welcome Employee " + text);
                member = true;
                break;
            }
            else if (patientNumber(text)) {
                System.out.println("Welcome Patient " + text);
                member = true;
                break;
            }
            else {
                if ( k != 2 ) {
                    System.out.println("Invalid Entry, Please Try Again");
                }
            }

        }

        if ( member != true ) {
            System.out.println("Too Many Failed Logins Detected, Please Try Again Later");
            //break or leave the code or something
        }
        else {
            System.out.println("Enjoy the program");
        }

    }

    public static boolean customerNumber(String custNo) {
        //valides customer number is format "LLLNNNN"

        //return custno.matches("\\D(3)\\d(4)");
        //or you could type it like
        return custNo.matches("[A-Za-z]{3}[0-9]{4}");
    }

    public static boolean employeeNumber(String custNo) {
        //valides customer number is format "L(N*8)"

        return custNo.matches("[A-Z][0-9]{8}");
    }

    public static boolean patientNumber(String custNo) {
        //valides customer number is format "L(N*8)"

        return custNo.matches("[0-9]{4}[-][A-Za-z]{2}");
    }
}
