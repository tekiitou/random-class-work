package compsci;

import java.util.Random;
import java.util.Scanner;

public class Assignment2Two {

    /**
     * Prints out the options the user can choose from
     */
    public static void menu() {
        System.out.println("Test your math skills : ");
        System.out.println("\t 1. Addition & Subtraction");
        System.out.println("\t 2. Multiplication & Division");
        System.out.println("\t 3. All Operations Survival Mode");
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

        System.out.println("Select 1-2 to get 10 math problems, 3 to play Survival and 4 to exit the program");
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
        int number = rand.nextInt(100);
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
     * 1. Creates two integers. Checks to see if they are valid numbers to divide by being that they :
     * Divide evenly (have no remainder)
     * The second integer must be less than the first, for obvious reasons
     * -- Note that the generator has been altered to not be able to generate a "0" as this results in undefined
     * While this could be remedied with an Arithmetic Exception, it just makes more sense to make it not a possibility
     * 2. If they don't, it generates a new set of integers, until they do
     * 3. Outputs equation string and returns divided value
     * @return
     */
    public static int division() {
        Random rand = new Random();
        int a = rand.nextInt(49)+1;
        int b = rand.nextInt(49)+1;

        while ((b>a)||(a%b != 0)) {      //clean division check

            a = rand.nextInt(49) + 1;
            b = rand.nextInt(49) + 1;
        }
        System.out.println(". What is " + a + " / " + b + "?");
        return a / b;
    }

    /**
     * Checks if answer inputted is correct, outputs matching string
     * Depending on if it is or not, c is set to 0 or 1, which will be added to score (and or lives depending on mode)
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
        int divAns = 0;        //just made this var cause im lazy lol
        //^ basically stores the answer to the division and runs the division method
        int operator = 5;       //for randomly generating the operator




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

                    operator = randomGenerator();       //randomly decides if user will be adding or subtracting
                    number1 = randomGenerator()/2;        //randomly generate first number
                    number2 = randomGenerator()/2;        //randomly generate second number

                    if (operator < 50) {     //decides operation
                        System.out.println(k + ". What is " + number1 + " + " + number2 + "?");     //output add
                        answer = getAnswer();       //get answer from user (and validate it to be numerical only)
                        score += checkAnswer(answer, addition(number1, number2));
                        //^ checks if answer is correct and adjusts score accordingly ^
                    }
                    else {
                        System.out.println(k + ". What is " + number1 + " - " + number2 + "?");     //output sub
                        answer = getAnswer();
                        score += checkAnswer(answer, subtraction(number1, number2));
                        //^ does the same but with subtraction ^
                    }

                }
                System.out.println("You answered " + score + " correct\n");     //once 10 questions are done, output users score
            }
            else if ( choice == 2 ) {       //similar to above

                for (int k = 1; k <= 10; k++) {

                    operator = randomGenerator();       //randomly decides if user will be adding or subtracting
                    number1 = randomGenerator()/2;
                    number2 = randomGenerator()/2;

                    if (operator < 50) {
                        System.out.println(k + ". What is " + number1 + " x " + number2 + "?");     //output multiplication
                        answer = getAnswer();       //get answer
                        score += checkAnswer(answer, multiplication(number1, number2));
                    }
                    else {
                        System.out.print(k);        //to keep track of the question number
                        divAns = division();        //runs division method and stores return to divAns
                        answer = getAnswer();       //get answer
                        score += checkAnswer(answer, divAns);       //adds 1 to score if correct
                    }
                }
                System.out.println("You answered " + score + " correct\n");     //once 10 questions are done, output users score
            }
            else if ( choice == 3 ) {

                int lives = 3;          //how many mistakes user can make
                int k = 1;              //keeps track of question number
                int adjust = 0;       //new variable to adjust score/lives by (so methods dont run multiple times)

                while ( lives != 0 ) {

                    operator = randomGenerator();
                    number1 = randomGenerator()/2;
                    number2 = randomGenerator()/2;

                    if (operator < 25) {     //decides operation
                        System.out.println(k + ". What is " + number1 + " + " + number2 + "?");     //output add
                        answer = getAnswer();
                        adjust = checkAnswer(answer, addition(number1, number2));
                        lives += adjust;
                        lives--;        //my dumb solution to keeping only one function for all score/life tracking...
                        //... if they get it correct, life gets one, which is subtracted to 0 so nothing happens. if wrong life..
                        //... gets 0, which is subtracted to -1, and they lose a life. and score can still be incremented without any changes
                        if (adjust == 0) {
                            System.out.println("Lives : " + lives);
                        }
                        score += adjust;
                    }
                    else if ( operator >= 25 && operator < 50) {
                        System.out.println(k + ". What is " + number1 + " - " + number2 + "?");     //output sub
                        answer = getAnswer();
                        adjust = checkAnswer(answer, subtraction(number1, number2));
                        lives += adjust;
                        lives--;
                        if (adjust == 0) {
                            System.out.println("Lives : " + lives);
                        }
                        score += adjust;
                    }
                    else if (operator >= 50 && operator < 75) {
                        System.out.println(k + ". What is " + number1 + " x " + number2 + "?");     //output multiplication
                        answer = getAnswer();       //get answer
                        adjust = checkAnswer(answer, multiplication(number1, number2));
                        lives += adjust;
                        lives--;
                        if (adjust == 0) {
                            System.out.println("Lives : " + lives);
                        }
                        score += adjust;
                    }
                    else if (operator >= 75 && operator <=100){
                        System.out.print(k);
                        divAns = division();
                        answer = getAnswer();
                        adjust = checkAnswer(answer, divAns);
                        lives += adjust;
                        lives--;
                        if (adjust == 0) {
                            System.out.println("Lives : " + lives);
                        }
                        score += adjust;
                    }
                    else {      //backup
                        System.out.println("Error occured");
                    }

                    if (lives == 0) {
                        break;
                    }
                    k++;
                }
                System.out.println("Your score is : " + score + "\n");     //once they run out of lives, score is given
            }


        } while (choice != 4);      //loop until exit 4 is chosen

        System.out.println("Thank you for using the Math Quizzer Program!");        //end message
    }
}
