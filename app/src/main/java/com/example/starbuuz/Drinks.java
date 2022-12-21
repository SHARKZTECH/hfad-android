package com.example.starbuuz;

public class Drinks {
   private String name;
   private String description;
   private int imageId;

   public Drinks(String name, String description, int imageId) {
      this.name = name;
      this.description = description;
      this.imageId = imageId;
   }

   public static final Drinks[] drinks={
           new Drinks("Latte","A couple of espresso shots with steamed milk",R.drawable.latte),
           new Drinks("Cappuccino","Espresso, hot milk, and a steamed milk foam",R.drawable.cappuccino),
           new Drinks("Filter","Highest quality beans roasted and brewed fresh",R.drawable.filter)
   };

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public int getImageId() {
      return imageId;
   }
   public  String toString(){
      return this.name;
   }
}
