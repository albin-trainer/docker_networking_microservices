package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.OrderDetails;
import com.example.proxy.ProductProxy;
import com.example.service.OrderService;
@RestController
public class OrderApi {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/testorder")
public ResponseEntity<String> testOrder( @RequestHeader("loggedInUser") int id ){
	String url="http://localhost:8100/test";
	 //communicate with product catalogue
	RestTemplate template= new RestTemplate();
	String msg=template.getForObject(url, String.class);
	msg=msg+" Hello "+id;
	return new ResponseEntity<String>(msg, HttpStatus.OK);
}
	@GetMapping("order/{pid}/{quantity}")
	public ResponseEntity<OrderDetails> order(@PathVariable  int pid,@PathVariable  int quantity){
		OrderDetails orderDetails=orderService.order(pid, quantity);;
		return new ResponseEntity<OrderDetails>(orderDetails,HttpStatus.OK);
	}
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("orderLoadBal/{pid}/{quantity}")
	public ResponseEntity<OrderDetails> orderWithLoadBal(@PathVariable  int pid,@PathVariable  int quantity){
	//	OrderDetails orderDetails=orderService.order(pid, quantity);;
		String url="http://product-catalogue/products/"+pid;
		//here it will get all the list of product-catalogue instances from Eureka
		//loadbalancing is done by the resttemplate 
		//developer shud know url, http method etc ....
		OrderDetails orderDetails=restTemplate.getForObject(url, OrderDetails.class);
		return new ResponseEntity<>(orderDetails,HttpStatus.OK);
	}
	@Autowired
	private ProductProxy proxy;
	@GetMapping("orderFeign/{pid}/{quantity}")
	public ResponseEntity<OrderDetails> orderWithFeign(@PathVariable  int pid,@PathVariable  int quantity){
		OrderDetails orderDetails=proxy.order(pid);
		return new ResponseEntity<>(orderDetails,HttpStatus.OK);
	}
	@PostMapping("/testOrderPost")
	public OrderDetails testOrder ( @RequestBody OrderDetails o) {
		return o;
	}
}
