package com.habittracker.ui;

import com.habittracker.classes.Habit;
import com.habittracker.interfaces.UserInterface;

import static com.habittracker.classes.User.habitList;

public class TerminalUI implements UserInterface {
    @Override
    public void displayHomeMenu() {
        System.out.println("""
                                 
                    --------------------------------
                     Home Menu
                    --------------------------------
                    1 - Create new habit
                    2 - View habits
                    3 - Edit habit
                    4 - Increase habit streak
                    5 - Navigation menu
                    f - Exit program
                    --------------------------------""");
    }


    @Override
    public void displayCreateHabitMenu() {
        System.out.println("""   
                      
                    --------------------------------
                     Create new habit
                    --------------------------------
                    1 - Name (mandatory)
                    2 - Description
                    3 - Icon
                    4 - Reminder
                    5 - Complete
                    f - Go back
                    --------------------------------""");
        System.out.print("Enter option: ");

    }

    @Override
    public void displayEditHabitMenu(String habitName) {
        System.out.println("""
                      
                    --------------------------------
                     Editing habit:\040""" + habitName);
        System.out.println("""
                    --------------------------------
                    1 - Name
                    2 - Description
                    3 - Icon
                    4 - Reminder
                    5 - Streak
                    6 - Delete habit
                    f - Save changes and go back
                    --------------------------------""");
        System.out.print("Enter option: ");
    }

    @Override
    public void displayHabits() {
        System.out.println("""
                            
                            --------------------------------
                             Viewing habit list
                            --------------------------------""");
        for (Habit habit : habitList) {
            System.out.println(habit.toString());
        }
    }

    @Override
    public void displayLogin() {
        return;
    }

    @Override
    public void displaySignUp() {
        return;
    }
}
