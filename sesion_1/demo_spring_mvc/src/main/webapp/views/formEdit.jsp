<%--
  Created by IntelliJ IDEA.
  User: ACER NITRO 5
  Date: 8/9/2023
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
  <div class="container">
    <div class="mt-3">
      <h1 style="color: blue">Edit Product</h1>
    </div>
    <form action="/products/edit" method="post">
      <div class="form-group">
        <label for="id">Ảnh</label>
        <input type="text" class="form-control" id="id" name="id" value="${product.id}" readonly>
      </div>
      <div class="form-group">
        <label for="img">Ảnh</label>
        <input type="text" class="form-control" id="img" name="img" value="${product.img}" >
      </div>
      <div class="form-group">
        <label for="name">Tên sản phẩm</label>
        <input type="text" class="form-control" id="name" name="name" value="${product.name}">
      </div>
      <div class="form-group">
        <label for="price">Giá</label>
        <input type="text" class="form-control" id="price" name="price" value="${product.price}">
      </div>
      <button type="submit" class="btn btn-outline-primary">Edit</button>

    </form>
  </div>
</div>
</body>
</html>
