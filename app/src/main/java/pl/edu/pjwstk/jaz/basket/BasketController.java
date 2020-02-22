package pl.edu.pjwstk.jaz.basket;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.basket.jpa.Basket;
import pl.edu.pjwstk.jaz.basket.jpa.BasketItem;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.user.product.list.ListProductService;
import pl.edu.pjwstk.jaz.user.product.list.ProductRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;
import java.time.LocalDate;

@Named
@RequestScoped
public class BasketController {
    @Inject
    private BasketService basketService;

    @Inject
    private ParamRetriever paramRetriever;

    private BasketRequest basketRequest;

    public Long getUserId() {
        return paramRetriever.getLongUserId("id");
    }

//    public BasketRequest getBasketRequest() {
//        if (basketRequest == null) {
//            basketRequest = createBasketRequest();
//        }
//        return basketRequest;
//    }
//
//
//    private BasketRequest createBasketRequest() {
//        if (paramRetriever.contains("productId")) {
//            var productId = paramRetriever.getLong("productId");
//            System.out.println("productId: " + productId);
//            var product = basketService.findProductById(productId).orElseThrow();
//            return new BasketRequest(product);
//        }
//        return new BasketRequest();
//    }

//    public String addToBasket(){
//        Long userId = getUserId();
//
//        Date date = new Date(System.currentTimeMillis());
//        LocalDate localDate = date.toLocalDate();
//        Date sqldate = Date.valueOf(localDate);
//
//        //System.out.println("isPresent: " + basketService.doesBasketExist(userId));
//
//        if(!basketService.doesBasketExist(userId))
//            basketService.addBasket(new Basket(userId,sqldate));
//
//        basketRequest = getBasketRequest();
//        Basket basket = basketService.getBasket(userId);
//        basketRequest.setBasket(basket);
//
//        Long productId = basketRequest.getProduct().getId();
//        Long basketId = basketRequest.getBasket().getId();
//
//        if(!basketService.doesBasketItemExist(productId, basketId)) {
//            basketRequest.setAmount(1L);
//            BasketItem basketItem = basketRequest.toBasketItem();
//            basketService.addBasketItem(basketItem);
//        }
//
//
//
//
//        return "/basket/allProducts.xhtml?faces-redirect=true";
//    }

    public String addToBasket(Long productId) {
        Long userId = getUserId();

        Date date = new Date(System.currentTimeMillis());
        LocalDate localDate = date.toLocalDate();
        Date sqldate = Date.valueOf(localDate);

        //System.out.println("isPresent: " + basketService.doesBasketExist(userId));

        if (!basketService.doesBasketExist(userId))
            basketService.addBasket(new Basket(userId, sqldate));

        Basket basket = basketService.getBasket(userId);
        Product product = basketService.findProductById(productId).orElseThrow();
//        basketRequest = new BasketRequest();

//        basketRequest.setBasket(basket);

        //Long productId = basketRequest.getProduct().getId();
//        basketRequest.setProduct(product);
        Long prodId = product.getId();
        Long basketId = basket.getId();

//        Long basketId = basketRequest.getBasket().getId();

        if (!basketService.doesBasketItemExist(prodId, basketId)) {
            //basketRequest.setAmount(1L);
            //BasketItem basketItem = basketRequest.toBasketItem();
            basketService.addBasketItem(new BasketItem(basket,product,1L));
        } else {
            BasketItem basketItem = basketService.getBasketItemByProductIdBasketId(prodId, basketId).orElseThrow();
            Long amount = basketItem.getAmount();
            basketService.changeBasketItem(new BasketItem(basket,product, amount + 1));
        }

        return "/basket/allProducts.xhtml?faces-redirect=true";
    }


}
