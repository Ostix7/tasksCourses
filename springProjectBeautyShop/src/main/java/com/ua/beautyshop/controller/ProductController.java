package com.ua.beautyshop.controller;

import com.ua.beautyshop.domain.Product;
import com.ua.beautyshop.service.CategoryService;
import com.ua.beautyshop.service.MasterService;
import com.ua.beautyshop.service.ProductService;
import com.ua.beautyshop.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ProductValidator productValidator;
    private final CategoryService categoryService;
    private final MasterService masterService;


    @Autowired
    public ProductController(ProductService productService,MasterService masterService, ProductValidator productValidator, CategoryService categoryService) {
        this.productService = productService;
        this.masterService=masterService;
        this.productValidator = productValidator;
        this.categoryService = categoryService;
    }

    @GetMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new Product());
        model.addAttribute("method", "new");
        model.addAttribute("masters",masterService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "product";
    }

    @PostMapping("/product/new")
    public String newProduct(@ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model) {
        productValidator.validate(productForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
            return "product";
        }
        productService.save(productForm);
        logger.debug(String.format("Product with id: %s successfully created.", productForm.getId()));

        return "redirect:/home";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") long productId, Model model){
        Product product = productService.findById(productId);
        if (product != null){
            model.addAttribute("productForm", product);
            model.addAttribute("method", "edit");
            model.addAttribute("masters", masterService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            return "product";
        }else {
            return "error/404";
        }
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") long productId, @ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model){
        productValidator.validate(productForm, bindingResult);

            productService.edit(productId, productForm);
            logger.debug(String.format("Product with id: %s has been successfully edited.", productId));
            return "redirect:/home";


    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long productId){
        Product product = productService.findById(productId);
        if (product != null){
           productService.delete(productId);
           logger.debug(String.format("Product with id: %s successfully deleted.", product.getId()));
           return "redirect:/home";
        }else {
            return "error/404";
        }
    }
}
