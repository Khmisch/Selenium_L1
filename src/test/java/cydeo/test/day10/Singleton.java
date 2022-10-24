package cydeo.test.day10;

public class Singleton {
    // 2-create private static String
    // prevent access and provide a getter method
    private static String word;

    // 1-create private constructor
    private Singleton() {
    }

    // This utility method will return the word in the way we want to return
    public static String getWord() {

        if (word == null) {
            System.out.println("First time call. Word object is null. " + "Assigning the value now");

            word = "Something";
        } else {
            System.out.println("Word already has value");
        }

        return word;
    }
}
