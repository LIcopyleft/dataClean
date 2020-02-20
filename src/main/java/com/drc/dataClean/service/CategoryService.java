package com.drc.dataClean.service;


import com.drc.dataClean.model.Category;

public interface CategoryService {

    void add(Category category);

    void delete(int id);

    void update(Category category);

    Category get(int id);

}
