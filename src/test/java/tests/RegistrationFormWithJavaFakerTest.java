package tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormWithJavaFakerTest extends TestBase {

    @Test
    void successfulRegistration() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.userGender)
                .setPhone(data.userPhoneNumber)
                .setBirthDate(
                        data.dayMonthYear[0],
                        data.dayMonthYear[1],
                        data.dayMonthYear[2])
                .setSubject(data.subjects)
                .setHobbies(data.hobbies)
                .uploadPicture("img/2019-08-04 15.24.58.JPG")
                .setAddress(data.address)
                .selectionState(data.state)
                .selectionCity(data.city)
                .clickSubmitButton()
                .registrationResultsModal()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", data.userGender)
                .verifyResult("Mobile", data.userPhoneNumber)
                .verifyResult("Date of Birth", data.dateOfBirth)
                .verifyResult("Subjects", data.subjects)
                .verifyResult("Hobbies", data.hobbies)
                .verifyResult("Picture", "Picture 2019-08-04 15.24.58.JPG")
                .verifyResult("Address", data.address)
                .verifyResult("State and City", data.state + " " + data.city);
    }
}