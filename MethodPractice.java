

package compsci;

import java.util.*;

/*
Honestly this code is chaotic, sry in advance if ur trying to understand it lol
I was just messing around with methods. Perhaps some tidbit could provide some use to someone
but its pretty unorganized
 */

public class MethodPractice {

    public static void main(String[] args) {
        /*System.out.println("We are writing methods today\n");
        displayMessage();       //calling the method below to main
        menu();
        adding();
        String name = "Jerry";
        personalMessage(name);
        personalMessage("Sue");*/

        /*Scanner input = new Scanner(System.in);
        System.out.println("Welcome! Whats your name?");
        String name = input.nextLine();
        System.out.println("Now input your age");
        int age = input.nextInt();
        printInfo(name, age);*/

        /*double first = 6.2;
        double second = 8.8;
        doubleAdd(first, second);
        doubleAdd(19.7, 20.3);*/

        /*String studentName = getName();
        personalMessage(studentName);*/

        menu();
        int choice = getChoice();
        if (choice == 1) {
            System.out.println("you choose option 1");
        }
        else if (choice == 2) {
            System.out.println("you choose option 1");
        }
        else {
            System.out.println("you picked an invalid option, so you get nothing!");
        }
    }

    /**
     * Displays a preset message
     */
    public static void displayMessage() {
        System.out.println("Aloha, it's almost Friday!");
    }

    /**
     * outputs the menu options
     */
    public static void menu() {
        System.out.println("Your Name's Menu");
        System.out.println("1. Choice one");
        System.out.println("2. Choice two");
    }

    /**
     * getChoice = gets the menu choice of the user
     * @return
     */
    public static int getChoice() {
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like, 1 or 2?");
        return input.nextInt();
    }

    /**
     * Adds preset integers and outputs the sum
     */
    public static void adding() {
        int x=2;
        int y=55;
        System.out.println("Sum : " + (x+y));
    }

    /**
     *  Method takes in a string and prints out a personalized method
     * @param
     */
    public static void personalMessage(String n) {      //creating void method with one argument
        System.out.println("Aloha " + n);
    }

    /**
     * Using String n and int a, it prints a personal msg
     * @param n
     * @param a
     */
    public static void printInfo(String n, int a) {
        System.out.println("Aloha " + n);
        System.out.println("You are " + a + " years old");
    }

    /**
     * Combines double a and double b, printing the sum
     * @param a
     * @param b
     */
    public static void doubleAdd(double a, double b) {
        System.out.println("Sum of doubles " + (a+b));
    }

    /**
     * combines the two integers and stores them to the int result
     * @param num1
     * @param num2
     * @return
     */
    public static int sum(int num1, int num2) {     //if you want the method to output something, INT
        int result;
        result = num1 + num2;
        return result;
    }

    /**
     * Asks for name and then stores user input to String name
     * @return
     */
    public static String getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();

        return name;
    }
}
