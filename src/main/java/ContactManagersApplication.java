import ContactManagersMethods.Contact;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ContactManagersApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        createPathAndFile();

        while (true) {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5): ");

            int category = scanner.nextInt();
            scanner.nextLine();

            switch (category) {
                case 1:
                    System.out.print("Add new contact name: ");
                    String name = scanner.nextLine();

                    System.out.print("Add new contact phone number: ");
                    String number = scanner.nextLine();
                    scanner.nextLine();

                    Contact newContact = new Contact(name, number);

                    List<String> contactStrings = Arrays.asList(newContact.toFileString());

                    try {
                        // , StandardOpenOption.APPEND
                        Path contacts;
                        Files.write(contacts, contactStrings);
                    } catch (IOException e) {
                        System.out.println("file write exception: " + e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
            }


//            Contact moe = new Contact();
//            moe.name = "Moe";
//            moe.number = String.valueOf(2103674647);
//            moe.getName();
//            moe.getNumber();

//            break;


        }
    }
        public static void createPathAndFile() {
            Path Data = Paths.get("/Users/shawnhardin/IdeaProjects/ContactsManager1/src/main/java/ContactManagersMethods/Data");
            Path contacts = Paths.get("/Users/shawnhardin/IdeaProjects/ContactsManager1/src/main/java/ContactManagersMethods/Data", "contacts.txt");

            System.out.println(Files.exists(Data));

            if(!Files.exists(Data)) {
                try {
                    Files.createDirectory(Data);
                    System.out.println("dir created");
                } catch (IOException e) {
                    System.out.println("createDirectory exception: " + e.getMessage());
                }
            } else {
                System.out.println("the directory exists already");
            }

            try {
                Files.createFile(contacts);
                System.out.println("the file has been created");
            } catch(FileAlreadyExistsException e) {
                System.out.println("the file exists!");
            } catch (IOException e) {
                System.out.println("createFile exception: " + e.getMessage());
                e.printStackTrace();
            }
        }

    
}
