package compsci;

/*
Two codes put together. First was a total cost (items + tax) calculator. That got commented out
and at the bottom I just messed around with more methods. Practice makes perfect ig
Some calc methods, input methods, and return and void methods
 */

/******************************************************************************
 algorithm
 prompt user for the item they are purchasing
 take the input
 prompt user for retail price
 take input
 prompt user for quantity
 take input
 calculate retail cost and then calculate the total cost with a 0.065
 output name of the item, retail price, quantity & total cost
 *******************************************************************************/

import java.util.*;
public class Practice
{
    public static void main(String[] args) {
//        String retailItem;
//        double retailPrice, quantity, totalCost;
//
//        System.out.println("Enter the name of the item you purchased, retail price, and quantity");
//
//        retailItem = retailItem();
//        retailPrice = retailPrice();
//        quantity = quantity();
//        totalCost = totalCost(quantity, retailPrice);
//
//        System.out.println("Retail Item: " + retailItem);
//        System.out.println("Retail Cost: " + retailPrice);
//        System.out.println("Quantity: " + quantity);
//        System.out.println("Total Cost: " + totalCost);

//        System.out.println(gradeAvg());

        String name = "Test";
        twentyNames(name);

        String class1 = "CSCI2911";
        String class2 = "CSCI3911";

        if(class1.equals(class2)) {
            System.out.println("It is the same");
        }
        else {
            System.out.println("Doesn't match");
        }

        int age1 = 22;
        int age2 = 25;

        if (age1 == age2){
            System.out.println("It is the same");
        }
        else {
            System.out.println("Doesn't match");
        }

    }

    /**
     * Takes users input for item name
     * Returns string of item name
     * @return
     */
    public static String retailItem() {
        Scanner keyboard = new Scanner(System.in);
        String itemName = keyboard.nextLine();

        return itemName;
    }

    /**
     * Takes input of retail price
     * returns double of price
     * @return
     */
    public static double retailPrice() {
        Scanner keyboard = new Scanner(System.in);

        while (!keyboard.hasNextDouble()) {
            System.out.println("Enter numbers only");
            keyboard.nextLine();
        }
        double price = keyboard.nextDouble();

        return price;
    }

    /**
     * takes input of number of items
     * returns double of quantity of items
     * @return
     */
    public static double quantity(){
        Scanner keyboard = new Scanner(System.in);

        while(!keyboard.hasNextDouble()){
            System.out.println("Enter a number");
            keyboard.nextLine();
        }
        double quantity = keyboard.nextDouble();

        return quantity;
    }

    /**
     * takes in two doubles
     * calculates what the total cost would be based off of price, amount, and tax rate
     * retuerns that double value
     * @param a
     * @param b
     * @return
     */
    public static double totalCost(double a, double b){
        double totalCost = a*b*1.065;
        return totalCost;
    }

    public static double gradeAvg() {
        Scanner input = new Scanner(System.in);

        double grade;
        double total = 0;

        for (int k= 0; k < 3; k++){
            grade = input.nextDouble();
            total += grade;
        }
        return (total)/3;
    }

    public static double gradeAvg2(double a, double b, double c) {

        return (a+b+c)/3;
    }

    public static void twentyNames(String a) {
        for (int k = 0; k < 20; k++) {
            System.out.println(a);
        }
    }

}


