package mvc.controller;

import mvc.Entity.ProductsEntity;
import mvc.Repository.OrderDetailRepository;
import mvc.Repository.OrderRepository;
import mvc.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;
    @RequestMapping
    public String GetCart(Model model,HttpSession httpSession){
        List<ProductsEntity> productsEntityList =(List<ProductsEntity>) productRepository.findAll();
        model.addAttribute("productsList",productsEntityList);
        return "Products/productLists";
    }
}
