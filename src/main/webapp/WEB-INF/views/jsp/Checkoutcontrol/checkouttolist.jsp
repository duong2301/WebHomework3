<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.3.0/css/bootstrap.min.css' />
    <meta charset="UTF-8">
    <title>Hello JSP</title>
</head>
<body>
   <div class="d-flex justify-content-center mt-5">
<mvc:form action="${action}"  method="POST" modelAttribute="customer">
      <h1>Register Customer</h1>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Customer name</label>
    <mvc:input type="text" class="form-control" path="customerName" id="exampleInputEmail1" aria-describedby="nameHelp"/>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1"  class="form-label">Customer Address</label>
    <mvc:input  type="text" path="customerAddress" class="form-control" id="exampleInputPassword1"/>
  </div>
  <div class="mb-3 d-grid">
  <button type="submit"  class="btn btn-primary">Submit</button>
  <br>
  <button type="button" onclick="window.location.href='/'" class="btn btn-outline-primary">Cannel</button>
  </div>
</mvc:form>
   </div>
   <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>