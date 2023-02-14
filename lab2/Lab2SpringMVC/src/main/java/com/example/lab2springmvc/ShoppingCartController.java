package com.example.lab2springmvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ShoppingCartController {

    @PostMapping("/addToCart")
    public ModelAndView addToCart(@RequestParam("productNumber") String productNumber, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Product> productList = (Map<String, Product>) httpSession.getAttribute("productList");
        Map<String, CartItem> cartMap = CartItemHelper.addToCard(productNumber, productList, httpSession);
        modelAndView.addObject("cartList", cartMap.values());
        modelAndView.setViewName("redirect:showCart");
        return modelAndView;
    }

    @GetMapping("/showCart")
    public ModelAndView showCart(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, CartItem> productCartList = (Map<String, CartItem>) httpSession.getAttribute("cartList");
        double total = 0.0;
        for (CartItem cartItem: productCartList.values()) {
            total += cartItem.getTotal();
        }
        modelAndView.addObject("cartList", productCartList.values());
        modelAndView.addObject("total", total);
        modelAndView.setViewName("showCart");
        return modelAndView;
    }

    @PostMapping("/removeCartProduct")
    public ModelAndView removeProduct(@RequestParam("productNumber") String productNumber, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        if (productNumber != null) {
            Map<String, CartItem> productCartList = (Map<String, CartItem>) httpSession.getAttribute("cartList");
            if (productCartList == null) {
                productCartList = new HashMap<>();
                httpSession.setAttribute("cartList", productCartList);
            }
            productCartList.remove(productNumber);
        }
        modelAndView.setViewName("redirect:showCart");
        return modelAndView;
    }
}
