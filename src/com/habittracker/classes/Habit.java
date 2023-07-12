package com.habittracker.classes;

import java.time.LocalTime;
import java.util.ArrayList;

public class Habit {
    private String name;
    private String description;
    private Icon icon; // each icon will have an assigned number
    private LocalTime reminder;
    private int streak;

    public static ArrayList<Icon> iconList = new ArrayList<>(); // might need to change to a hashmap where name is the key so they can be retreived

    public Habit() {

        this.name = "No name provided";
        this.description = "No description";
        this.icon = new Icon("leaf");
        this.reminder = null;
        this.streak = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Icon getIcon() {
        return icon;
    }

    public LocalTime getReminder() {
        return reminder;
    }

    public int getStreak() {
        return streak;
    }

    public void setName(String name) {
        // Validates the user input
        if(!(name == null || name.trim().isEmpty() || name.equals("\n"))) {
            this.name = name;
            System.out.println("Chosen name: " + getName());

        } else {
            System.out.println("Invalid name entered. Please try again.");
        }
    }

    public void setDescription(String des) {
        // Validates user input
        if (des == null || des.trim().isEmpty() || des.equals("\n")) {
            this.description = "No description";
            System.out.println("Chosen description: " + getDescription());

        } else {
            this.description = des;
            System.out.println("Chosen description: " + getDescription());
        }
    }

    // Prints the string names of all available icons
    public void getIconList() {
        System.out.print("Available icons: ");
        for (Icon icon : iconList) {
            System.out.print(icon.getIconName() + ", ");
        }    //todo multiples the list if icon is changed during the same create session
    }

    public void setIcon(String userInput) {

        // Search for the icon
        Icon selectedIcon = null;
        for (Icon icon : iconList) {
            if (icon.getIconName().equalsIgnoreCase(userInput)) {
                selectedIcon = icon;
                break;
            }
        }
        // Validates user input
        if (selectedIcon == null) {
            System.out.println("Invalid icon selected. Please try again.");

        } else {
            // Set the icon
            this.icon = selectedIcon;
            System.out.println("Chosen icon: " + selectedIcon.getIconName());
        }
    }

    public void setReminder(String time) {
        // Validates user input
        if (time == null || time.trim().isEmpty() || time.equals("\n")) {
            this.reminder = LocalTime.parse("No reminder");
            System.out.println("Chosen reminder: " + getReminder());

            // Checks user input matches HH:mm format
        } else if (!time.matches("^\\d{2}:\\d{2}$")) {
            System.out.println("Invalid input. Please try again.");

        } else {
            // Parse user input into hours and minutes
            String[] timeParts = time.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int mins = Integer.parseInt(timeParts[1]);

            // Validate the user input
            if (hours < 0 || hours > 23 || mins < 0 || mins > 59) {
                System.out.println("Invalid time. Please enter a valid time in 24-hour format.");

            } else {
                // Set the reminder
                this.reminder = LocalTime.of(hours, mins);
                System.out.println("Daily reminder set for: " + getReminder());
            }
        }
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public static void addIcons() {
        // Populates iconList with available icons
        iconList.add(new Icon("leaf"));
        iconList.add(new Icon("bike"));
        iconList.add(new Icon("cutlery"));
        iconList.add(new Icon("paw"));
        iconList.add(new Icon("pizza"));
        iconList.add(new Icon("smoking"));
        iconList.add(new Icon("walk"));
    }

    public String toString() {
        return  "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n" + "Icon: " + icon.getIconName() +
                "\n" + "Reminder: " + getReminder() + "\n" + "Streak: " + getStreak() + "\n"
                + "--------------------------------";

    }

}
