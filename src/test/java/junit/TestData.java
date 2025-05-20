package junit;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("fr"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String address = faker.address().streetAddress();
    String phone = faker.phoneNumber().cellPhone();
    String company = faker.company().name();

}

