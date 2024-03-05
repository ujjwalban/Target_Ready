package com.targetindia.programs;

import java.util.Scanner;

public class assignment_2 {
    public static String inWords(int num) {

        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        int crore = 10000000;
        int lakh = 100000;
        int thousand = 1000;
        int hundred = 100;
        int ten = 10;

        StringBuilder sb = new StringBuilder();
        if (num >= crore) {
            sb.append(inWords(num / crore)).append(" Crore ").append(inWords(num % crore));
        } else if (num >= lakh) {
            sb.append(inWords(num / lakh)).append(" Lakh ").append(inWords(num % lakh));
        } else if (num >= thousand) {
            sb.append(inWords(num / thousand)).append(" Thousand ").append(inWords(num % thousand));
        } else if (num >= hundred) {
            sb.append(inWords(num / hundred)).append(" Hundred ").append(inWords(num % hundred));
        } else if (num >= 20) {
            sb.append(tens[num / ten]).append(" ").append(inWords(num % ten));
        } else {
            sb.append(ones[num]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(inWords(10001));
        System.out.println(inWords(999999999));
        System.out.println(inWords(35145));
    }
}
