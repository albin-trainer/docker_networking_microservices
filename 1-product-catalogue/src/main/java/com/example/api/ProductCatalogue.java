package com.example.api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;
@RestController
public class ProductCatalogue {
	@Autowired
	private Environment env; //to get the properties of the cur environment
@GetMapping("/test")
	public ResponseEntity<String> testProduct(){
		String port=env.getProperty("local.server.port"); //returns port of local server
		String msg="Testing product From "+port;
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
@Autowired
private ProductService productService;
@GetMapping("/products/{pid}")
public ResponseEntity<Product> searchProduct( @PathVariable  int pid){
	List<Product> products=productService.allProducts();
	Product product=
	products.stream().filter(p->p.getProdId()==pid).findFirst().get();
	return new ResponseEntity<Product>(product,HttpStatus.OK);
}



}
