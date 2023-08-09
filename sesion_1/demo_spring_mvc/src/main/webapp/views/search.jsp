<%--
  Created by IntelliJ IDEA.
  User: ACER NITRO 5
  Date: 8/9/2023
  Time: 5:23 PM
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
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/products">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/products">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/products/showFormAdd">Add Product</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0" action="/products/search">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="name">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Mã sản phẩm</th>
      <th scope="col">Ảnh</th>
      <th scope="col">Tên</th>
      <th scope="col">Giá</th>
      <th scope="col" colspan="2">Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${productList.size() == 0}">
     <tr>
       <th>Không tìm thấy sản phẩm</th>
     </tr>
    </c:if>
    <c:if test="${productList.size() > 0}">
      <c:forEach items="${productList}" var="p">
        <tr>
          <th scope="col">${p.id}</th>
          <th scope="col"><img src="${p.img}" style="width: 150px ; height: 200px" alt="img.jpg"></th>
          <th scope="col">${p.name}</th>
          <th scope="col">${p.price}</th>
          <th scope="col">
            <a href="/products/formEdit?idProduct=${p.id}" type="button" class="btn btn-outline-warning">Edit</a>
          </th>
          <th scope="col">
            <a href="/products/delete?idProduct=${p.id}" type="button" class="btn btn-outline-danger">Delete</a>
          </th>
        </tr>
      </c:forEach>
    </c:if>


    </tbody>
  </table>
</div>

</body>
</html>
