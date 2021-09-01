package com.ua.beautyshop;

import com.ua.beautyshop.domain.*;
import com.ua.beautyshop.repository.CategoryRepository;
import com.ua.beautyshop.repository.OrderRepository;
import com.ua.beautyshop.service.MasterService;
import com.ua.beautyshop.service.OrderService;
import com.ua.beautyshop.service.ProductService;
import com.ua.beautyshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final MasterService masterService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);



    @Autowired
    public StartupData(UserService userService, MasterService masterService, ProductService productService, CategoryRepository categoryRepository, OrderRepository orderRepository, OrderService orderService) {
        this.userService = userService;
        this.masterService=masterService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        masterAccount();
        master2Account();
        master3Account();
        category();
        order();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");
        user.setBalance(BigDecimal.valueOf(1000));

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("user2");
        user2.setPasswordConfirm("user2");
        user2.setGender("Female");

        user2.setEmail("user2@example.com");

        userService.save(user);
        userService.save(user2);
    }
    private void masterAccount(){
        Master master = new Master();

        master.setUsername("master");
        master.setPassword("master");
        master.setPasswordConfirm("master");
        master.setId(1);
        master.setImageUrl("https://i.pinimg.com/originals/5f/20/77/5f20778bfa96dd81a3483816307e5fbe.jpg");
        masterService.save(master);
    }
    private void master2Account(){
        Master master2 = new Master();

        master2.setUsername("master2");
        master2.setPassword("master2");
        master2.setPasswordConfirm("master2");
        master2.setRate(4.0);
        master2.setImageUrl("https://lh3.googleusercontent.com/proxy/S9NXghjIIzSC6ZDMST8H6-gY1iPGGbqSQ1Cqx9qQZAk4uBdZ98j7LSDB_FyWOLglHkSFVlbvzNiUuKV_N__NBBLNhmAd4a1jRYwNpi0h6SamsgcVMk-WSLrLk8ZjUR0OPky3uGqysiUQQj_6ryGNKLRfh4eEI8QbS3PR5YtJWL4qnuhkxO1GmKc4J0QSlHV0HyjE-tiiuYqzWoIxhdWoCPY");
        masterService.save(master2);
    }
    private void master3Account(){
        Master master3 = new Master();

        master3.setUsername("z");
        master3.setPassword("master2");
        master3.setPasswordConfirm("master2");
        master3.setRate(2.0);
        master3.setImageUrl("https://lh3.googleusercontent.com/proxy/S9NXghjIIzSC6ZDMST8H6-gY1iPGGbqSQ1Cqx9qQZAk4uBdZ98j7LSDB_FyWOLglHkSFVlbvzNiUuKV_N__NBBLNhmAd4a1jRYwNpi0h6SamsgcVMk-WSLrLk8ZjUR0OPky3uGqysiUQQj_6ryGNKLRfh4eEI8QbS3PR5YtJWL4qnuhkxO1GmKc4J0QSlHV0HyjE-tiiuYqzWoIxhdWoCPY");
        masterService.save(master3);
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
    private void order(){
        Order order=new Order();
        order.setId(1);
        order.setEstimatedCheckInTime(LocalTime.of(5,30));
        order.setRegistrationDate(LocalDate.of(2021,12,14));
        order.setUserId(1);
        order.setTotalPrice(BigDecimal.valueOf(200.0));
        order.setMaster(masterService.findByUsername("master"));
        Order order2=new Order();
        order2.setId(2);
        order2.setEstimatedCheckInTime(LocalTime.of(6,30));
        order2.setRegistrationDate(LocalDate.of(2021,12,14));
        order2.setUserId(2);
        order2.setTotalPrice(BigDecimal.valueOf(200.0));
        order2.setMaster(masterService.findByUsername("master"));

        orderRepository.save(order);
        orderRepository.save(order2);


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
        final String IMAGE_URL = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/download-51-1567099294.jpeg?resize=780:*";
        final String DESCRIPTION = "Nails";
        final BigDecimal PRICE = BigDecimal.valueOf(22);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName("Nails ckean");
        product1.setImageUrl(IMAGE_URL);
        product1.setDescription("cutting of nails");
        product1.setCategory(categoryRepository.findByCategoryName("Nails"));
        product1.setPrice(PRICE);
        product1.setMaster( masterService.findByUsername("master"));


        product2.setName("Nails cut");
        product2.setImageUrl(IMAGE_URL);
        product2.setDescription("cutting of nails");
        product2.setCategory(categoryRepository.findByCategoryName("Nails"));
        product2.setPrice(PRICE);
        product2.setMaster( masterService.findByUsername("master2"));


        product3.setName("c"+NAME);
        product3.setImageUrl("https://www.modnapricha.info/wp-content/uploads/2020/02/krasivaya-pricheska-na-1-sentyabrya-bystro-i-prosto40.jpg");
        product3.setDescription("р");
        product3.setCategory(categoryRepository.findByCategoryName("Hair"));
        product3.setPrice(PRICE);
        product3.setMaster( masterService.findByUsername("master"));


        product4.setName(NAME);
        product4.setImageUrl("https://www.modnapricha.info/wp-content/uploads/2020/02/krasivaya-pricheska-na-1-sentyabrya-bystro-i-prosto40.jpg");
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
