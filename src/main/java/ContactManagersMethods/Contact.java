package ContactManagersMethods;

public class Contact {
    private String name;
     private String number;
    public String getName() {
        System.out.print(name + "\n");
        return "";
    }

    public String getNumber() {
        System.out.println(String.valueOf(number).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
        return "";
    }





    public static void main(String[] args) {
        Contact moe = new Contact();
        moe.name = "Moe";
        moe.number = String.valueOf(2103674647);
        moe.getName();
        moe.getNumber();


    }



}
