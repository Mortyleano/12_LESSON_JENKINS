package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWidget;
import tests.utils.RandomUtils;

import static pages.components.ModalWidget.*;

import static io.qameta.allure.Allure.step;

public class CheckMinimalDataEntryTest extends TestBase {

    @Test
    @Tag("smoke") @Tag("registration")
    @Disabled("Тест добавлен для пропуска в Allure отчете")
    @DisplayName("Тест проверяет минимальный ввод данных в форме регистрации")
    void checkingMinimalDataEntryTest() {
        RandomUtils randomUtils = new RandomUtils();
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserGender(randomUtils.userGender)
                .setUserNumber(randomUtils.userNumber)
                .setDateOfBirth(randomUtils.dayOfBirth, randomUtils.monthOfBirth, randomUtils.yearOfBirth)
                .submitRegistrationForm();

        step("Проверяем результаты регистрации в модальном окне",
                () -> new ModalWidget().checkResultRegistrationForm(MODAL_STUDENT_NAME, randomUtils.firstName + " " + randomUtils.lastName)
                        .checkResultRegistrationForm(MODAL_STUDENT_GENDER, randomUtils.userGender)
                        .checkResultRegistrationForm(MODAL_STUDENT_MOBILE, randomUtils.userNumber)
                        .checkResultRegistrationForm(MODAL_STUDENT_DATE_OF_BIRTH, randomUtils.dayOfBirth + " "
                                + randomUtils.monthOfBirth + ","
                                + randomUtils.yearOfBirth
                ));
    }
}