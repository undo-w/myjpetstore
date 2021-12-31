package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Cart;

import java.util.List;

public interface CartDAO {
    List<Cart> getCartByUser(String userid);

    void insertCart(Cart cart);

    void clearCartByUser(String userid);
}
