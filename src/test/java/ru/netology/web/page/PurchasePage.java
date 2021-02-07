package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PurchasePage {


    private SelenideElement heading = $(".App_appContainer__3jRx1");
    private SelenideElement buyButton = $(".button:nth-child(3)");
    private SelenideElement buyInCreditButton = $(".button.button.button_view_extra.button_size_m.button_theme_alfa-on-white");
    private SelenideElement cardField = $(".input__control");
    private ElementsCollection enterMonth = $$(".input__control");
    private SelenideElement enterYear = $(".");
    private SelenideElement enterOwner = $(".input_width_available");
    private SelenideElement enterACode = $(".");
    private SelenideElement continueButton = $(".pin_theme_alfa-on-white");



    public PurchasePage(){
        heading.shouldBe(Condition.visible);
    }

    public PurchasePage purchase(DataHelper.CardInfo info){
        buyButton.click();
        cardField.setValue(info.getCardDebet());
        enterMonth.last().setValue(info.getValidMonth());
        return new PurchasePage();
    }








}
