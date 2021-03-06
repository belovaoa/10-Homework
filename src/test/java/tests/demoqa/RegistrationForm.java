package tests.demoqa;

import com.codeborne.selenide.SelenideElement;
import helpers.componentsOfCalenderAndAttach.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderChoose = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            fileUpload = $("#uploadPicture"),
            submit = $("#submit"),
            popuppName = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
            open("https://demoqa.com/automation-practice-form");
            formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationForm inputFirstName(String nameStudent) {
        firstNameInput.setValue(nameStudent);
        return this;
    }

    public RegistrationForm inputLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationForm inputEmail(String emailStudent) {
        emailInput.setValue(emailStudent);
        return this;
    }

    public RegistrationForm chooseGender(String gender) {
        genderChoose.$(byText(gender)).click();
        return this;
    }

    public RegistrationForm inputMobileNumber(String phoneNumber) {
        mobileNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationForm inputSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationForm chooseHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationForm inputAddress(String addressStudent) {
        addressInput.setValue(addressStudent);
        return this;
    }

    public RegistrationForm uploadFile(String fileName) {
        fileUpload.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationForm inputState(String stateName) {
        $("#state").click();
        $(byText(stateName)).click();
        return this;
    }

    public void inputCity(String cityName) {
        $("#city").click();
        $(byText(cityName)).click();
    }

    public void submit() {
        submit.click();
    }

    public void verificationPopupName(String popupName) {
        popuppName.shouldHave(text(popupName));
    }

    public RegistrationForm checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
