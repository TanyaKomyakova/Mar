package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;

public class TravelTest {
    @Test
    void buyTour() {
        open("http://localhost:8080");
        val purchasePage = new PurchasePage();
        purchasePage.purchase1();
        val cardInfo = DataHelper.getCard();
        val purchasePage1 = purchasePage.purchase(cardInfo);







    }

}
