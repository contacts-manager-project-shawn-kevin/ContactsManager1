import ContactManagersMethods.Contact;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import static java.lang.Character.getName;

public class ContactManagersApplication {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        createPathAndFile();

        while (true) {
            System.out.println("1. Add a new contact..");
            System.out.println("2. View contacts");
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

                    Contact newContact = new Contact(name, number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));

                    List<String> contactStrings = Collections.singletonList(newContact.toFileString());


                    try {    // , StandardOpenOption.APPEND
                        Path contacts = Paths.get("data", "contacts.txt");
//

                        Files.write(contacts, contactStrings, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        System.out.println("file write exception: " + e.getMessage());
                    }

                    break;
                case 2:
                    try {    // , StandardOpenOption.APPEND
                        Path contacts = Paths.get("data", "contacts.txt");
                        List<String> contactList = Files.readAllLines(contacts);
                        for (int i = 0; i < contactList.size(); i++) {
                            System.out.println((i+1)+": "+contactList.get(i));
                        }

                    } catch (IOException e) {
                        System.out.println("file write exception: " + e.getMessage());
                    }


                    break;
                case 3:
                    System.out.println("search for a friend");
                    String input = scanner.nextLine();

                    List<String> contacts = Files.readAllLines(Paths.get("data", "contacts.txt"));
                   int i = 0 ;
                    for (String contact : contacts) {
                        if (contact.equalsIgnoreCase(input)){
                            System.out.println((i+1)+": "+ contacts.get(i));
                            continue;
                        }

                        i++;

                    }


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
//            Path Data = Paths.get("/Users/shawnhardin/IdeaProjects/ContactsManager1/src/main/java/ContactManagersMethods/Data");
//            Path contacts = Paths.get("/Users/shawnhardin/IdeaProjects/ContactsManager1/src/main/java/ContactManagersMethods/Data", "contact.txt");

            Path Data = Paths.get("data");
            Path contacts = Paths.get("data", "contacts.txt");

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
