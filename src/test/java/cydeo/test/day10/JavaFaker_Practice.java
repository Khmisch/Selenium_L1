package cydeo.test.day10;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker_Practice {
    @Test
    public void java_faker_test(){
        Faker faker = new Faker();
        System.out.println("Fullname: "+faker.name().firstName() +" "+ faker.name().lastName());
        System.out.println("Address: "+faker.address().country() +", "+ faker.address().cityName() +" "+ faker.address().buildingNumber());
        System.out.println("Phone: "+faker.numerify("+998 (##) ###-##-##"));
        System.out.println("Birthdate: "+faker.date().birthday());
        System.out.println("Passport ID: "+faker.bothify("??#####",true));
        System.out.println("Credit card: "+faker.finance().creditCard());

    }
}
