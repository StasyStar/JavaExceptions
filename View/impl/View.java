package seminar3.hw.View.impl;

import java.util.Scanner;

import seminar3.hw.InputData;
import seminar3.hw.Controller.Controller;
import seminar3.hw.Model.Contact;
import seminar3.hw.View.Viewable;

public class View implements Viewable{
    private final Controller controller;
    private final InputData data;

    public View(Controller controller, InputData data) {
        this.controller = controller;
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("We have three commands:\n"
            + "1. Write a new contact.\n"
            + "2. Read a file with contacts.\n"
            + "3. Exit program.");
            int command = Integer.parseInt(prompt("Enter the number of the command: "));
            if (command == 3) {
                return;
            } else if(command == 1) {
                try {
                    Contact contact1 = data.checkContact();
                    controller.saveContact(contact1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if(command == 2) {
                String userSecondName = prompt("Enter the Last Name: ");
                controller.readAll(userSecondName);
            } else {
                System.out.println("Enter incorrect number. Try again");
                run();
            }
        }
    }

    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine().trim();
    }
    
}
