package org.example.task.controller;

import org.example.task.domain.Boutique;
import org.example.task.domain.Product;
import org.example.task.domain.Store;
import org.example.task.dto.StoreDto;
import org.example.task.repos.BoutiqueRepo;
import org.example.task.repos.ProductRepo;
import org.example.task.repos.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class MainController {

    @Autowired
    private StoreRepo storeRepo;
    @Autowired
    private BoutiqueRepo boutiqueRepo;
    @Autowired
    private ProductRepo productRepo;

    @GetMapping(value = "/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }


    @GetMapping("/get_store/{id}")
    public StoreDto getStore(@PathVariable(value = "id") final Long id) {
        return StoreDto.fromEntity(storeRepo.findById(id).orElseThrow(RuntimeException::new));
    }
//    @GetMapping("/get_store")
//    public

    @GetMapping("/get_boutique")
    public Boutique getBoutique() {
        System.out.println("Log");
        return new Boutique("zzum", "Bishkek", null );
    }

    @GetMapping("/get_product")
    public Product getProduct() {
        System.out.println("Log");
        return new Product(true, "T-Short", "M", 213);
    }
//    @GetMapping("/get_model")
//    public Model getModel() {
//        System.out.println("Log");
//        return new Model("Anvar", "anvar123");
//    }
//
//    class Model {
//
//        private String name;
//
//        private String password;
//
//        public Model() {
//        }
//
//        public Model(String name, String password) {
//            this.name = name;
//            this.password = password;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }

    @GetMapping(value = "/main")
    public String main(Map<String, Object> model) {
        Iterable<Store> stores = storeRepo.findAll();
        model.put("store", stores);
        return "main";
    }

    @PostMapping(value = "/addStore")
    public String addStore(@RequestParam(name = "name") String name,
                           @RequestParam(name = "country") String country,
                           @RequestParam(name = "boutique") Boutique boutique,
                           Map<String, Object> model) {
        Store store = new Store(name, country);

        storeRepo.save(store);

        Iterable<Store> stores = storeRepo.findAll();
        model.put("store", stores);

        return "main";
    }
    @PostMapping(value = "addBoutique")
    public String addBoutique(@RequestParam(name = "address") String address,
                              @RequestParam(name = "city") String city,
                              @RequestParam(name = "product") Product product,
                              Map<String, Object> model) {
        Boutique boutique = new Boutique(address, city, product);

        boutiqueRepo.save(boutique);

        Iterable<Boutique> boutiques = boutiqueRepo.findAll();
        model.put("boutique", boutiques);

        return "main";
    }

    @PostMapping(value = "addProduct")
    public String addProduct(@RequestParam(name = "gender") Boolean gender,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "size") String size,
                             @RequestParam int price,
                             Map<String, Object> model) {
        Product product = new Product(gender, title, size, price);

        productRepo.save(product);

        Iterable<Product> products = productRepo.findAll();
        model.put("product", products);

        return "main";
    }

}
