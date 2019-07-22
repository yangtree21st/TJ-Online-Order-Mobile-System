package com.tjexpress.sell.Controller;


import com.tjexpress.sell.VO.ProductInfoVO;
import com.tjexpress.sell.VO.ProductVO;
import com.tjexpress.sell.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();

        resultVO.setCode(0);
        resultVO.setMsg("sucessful input");


        return resultVO;
    }

}
