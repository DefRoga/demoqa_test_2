package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Fedor");
        $("#lastName").setValue("Bondarchuk");
        $("#userEmail").setValue("bodya322@goden.ru");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("8992772000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("img/2019-08-04 15.24.58.JPG");
        $("#currentAddress").setValue("Stepanova Street");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        $(".modal-dialog").shouldBe(Condition.visible);


    }

}