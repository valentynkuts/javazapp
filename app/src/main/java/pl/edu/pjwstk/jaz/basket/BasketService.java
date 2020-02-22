package pl.edu.pjwstk.jaz.basket;

import pl.edu.pjwstk.jaz.basket.jpa.Basket;
import pl.edu.pjwstk.jaz.basket.jpa.BasketItem;
import pl.edu.pjwstk.jaz.basket.jpa.BasketRepository;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BasketService {
    @Inject
    private BasketRepository basketRepository;

    @Inject
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return basketRepository.getAllProducts();
    }

    public void addBasket(Basket basket) {
        basketRepository.addBasket(basket);
    }


    public boolean doesBasketExist(Long userId){
        return basketRepository.findBasketByUserId(userId).isPresent();
    }

    public Basket getBasket(Long userId){
        return basketRepository.findBasketByUserId(userId).orElseThrow();
    }

    public Optional<Product> findProductById(Long productId) {
        return productRepository.findProductById(productId);
    }

    public boolean doesBasketItemExist(Long productId, Long basketId){
        return basketRepository.getBasketItemByProductIdBasketId(productId, basketId).isPresent();
    }

    public Optional<BasketItem> getBasketItemByProductIdBasketId(Long productId, Long basketId) {
        return basketRepository.getBasketItemByProductIdBasketId(productId, basketId);
    }


        public void addBasketItem(BasketItem basketItem) {
        basketRepository.addBasketItem(basketItem);
    }
    public void changeBasketItem(BasketItem basketItem) {
        basketRepository.changeBasketItem(basketItem);
    }


}
