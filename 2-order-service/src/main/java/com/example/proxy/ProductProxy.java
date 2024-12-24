package com.example.proxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.model.OrderDetails;
@FeignClient(name="product-catalogue") //name which is registered in Eureka
public interface ProductProxy {
	@GetMapping("/products/{pid}")
OrderDetails order(@PathVariable int pid);
}
