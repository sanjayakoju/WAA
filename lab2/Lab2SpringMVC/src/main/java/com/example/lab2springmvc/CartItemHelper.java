package com.example.lab2springmvc;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

public class CartItemHelper {

    public static Map<String,CartItem> addToCard(String productNumber, Map<String, Product> productList, HttpSession httpSession) {
        Map<String,CartItem> cartList = (Map<String, CartItem>) httpSession.getAttribute("cartList");
        Product product = productList.get(productNumber);
        if(cartList==null) {
            cartList = new HashMap<>();
            CartItem cart = new CartItem();
            cart.setName(product.getName());
            cart.setPrice(product.getPrice());
            cart.setProductNumber(productNumber);
            int qty = cart.getQuantity() + 1;
            cart.setQuantity(qty);
            cart.setTotal(qty* product.getPrice());
            cartList.put(productNumber, cart);
            httpSession.setAttribute("cartList", cartList);
        } else {
           CartItem cart = cartList.get(productNumber);
           if(cart!=null) {
               cart.setName(product.getName());
               cart.setPrice(product.getPrice());
               cart.setProductNumber(productNumber);
               int qty = cart.getQuantity() + 1;
               cart.setQuantity(qty);
               cart.setQuantity(qty);
               cart.setTotal(qty* product.getPrice());
               cartList.put(productNumber, cart);
               httpSession.setAttribute("cartList", cartList);
           } else {
               CartItem newCart = new CartItem();
               newCart.setName(product.getName());
               newCart.setPrice(product.getPrice());
               newCart.setProductNumber(productNumber);
               int qty = newCart.getQuantity() + 1;
               newCart.setQuantity(qty);
               newCart.setQuantity(qty);
               newCart.setTotal(qty* product.getPrice());
               cartList.put(productNumber, newCart);
               httpSession.setAttribute("cartList", cartList);
           }
        }
        return cartList;
    }
}
