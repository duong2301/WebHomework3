%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.3.0/css/bootstrap.min.css' />

    <meta charset="UTF-8">
    <title>Hello JSP</title>
</head>
<body>
    <header>
<nav class="navbar bg-body-tertiary fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Customer Store</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">


           <li class="nav-item">
                     <a class="nav-link" href="/">Home</a>
           </li>
           <li class="nav-item">
            <a class="nav-link" href="/cart/checkout">Check out</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="/cart/myCartsOnCustomer">My Carts</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="/cart/dashboard">My Order</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>
    </header>
    <br>
    <main class="mt-5" style="padding:19px; display:center; justify-content:center;">
       <p class="text-center">Check to list</p>
       <table class="table  table-dark table-striped">
         <thead>
           <tr>
             <th scope="col">id</th>
             <th scope="col">Name</th>
             <th scope="col">Description</th>
             <th scope="col">prices</th>
             <th scope="col">Quantity</th>
             <th scope="col">buy</th>
           </tr>
         </thead>
         <tbody class="">

        <c:forEach  var="cart" items="${cart}" >
        <tr>
           <th scope="row">${cart.productsEntity.productId}</th>
            <td>${cart.productsEntity.productName}</td>
             <td>${cart.productsEntity.productDescription}</td>
             <td>${cart.productsEntity.unitPrice}</td>
             <td>${cart.quantity}</td>
             <td><button type="button" class="btn btn-primary" onclick="location.href='/cart/removeToCart/${cart.productsEntity.productId}'">Remove from cart</button></td>
            </tr>
        </c:forEach>

         </tbody>
       </table>
       <br>
       <div class="d-md-flex justify-content-md-center">

        <button  class="btn btn-primary" onclick="window.location.href='/cart/checkout'">checkout</button>

       </div>
    </main>
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>