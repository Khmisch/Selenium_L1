package cydeo.test.day10;

import org.testng.annotations.Test;

public class TestingSingleton {
    @Test
    public void singleton_understand_test(){
        String str1 = Singleton.getWord();

        System.out.println(str1);

        String str2 = Singleton.getWord();

        System.out.println(str2);
    }

    @Test
    public void singleton_understand_test2(){
        String str1 = Singleton.getWord();

        System.out.println(str1);

        /*String str2 = Singleton.getWord();

        System.out.println(str2);*/
    }
}
