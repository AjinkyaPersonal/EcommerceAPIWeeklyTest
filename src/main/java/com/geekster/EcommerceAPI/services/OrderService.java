package com.geekster.EcommerceAPI.services;

import com.geekster.EcommerceAPI.models.Address;
import com.geekster.EcommerceAPI.models.Order;
import com.geekster.EcommerceAPI.models.Product;
import com.geekster.EcommerceAPI.models.Users;
import com.geekster.EcommerceAPI.repos.IAddressRepo;
import com.geekster.EcommerceAPI.repos.IOrderRepo;
import com.geekster.EcommerceAPI.repos.IProductRepo;
import com.geekster.EcommerceAPI.repos.IUserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepo orderRepo;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IAddressRepo addressRepo;

    @Autowired
    IProductRepo productRepo;

    public String addOrder(Order order) {
        Users user = order.getUserId();
        Address address = order.getAddressId();
        Product product = order.getProductId();

        Optional<Address> addressOptional =  addressRepo.findById(address.getAddressId());
        Optional<Users> userOptional =  userRepo.findById(product.getProductId());
        Optional<Product> productOptional =  productRepo.findById(product.getProductId());

        if(addressOptional.isEmpty()){
            return "Enter the correct addressID";
        } else if (userOptional.isEmpty()) {
            return "Enter the correct userID";
        } else if (productOptional.isEmpty()) {
            return "Enter the correct productID";
        }else{
            order.setAddressId(addressOptional.get());
            order.setProductId(productOptional.get());
            order.setUserId(userOptional.get());

            orderRepo.save(order);
            return "Order placed sucessfully !!!";
        }


    }
}
