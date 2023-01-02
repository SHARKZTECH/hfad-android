package com.example.bitsandpizza;

public class Pizza {
    private String name;
    private int imgId;

    public final static Pizza[] pizza={
            new Pizza("Diavolo",R.drawable.diavolo),
            new Pizza("Funghi",R.drawable.funghi),
            new Pizza("Diavolo",R.drawable.diavolo),
            new Pizza("Funghi",R.drawable.funghi)
    };
    public Pizza(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }
}
