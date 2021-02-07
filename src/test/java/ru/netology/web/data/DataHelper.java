package ru.netology.web.data;

import lombok.Value;

public class DataHelper {

    private DataHelper(){}

    @Value
    public static class CardInfo{
        private String cardDebet;
        private String cardCredit;
        private String validMonth;
        private String invalidMonth;
        private String validYear;
        private String invalidYear;
        private String name;
        private String code;
    }

    public static CardInfo getCard(){
        return new CardInfo("4444 4444 4444 4441","4444 4444 4444 4442", "11","1", "21", "20", "Vasya","453");
    }


}
