package com.pluralsight;

import java.util.Scanner;

public class TheLibraryApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book[] shelf = new Book[20];
        int totalbooks = 0;

        shelf[0] = new Book(1, "978-0-14-017739-8", "Of Human Bondage");
        shelf[1] = new Book(2, "978-0-14-044333-2", "Count of Monte Cristo");
        shelf[2] = new Book(3, "978-0-14-044926-6", "The Iliad");
        shelf[3] = new Book(4, "978-0-14-044913-6", "The Odyssey");
        shelf[4] = new Book(5, "978-0-14-044792-7", "Crime and Punishment");
        shelf[5] = new Book(6, "978-0-14-044917-4", "The Brothers Karamazov");
        shelf[6] = new Book(7, "978-0-14-044118-5", "War and Peace");
        shelf[7] = new Book(8, "978-0-14-044793-4", "Anna Karenina");
        shelf[8] = new Book(9, "978-0-14-143951-8", "Great Expectations");
        shelf[9] = new Book(10, "978-0-14-143960-0", "A Tale of Two Cities");
        shelf[10] = new Book(11, "978-0-14-044281-6", "Don Quixote");
        shelf[11] = new Book(12, "978-0-14-044082-9", "Madame Bovary");
        shelf[12] = new Book(13, "978-0-14-044109-3", "The Three Musketeers");
        shelf[13] = new Book(14, "978-0-14-044027-0", "Les Miserables");
        shelf[14] = new Book(15, "978-0-14-044095-9", "Frankenstein");
        shelf[15] = new Book(16, "978-0-14-143947-1", "Dracula");
        shelf[16] = new Book(17, "978-0-14-044515-2", "The Picture of Dorian Gray");
        shelf[17] = new Book(18, "978-0-14-044165-9", "The Hunchback of Notre Dame");
        shelf[18] = new Book(19, "978-0-14-143982-2", "Wuthering Heights");
        shelf[19] = new Book(20, "978-0-14-143951-8", "Jane Eyre");

        boolean done = false;

        while (!done) {
            System.out.println("\n   LIBRARY   ");
            System.out.println("1 - See available books");
            System.out.println("2 - See checked out books");
            System.out.println("3 - See You Another Time");
            System.out.println("Pick: ");

            String pick = scanner.nextLine();

            if (pick.equals("1")) {
                System.out.println("\nBooks you can borrow:");
                int available = 0;

                for (int i = 0; i < totalbooks; i++) {
                    if (!shelf[i].isCheckedOut()) {
                        System.out.println(shelf[i].getId() + " | " + shelf[i].getTitle());
                        available++;
                    }
                }
                if (available == 0) {
                    System.out.println("Nothing available right now.");
                    continue;
                }
                System.out.println("\nEnter ID to check out, or X to go back: ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("X")) {
                    continue;
                }
                boolean isNum = true;
                for (int i = 0; i < choice.length(); i++) {
                    if (!Character.isDigit(choice.charAt(i))) {
                        isNum = false;
                        break;
                    }
                }
                if (!isNum) {
                    System.out.println("That's not a number.");
                    continue;
                }
                int bookId = Integer.parseInt(choice);
                Book found = null;

                for (int i = 0; i < totalbooks; i++) {
                    if (shelf[i].getId() == bookId) {
                        found = shelf[i];
                        break;
                    }
                }
                if (found == null) {
                    System.out.println("No book with that ID.");
                    continue;
                }
                if (found.isCheckedOut()) {
                    System.out.println("Already checked out.");
                    continue;
                }
                System.out.println("your name: ");
                String person = scanner.nextLine();
                found.checkOut(person);
                System.out.println("Checked out to " + person);

            } else if (pick.equals("2")) {
                System.out.println("\nChecked out books:");
                int out = 0;

                for (int i = 0; i < totalbooks; i++) {
                    if (shelf[i].isCheckedOut()) {
                        System.out.println(shelf[i].getId() + " | " + shelf[i].getTitle() + " | Out to: " + shelf[i].getBorrower());
                        out++;
                    }
                }
                if (out == 0) {
                    System.out.println("All books are on shelf.");
                    continue;
                }
                System.out.println("\nC to check in, X to go back: ");
                String action = scanner.nextLine();

                if (!action.equalsIgnoreCase("C")) {
                    continue;
                }
                System.out.println("Book ID to check in: ");
                String idStr = scanner.nextLine();

                boolean valid = true;
                for (int i = 0; i < idStr.length(); i++) {
                    if (!Character.isDigit(idStr.charAt(i))) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    System.out.println("Invalid ID.");
                    continue;
                }
                int returnedID = Integer.parseInt(idStr);
                Book toReturn = null;

                for (int i = 0; i < totalbooks; i++) {
                    if (shelf[i].getId() == returnedID) {
                        toReturn = shelf[i];
                        break;
                    }
                }
                if (toReturn == null || !toReturn.isCheckedOut()) {
                    System.out.println("that book isn't checked out.");
                    continue;
                }
                toReturn.checkIn();
                System.out.println("Book returned");

            }
            
        }

        scanner.close();





    }



}
