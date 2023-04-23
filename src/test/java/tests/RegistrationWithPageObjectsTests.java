package tests;

import org.junit.jupiter.api.Test;

class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Fedor")
                .setLastName("Bondarchuk")
                .setEmail("bodya322@goden.ru")
                .setGender("Male")
                .setPhone("8992772000")
                .setBirthDate("20", "April", "2000")
                .setSubject("Math")
                .setHobbies("Sports")
                .uploadPicture("img/2019-08-04 15.24.58.JPG")
                .setAddress("Stepanova Street")
                .selectionState("Uttar Pradesh")
                .selectionCity("Agra")
                .clickSubmitButton()
                .registrationResultsModal()
                .verifyResult("Student Name", "Fedor Bondarchuk")
                .verifyResult("Student Email","bodya322@goden.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8992772000")
                .verifyResult("Date of Birth", "20 April,2000")
                .verifyResult("Subjects", "Math")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "Picture 2019-08-04 15.24.58.JPG")
                .verifyResult("Address", "Stepanova Street")
                .verifyResult("State and City", "Uttar Pradesh Agra");
    }
}