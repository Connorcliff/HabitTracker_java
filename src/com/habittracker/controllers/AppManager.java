package com.habittracker.controllers;

import com.habittracker.classes.Habit;
import com.habittracker.ui.TerminalUI;

import java.util.Objects;
import java.util.Scanner;

import static com.habittracker.classes.Habit.addIcons;
import static com.habittracker.classes.Habit.iconList;
import static com.habittracker.classes.User.habitList;

public class AppManager {
    static TerminalUI tui = new TerminalUI();

    public static void home() {

        // Loops the menu back to the console until the user chooses to exit the program.
        boolean done = false;
        while (!done) {

            tui.displayHomeMenu();
            System.out.print("Enter option: ");

            Scanner input = new Scanner(System.in);
            char option = input.next().charAt(0);

            // Consumes \n after option
            input.nextLine();

            switch (option) {
                case '1' -> createNewHabit();
                case '2' -> tui.displayHabits();
                case '3' -> editHabit();
                case '4' -> increaseStreak();
                case '5' -> System.out.println("navigation menu - to implement");
                case 'f' -> {
                    done = true;
                    System.out.println("Exiting program...");
                }
                default -> System.out.println("Invalid input - Please try one of the menu options.");
            }
        }
    }

    public static void createNewHabit() {

        // Create a new instance of Habit
        Habit h = new Habit();

        boolean done = false;
        while (!done) {

            // Prints menu to console
            tui.displayCreateHabitMenu();

            Scanner input = new Scanner(System.in);
            char option = input.next().charAt(0);

            //todo accepts more than one char

            // Consumes \n after option
            input.nextLine();

            switch (option) {
                case '1' -> {
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    h.setName(name);
                }
                case '2' -> {
                    System.out.print("Enter description: ");
                    String des = input.nextLine();
                    h.setDescription(des);
                }
                case '3' -> {
                    addIcons();
                    h.getIconList();
                    System.out.print("\nSelect an icon: ");
                    String icon = input.nextLine();
                    h.setIcon(icon);
                }
                case '4' -> {
                    System.out.print("Enter reminder time (in 24-hour format, HH:mm): ");
                    String time = input.nextLine();
                    h.setReminder(time);
                }
                case '5' -> {
                    // Checks habit data has been provided
                    if ((Objects.equals(h.getName(), "No name provided"))) {
                        System.out.println("Please complete all mandatory forms before saving.");
                    } else {
                        System.out.println("Saving habit...");
                        // Adds habit to the list
                        habitList.add(h);
                        done = true;
                    }
                }
                case 'f' -> {
                    done = true;
                    System.out.println("Going back...");
                }
                default -> System.out.println("Invalid input - Please try one of the menu options.");
            }
        }
    }
/*
    public static void findIcon(String userInput) {

        // Search for the icon
        Icon selectedIcon = null;
        for (Icon icon : iconList) {
            if (icon.getIconName().equalsIgnoreCase(userInput)) {
                selectedIcon = icon;
                break;
            }
        }
        h.setIcon(selectedIcon);
    }*/

    public static void editHabit() {

        // Checks there are existing habits
        if (habitList.isEmpty()) {
            System.out.println("No habits found.");
        } else {
            // Displays existing habits
            tui.displayHabits();

            System.out.print("Select an existing habit: ");
            Scanner input = new Scanner(System.in);
            String habitName = input.nextLine();

            // Find the habit with the specified name
            Habit habitToEdit = null;
            for (Habit habit : habitList) {
                if (habit.getName().equalsIgnoreCase(habitName)) {
                    habitToEdit = habit;
                    break;
                }
            }

            if (habitToEdit != null) {

                // Loops the menu back to the console until the user chooses to exit the program.
                boolean done = false;
                while (!done) {

                    tui.displayEditHabitMenu(habitName);

                    char option = input.next().charAt(0);
                    // Consumes \n after option
                    input.nextLine();

                    switch (option) {
                        case '1' -> {
                            System.out.print("Enter new name: ");
                            String name = input.nextLine();
                            habitToEdit.setName(name);
                            System.out.println("Changes saved.");
                        }
                        case '2' -> {
                            System.out.print("Enter new description: ");
                            String des = input.nextLine();
                            habitToEdit.setDescription(des);
                            System.out.println("Changes saved.");
                        }
                        case '3' -> {
                            System.out.println("Available icons: " + iconList);
                            System.out.print("Select a new icon: ");
                            String icon = input.nextLine();
                            habitToEdit.setIcon(icon);
                            System.out.println("Changes saved.");
                        }
                        case '4' -> {
                            System.out.print("Enter new reminder time (in 24-hour format, HH:mm): ");
                            String time = input.nextLine();
                            habitToEdit.setReminder(time);
                            System.out.println("Changes saved.");
                        }
                        case '5' -> {
                            System.out.print("Enter new streak: ");
                            int streak = Integer.parseInt(input.nextLine());
                            habitToEdit.setStreak(streak);
                            System.out.println("Changes saved.");
                        }
                        case '6' -> {
                            habitList.remove(habitToEdit);
                            done = true;
                            System.out.println("Habit deleted.");
                        }
                        case 'f' -> {
                            done = true;
                            System.out.println("Going back...");

                        }
                        default -> System.out.println("Invalid input - Please try one of the menu options.");
                    }
                }

            } else {
                System.out.println("Habit not found. Please try again.");
            }
        }
    }

    public static void increaseStreak() {
        tui.displayHabits();

        System.out.print("Which streak should we increase: ");
        Scanner input = new Scanner(System.in);
        String habitName = input.nextLine();

        // Find the habit with the specified name
        Habit habitToEdit = null;
        for (Habit habit : habitList) {
            if (habit.getName().equalsIgnoreCase(habitName)) {
                habitToEdit = habit;
                break;
            }
        }

        if (habitToEdit != null) {

            int currentStreak =  habitToEdit.getStreak();
            currentStreak++;
            habitToEdit.setStreak(currentStreak);
            System.out.println("Streak increased by 1.");

            //todo make this only available once a day

        } else {
            System.out.println("No habit found. Please try again.");
        }

    }
}
