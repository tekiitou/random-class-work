package compsci;

import java.util.Random;
import java.util.Scanner;

public class Assignment2 {

    /**
     * Prints out the options the user can choose from
     */
    public static void menu() {
        System.out.println("Test your math skills : ");
        System.out.println("\t 1. Addition");
        System.out.println("\t 2. Subtraction");
        System.out.println("\t 3. Multiplication");
        System.out.println("\t 4. Exit");
    }

    /**
     * Prompts user, takes input, validates it, and then returns it to be used for menu option selection
     * @return
     */
    public static int getAnswer() {
        Scanner input = new Scanner(System.in);


        while (!input.hasNextInt()) {      //if input is not a number, ask for a new input
            System.out.println("Enter numbers only");
            input.nextLine();
        }
        int select = input.nextInt();       //takes user choice input

        return select;
    }

    /**
     * prompts, gets users choice from menu options, and returns a valid selection
     * @return
     */
    public static int getChoice() {
        Scanner input = new Scanner(System.in);

        System.out.println("Select 1-3 to get 10 math problems, 4 to exit the program");
        int select = input.nextInt();       //takes user choice input

        while ((select < 1) || (select > 4)) {      //input validation
            System.out.println("Select 1 - 4 only");
            select = input.nextInt();
        }

        return select;
    }

    /**
     * randomly generates number and returns it
     * @return
     */
    public static int randomGenerator() {
        Random rand = new Random();
        int number = rand.nextInt(50);
        return number;
    }

    /**
     * return the value of two integers added
     * @param a
     * @param b
     * @return
     */
    public static int addition(int a, int b) {
        return a + b;
    }

    /**
     * return the value of two integers subtracted
     * @param a
     * @param b
     * @return
     */
    public static int subtraction(int a, int b) {
        return a - b;
    }

    /**
     * return the value of two integers multiplied
     * @param a
     * @param b
     * @return
     */
    public static int multiplication(int a, int b) {
        return a * b;
    }

    /**
     * Checks if answer inputted is correct, outputs matching string
     * Depending on if it is or not, c is set to 0 or 1, which will be added to score
     * @param a
     * @param b
     * @return
     */
    public static int checkAnswer(int a, int b) {
        int c = 0;

        if (a == b) {
            System.out.println("Correct, great job!\n");
            c = 1;
        }
        else {
            System.out.println("Incorrect\n");
            c = 0;
        }
        return c;
    }

    public static void main (String[] args) {
        int choice = 0;     //user selects from menu
        int number1;        //first random number to calculate with
        int number2;        //second random number
        int score = 0;      //tracks how many questions user answered correctly
        int answer = 0;     //users answer to math question

        System.out.println("**********Math Quizzer**********");     //display once at top

        do {
            menu();                 //display options menu
            choice = getChoice();       //take users input selection
            if ( choice == 4 ) {     //checks if user wants to exit
                break;
            }

            score = 0;  //if they decide to play again, reset score

            if ( choice == 1 ) {

                for (int k = 1; k <=10; k++ ) {     //loop for 10 questions

                    number1 = randomGenerator();        //randomly generate first number
                    number2 = randomGenerator();        //randomly generate second number
                    System.out.println(k + ". What is " + number1 + " + " + number2 + "?");     //output equation
                    answer = getAnswer();       //get answer from user (and validate it to be numerical only)
                    score += checkAnswer(answer, addition(number1, number2));
                    //^ checks if answer is correct and adjusts score accordingly ^
                }
            }
            else if ( choice == 2 ) {       //similar to above

                for (int k = 1; k <=10; k++ ) {

                    number1 = randomGenerator();
                    number2 = randomGenerator();
                    System.out.println(k + ". What is " + number1 + " - " + number2 + "?");
                    answer = getAnswer();
                    score += checkAnswer(answer, subtraction(number1, number2));
                }
            }
            else if ( choice == 3 ) {       //similar to above

                for (int k = 1; k <=10; k++ ) {

                    number1 = randomGenerator();
                    number2 = randomGenerator();
                    System.out.println(k + ". What is " + number1 + " x " + number2 + "?");
                    answer = getAnswer();
                    score += checkAnswer(answer, multiplication(number1, number2));
                }
            }


            System.out.println("You answered " + score + " correct\n");     //once 10 questions are done, output users score

        } while (choice != 4);      //loop until exit 4 is chosen

        System.out.println("Thank you for using the Math Quizzer Program!");        //end message
    }
}
