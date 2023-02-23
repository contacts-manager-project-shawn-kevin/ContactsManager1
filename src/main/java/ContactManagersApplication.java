import ContactManagersMethods.Contact;


import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;
import util.Input;



public class ContactManagersApplication {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Input userCategory = new Input();

        createPathAndFile();

        while (true) {
            System.out.println("1. Add a new contact.");
            System.out.println("2. View contacts.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.print("Enter an option (1, 2, 3, 4 or 5): ");

            int category = userCategory.getInt(1,5);

            switch (category) {
                case 1:

                    System.out.println("Add new contact name.");
                    System.out.println("                           ||||||\n" +
                            "                           | o o |\n" +
                            "                           |  >  |\n" +
                            "                           | \\_/ |\n" +
                            "                            \\___/\n" +
                            "                           __| |__\n" +
                            "                          /       \\\n" +
                            "                         | |     | |\n" +
                            "        _________________| |     | |_____________---__\n" +
                            "       /                 | |_____| |         /  /  / /|\n" +
                            "new   /                  /_|  _  |_\\        /  /  / / |\n" +
                            "     /                    / / / /          /  /__/ / /|\n" +
                            "    /____________________/ / / /__________/___\\_/_/ / |\n" +
                            "    |____________________| |_| |__________________|/  |\n" +
                            "    |____________________| |_| |__________________|   /\n" +
                            "____|              |     | | | | ||               |  /\n" +
                            "    | o          o | o         o || o           o | /\n" +
                            "    |______________|_____________||_______________|/\n" +
                            "_______________________________________________________");
                    System.out.println("Add new contact name.");

                    System.out.print("First name: ");
                    String firstName = scanner.nextLine().toLowerCase();

                    System.out.print("Last name: ");
                    String lastName = scanner.nextLine().toLowerCase();

                    String name = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1) + " " + Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);

                    String emailAddress = "";
                    do {
                        System.out.print("Email address: ");
                        emailAddress = scanner.nextLine().toLowerCase();

                        if (!isValid(emailAddress)) {
                            System.out.println("Invalid email address entered.");
                        }
                    } while (!isValid(emailAddress));

                    String number = "";
                    do {
                        System.out.print("Add new contact phone number with area code: ");
                        number = scanner.nextLine();
                        if (number.length() < 10 || number.length() > 10){
                            System.out.println("Invalid phone number entered.");
                        }
                    } while (number.length() < 10 || number.length() > 10);

                    Contact newContact = new Contact(name, number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"), emailAddress);

                    List<String> contactStrings = Collections.singletonList(newContact.toFileString());


                    try {
                        Path contacts = Paths.get("data", "contacts.txt");

                        Files.write(contacts, contactStrings, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        System.out.println("file write exception: " + e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("view contacts");
                    System.out.println("(\\ \n" +
                            "\\'\\ \n" +
                            " \\'\\     __________  \n" +
                            " / '|   ()_________)\n" +
                            " \\ '/    \\ list~~of \\\n" +
                            "   \\       \\ contacts \\\n" +
                            "   ==).      \\__________\\\n" +
                            "  (__)       ()__________)");
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
                    System.out.println(" \n" +
                            "       /\\       \n" +
                            "      /  \\      \n" +
                            "     /,--.\\     \n" +
                            "    /< () >\\    \n" +
                            "   /  `--'  \\   \n" +
                            "  /          \\  \n" +
                            " /   search   \\ \n" +
                            "/______________\\\n");
                    String input = scanner.nextLine();

                    List<String> contacts = Files.readAllLines(Paths.get("data", "contacts.txt"));

                    int i = 0 ;
                    for (String contact : contacts) {
                        if (contact.toLowerCase().indexOf(input.toLowerCase()) !=-1? true: false){
                            System.out.println((i+1)+": "+ contacts.get(i));
                            i++;
                            continue;
                        }
                        i++;
                    }
                    break;
                case 4:
                    System.out.println("remove friend");
                    System.out.println("        ,--.!,\n" +
                            "     __/   -*-\n" +
                            "   ,d08b.  '|`\n" +
                            "   0088MM     \n" +
                            "   `9MMP'     \n" +
                            "Enter name");
                    String userInput = scanner.nextLine();
                    Path contactsFile = Paths.get("data", "contacts.txt");
                    List<String> contactPeople = Files.readAllLines(contactsFile);

                    for (int j = 0; j < contactPeople.size(); j++) {
                        String contact = contactPeople.get(j);
                        if (contact.toLowerCase().contains(userInput.toLowerCase())) {
                            System.out.println("Are you sure you want to remove " + contact + "? (y/n)");
                            String userInput2 = scanner.nextLine();
                            if (Objects.equals(userInput2, "y")) {
                                contactPeople.remove(j);
                                Files.write(contactsFile, contactPeople);
                                System.out.println(contact + " has been removed from your contacts.");
                                System.out.println("     _.-^^---....,,--       \n" +
                                        " _--                  --_  \n" +
                                        "<                        >)\n" +
                                        "|                         | \n" +
                                        " \\._                   _./  \n" +
                                        "    ```--. . , ; .--'''       \n" +
                                        "          | |   |             \n" +
                                        "       .-=||  | |=-.   \n" +
                                        "       `-=#$%&%$#=-'   \n" +
                                        "          | ;  :|     \n" +
                                        " _____.,-#%&$@%#&#~,._____");
                            } else {
                                System.out.println(contact + " has not been removed from your contacts.");
                                break;
                            }
                        }
                    }
                    break;
                    case 5:
                    System.out.println("you found the exit");
                    System.out.println("88888888888888888888888888888888888888888888888888888888888888888888888\n" +
                            "88.._|      | `-.  | `.  -_-_ _-_  _-  _- -_ -  .'|   |.'|     |  _..88\n" +
                            "88   `-.._  |    |`!  |`.  -_ -__ -_ _- _-_-  .'  |.;'   |   _.!-'|  88\n" +
                            "88      | `-!._  |  `;!  ;. _______________ ,'| .-' |   _!.i'     |  88\n" +
                            "88..__  |     |`-!._ | `.| |_______________||.\"'|  _!.;'   |     _|..88\n" +
                            "88   |``\"..__ |    |`\";.| i|_|MMMMMMMMMMM|_|'| _!-|   |   _|..-|'    88\n" +
                            "88   |      |``--..|_ | `;!|l|MMoMMMMoMMM|1|.'j   |_..!-'|     |     88\n" +
                            "88   |      |    |   |`-,!_|_|MMMMP'YMMMM|_||.!-;'  |    |     |     88\n" +
                            "88___|______|____!.,.!,.!,!|d|MMMo * loMM|p|,!,.!.,.!..__|_____|_____88\n" +
                            "88      |     |    |  |  | |_|MMMMb,dMMMM|_|| |   |   |    |      |  88\n" +
                            "88      |     |    |..!-;'i|r|MPYMoMMMMoM|r| |`-..|   |    |      |  88\n" +
                            "88      |    _!.-j'  | _!,\"|_|M<>MMMMoMMM|_||!._|  `i-!.._ |      |  88\n" +
                            "88     _!.-'|    | _.\"|  !;|1|MbdMMoMMMMM|l|`.| `-._|    |``-.._  |  88\n" +
                            "88..-i'     |  _.''|  !-| !|_|MMMoMMMMoMM|_|.|`-. | ``._ |     |``\"..88\n" +
                            "88   |      |.|    |.|  !| |u|MoMMMMoMMMM|n||`. |`!   | `\".    |     88\n" +
                            "88   |  _.-'  |  .'  |.' |/|_|MMMMoMMMMoM|_|! |`!  `,.|    |-._|     88\n" +
                            "88  _!\"'|     !.'|  .'| .'|[@]MMMMMMMMMMM[@] \\|  `. | `._  |   `-._  88\n" +
                            "88-'    |   .'   |.|  |/| /                 \\|`.  |`!    |.|      |`-88\n" +
                            "88      |_.'|   .' | .' |/                   \\  \\ |  `.  | `._-Lee|  88\n" +
                            "88     .'   | .'   |/|  /                     \\ |`!   |`.|    `.  |  88\n" +
                            "88  _.'     !'|   .' | /                       \\|  `  |  `.    |`.|  88\n" +
                            "88 vanishing point 888888888888888888888888888888888888888888888(FL)888");
                    break;
            }
            if (category == 5) {
                break;
            }
        }



        }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
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
