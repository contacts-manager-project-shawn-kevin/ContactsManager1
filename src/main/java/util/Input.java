package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(){
        return this.scanner.nextLine();
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return getString();
    }

    public boolean yesNo(){
        return yesNo("Enter yes or no.");
    }

    public boolean yesNo(String prompt){
        System.out.print(prompt);
        String response = this.scanner.next();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            return true;
        };
        return false;
    }


    public int getInt(){
//        System.out.print("Enter an integer: ");
        String userInput = getString();
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid value entered, enter an integer: ");
        }
        return getInt();
    }

    public int getInt(String prompt){
        System.out.print(prompt);
        return getInt();
    }

    public int getInt(int min, int max){
        System.out.printf("Enter an integer between " + min + " and " + max + ": ");
        int userInt = getInt();

        if (userInt > max || userInt < min) {
            return getInt(min, max);
        }

        return userInt;
    }

    public int getInt(int min, int max, String prompt){
        System.out.print(prompt);
        int userInt = getInt();

        if (userInt > max || userInt < min) {
            return getInt(min, max);
        }

        return userInt;
    }

    public double getDouble(){
//        System.out.print("Enter a number: ");
        String userInput = getString();
        try {
            return Double.valueOf(userInput);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid value entered, enter a number: ");
        }
        return getDouble();

    }
    public double getDouble(String prompt){
        System.out.print(prompt);
        return getDouble();
    }

    public double getDouble(double min, double max){
        System.out.printf("Enter a number between " + min + " and " + max + ": ");
        double userDouble = getDouble();

        if (userDouble > max || userDouble < min) {
            return getDouble(min, max);
        }

        return userDouble;
    }

    public double getDouble(double min, double max, String prompt){
        System.out.printf(prompt);
        double userDouble = getDouble();

        if (userDouble > max || userDouble < min) {
            return getDouble(min, max, prompt);
        }

        return userDouble;
    }

    public long getBinary() {
        System.out.println("Enter a binary number: ");
        try {
            return Long.valueOf(scanner.next(), 2);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid value entered, enter a binary number: ");
            return getBinary();
        }
    }

    public long getHex() {
        System.out.println("Enter a hexadecimal number: ");
        try {
            return Long.valueOf(scanner.next(), 16);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid value entered, enter a hexadecimal number: ");
            return getHex();
        }
    }

}
