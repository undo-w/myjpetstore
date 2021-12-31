package org.csu.mypetstore.service;

import java.util.List;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.persistence.CategoryDAO;
import org.csu.mypetstore.persistence.ItemDAO;
import org.csu.mypetstore.persistence.ProductDAO;
import org.csu.mypetstore.persistence.impl.CategoryDAOImpl;
import org.csu.mypetstore.persistence.impl.ItemDAOImpl;
import org.csu.mypetstore.persistence.impl.ProductDAOImpl;

import javax.xml.catalog.Catalog;

public class CatalogService {

    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDao;

    public CatalogService(){
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
        itemDao = new ItemDAOImpl();
    }


    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDao.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDao.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDao.getInventoryQuantity(itemId) > 0;
    }
}
