package com.cloud.mall.practice.categoryproduct.controller;


import com.cloud.mall.practice.categoryproduct.model.pojo.Category;
import com.cloud.mall.practice.categoryproduct.model.request.AddCategoryReq;
import com.cloud.mall.practice.categoryproduct.model.request.UpdateCategoryReq;
import com.cloud.mall.practice.categoryproduct.model.vo.CategoryVO;
import com.cloud.mall.practice.categoryproduct.service.CategoryService;
import com.github.pagehelper.PageInfo;
import com.qianxu.cloud.mall.practice.common.common.ApiRestResponse;
import com.qianxu.cloud.mall.practice.common.common.Constant;
import com.qianxu.cloud.mall.practice.common.exception.QianxuMallExceptionEnum;
import com.qianxu.cloud.mall.practice.user.model.pojo.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/7 15:07
 * @describe 目录分类Controller
 */
@Controller
@RequiredArgsConstructor
public class CategoryController {

    final CategoryService categoryService;

    @ApiOperation("后台添加目录")
    @PostMapping({"/admin/category/add"})
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session,
                                       @Valid @RequestBody AddCategoryReq addCategoryReq) {
        User currentUser = (User) session.getAttribute(Constant.QIANXU_MALL_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_LOGIN);
        }
            categoryService.add(addCategoryReq);
            return ApiRestResponse.success();
    }

    @ApiOperation("后台更新目录")
    @PutMapping({"/admin/category/update"})
    @ResponseBody
    public ApiRestResponse updateCategory(HttpSession session,
                                          @Valid @RequestBody UpdateCategoryReq updateCategoryReq) {
        User currentUser = (User) session.getAttribute(Constant.QIANXU_MALL_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_LOGIN);
        }
            Category category = new Category();
            BeanUtils.copyProperties(updateCategoryReq, category);
            categoryService.update(category);
            return ApiRestResponse.success();
    }

    @ApiOperation("后台删除目录")
    @DeleteMapping({"/admin/category/delete"})
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台目录列表")
    @GetMapping({"/admin/category/list"})
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台目录列表")
    @GetMapping({"/category/list"})
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer() {
        List<CategoryVO> categoryVOList = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.success(categoryVOList);
    }
}
