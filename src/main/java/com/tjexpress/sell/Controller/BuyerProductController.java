package com.tjexpress.sell.Controller;


import com.tjexpress.sell.ResultVOUtil.ResultVOUtil;
import com.tjexpress.sell.VO.ProductInfoVO;
import com.tjexpress.sell.VO.ProductVO;
import com.tjexpress.sell.VO.ResultVO;
import com.tjexpress.sell.dataobject.ProductCategory;
import com.tjexpress.sell.dataobject.ProductInfo;
import com.tjexpress.sell.repository.ProductInfoRepository;
import com.tjexpress.sell.service.CategoryService;
import com.tjexpress.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
    //1. search all products on shelves
    List<ProductInfo> productInfoList = productService.findUpAll();

    //2. search on shelves products by productCategory ID
//        List<Integer> categoryTypeList = new ArrayList<>();

//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
    //(java8, lambda)
    List<Integer> categoryTypeList = productInfoList.stream()
            .map(e -> e.getCategoryType())
            .collect(Collectors.toList());
    List<ProductCategory> productCategoryList = categoryService.findByCategoryIn(categoryTypeList);

    //3. data assembly
    List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
        ProductVO productVO = new ProductVO();
        productVO.setCategoryType(productCategory.getCategoryType());
        productVO.setCategoryname(productCategory.getCategoryName());

        List<ProductInfoVO> productInfoVOList = new ArrayList<>();
        for (ProductInfo productInfo: productInfoList) {
            if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(productInfo, productInfoVO);
                productInfoVOList.add(productInfoVO);
            }
        }
        productVO.setProductInfoVOList(productInfoVOList);
        productVOList.add(productVO);
    }

        return ResultVOUtil.success(productVOList);
}
}


