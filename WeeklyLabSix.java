package compsci;

/*
Kinda tired so im ngl this code summary is gonna suck
Idek what this code is lol basically it randomly generates a Hawaiian fish
and the user has to guess what it is
You get a point if you're right, get the highest score you can.
Guess I was learning equalsIgnoreCase and random generation??
Beats me, this was awhile ago
 */

import java.util.*;
/*teki

Algorithm :
1. Assign each fish to an integer starting from 0
2. Randomly generate a number (and thus fish)
3. Prompt user to guess a fish
3a. Check if the guess was valid
4. Check if they match & display results
4a. Give point if correct
5. Loop steps 2-4 10 times
6. Display the amount of times the user guessed correctly

 */


public class WeeklyLabSix {

    //array of fish options
    public static String[] fish = {"Ahi", "Opahu", "Uku", "Ono"};

    /**
     * Displays the options (up to 4)
     * Works off of array so that it can easily be changed
     */
    public static void options() {
        System.out.println("I'm thinking of a fish.");
        System.out.print("Is it ");
        for (int k = 0; k < 4; k++) {
            System.out.print(fish[k]);
            if (k < 3) {
                System.out.print(", ");
            }
            else {
                System.out.println("?");
            }
        }
    }

    /**
     * Takes user input and validates that it is one of the possible options
     * returns the users valid input
     * @return
     */
    public static String getGuess() {
        Scanner input = new Scanner(System.in);
        String guess = "no";


        options();

        while ( guess.equalsIgnoreCase("AHI") && guess.equalsIgnoreCase("OPAHU") && guess.equalsIgnoreCase("UKU") && guess.equalsIgnoreCase("ONO")) {      //if input is not a number, ask for a new input
            System.out.println("Please select one of the valid options");
            guess = input.nextLine().toUpperCase();
        }

        return (input.nextLine()).toUpperCase();
    }

    /**
     * Randomly generates a number between 0 and 3, and returns it
     * @return
     */
    public static int randomGenerator() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        return rand.nextInt(4);
    }

    /**
     * Takes in 2 string inputs,formats and outputs them
     * @param a
     * @param b
     */
    public static void choices(String a, String b) {
        System.out.println("You chose " + a);
        System.out.println("Computer chose " + b + "\n");
    }

    /**
     * takes the string inputs and compares them. if they match, int a is set to 1, to be added to points
     * @param b
     * @param c
     * @return
     */
    public static int compareFish(String b, String c) {
        int a = 0;

        if (b.equalsIgnoreCase(c)) {
            a = 1;
        }
        else {
            a = 0;
        }

        return a;
    }

    /**
     * Takes in point value, formats and outputs it
     * @param a
     */
    public static void finalScore(int a) {
        System.out.println("Number of correct guesses : " + a);
    }


    public static void main(String[] args) {

        int lup = 0;    //which loop number we're on, 1-10;
        int ran = 0;    //fish random number
        int point = 0;  //tracks users score
        String guess;   //user guess
        String cpu;     //cpus fish


        while ( lup != 10) {

            guess = getGuess();

            ran = randomGenerator();    //random number is generated
            cpu = fish[ran];            //fish is selected based off that

            cpu = cpu.toUpperCase();        //convert to Upper for display
            guess = guess.toUpperCase();        //same as above

            choices(cpu, guess);
            //output info


            point += compareFish(cpu, guess);
            //compares and adds point if they got it correct

            lup++;      //adds 1 to loop counter
        }
        finalScore(point);      //displays final total score of user
    }
}
