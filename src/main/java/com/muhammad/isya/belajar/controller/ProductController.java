package com.muhammad.isya.belajar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.muhammad.isya.belajar.dao.ProductRepository;
import com.muhammad.isya.belajar.domain.Product;


@RestController
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	@RequestMapping("/products")
	public Iterable<Product> allProduct(){
		return repository.findAll();
	}
	
	@RequestMapping("/allproducts")
	public Page<Product> getAllProduct(Pageable page){
		return repository.findAll(page);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertProduct(@RequestBody Product product){
		repository.save(product);
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateProduct(@PathVariable("id") String id, @RequestBody Product product){
		product.setId(id);
		repository.save(product);
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Product findProductById(@PathVariable("id") String id){
		return repository.findOne(id);
	}
	
	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getAll(){
		repository.findAll();
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable("id") String id){
		repository.delete(id);
	}
}
