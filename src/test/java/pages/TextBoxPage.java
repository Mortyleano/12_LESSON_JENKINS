package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement titlePage = $(".text-center");
    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputName = $("#output #name");
    private final SelenideElement outputEmail = $("#output #email");
    private final SelenideElement outputCurrentAddress = $("#output #currentAddress");
    private final SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    @Step("Открываем страницу с тестовой формой для ввода данных")
    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        titlePage.shouldHave(text("Text Box"));
        return this;
    }

    @Step("Удаляем все рекламные баннера на странице с тестовой формой")
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Добавляем полное имя пользователя в поле ввода тестовой формы")
    public TextBoxPage setFullName(String fullName) {
        fullNameInput.shouldBe(visible).setValue(fullName);
        return this;
    }

    @Step("Добавляем e-mail пользователя в поле ввода тестовой формы")
    public TextBoxPage setUserEmail(String userEmail) {
        userEmailInput.shouldBe(visible).setValue(userEmail);
        return this;
    }

    @Step("Добавляем текущий адрес проживания пользователя в поле ввода тестовой формы")
    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.shouldBe(visible).setValue(currentAddress);
        return this;
    }

    @Step("Добавляем постоянный адрес проживания пользователя в поле ввода тестовой формы")
    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.shouldBe(visible).setValue(permanentAddress);
        return this;
    }

    @Step("Подтверждаем заполненную тестовую форму")
    public TextBoxPage submitTextBoxForm() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    @Step("Проверяем все введенные данные в тестовой форме")
    public void checkResultOutputBox(String fullName, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(fullName));
        outputEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddress));
        outputPermanentAddress.shouldHave(text(permanentAddress));
    }
}