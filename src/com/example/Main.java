package com.example;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calc(input);

    }

    public static String calc(String input) throws IOException{
        int x;
        int y;

        String[] romeDigits = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        String[] calculation = input.split("\s");

        if (calculation.length > 3)
        {
            throw new IOException();
            //System.out.println("To many digits! You can input only 2!");
        }
        else if (!Arrays.asList(romeDigits).contains(calculation[0]) && !Arrays.asList(romeDigits).contains(calculation[2]))
        {
            if (Integer.parseInt(calculation[0]) < -10 || Integer.parseInt(calculation[0]) > 10 || Integer.parseInt(calculation[2]) < -10 || Integer.valueOf(calculation[2]) > 10)
            {
                throw new IOException();
                //System.out.println("Some digits are too big! You can input only 10 or -10 max!");
            }
            else
            {
                switch (calculation[1]) {
                    case "+":
                        System.out.println(Integer.parseInt(calculation[0]) + Integer.parseInt(calculation[2]));
                        break;
                    case "-":
                        System.out.println(Integer.parseInt(calculation[0]) - Integer.parseInt(calculation[2]));
                        break;
                    case "*":
                        System.out.println(Integer.parseInt(calculation[0]) * Integer.parseInt(calculation[2]));
                        break;
                    case "/":
                        System.out.println(Integer.parseInt(calculation[0]) / Integer.parseInt(calculation[2]));
                        break;
                }
            }
        }
        else if (Arrays.asList(romeDigits).contains(calculation[0]) && Arrays.asList(romeDigits).contains(calculation[2]))
        {
            x = Arrays.asList(romeDigits).indexOf(calculation[0]);
            y = Arrays.asList(romeDigits).indexOf(calculation[2]);
            if (x < 10 && y < 10) {
                switch (calculation[1]) {
                    case "+":

                        System.out.println(romeDigits[x + y + 1]);
                        break;
                    case "-":
                        if (x - y + 1 <= 0) {
                            throw new IOException();
                            //System.out.println("There are no null and negatives in Roman numbers. Try another numbers.");
                        } else {
                            System.out.println(romeDigits[x - y - 1]);
                        }
                        break;
                    case "*":
                        System.out.println(romeDigits[(x + 1) * (y + 1) - 1]);
                        break;
                    case "/":
                        if ((x + 1) / (y + 1) - 1 > 0)  {
                            System.out.println(romeDigits[(x + 1) / (y + 1) - 1]);
                        } else {
                            throw new IOException();
                            // System.out.println("You can't get a number < I in Roman numbers! Try another numbers.");
                        }
                        break;
                }
            }
            else
            {
                throw new IOException();
                // System.out.println("Some digits are too big! You can input only X max!");
            }
        }
        else
        {
            throw new IOException();
            // System.out.println("Something went wrong! Try to chek your inputted math operation.");
        }
        return input;
    }

}
