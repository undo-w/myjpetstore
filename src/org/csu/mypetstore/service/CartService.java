package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.persistence.CartDAO;
import org.csu.mypetstore.persistence.impl.CartDAOImpl;

import java.util.List;

public class CartService {
    private CartDAO cartDAO;

    public CartService(){
        cartDAO = new CartDAOImpl();
    }

    public List<Cart> getCartByUser(String userid){
        return cartDAO.getCartByUser(userid);
    };

    public void insertCart(Cart cart){
        cartDAO.insertCart(cart);
    }

    public void clearCartByUser(String userid){
        cartDAO.clearCartByUser(userid);
    }
}
