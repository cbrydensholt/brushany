package com.example.brushany.controllers;

import com.example.brushany.models.Product;
import com.example.brushany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired //binder controlleren sammen med service layer
            ProductService productService;


    @GetMapping("/createproduct")
    public String createProduct()
    {
        return "product/createproduct";
    }

    @PostMapping("/createdproduct")
    public String createdProduct(@ModelAttribute Product product){
        productService.create(product);
        return "redirect:/";

    }

    @GetMapping("/productoverview")
    public String customerOverview(Model model){
        model.addAttribute("products", productService.readall());

        return "product/productOverview";

    }

    @GetMapping("/deleteproduct")
    public String deleteCustomer(@RequestParam int productId){
        productService.delete(productId);

        return "redirect:/";

    }

    @GetMapping("/updateproduct")
    public String updateCustomer(@RequestParam int productId, Model model){
        Product product= productService.read(productId);
        model.addAttribute("product", product);
        return "product/updateproduct";

    }

    @PostMapping("/updatedproduct")
    public String updatedsnus(@ModelAttribute Product productFromPost){
        productService.update(productFromPost);
        return "redirect:/";

    }

    @GetMapping("/singleproduct")
    public String singlesnus(@RequestParam int productId, Model model){
        Product tempProduct = productService.read(productId);
        model.addAttribute("product", tempProduct);

        return "product/singleProduct";
    }


}
