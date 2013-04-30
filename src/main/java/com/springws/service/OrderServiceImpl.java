package com.springws.service;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.stereotype.Service;

import com.springws.domain.PlaceOrderRequest;
import com.springws.domain.PlaceOrderResponse;

@Service("orderServiceImpl")
@WebService(serviceName = "OrderService")
public class OrderServiceImpl  implements OrderService {
	
	@Resource
    private WebServiceContext context;
	
    @WebMethod(operationName = "placeOrder")
    public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
    	PlaceOrderResponse response=new PlaceOrderResponse();
    	response.setRefNumber(getRandomOrderRefNo());
    	final HttpServletRequest request = (HttpServletRequest) context.getMessageContext().get( MessageContext.SERVLET_REQUEST );
        final HttpSession session = request.getSession();
 		return response;
    }
    
    
    private String getRandomOrderRefNo() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return "Ref-1234-" + year + "-" + month + "-" + day + "-" + Math.random();
    }
}
 