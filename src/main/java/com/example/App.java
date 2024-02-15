package com.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.print("\n");
      System.out.println("Scientific Calculator Menu:");
      System.out.println("1. Square root (√x)");
      System.out.println("2. Factorial (x!)");
      System.out.println("3. Natural logarithm (ln(x))");
      System.out.println("4. Power function (x^b)");
      System.out.println("5. Exit");

      System.out.print("Enter your choice (1-5): ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          squareRoot();
          break;
        case 2:
          factorial();
          break;
        case 3:
          naturalLogarithm();
          break;
        case 4:
          powerFunction();
          break;
        case 5:
          System.out.println("Exiting the calculator. Goodbye!");
          break;
        default:
          System.out.println("Invalid choice. Please enter a number between 1 and 5.");
      }

    } while (choice != 5);
    scanner.close();
  }

  private static void squareRoot() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number (x) for square root: ");
    double x = scanner.nextDouble();
    double result = Math.sqrt(x);
    System.out.println("Square root of " + x + " is: " + result);
  }

  private static void factorial() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number (x) for factorial: ");
    int x = scanner.nextInt();
    long result = 1;

    for (int i = 1; i <= x; i++) {
      result *= i;
    }

    System.out.println("Factorial of " + x + " is: " + result);
  }

  private static void naturalLogarithm() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number (x) for natural logarithm: ");
    double x = scanner.nextDouble();
    double result = Math.log(x);
    System.out.println("Natural logarithm of " + x + " is: " + result);
  }

  private static void powerFunction() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the base (x) for the power function: ");
    double x = scanner.nextDouble();
    System.out.print("Enter the exponent (b) for the power function: ");
    double b = scanner.nextDouble();
    double result = Math.pow(x, b);
    System.out.println(x + " raised to the power " + b + " is: " + result);
  }
}
