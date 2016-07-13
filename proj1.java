import java.io.*;
import java.util.Scanner;
import java.lang.Math;

 public class proj1{

   public static void main(String args[]){

       double principal;
       double payment;
       double interest;
       int lengthOfLoan;
       double totalAmt;
       double interestPaid;
       char c = 'Y';

       Scanner s = new Scanner(System.in);

       System.out.println("This is a loan calculator program. It will calculate the total amount payed based upon\n" +
               "the principal amount, interest rate, and length of the loan.\n");

       while (c == 'y' | c == 'Y'){
           System.out.print("Please enter in the loan principal amount: ");
           principal = s.nextDouble();

           System.out.print("Please enter in the interest rate: ");
           interest = s.nextDouble();

           System.out.print("Please enter in the length you wish to pay the loan off in (months): ");
           lengthOfLoan = s.nextInt();

           System.out.println();

           payment = calcPayment(principal, interest, lengthOfLoan);
           System.out.format("Monthly payment is: %,.2f%n", payment);

           totalAmt = calcTotalAmt(payment, lengthOfLoan);
           System.out.format("Total amount paid is: %,.2f%n", totalAmt);

           interestPaid = calcInterestPaid(totalAmt, principal);
           System.out.format("Total interest paid: %,.2f%n\n", interestPaid);

           System.out.print("Again? (Y/N)\n\n");
           c = s.next().charAt(0);
       }

   }

     public static double calcPayment(double principal, double interest, int lengthOfLoan){

         double r = interest / 100.0;

         // 12 is hard-coded because the interest rate is assumed to be an APR, annual percentage rate
         // based off of a 12-month calendar year where the interest is calculated

         double payment = principal * (r / 12) / (1 - Math.pow((1 + r / 12), -lengthOfLoan));

         return payment;
     }

     public static double calcTotalAmt(double payment, int lengthOfLoan ){

         return payment * lengthOfLoan;
     }

     public static double calcInterestPaid(double totalAmt, double principal){

         return totalAmt - principal;
     }

/*     public static void payoffPrintout(double principal, double interest, double lengthOfLoan){

         for (int i = 0; i < lengthOfLoan; i++){

         }
     }*/

}
