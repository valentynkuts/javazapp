package pl.edu.pjwstk.jaz.basket;

import pl.edu.pjwstk.jaz.basket.jpa.Basket;
import pl.edu.pjwstk.jaz.basket.jpa.BasketItem;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.persistence.Column;

public class BasketRequest {
    private Basket basket;
    private Product product;
    private Long amount;

    public BasketRequest() {
    }

    public BasketRequest(Product product) {
        this.product = product;
    }

    public BasketRequest(Basket basket, Product product) {
        this.basket = basket;
        this.product = product;
    }

    public BasketRequest(Basket basket, Product product, Long amount) {
        this.basket = basket;
        this.product = product;
        this.amount = amount;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BasketItem toBasketItem() {
        return new BasketItem(basket, product, amount);
    }
}
