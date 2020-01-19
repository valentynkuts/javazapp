package pl.edu.pjwstk.jaz.basket.jpa;

import javax.persistence.*;
import java.sql.Date;

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

    public Basket() {
    }

    public Basket(Long userId, Date lastAccessDate) {
        this.userId = userId;
        this.lastAccessDate = lastAccessDate;
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
}
