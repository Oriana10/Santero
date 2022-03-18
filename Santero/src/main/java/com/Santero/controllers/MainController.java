package com.Santero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Santero.entities.Product;
import com.Santero.services.ClientOrderService;
import com.Santero.services.ClientService;
import com.Santero.services.PaymentService;
import com.Santero.services.ProductService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired 
	private PaymentService paymentService;
	
	@Autowired 
	private ProductService productService;
	
	@Autowired
	private ClientOrderService orderService;
	
	@GetMapping()
	public String index() {
		return "index";
	}	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String adminPanel(ModelMap modelMap){
		try {
			modelMap.put("list-clients", clientService.getAll());
			modelMap.put("accounting", paymentService.getAll());
			modelMap.put("stock", productService.getAllProducts());
			modelMap.put("orders", orderService.getAll());
			return "views/admin/adminPanel";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "redirect:/admin";
		}
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("/product_save_and_edit")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product obj = productService.saveProduct(product);
		return new ResponseEntity<Product>(obj, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/delete/{idProduct}")
	public ResponseEntity<Product> deleteProduct(@PathVariable String idProduct) {
		Product product = productService.getById(idProduct);
		if(product != null) {
			productService.deleteProduct(idProduct);
		}else {			
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
