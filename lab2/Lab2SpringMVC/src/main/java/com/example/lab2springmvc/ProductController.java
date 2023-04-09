package com.example.lab2springmvc;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    @GetMapping("/addProductPage")
    public ModelAndView getProductForm() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("addProductPage");
        return modelAndView;
    }

    @PostMapping("/addproduct")
    public ModelAndView addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addProductPage");
            return modelAndView;
        }
//        Map<String, Object> map = new HashMap<>();
        if (product != null) {
            Map<String, Product> productList = (Map<String, Product>) httpSession.getAttribute("productList");
            if (productList == null) {
                productList = new HashMap<>();
                httpSession.setAttribute("productList", productList);
            }
            productList.put(product.getProductNumber(), product);
//            map.put("productList", productList.values());
        }
//        modelAndView.addObject(map);
        modelAndView.setViewName("redirect:products");
        return modelAndView;
//        return new ModelAndView("redirect:products", map);
    }

    @GetMapping("/products")
    public ModelAndView getProductList(HttpSession httpSession) {
        Map<String, Object> productList = (Map<String, Object>) httpSession.getAttribute("productList");
        if (productList == null) {
            productList = new HashMap<>();
            httpSession.setAttribute("productList", productList);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("productList", productList.values());
        return new ModelAndView("products", params);
    }

    @PostMapping("/removeProduct")
    public ModelAndView removeProduct(@RequestParam("productNumber") String productNumber, HttpSession httpSession) {
        Map<String, Object> params = new HashMap<>();
        if (productNumber != null) {
            Map<String, Product> productList = (Map<String, Product>) httpSession.getAttribute("productList");
            if (productList == null) {
                productList = new HashMap<>();
                httpSession.setAttribute("productList", productList);
            }
            productList.remove(productNumber);
            params.put("productList", productList.values());
        }
        return new ModelAndView("redirect:products", params);
    }

}
