package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class TravelTest {
    @Test
    void successfulTourPurchase() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.approvedPurchase(cardApproved);
        purchasePage.getAMessageAboutSuccessfulOperation();
    }

    @Test
    void tourPurchaseDeclined(){
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardDeclined = DataHelper.getCard();
        val cardOperation = purchasePage.declinedPurchase(cardDeclined);
        purchasePage.getAMessageAboutDeclinedOperation();
    }

    @Test
    void successfulPurchaseOfTheTourOnCredit(){
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.approvedCreditPurchase(cardApproved);
        purchasePage.getAMessageAboutSuccessfulOperation();

    }

    @Test
    void declinedPurchaseOfTheTourOnCredit(){
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardDeclined = DataHelper.getCard();
        val cardOperation = purchasePage.declinedCreditPurchase(cardDeclined);
        purchasePage.getAMessageAboutDeclinedOperation();
    }



}
