package com.dnkrn.evolver.workouts;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by dinakaran on 8/18/17.
 */
public class BankAccount {


    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            int scenarios = Integer.parseInt(scanner.nextLine());

            while(scenarios > 0) {
                String[] userInputs = scanner.nextLine().split(" ");

                int noOfPayments = Integer.parseInt(userInputs[0]);
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setMinAmount(Double.parseDouble(userInputs[1]));
                paymentMethod.setInterestRate(Double.parseDouble(userInputs[2]));
                paymentMethod.setUpfrontAmt(Double.parseDouble(userInputs[3]));

                double[] paymentAmounts = new double[noOfPayments];

                String[] paymentInputs = scanner.nextLine().split(" ");

                if (paymentInputs.length > noOfPayments) {
                    throw new Exception("enter proper no of payments");
                }

                int i = 0;
                while (i < noOfPayments) {
                    paymentAmounts[i] = Double.parseDouble(paymentInputs[i]);
                    i++;
                }


                paymentMethod.setPaymentAmounts(paymentAmounts);


                paymentMethod.determinePaymentMethod();

                scenarios--;
            }
        }
        catch(NumberFormatException pe)
        {
            System.out.println("please enter valid inputs");

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }



    }

    static class PaymentMethod{

        private double[] paymentAmounts;
        private double minAmount ;
        private double interestRate ;
        private double upfrontAmt ;

        public double[] getPaymentAmounts() {
            return paymentAmounts;
        }

        public void setPaymentAmounts(double[] paymentAmounts) {
            this.paymentAmounts = paymentAmounts;
        }

        public double getMinAmount() {
            return minAmount;
        }

        public void setMinAmount(double minAmount) {
            this.minAmount = minAmount;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public double getUpfrontAmt() {
            return upfrontAmt;
        }

        public void setUpfrontAmt(double upfrontAmt) {
            this.upfrontAmt = upfrontAmt;
        }

        /**
         *
         * Calculates max of each payment
         *
         * @return
         */

        public double calculateTotalPayment()
        {
            if(paymentAmounts==null|| paymentAmounts.length == 0)
            {
                return 0;
            }
            double totalPayment = 0;
            for (double payment : paymentAmounts) {
                totalPayment += Math.max(minAmount, interestRate * payment / 100);
            }
            return totalPayment;
        }

        /**
         * Determines Payment Method
         */
        public void determinePaymentMethod()
        {

            double totalPayment=calculateTotalPayment();
            if (totalPayment <= this.upfrontAmt) {
                System.out.println("fee");
            } else {
                System.out.println("upfront");
            }
        }

    }


}
