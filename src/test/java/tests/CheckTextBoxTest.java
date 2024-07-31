package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import tests.utils.RandomUtils;

public class CheckTextBoxTest extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("Тест проверяет заполнение обычной текстовой формы и получение результатов отправки")
    void checkingTextBoxTest() {
        RandomUtils randomUtils = new RandomUtils();
        new TextBoxPage().openTextBoxPage()
                .removeBanner()
                .setFullName(randomUtils.fullName)
                .setUserEmail(randomUtils.userEmail)
                .setCurrentAddress(randomUtils.userCurrentAddress)
                .setPermanentAddress(randomUtils.userPermanentAddress)
                .submitTextBoxForm()
                .checkResultOutputBox(
                        randomUtils.fullName, randomUtils.userEmail, randomUtils.userCurrentAddress,
                        randomUtils.userPermanentAddress
                );
    }
}