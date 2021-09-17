package utils.helper;

import com.github.javafaker.Faker;

public class DataHelper {
    private static Faker faker = new Faker();

    //Generate Random Password
    public static String getRandomText() {
        return faker.letterify("????????????????");
    }
}