package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWidget {

    public static final String MODAL_STUDENT_NAME = "Student Name";
    public static final String MODAL_STUDENT_EMAIL = "Student Email";
    public static final String MODAL_STUDENT_GENDER = "Gender";
    public static final String MODAL_STUDENT_MOBILE = "Mobile";
    public static final String MODAL_STUDENT_DATE_OF_BIRTH = "Date of Birth";
    public static final String MODAL_STUDENT_SUBJECT = "Subjects";
    public static final String MODAL_STUDENT_HOBBIES = "Hobbies";
    public static final String MODAL_STUDENT_PICTURE = "Picture";
    public static final String MODAL_STUDENT_ADDRESS = "Address";
    public static final String MODAL_STUDENT_STATE_AND_CITY = "State and City";

    private final SelenideElement modalWindow = $(".modal-content");
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");
    private final SelenideElement modalWindowWithResults = $(".table-responsive");

    public ModalWidget checkResultRegistrationForm(String key, String value) {
        modalWindow.should(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        modalWindowWithResults.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    @Step("Проверяем отсутствие отображения модального окна после вывода ошибки в форме регистрации")
    public void modalWindowNotExist() {
        modalWindow.shouldNotBe(exist);
    }
}