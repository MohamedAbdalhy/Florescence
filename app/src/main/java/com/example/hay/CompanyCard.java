package com.example.hay;

public class CompanyCard {
    private String name;
    private  int picture;
private  String maxBudget ;
private String minBudget ;


    public CompanyCard(String name, int picture, String maxBudget, String minBudget) {
        this.name = name;
        this.picture = picture;
        this.maxBudget = maxBudget;
        this.minBudget = minBudget;
    }

    public String getMaxBudget() {
        return maxBudget;
    }

    public String getMinBudget() {
        return minBudget;
    }

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }


}
