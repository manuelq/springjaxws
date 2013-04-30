package com.springws.service;

import javax.jws.WebService;

import com.springws.domain.PlaceOrderRequest;
import com.springws.domain.PlaceOrderResponse;


@WebService
public interface OrderService {
	PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
}
