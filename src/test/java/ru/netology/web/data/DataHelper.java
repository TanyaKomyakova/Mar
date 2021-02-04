package ru.netology.web.data;

import lombok.Value;

public class DataHelper {

    private DataHelper(){}

    @Value
    public static class CardInfo{
        private String cardFirst;
        private String cardSecond;
    }

    public static CardInfo getCard(){
        return new CardInfo("4444 4444 4444 4441","4444 4444 4444 4442");
    }


}
