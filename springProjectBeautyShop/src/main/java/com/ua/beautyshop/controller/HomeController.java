package com.ua.beautyshop.controller;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Order;
import com.ua.beautyshop.domain.Product;
import com.ua.beautyshop.repository.ProductRepository;
import com.ua.beautyshop.service.CategoryService;
import com.ua.beautyshop.service.MasterService;
import com.ua.beautyshop.service.OrderService;
import com.ua.beautyshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;
    private final MasterService masterService;
    private final ProductRepository productRepository;
    private final OrderService orderService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public HomeController(ProductService productService, ProductRepository productRepository, MasterService masterService, OrderService orderService) {
        this.productService = productService;
        this.masterService = masterService;
        this.productRepository = productRepository;
        this.orderService = orderService;
    }

    @GetMapping(value = {"/", "/index", "/home"})
    public String home(Model model) {
        model.addAttribute("products", getAllProducts());
        model.addAttribute("productsCount", productsCount());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("masters", getAllMasters());
        model.addAttribute("master",getMaster());

        return "home";
    }

    @GetMapping("/searchByCategory")
    public String homePost(@RequestParam("categoryId") long categoryId, Model model) {
        List<Product> prodByCat = productService.findAllByCategoryId(categoryId);
        getAllProductsCategory(model, prodByCat);
        model.addAttribute("category", productService.findAllByCategoryId(categoryId));
        model.addAttribute("categoryCount", productService.count());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("masters", getAllMasters());

        return "home";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {

        List<Product> copy = new ArrayList<>();

        copy.add(productService.findByName(keyword));
        model.addAttribute("products", copy);
        model.addAttribute("categoryCount", productService.count());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("masters", getAllMasters());
        model.addAttribute("productsCount", productsCount());
        return "home";
    }

    @GetMapping("/searchByMaster")
    private String searchByMaster(@RequestParam("masterId") long masterId, Model model) {
        List<Product> product = productService.findAll();
        List<Product> copyProduct = new ArrayList<>();

        for (Product prod : product) {
            if (prod.getMaster() == masterService.findById(masterId))
                copyProduct.add(prod);
        }
//        product.stream().filter(pr -> pr.getMaster().equals(masterService.findById(masterId)))
//                            .collect(Collectors.toList());

        model.addAttribute("productsCount", productsCount());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("masters", getAllMasters());
        getAllProducts(model, copyProduct);
        return "home";
    }


    @GetMapping("/sortMasterByRate")
    private String sortRate(Model model) {

        getMastersSorted(model, getAllMastersByRate());
        model.addAttribute("productsCount", productsCount());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.findAll());
        return "home";
    }

    @GetMapping("/sortMasterByName")
    private String sortName(Model model) {

        getMastersSorted(model, getAllMastersByName());
        model.addAttribute("categories", categoryService.findAll());
        return "redirect:/home";
    }

    @GetMapping("/schedule")
    private String getSchedule(Model model){
        List<Order> masterAllOrders=orderService.findAllByMaster(getMaster());
        List<Order> acceptedOrders=orderService.findAllByStatus(true);
        List<Order>notDoneOrders=orderService.findAllByDone(false);
        masterAllOrders.retainAll(acceptedOrders);
        masterAllOrders.retainAll(notDoneOrders);
        model.addAttribute("schedules",masterAllOrders);
        return "schedule";
    }

    private void getMastersSorted(Model model, List<Master> attribute) {
        model.addAttribute("masters", attribute);
    }

    private void getAllProducts(Model model, List<Product> attribute) {
        model.addAttribute("products", attribute);
    }

    private void getAllProductsCategory(Model model, List<Product> attribute) {
        model.addAttribute("products", attribute);
    }


    @GetMapping("/about")
    public String about() {
        return "about";
    }

    private List<Product> getAllProducts() {

        return productService.findAllByOrderByIdAsc();
    }


    private List<Master> getAllMasters() {
        return masterService.findAll();
    }


    private List<Master> getAllMastersByName() {
        List copy = masterService.findAll();
        Collections.sort(copy, new NameComparator());
        return copy;
    }

    private List<Master> getAllMastersByRate() {
        List copy = masterService.findAll();
        Collections.sort(copy, new RateComparator());
        return copy;
    }


    class RateComparator implements Comparator<Master> {
        @Override
        public int compare(Master a, Master b) {
            return a.getRate() < b.getRate() ? 1 : a.getRate() == b.getRate() ? 0 : -1;
        }
    }

    class NameComparator implements Comparator<Master> {
        @Override
        public int compare(Master a, Master b) {
            return a.getUsername().compareToIgnoreCase(b.getUsername());
        }
    }




    public Master getMaster() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return masterService.findByUsername(username);
    }
        private long productsCount() {
        return productService.count();
    }
}
