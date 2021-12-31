package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;

import java.util.List;

public interface CategoryDAO {

    //Select all categories
    List<Category> getCategoryList();

    //select a category by id
    Category getCategory(String categoryId);
}
