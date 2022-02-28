package org.niraj.controller;

import java.util.List;

import org.niraj.entity.Product;
import org.niraj.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;


//  This class is for [ traditional way of REST API ] Shifted Spring4 version
//  of @RestController in ProductController
 


/*
@Controller
@RequestMapping("product")
public class ProductController_OLD {

	private static final Logger logger = LoggerFactory.getLogger(ProductController_OLD.class);

	@Autowired
	private IProductService productService;

	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id){
        Product prod = productService.getProductById(id);
        logger.info("In the getProductId method ==> " + prod);	
        if (id == 6){throw new RuntimeException();}
		return new ResponseEntity<Product>(prod , HttpStatus.OK); 
	}

	@GetMapping("/allProduct")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> producList = productService.getAllProducts();
        logger.info("Getting all the product for path /all Size is ==> " + producList.size());
        return new ResponseEntity<List<Product>>(producList , HttpStatus.OK);
	}

	@GetMapping("/allProduct/c/{sortBy}")
	public ResponseEntity<List<Product>> getAllProductsSorted(@PathVariable("sortBy") String sortBy){
        logger.info("Product Sorting Request by Comparator  ==> " + sortBy);
        List<Product> producList = productService.getAllProductsSortedByComparator(sortBy);        
        return new ResponseEntity<List<Product>>(producList , HttpStatus.OK);
	}

	@GetMapping("/allProduct/q/{sortBy}")
	public ResponseEntity<List<Product>> getAllProductsSortedByQuery(@PathVariable("sortBy") String sortBy){
        logger.info("Product Sorting Request by Query ==> " + sortBy);
        List<Product> producList = productService.getAllProductsSortedByQuery(sortBy);        
        return new ResponseEntity<List<Product>>(producList , HttpStatus.OK);
	}

	@GetMapping("/{start}/{count}")
	public ResponseEntity<List<Product>> getProductsInRange(@PathVariable("start") int start, @PathVariable("count") int count) {
		logger.info("Product Range Request Start/Count ==> " + start + "/" + count);
		List<Product> producList = productService.getProductsInRange(start, count);
		logger.info("Getting Product Range Size is ==> " + producList.size());
		return new ResponseEntity<List<Product>>(producList, HttpStatus.OK);
	}	

	@PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct( @RequestBody Product prodVo , UriComponentsBuilder uriBuilder){
    	Product newProd = productService.addProduct(prodVo);
    	HttpHeaders header = new HttpHeaders();
        header.setLocation(uriBuilder.path("/product/{id}").buildAndExpand(newProd.getPkIdProduct()).toUri()  );
        return new ResponseEntity<Void>( header, HttpStatus.CREATED);
    }

	@PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct( @RequestBody Product prodVo , @PathVariable("id") Integer pid ){
		Product updatedProduct = productService.updateProduct(pid, prodVo);
        logger.info("Product Update in Controller "+ pid +"==>"+ prodVo);
		return new ResponseEntity<Product>(updatedProduct , HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id ){
        logger.info("Product Delete in Controller "+ id);
        productService.deleteProduct(id);
    	return new ResponseEntity<String>(HttpStatus.NO_CONTENT); 
    }
	
} 

*/