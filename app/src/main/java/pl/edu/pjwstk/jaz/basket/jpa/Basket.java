package pl.edu.pjwstk.jaz.basket.jpa;


import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "last_access_date")
    private Date lastAccessDate;

    @OneToMany
    @JoinColumn(name = "basket_id")
    private Collection<BasketItem> basketItems;

    public Basket() {
    }

    public Basket(Long userId, Date lastAccessDate) {
        this.userId = userId;
        this.lastAccessDate = lastAccessDate;
    }

    public Basket(Long userId, Date lastAccessDate, Collection<BasketItem> basketItems) {
        this.userId = userId;
        this.lastAccessDate = lastAccessDate;
        this.basketItems = basketItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public Collection<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(Collection<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }
}
