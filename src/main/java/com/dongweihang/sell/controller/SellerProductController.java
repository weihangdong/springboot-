package com.dongweihang.sell.controller;

import com.dongweihang.sell.dto.OrderDTO;
import com.dongweihang.sell.enums.ResultEnum;
import com.dongweihang.sell.exception.SellException;
import com.dongweihang.sell.service.OrderService;
import com.dongweihang.sell.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/seller/product")
public class SellerProductController {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(SellerProductController.class);

    /**
     *
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(){
        int page=0;
        int size=10;
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList("1517325871468165760",request);

//        return ResultVOUtil.success(orderDTOPage.getContent());
        Map<String,Object> map = new HashMap<>();
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/list",map);
    }

}
