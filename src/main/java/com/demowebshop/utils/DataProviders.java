package com.demowebshop.utils;

import com.demowebshop.models.Contact;
import com.demowebshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;  // Добавлено для использования Arrays.toString()

public class DataProviders {

    @DataProvider(name = "userRegistrationData")
    public Object[][] userRegistrationData() {
        return new Object[][]{
                {new User().setFirstName("Olha").setLastName("Sitiuk").setEmail("sitiuk1981@gmail.com").setPassword("Qwerty1234@").setConfirmPassword("Qwerty1234@")},
                {new User().setFirstName("Olha").setLastName("Sitiuk").setEmail("sitiuk1982@gmail.com").setPassword("Qwerty12345@").setConfirmPassword("Qwerty12345@")},
                {new User().setFirstName("Olha").setLastName("Sitiuk").setEmail("sitiuk1983@gmail.com").setPassword("Qwerty123456@").setConfirmPassword("Qwerty123456@")},
        };
    }

    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contact.csv")));

        String line = reader.readLine();
        while (line != null) {
            System.out.println("Processing line: " + line);

            String[] split = line.split(",");
            System.out.println("Split data: " + Arrays.toString(split));

            if (split.length >= 5) {  // Ensure enough columns: FirstName, LastName, Email, Password, Confirm Password
                list.add(new Object[]{
                        new Contact()
                                .setFirstName(split[0])
                                .setLastName(split[1])
                                .setEmail(split[2])
                                .setPassword(split[3])
                                .setConfirmPassword(split[4])
                });
            } else {
                System.out.println("Skipping invalid line: " + line);
            }

            line = reader.readLine();
        }

        reader.close();
        return list.iterator();
    }
}
