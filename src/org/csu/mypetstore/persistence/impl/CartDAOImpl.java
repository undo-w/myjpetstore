package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.persistence.CartDAO;
import org.csu.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
    private static String GET_CART_BY_USER = "SELECT userid,itemid,quantity,unitprice FROM cart WHERE userid = ?";
    private static String INSERT_CART = "INSERT INTO cart(userid,itemid,quantity,unitprice) VALUES(?,?,?,?)";
    private static String CLEAR_CART_BY_USER = "DELETE FROM cart WHERE userid = ?";
    @Override
    public List<Cart> getCartByUser(String userid) {
        List<Cart> carts = new ArrayList<>();

        try{
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_CART_BY_USER);
            preparedStatement.setString(1,userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cart cart = new Cart();
                cart.setUserid(resultSet.getString(1));
                cart.setItemid(resultSet.getString(2));
                cart.setQuantity(resultSet.getInt(3));
                cart.setUnitprice(resultSet.getBigDecimal(4));

                carts.add(cart);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return carts;
    }

    @Override
    public void insertCart(Cart cart) {
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_CART);
            preparedStatement.setString(1,cart.getUserid());
            preparedStatement.setString(2,cart.getItemid());
            preparedStatement.setInt(3,cart.getQuantity());
            preparedStatement.setBigDecimal(4,cart.getUnitprice());

            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void clearCartByUser(String userid) {
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(CLEAR_CART_BY_USER);
            preparedStatement.setString(1,userid);
            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
