package com.emerio.productapp;

import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ProductAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}
        
        @Controller
        class ProductionController{
            
            @GetMapping(path = "/products")
            public String getProducts(Model model)
            {
                model.addAttribute("products", Arrays.asList("product a", "product b", "product c"));
                return "products";
            }
            
            @GetMapping(path = "/logout")
            public String logout (HttpServletRequest request) throws ServletException
            {
                request.logout();
                return "/";
            }
        }
}
