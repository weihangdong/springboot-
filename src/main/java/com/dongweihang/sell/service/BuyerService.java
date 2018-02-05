package com.dongweihang.sell.service;

import com.dongweihang.sell.dto.OrderDTO;

/**
 * 买家查询订单和取消清单
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrderOne(String openid,String orderId);


}
