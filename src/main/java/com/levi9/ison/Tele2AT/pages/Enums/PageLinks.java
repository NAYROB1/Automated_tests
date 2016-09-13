package com.levi9.ison.Tele2AT.pages.Enums;

/**
 * Created by Vlado on 7/9/2016.
 */
public enum PageLinks {

        SimOnlyPageURL ("https://www.tele2.nl/shop/mobiel/abonnement/sim-only/"),
        catalogPageURL ("https://www.tele2.nl/shop/mobiel/smartphones/"),
        prepaidSimPageURL ("https://www.tele2.nl/shop/mobiel/prepaid/sim-only/");

        private String value;

        private PageLinks(String value) {
            this.value = value;
        }
        public String getPageLinkValue() {
            return value;
        }
}

