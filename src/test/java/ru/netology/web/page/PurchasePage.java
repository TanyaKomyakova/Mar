package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class PurchasePage {

    private SelenideElement buyButton = $(".button");
    private SelenideElement buyInCreditButton = $(".button_view_extra");
    private SelenideElement cardField = $(".input__control");
    private SelenideElement enterMonth = $(".08");
    private SelenideElement enterYear = $(".22");
    private SelenideElement enterOwner = $(".input_width_available");
    private SelenideElement enterACode = $(".999");
    private SelenideElement continueButton = $(".pin_theme_alfa-on-white");


    public PurchasePage purchase1 () {
        buyButton.click();

        return new PurchasePage();

    }

    public PurchasePage(){
        cardField.shouldBe(Condition.visible);
    }

    public PurchasePage purchase(DataHelper.CardInfo info){
        cardField.setValue(info.getCardFirst());
        return new PurchasePage();
    }






}
