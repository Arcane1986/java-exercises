package Initials;

import java.util.Scanner;

public class User {
    private String name;
    private String initials;
    private static Scanner scanner = new Scanner(System.in);


    User() {
        System.out.println("What is your name dummy?");
        if (scanner.hasNextLine()) {
            setName(scanner.nextLine());
        } else {
            throw new Error("Enter a string dummy");
        }
        String[] nameList = getName().split(" ");
        if (nameList.length == 1)
            {String firstLetter = nameList[0].split("")[0];
            setInitials(firstLetter.toUpperCase());}
        else if (nameList.length == 2)
            {String firstLetter = nameList[0].split("")[0];
            String secondLetter = nameList[1].split("")[0];
            setInitials(firstLetter.toUpperCase()+secondLetter.toUpperCase());}
        else if (nameList.length == 3)
            {String firstLetter = nameList[0].split("")[0];
            String secondLetter = nameList[1].split("")[0];
            String thirdLetter = nameList[2].split("")[0];
            setInitials(firstLetter.toUpperCase()+secondLetter.toUpperCase()+thirdLetter.toUpperCase());}
        else
            setInitials("Get a shorter name asshole");
            System.out.print(getInitials());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}