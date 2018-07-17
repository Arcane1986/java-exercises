package Studios;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {

        float radius=0;

        do {
            System.out.println("What is the radius of the circle?(input must be a non-negative number)");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextFloat())
            radius = scanner.nextFloat();

        } while (radius <= 0);

        double area = radius * radius * 3.14;
        System.out.println("The area of the circle is " + area);

    }
}
