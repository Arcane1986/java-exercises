package Studios;

import java.util.HashMap;
import java.util.Scanner;

public class CharacterCount {

    public static void main(String[]args) {

        HashMap<Character, Integer> charactersCount = new HashMap<>();

        System.out.println("Enter your sentence here:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] sentence = input.toCharArray();

        for (char letter : sentence) {
            if(charactersCount.containsKey(letter)){
                int count = 0;
                count = charactersCount.get(letter) + 1;
                charactersCount.put(letter,count);
            }else{
                charactersCount.put(letter,1);
            }
        }
        System.out.print(charactersCount);
    }
}
