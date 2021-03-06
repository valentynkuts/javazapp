package pl.edu.pjwstk.jaz.basket.jpa;


import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "basket_item")
public class BasketItem implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

    @Id
    @OneToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Column(name = "amount")
    private Long amount;

    public BasketItem() {
    }

    public BasketItem(Basket basket, Product product, Long amount) {
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
}
