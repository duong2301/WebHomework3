<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                           <a class="nav-link" href="/cart/dashboard">My Orders</a>
               </li>

        </ul>

      </div>
    </div>
  </div>
</nav>
</header>
<br>
<main class="mt-5">
   <div class="d-flex justify-content-center mt-5 px-5">
         <table class="table table-primary">
           <thead>
             <tr>
               <th scope="col">Id</th>
               <th scope="col">name</th>
               <th scope="col">address</th>
               <th scope="col">Date</th>
                <th scope="col">Detail</th>
             </tr>
           </thead>
           <tbody>
           <c:forEach var="order" items="${orders}">
             <tr>
               <th scope="row">${order.orderId}</th>
                <td>${order.customerName}</td>
                              <td>${order.customerAddress}</td>
                              <td>${order.orderDate}</td>
                              <td><a href="/cart/viewDetail/${order.orderId}">viewDetail</a></td>

             </tr>
             </c:forEach>
           </tbody>
         </table>
   </div>
   </main>
   <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>