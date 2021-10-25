package com.company;

public class Main {

    public enum Cocktail {
        ONE_BEER, ONE_CIDER, A_PROPER_CIDER, GT, BACARDI_SPECIAL, MOHITO
    }

    Cocktail drink;

    public static void main(String[] args) {
        System.out.println(computeCost(Cocktail.MOHITO, true, 5));

    }

    public static int computeCost(Cocktail drink, boolean student, int amount) {

        if (amount > 2 && (drink == Cocktail.GT || drink == Cocktail.BACARDI_SPECIAL)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        int rum = 65;
        int grenadine = 10;
        int limeJuice = 10;
        int greenStuff = 10;
        int tonicWater = 20;
        int gin = 85;
        if (drink == Cocktail.ONE_BEER) {
            price = 74;
        } else if (drink == Cocktail.ONE_CIDER) {
            price = 103;
        } else if (drink == Cocktail.A_PROPER_CIDER) price = 110;
        else if (drink == Cocktail.GT) {
            price = gin + tonicWater + greenStuff;
        } else if (drink == Cocktail.BACARDI_SPECIAL) {
            price = gin / 2 + rum + grenadine + limeJuice;
        } else {
            throw new RuntimeException("No such drink exists");
        }
        if (student && (drink == Cocktail.ONE_CIDER || drink == Cocktail.ONE_BEER || drink == Cocktail.A_PROPER_CIDER)) {
            price = price - price / 10;
        }
        return price * amount;
    }

}



