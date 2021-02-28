package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.netology.web.data.DataHelper;
import ru.netology.web.info.SQLHelper;
import ru.netology.web.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TravelTest {

    @Test
    @Order(1)
    void successfulTourPurchase() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.approvedPurchase(cardApproved);
        purchasePage.getAMessageAboutSuccessfulOperation();
        val statusExpected = "APPROVED";
        val statusActual = SQLHelper.getPurchaseInformation();
        assertEquals(statusExpected,statusActual);
    }

    @Test
    @Order(3)
    void tourPurchaseDeclined(){
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardDeclined = DataHelper.getCard();
        val cardOperation = purchasePage.declinedPurchase(cardDeclined);
        purchasePage.getAMessageAboutDeclinedOperation();
        val statusExpected = "DECLINED";
        val statusActual = SQLHelper.getPurchaseInformation();
    }

    @Test
    @Order(2)
    void successfulPurchaseOfTheTourOnCredit(){
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardApproved = DataHelper.getCard();
        val cardOperation = purchasePage.approvedCreditPurchase(cardApproved);
        purchasePage.getAMessageAboutSuccessfulOperation();
        val statusExpected = "APPROVED";
        val statusActual = SQLHelper.getInformationAboutBuyingOnCredit();
        assertEquals(statusExpected,statusActual);

    }

    @Test
    @Order(4)
    void declinedPurchaseOfTheTourOnCredit(){
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        val cardDeclined = DataHelper.getCard();
        val cardOperation = purchasePage.declinedCreditPurchase(cardDeclined);
        purchasePage.getAMessageAboutDeclinedOperation();
        val statusExpected = "DECLINED";
        val statusActual = SQLHelper.getInformationAboutBuyingOnCredit();
        assertEquals(statusExpected,statusActual);
    }
}
