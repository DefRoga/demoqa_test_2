package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            setBirthDate = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelection =   $("#stateCity-wrapper"),
            citySelection = $("#city"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value){
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        setBirthDate.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectionState(String value){
        $("#state").click();
        stateSelection.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectionCity(String value){
        $("#city").click();
        citySelection.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
    public RegistrationPage registrationResultsModal() {
        registrationResultsModal.verifyModalAppear();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

}
