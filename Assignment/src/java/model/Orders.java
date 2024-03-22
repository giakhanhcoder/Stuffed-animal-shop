/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author GIA KHANH
 */
public class Orders {

    private int id;
    private Product product;
    private int quantity;
    private double price;
    private Purchase purchase;

    public Orders() {
    }

    public Orders(int id, Product product, int quantity, double price, Purchase purchase) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.purchase = purchase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", product=" + product + ", quantity=" + quantity + ", price=" + price + ", purchase=" + purchase + '}';
    }

}
