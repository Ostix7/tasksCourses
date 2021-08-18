package com.ua.beautyshop;

import com.ua.beautyshop.domain.Category;
import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Product;
import com.ua.beautyshop.repository.CategoryRepository;
import com.ua.beautyshop.service.MasterService;
import com.ua.beautyshop.service.ProductService;
import com.ua.beautyshop.domain.User;
import com.ua.beautyshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final MasterService masterService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);



    @Autowired
    public StartupData(UserService userService,MasterService masterService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.masterService=masterService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        masterAccount();
        master2Account();
        category();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");

        user.setEmail("user@example.com");

        userService.save(user);
    }
    private void masterAccount(){
        Master master = new Master();

        master.setUsername("master");
        master.setPassword("master");
        master.setPasswordConfirm("master");
        master.setId(1);
        master.setImageUrl("https://lh3.googleusercontent.com/proxy/S9NXghjIIzSC6ZDMST8H6-gY1iPGGbqSQ1Cqx9qQZAk4uBdZ98j7LSDB_FyWOLglHkSFVlbvzNiUuKV_N__NBBLNhmAd4a1jRYwNpi0h6SamsgcVMk-WSLrLk8ZjUR0OPky3uGqysiUQQj_6ryGNKLRfh4eEI8QbS3PR5YtJWL4qnuhkxO1GmKc4J0QSlHV0HyjE-tiiuYqzWoIxhdWoCPY");
        masterService.save(master);
    }
    private void master2Account(){
        Master master2 = new Master();

        master2.setUsername("master2");
        master2.setPassword("master2");
        master2.setPasswordConfirm("master2");
        master2.setImageUrl("https://lh3.googleusercontent.com/proxy/S9NXghjIIzSC6ZDMST8H6-gY1iPGGbqSQ1Cqx9qQZAk4uBdZ98j7LSDB_FyWOLglHkSFVlbvzNiUuKV_N__NBBLNhmAd4a1jRYwNpi0h6SamsgcVMk-WSLrLk8ZjUR0OPky3uGqysiUQQj_6ryGNKLRfh4eEI8QbS3PR5YtJWL4qnuhkxO1GmKc4J0QSlHV0HyjE-tiiuYqzWoIxhdWoCPY");
        masterService.save(master2);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category(){
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setId(1);
        category1.setCategoryName("Nails");
        category2.setId(2);
        category2.setCategoryName("Hair");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }

    private void exampleProducts(){
        final String NAME = "Example Name";
        final String IMAGE_URL = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/download-51-1567099294.jpeg?resize=480:*";
        final String DESCRIPTION = "Nails";
        final BigDecimal PRICE = BigDecimal.valueOf(22);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName("B"+NAME);
        product1.setImageUrl(IMAGE_URL);
        product1.setDescription(DESCRIPTION);
        product1.setCategory(categoryRepository.findByCategoryName("Nails"));
        product1.setPrice(PRICE);
        product1.setMaster( masterService.findByUsername("master2"));


        product2.setName("A "+NAME);
        product2.setImageUrl(IMAGE_URL);
        product2.setDescription(DESCRIPTION);
        product2.setCategory(categoryRepository.findByCategoryName("Nails"));
        product2.setPrice(PRICE);
        product2.setMaster( masterService.findByUsername("master2"));


        product3.setName("c"+NAME);
        product3.setImageUrl(IMAGE_URL);
        product3.setDescription(DESCRIPTION);
        product3.setCategory(categoryRepository.findByCategoryName("Hair"));
        product3.setPrice(PRICE);
        product3.setMaster( masterService.findByUsername("master"));


        product4.setName(NAME);
        product4.setImageUrl(IMAGE_URL);
        product4.setDescription(DESCRIPTION);
        product4.setCategory(categoryRepository.findByCategoryName("Hair"));
        product4.setPrice(PRICE);
        product4.setMaster( masterService.findByUsername("master2"));

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
