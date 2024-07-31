package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWidget;
import tests.utils.RandomUtils;

public class CheckNegativeDataEntryTest extends TestBase {

    @Test
    @Tag("smoke") @Tag("registration")
    @DisplayName("Тест проверяет вывод ошибки в форме регистрации студента при отсутствии введенного номера телефона")
    void checkingNegativeDataEntryTest() {
        RandomUtils randomUtils = new RandomUtils();
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserGender(randomUtils.userGender)
                .submitRegistrationForm();

        new ModalWidget().modalWindowNotExist();
    }
}