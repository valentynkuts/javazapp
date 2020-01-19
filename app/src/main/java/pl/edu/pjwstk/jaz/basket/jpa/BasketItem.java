package pl.edu.pjwstk.jaz.basket.jpa;


import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BasketItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Column(name = "amount")
    private Long amount;
}
