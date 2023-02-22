package ContactManagersMethods;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    public String name;
    public String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact() {

    }

    public String getName() {
        System.out.print(this.name + "\n");
        return this.name;
    }

    public String getNumber() {
        System.out.println(String.valueOf(this.number).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
        return this.number;
    }

    public String toFileString() {
        return String.format("%s,%s", name, number);
    }







}
