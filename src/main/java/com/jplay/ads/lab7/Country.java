package com.jplay.ads.lab7;

public record Country(String name, double population) implements Comparable<Country>{

    @Override
    public int compareTo(Country anotherCountry) {
        if (this.population == anotherCountry.population) return 0;
        return (this.population > anotherCountry.population) ? 1 : -1;
    }
}
