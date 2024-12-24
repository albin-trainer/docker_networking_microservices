package com.example.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.OrderDetails;
@Service
public class OrderServiceImpl implements OrderService{
	@Override
	public OrderDetails order(int pid, int quantity) {
		String url="http://localhost:8100/products/"+pid;
		RestTemplate template=new RestTemplate();
		OrderDetails orderDetails=
				template.getForObject(url, OrderDetails.class);
		//orderDetails.setQuantity(quantity);
		return orderDetails;
	}

}
