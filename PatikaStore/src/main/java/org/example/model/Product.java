package org.example.model;

public abstract class Product {
    private int id;
    private double unitPrice;
    private int discountRate;
    private int stock;
    private String name;
    private Brand brand;

    public Product(int id, double unitPrice, int discountRate, int stock, String name, Brand brand) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }
    public int getId(){return this.id;}
    public double getUnitPrice(){return this.unitPrice;}
    public void setUnitPrice(double unitPrice){this.unitPrice = unitPrice;}
    public int getDiscountRate() {return this.discountRate;}
    public void setDiscountRate(int discountRate) {this.discountRate = discountRate;}
    public int getStock() {return this.stock;}
    public void setStock(int stock) {this.stock = stock;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public Brand getBrand(){return this.brand;}
    public void setBrand(Brand brand){this.brand = brand;}

     public abstract void printTableRow();
}
