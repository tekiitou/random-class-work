package compsci;

import java.util.*;

/*
Messing around with methods some more, this time using
a lot of return methods. Learning how variables interact yada yada
Another pretty messy one ngl
 */
public class MoreMethods {

    public static void main(String[] args) {

        Random rand = new Random(10);

        int number1 = rand.nextInt(10);
        int number2 = rand.nextInt(10);

        System.out.println(number1 + " + " + number2 + " = " + sub(number1,number2));

//        add(5,6);
        int a = 5;
        int b = 6;
        add(a,b);
        add(34.50,2.25);
        add("Susie", "Que");

        int x=10;
        int y=20;
        int subresult = sub(x,y);       //calling method and storing the returned value to subresult

        System.out.printf("");
        System.out.println(x + " - " + y + " = " + sub(x,y));       //calling method in sout
        System.out.println(x + " - " + y + " = " + subresult);      //calling integer
    }

    /**
     * add = takes in two integers and outputs sum
     * @param num1
     * @param num2
     */
    public static void add(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
    }

    /**
     * add = takes in 3 integers and outputs sum
     * @param num1
     * @param num2
     * @param num3
     */
    public static void add(int num1, int num2, int num3) {
        System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + (num1+num2+num3));
    }

    /**
     * add = takes in two doubles and outputs sum
     * @param num1
     * @param num2
     */
    public static void add(double num1, double num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
    }

    /**
     * sub = subtracts two integers and returns the value
     * @param num1
     * @param num2
     * @return
     */
    public static int sub(int num1, int num2) {
        int result = num1 - num2;
        return result;
        //or we could just return num1-num2
    }

    /**
     * add = takes in two strings and outputs them
     * @param n1
     * @param n2
     */
    public static void add(String n1, String n2) {
        System.out.println(n1 + " & " + n2);
    }
}
