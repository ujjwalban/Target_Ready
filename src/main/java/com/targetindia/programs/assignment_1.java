package com.targetindia.programs;

import java.util.Scanner;

public class assignment_1 {

    private static boolean isLeapYear(int Year) {
        return Year % 400 == 0 || (Year % 4 == 0 && Year % 100 != 0);
    }

    private static int GetTheStartingDay(int InitialDay, int InitialYear, int year, int InitialMonth, int month, int[] NumberOfDays, int GetDay) {
        while (InitialDay != 1 || InitialYear != year || InitialMonth != month) {
            if (isLeapYear(InitialYear)) {
                NumberOfDays[1] = 29;
            } else {
                NumberOfDays[1] = 28;
            }

            InitialDay++;
            GetDay++;

            if (InitialDay > NumberOfDays[InitialMonth - 1]) {
                InitialMonth++;
                InitialDay = 1;
            }

            if (InitialMonth > 12) {
                InitialMonth = 1;
                InitialYear++;
            }
            if (GetDay == 7) {
                GetDay = 0;
            }
        }
        return GetDay;
    }

    private static void CheckValidity(int month, int year) {
        if (month > 12 || month < 1) {
            System.out.println("Invalid Month");
            System.exit(1);
        }
        if (year < 1) {
            System.out.println("Invalid Year");
            System.exit(1);
        }
    }

    private static void PrintingCalender(int month, String[] Days, int[] NumberOfDays, int GetDay) {
        for (int i = 0; i < 7; i++) {
            System.out.print("    " + Days[i]);
        }
        System.out.println();
        for (int i = 1; i <= (NumberOfDays[month - 1] + GetDay); i++) {
            if (i > 6) {
                GetDay = GetDay % 6;
            }
        }
        int Gap = GetDay;
        if (Gap < 0)
            Gap = 6;

        for (int i = 0; i < Gap; i++)
            System.out.print("      ");

        for (int i = 1; i <= NumberOfDays[month - 1]; i++) {
            System.out.printf(" %4d ", i);

            if (((i + Gap) % 7 == 0) || (i == NumberOfDays[month - 1]))
                System.out.println();
        }
    }

    public static void printCalender(int month, int year) {
        CheckValidity(month, year);

        String[] Days = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};

        int[] NumberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // let say our 1st year and 1st month started with sunday

        int GetDay = 1;

        int InitialDay = 1;
        int InitialYear = 1;
        int InitialMonth = 1;

        // Getting the starting day of the required month and year
        GetDay = GetTheStartingDay(InitialDay, InitialYear, year, InitialMonth, month, NumberOfDays, GetDay);

        if (isLeapYear(year)) {
            NumberOfDays[1] = 29;
        } else {
            NumberOfDays[1] = 28;
        }

        PrintingCalender(month, Days, NumberOfDays, GetDay);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        System.out.print("Enter Month: ");
        int month = sc.nextInt();

        printCalender(month, year);
    }
}
