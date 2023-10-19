package compsci;


import java.util.Random;
import java.util.Scanner;

/*
    Fun little code to make a christmas tree.
    User can pick how many rows, and it will generate (somewhat) evenly
    spaced trunks through the tree, as well as randomly add in ornaments
    Happy holidays everyone  <3
 */
public class MoreLoops {

    public static void main (String args[]) {

       /* int number = 0;
        while (number <= 50) {
            if (number%2 != 0) {
                System.out.println(number);

            }
            number++;
        }*/

        /*Scanner input= new Scanner(System.in);
        System.out.println("Input the number you'd like to factorialize");
        int number = input.nextInt();

        for (int k = number; k > 0; k--) {
            if ( k == number ) {
                number = 1;
            }
            number *= k;
        }
        System.out.println(number);*/


        System.out.println("How many layers would you like the christmas tree to have");
        Scanner input = new Scanner(System.in);     //asks for user input
        Random randomNumber = new Random();         //random num gen for ornaments

        int row = input.nextInt();
        int space = row;            //how many spaces for each row
        int trunk = row;            //for the bottom
        int star = 1;               //tracks amount of stars to output
        int mod;                    //how many rows of leaves before a trunk is shown
        int orna;                   //random chance to have an ornament
        boolean dub = false;        //checks removes chance for doubled up ornaments

        if (row%2 == 0) {       //set spacing for trunks based on users input #
            mod = 2;
        }
        else {
            mod = 3;
        }

        do {

            for (int j = row; j > 0; j--) {     //adds spaces to center the leaves
                System.out.print(" ");
            }
                for (int k = star; k > 0; k-- ) {

                    orna = randomNumber.nextInt(4) + 1;     //25% chance to make an ornament
                    if ( (dub == false) && (orna == 3 ) ) {
                        System.out.print(" O");     //print ornament
                        dub = true;     //turns off chance to get ornament for at least one
                    }
                    else {
                        System.out.print(" *");     //print star
                        dub = false;   //turns back on ornament chance
                    }
                }

            if ( (row-1)%mod == 0) {          //add trunks throughout
                System.out.println();
                for (int d = space; d > 1; d--) {
                    System.out.print(" ");
                }
                System.out.print(" | |");
            }
            System.out.println();   //reset line
            row--;
            star++;     //edit values before next loop

        } while (row > 0);      //end loop

        //trunk at bottom
        for (int j = trunk; j > 0; j--) {
            System.out.print(" ");
        }
        System.out.println("| |");
        for (int j = trunk; j > 0; j--) {
            System.out.print(" ");
        }
        System.out.println("| |");
    }

}

