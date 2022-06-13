package com.jplay.ads.lab7;

public class Main {
    public static void main (String... args) {
        AvlNode<Country> countiesAvl = new AvlNode<>();

        Country[] countries = {
                new Country("Senegal", 16.74),
                new Country("Madagascar", 27.69),
                new Country("Ghana", 31.07),
                new Country("Algeria", 43.85),
                new Country("Uganda", 45.74),
                new Country("Kenya", 53.77),
                new Country("Tanzania", 59.73),
                new Country("Kongo", 89.56),
                new Country("Ethiopia", 115),
                new Country("Nigeria", 206.1),
        };

        for (Country country : countries) {
            countiesAvl.add(country);
            countiesAvl.showPreorder();
            System.out.println();
        }
    }
}
