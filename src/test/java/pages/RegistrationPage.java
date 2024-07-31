package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarWidget;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement practiceFormWrapper = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbyWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureButton = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement stateAndCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");

    @Step("Открываем страницу регистрации студента")
    public RegistrationPage openRegistrationPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Удаляем все рекламные баннера на странице регистрации студента")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Добавляем имя студента в форму регистрации")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.shouldBe(visible).setValue(firstName);
        return this;
    }

    @Step("Добавляем фамилию студента в форму регистрации")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.shouldBe(visible).setValue(lastName);
        return this;
    }

    @Step("Добавляем e-mail студента в форму регистрации")
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.shouldBe(visible).setValue(userEmail);
        return this;
    }

    @Step("Добавляем номер телефона студента в форму регистрации")
    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.shouldBe(visible).setValue(userNumber);
        return this;
    }

    @Step("Устанавливаем гендер студента в форме регистрации")
    public RegistrationPage setUserGender(String userGender) {
        genderWrapper.shouldBe(visible).$(byText(userGender)).click();
        return this;
    }

    @Step("Устанавливаем дату рождения студента в форме регистрации")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.shouldBe(visible).click();
        new CalendarWidget().setDate(day, month, year);
        return this;
    }

    @Step("Выбираем предмет изучения студента в форме регистрации")
    public RegistrationPage setSubject(String subject) {
        subjectInput.shouldBe(visible).setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбираем хобби студента в форме регистрации")
    public RegistrationPage setHobby(String hobby) {
        hobbyWrapper.shouldBe(visible).$(byText(hobby)).click();
        return this;
    }

    @Step("Загружаем файл в форму регистрации студента")
    public RegistrationPage uploadPictureFile(String fileName) {
        uploadPictureButton.shouldBe(visible).uploadFromClasspath(fileName);
        return this;
    }

    @Step("Добавляем текущий адрес проживания студента в форму регистрации")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.shouldBe(visible).setValue(currentAddress);
        return this;
    }

    @Step("Выбираем штат студента в форме регистрации")
    public RegistrationPage setState(String state) {
        stateInput.click();
        stateAndCityWrapper.shouldHave(text(state)).$(byText(state)).click();
        return this;
    }

    @Step("Выбираем город студента в форме регистрации")
    public RegistrationPage setCity(String city) {
        cityInput.click();
        stateAndCityWrapper.shouldHave(text(city)).$(byText(city)).click();
        return this;
    }

    @Step("Подтверждаем форму регистрации студента")
    public void submitRegistrationForm() {
        submitButton.shouldBe(visible).click();
    }
}