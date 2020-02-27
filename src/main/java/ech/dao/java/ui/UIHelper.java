
package ech.dao.java.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
/**
 *
 * @author ethan
 */
public class UIHelper {
    
    /**
     * Display a Menu and return the user's response.
     *
     * @param title the menu title
     * @param prompt the prompt text
     * @param options the list of menu options as strings
     * @return the user's response
     */
    public static String getUserChoice(String title, String prompt, String[] options) {
        System.out.println("\n\t\t*** " + title + "***");
        for (String option : options) {
            System.out.println("\t" + option);
        }
        System.out.print(prompt + " ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }

    /**
     * displays an error message.
     * @param errorMessage 
     */
    public static void showErrorMessage(String errorMessage) {
        System.out.println("\nERROR: " + errorMessage);
        pressEnterToContinue();
    }

    /**
     * 
     */
    public static void pressEnterToContinue() {
        System.out.print("Press enter to continue: ");
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

    /**
     * 
     * @param message 
     */
    public static void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * 
     * @param prompt
     * @param errorMessage
     * @return 
     */
    public static String getUserString(String prompt, String errorMessage) {
        String userInput = null;
        Scanner in = new Scanner(System.in);
        boolean needed = true;
        while (needed) {
            System.out.print(prompt + " ");
            userInput = in.nextLine().trim();
            if (!userInput.isBlank()) {
                needed = false;
            } else {
                UIHelper.showErrorMessage(errorMessage);
            }
        }
        return userInput;
    }

    /**
     * 
     * @param prompt
     * @return 
     */
    public static LocalDate getDate(String prompt) {
        UIHelper.showMessage(prompt);
        LocalDate orderDate = null;
        boolean needed = true;
        while (needed) {
            //year
            int year = getInt("Year: ",
                    0000, LocalDate.now().getYear(),
                    "invalid, re enter: ");
            //month
            int month = getInt("Month: ",
                    1, 12, "invalid, re enter: ");
            //day
            int day = getInt("Day: ", 
                    1, 31,
                    "invalid, re enter: ");
            try {
                orderDate = LocalDate.of(year, month, day);
                needed = false;
            } catch (DateTimeException dte) {
                UIHelper.showErrorMessage(dte.getMessage());
            }
            //dob
        }
        return orderDate;
    }

    /**
     * Prompts the user for an int in the specified range.
     *
     * @param prompt the prompt
     * @param min the low end of the range
     * @param max the high end of the range
     * @param errorMessage the error message
     * @return the user int
     */
    public static int getInt(String prompt, int min,
            int max, String errorMessage) {
        String userInput = null;
        int value = 0;
        Scanner kb = new Scanner(System.in);
        boolean needed = true;
        while (needed) {
            System.out.println(prompt + " ");
            userInput = kb.nextLine();
            try {
                value = Integer.parseInt(userInput);
                if (value >= min && value <= max) {
                    needed = false;
                } else {
                    UIHelper.showErrorMessage(errorMessage);
                }
            } catch (NumberFormatException nfe) {
                UIHelper.showErrorMessage(nfe.getMessage());
            }
        }
        return value;
    }
    
    public static String showMenuOptions(String menuTitle
            , String prompt, String[] menuOptions) {
        showTitle(menuTitle);
        for (String menuOption : menuOptions) {
            System.out.println("\t" + menuOption);
        }
        System.out.print(prompt + " ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }

    /**
     * Displays section titles in a consistent manner.
     * 
     * @param title the title to display
     */
    public static void showTitle(String title) {
        System.out.println("\n\n\t\t*** " + title + " ***");
    }

}//end
