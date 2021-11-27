package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestRegistrationForm extends TestBase {
    @Test
    void fillFormTest() {
        step("Открыть страницу заполнения формы", () -> {
        registrationForm.openPage();
        });

        step("Заполнить поле firstname", () -> {
        registrationForm.inputFirstName("Olga");
        });

        step("Заполнить поле lastname", () -> {
        registrationForm.inputLastName("List");
        });

        step("Заполнить поле email", () -> {
        registrationForm.inputEmail("email@ya.ru");
        });

        step("Выбрать женский пол", () -> {
        registrationForm.chooseGender("Female");
        });

        step("Заполнить поле mobilenumber", () -> {
        registrationForm.inputMobileNumber("8919777777");
        });

        step("Заполнить поле subject, выбрать физику", () -> {
        registrationForm.inputSubjects("Physics");
        });

        step("Заполнить поле hobby, выбрать sports", () -> {
        registrationForm.chooseHobby("Sports");
        });

        step("Заполнить поле address", () -> {
        registrationForm.inputAddress("Ленина 15-22");
        });

        step("Загрузить картинку", () -> {
        registrationForm.uploadFile("img/image.jpg");
        });

        step("Выбрать из списка state NCR", () -> {
        registrationForm.inputState("NCR");
        });

        step("Выбрать из списка city Delhi", () -> {
        registrationForm.inputCity("Delhi");
        });

        step("Выбрать дату рождения 10.06.2001", () -> {
        registrationForm.calendar.setDate("10", "5", "2001");
        });

        step("Кликнуть submit", () -> {
        registrationForm.submit();
        });

        step("Проверяем название Thanks for submitting the form", () -> {
        registrationForm.verificationPopupName("Thanks for submitting the form");
        });

        step("Проверяем поля", () -> {
        registrationForm.checkResultsValue("Student Name", "Olga List")
                        .checkResultsValue("Student Email", "email@ya.ru")
                        .checkResultsValue("Gender", "Female")
                        .checkResultsValue("Mobile", "8919777777")
                        .checkResultsValue("Date of Birth", "10 June,2001")
                        .checkResultsValue("Subjects", "Physics")
                        .checkResultsValue("Hobbies", "Sports")
                        .checkResultsValue("Picture", "image.jpg")
                        .checkResultsValue("Address", "Ленина 15-22")
                        .checkResultsValue("State and City", "NCR Delhi");
        });
    }
}
