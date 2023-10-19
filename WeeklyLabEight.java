package compsci;

import java.util.Scanner;

/*
Decent info/practice/resource for both methods and RegEx
Accepts a number of inputs and makes sure they are valid inputs (loops until they are)
Then displays the Users inputs back at the end
Imo if I have more time I'll revisit this one as I really wanted to make
specific error messages (kinda like I did for the first) for all of them
Plus there's gotta be a few inefficiencies somewhere
 */

public class WeeklyLabEight {

    /**
     * Checks if the text has a first name at 2-10 letters long, and last name 3-20 LETTERS long
     * @param fullName
     * @return
     */
    public static boolean nameValid(String fullName) {
        //format is letters only
        return fullName.matches("[A-Za-z]{2,10}\s[A-Za-z]{3,20}");
    }

    /**
     * Extra check, determines if they did a "proper" input, but didn't capitalize their name.
     * This allows the computer to diagnose and tell you exactly what to change/fix for next input
     * Would've done this for all but ran out of time  :P
     * @param fullName
     * @return
     */
    public static boolean nameCaseValid(String fullName) {
        //format is Upper case for each name
        return fullName.matches("[A-Z]{1}[A-Za-z]{1,9}\s[A-Z]{1}[A-Za-z]{2,19}");
    }

    /**
     * validates customer number is format "@#########"
     * and also that its only numbers
     * @param ID
     * @return
     */
    public static boolean idNumber(String ID) {

        return ID.matches("[@]{1}[0-9]{9}");
    }

    /**
     * validates customer number is format "(###)###-####"
     * and also only numbers
     * @param phone
     * @return
     */
    public static boolean phoneNumber(String phone) {

        return phone.matches("[(]{1}[0-9]{3}[)]{1}[0-9]{3}[-]{1}[0-9]{4}");
    }

    /**
     * validates customer number is format "(##/##/####)"
     * and also only numbers
     * and also the very first digit can only be 0-1
     * @param date
     * @return
     */
    public static boolean birthDay(String date) {

        return date.matches("[0-1]{1}[0-9]{1}['/'][0-3]{1}[0-9]{1}['/']{1}[0-9]{4}");
    }

    public static void main (String [] args) {

        Scanner input = new Scanner(System.in);

        String text;                            //text to be inputted by user
        String[] output = new String[4];        //creates array to store inputs
        int count = 0;                          //keeps track of array compartments throughout code
        boolean pass = false;                   //check for valid inputs along the way

        System.out.println("*****Regular Expressions*****");
        System.out.println("Enter your full name");
        text = input.nextLine();
        pass = nameValid(text);     //checks if text is in alpha
        pass = nameCaseValid(text);         //checks if text is properly capitalized


        while (!pass) {     //if true bool isn't detected, enter while loop until only alpha name is game
            if (!nameValid(text)) {
                System.out.println("Please enter only alpha letters (A-Z)");
            }
            else if (!nameCaseValid(text)) {
                System.out.println("Please Uppercase First Letters");
            }

            text = input.nextLine();
            pass = nameCaseValid(text);
        }
        pass = false;       //reset bool for next loop
        output[count] = text;       //sets valid text to array

        System.out.println("Enter your Student ID number");
        text = input.nextLine();
        pass = idNumber(text);

        while(!pass) {      //if proper format isnt detected enter and stay in loop until it is
            if(!idNumber(text)) {
                System.out.println("Please enter numbers only in proper format @#########");
            }
            text = input.nextLine();
            pass = idNumber(text);

        }
        count++;        //add to count to access new compartment
        pass = false;       //reset bool value for next loop again
        output[count] = text;           //store validated text to new compartment


        System.out.println("Enter Your Phone Number");
        text = input.nextLine();
        pass = phoneNumber(text);
        while(!pass) {          //similiar to ID but with phone number format
            if(!phoneNumber(text)) {
                System.out.println("Please enter numbers only in proper format (###)###-####");
            }
            text = input.nextLine();
            pass = phoneNumber(text);
            count++;
        }
        count++;
        pass = false;
        output[count] = text;
        //same as above

        System.out.println("Enter Your Birthday (Month/Day/Year)");
        text = input.nextLine();
        pass = birthDay(text);
        while(!pass) {      //similiar to above, except the first number must be 0-1 and follows a different formatting
            if(!idNumber(text)) {
                System.out.println("Please enter numbers only in proper format ##/##/####");
            }
            text = input.nextLine();
            pass = phoneNumber(text);
        }
        count++;
        pass = false;
        output[count] = text;
        //same as above

        //wanted to do something a bit cleaner/cooler with the array at the end here but ran out of time so we do it the easy way
        System.out.print("ID : " + output[1] + "\t");
        System.out.print("Name : " + output[0] + "\t");
        System.out.print("Phone : " + output[2] + "\t");
        System.out.print("Birthday : " + output[3] + "\t");


    }
}
