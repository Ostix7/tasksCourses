package com.ua.beautyshop.controller;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Product;
import com.ua.beautyshop.repository.ProductRepository;
import com.ua.beautyshop.service.CategoryService;
import com.ua.beautyshop.service.MasterService;
import com.ua.beautyshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private final ProductService productService;
    private final MasterService masterService;
    private final ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public HomeController(ProductService productService,ProductRepository productRepository, MasterService masterService) {
        this.productService = productService;
        this.masterService=masterService;
        this.productRepository=productRepository;
    }

    @GetMapping(value = {"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("products", getAllProducts());
        model.addAttribute("productsCount", productsCount());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("masters",getAllMasters());
        return "home";
    }

    @RequestMapping("/searchByCategory")
    public String homePost(@RequestParam("categoryId") long categoryId, Model model){
        model.addAttribute("category", productService.findAllByCategoryId(categoryId));
        model.addAttribute("categoryCount", productService.count());
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }
    @RequestMapping("/searchByMaster")
    private String getAllMasters(@RequestParam("masterId") long masterId, Model model) {
        model.addAttribute("masterId", masterService.findById(masterId));
        model.addAttribute("allMasters", masterService.findAll());
        return  "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    private List<Product> getAllProducts(){

        return productService.findAllByOrderByIdAsc();
    }

    private List<Master>getAllMasters(){return masterService.findAll();}





    private long productsCount(){
        return productService.count();
    }
}
