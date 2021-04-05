package com.qianxu.cloud.mall.practice.categoryproduct.service;

import com.qianxu.cloud.mall.practice.categoryproduct.model.pojo.Category;
import com.qianxu.cloud.mall.practice.categoryproduct.model.request.AddCategoryReq;
import com.qianxu.cloud.mall.practice.categoryproduct.model.vo.CategoryVO;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/7 15:18
 * @describe
 */
public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategory);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    @Cacheable(value = "listCategoryForCustomer")
    List<CategoryVO> listCategoryForCustomer(Integer parentId);
}
