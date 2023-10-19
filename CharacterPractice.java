package compsci;

import java.util.Scanner;

/*
Basic code on how to check each character in a string.
Could be useful for validation purposes, passwords, etc.
 */

public class CharacterPractice {

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        char ch;

        System.out.println("Enter any character");
        String text = input.nextLine();

        for (int k = 0; k < text.length(); k++) {

            ch = text.charAt(k);

            if (Character.isLetter(ch)) {
                //System.out.println(ch + " is a letter");
                if (Character.isLowerCase(ch)) {
                    System.out.println(ch + " is a lower-case letter");
                } else if (Character.isUpperCase(ch)) {
                    System.out.println(ch + " is an upper-case letter");
                }
            }
            if (Character.isDigit(ch)) {
                System.out.println(ch + " is a digit");
            }
            if (Character.isSpaceChar(ch)) {
                System.out.println(ch + " is a space");
            }

        }


    }
}
