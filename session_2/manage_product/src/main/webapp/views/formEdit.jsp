<%--
  Created by IntelliJ IDEA.
  User: ACER NITRO 5
  Date: 8/11/2023
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="mt-3">
        <h1 style="color: blue">Edit Product</h1>
    </div>
    <form action="/products/edit" method="post">
        <div class="form-group">
            <label for="name">ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${product.id}" readonly>
        </div>
        <div class="form-group">
            <label for="name">Tên sản phẩm</label>
            <input type="text" class="form-control" id="name" name="name" value="${product.name}" >
        </div>
        <div class="form-group">
            <label for="price">Giá</label>
            <input type="text" class="form-control" id="price" name="price" value="${product.price}" >
        </div>
        <div class="form-group">
            <label for="price">Số lượng</label>
            <input type="text" class="form-control" id="quantity" name="quantity" value="${product.quantity}" >
        </div>
        <div class="form-group">
            <label for="img">Ảnh</label>
            <input type="text" class="form-control" id="img" name="image"  value="${product.image}">
        </div>
        <button type="submit" class="btn btn-outline-primary">Edit</button>

    </form>
</div>


</body>
</html>
