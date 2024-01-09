package mvc.controller;

import mvc.Entity.OrderDetailsEntity;
import mvc.Entity.OrdersEntity;
import mvc.Entity.ProductsEntity;
import mvc.Repository.OrderDetailRepository;
import mvc.Repository.OrderRepository;
import mvc.Repository.ProductRepository;
import mvc.Session.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
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



    @RequestMapping(value = "/addToCart/{productId}" ,method = RequestMethod.GET)
    public String GetCartonProduct(Model model, HttpServletRequest request, HttpSession session, @PathVariable int productId){
        ProductsEntity productsEntity =(ProductsEntity) productRepository.findById(productId).get();
        List<CartSession> cartSessions = (List<CartSession>) request.getSession().getAttribute("cartSessions");
        if(cartSessions == null){
            cartSessions = new ArrayList<CartSession>();
        }
        boolean found = false;

        for( CartSession cartSession : cartSessions){
            if(cartSession.getProductsEntity().getProductId() == productId){
                cartSession.setQuantity(cartSession.getQuantity() + 1);
                found = true;
                break;
            }
        }
        if(!found){
            CartSession cart = new CartSession();
            cart.setQuantity(1);
            cart.setProductsEntity(productsEntity);
            cartSessions.add(cart);
        }
        session.setAttribute("cartSessions", cartSessions);

        model.addAttribute("cart",cartSessions);


        return "Carts/carttolist";
    }






    @RequestMapping(value = "/removeToCart/{productId}",method = RequestMethod.GET)
    public String GetDeleteOnProduct(@PathVariable int productId,HttpServletRequest request,HttpSession session){

        List<CartSession> cartSessions = (List<CartSession>) request.getSession().getAttribute("cartSessions");
        if(cartSessions != null){
            for(CartSession cartSession:cartSessions) {
                if (cartSession.getProductsEntity().getProductId() == productId) {
                    cartSessions.remove(cartSession);
                    break;
                }
                session.setAttribute("cartSessions", cartSessions);
                break;
            }
        }



        return "Carts/carttolist";
    }


    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String RegisterOrderCustomer(Model model){
        model.addAttribute("customer",new OrdersEntity());
        model.addAttribute("action","checkout");
        return "Checkoutcontrol/checkouttolist";
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.POST)
    public String InsertRegisterOrderCustomer(Model model,OrdersEntity orders,HttpServletRequest request){
        OrdersEntity ordersEntity =new OrdersEntity();
        ordersEntity.setOrderDate(LocalDate.now());
        ordersEntity.setCustomerName(orders.getCustomerName());
        ordersEntity.setCustomerAddress(orders.getCustomerAddress());
        orderRepository.save(ordersEntity);

        List<CartSession> cartSessions =(List<CartSession>) request.getSession().getAttribute("cartSessions");
        if(cartSessions ==null){
            cartSessions = new ArrayList<CartSession>();
        }

        if(cartSessions !=null) {
            for (CartSession cartSession : cartSessions) {
                OrderDetailsEntity orderDetails = new OrderDetailsEntity();
                orderDetails.setProducts(cartSession.getProductsEntity());
                orderDetails.setOrdersEntities(ordersEntity);
                orderDetails.setQuantity(cartSession.getQuantity());
                orderDetailRepository.save(orderDetails);

            }

        }

        return "redirect:/cart/dashboard";
    }

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String SelectRegisterOrderCustomer(Model model){
        List<OrdersEntity> ordersEntities =(List<OrdersEntity>) orderRepository.findAll();
        model.addAttribute("orders",ordersEntities);
        return "Checkoutcontrol/Checklists";
    }

    @RequestMapping(value = "/viewDetail/{orderId}",method = RequestMethod.GET)
    public String ViewDetailRegister(Model model,@PathVariable int orderId){
         OrdersEntity ordersEntity = (OrdersEntity) orderRepository.findById(orderId).get();
         List<OrderDetailsEntity> orderDetailsEntities =ordersEntity.getOrderDetails();
         model.addAttribute("ordersDetail",orderDetailsEntities);
         return "Checkoutcontrol/orderDetail";
    }

    @RequestMapping(value = "/myCartsOnCustomer",method = RequestMethod.GET)
    public String MyCartOnCustomer(Model model,HttpServletRequest request,HttpSession session){
        List<CartSession> cartSessions =(List<CartSession>) request.getSession().getAttribute("cartSessions");
        session.setAttribute("cartSessions", cartSessions);

        model.addAttribute("cart",cartSessions);


        return "Carts/carttolist";
    }

    @RequestMapping(value = "/removeDetail/{productId}",method = RequestMethod.GET)
    public String DeleteViewDetailRegister(Model model,HttpServletRequest request,HttpSession session, @PathVariable int productId) {
        List<CartSession> cartSessions = (List<CartSession>) request.getSession().getAttribute("cartSessions");
        if (cartSessions != null) {
            for (CartSession cartSession : cartSessions) {
                if (cartSession.getProductsEntity().getProductId() == productId) {
                    cartSessions.remove(cartSession);
                    break;
                }
                session.setAttribute("cartSessions", cartSessions);
                break;
            }
        }
            return "Checkoutcontrol/orderDetail";
    }

    @RequestMapping(value = "/addCustomer/{orderId}",method = RequestMethod.POST)
    public String GetCheckoutOnOrderId(Model model,HttpSession session,HttpServletRequest request,@PathVariable int orderId){
        OrdersEntity ordersEntity=(OrdersEntity) orderRepository.findById(orderId).get();
        model.addAttribute("orders",ordersEntity);
        return "Checkoutcontrol/checkouttolist";
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public String GetCheckoutTableOnOrderId(Model model){
        List<OrdersEntity> ordersEntities =(List<OrdersEntity>) orderRepository.findAll();
        model.addAttribute("order",ordersEntities);
        return "Checkoutcontrol/Checklists";
    }

    @RequestMapping(value = "/addToCustomer/{orderId}",method = RequestMethod.POST)
    public String PostCheckOut(){
        return null;
    }





}
