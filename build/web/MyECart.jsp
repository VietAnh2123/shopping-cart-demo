<%-- 
    Document   : MyECart
    Created on : Jan 24, 2024, 8:16:26 PM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <style>
            .bag{
                text-align: right;
                margin-right: 100px;
                margin-top: 30px;
            }
            .cart-label:hover{
                cursor: pointer;
            }
            .input-width{
                width: 60px;
            }
            .cart-btn{
                color: white;
                text-decoration: none;
            }
            .back-btn{
                text-align: left;
                margin-left: 100px;
                margin-top: 30px;
            }
            .back-btn a{
                text-decoration: none;
            }
            .back-btn svg{
                color: dodgerblue;
            }
        </style>
    </head>
    <body>
        <div class="back-btn btn">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-bar-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M12.5 15a.5.5 0 0 1-.5-.5v-13a.5.5 0 0 1 1 0v13a.5.5 0 0 1-.5.5M10 8a.5.5 0 0 1-.5.5H3.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L3.707 7.5H9.5a.5.5 0 0 1 .5.5"/>
            </svg>
            <a href="MyEShop.jsp">BACK</a>
        </div>
        <div class="container">
            <h1 class="text-center mt-5">Your cart</h1>
            <table class="table mt-5">
                <tr>
                    <th>No</th>
                    <th>NAME</th>
                    <th>QUANTITY</th>
                    <th>PRICE</th>
                    <th>MONEY</th>
                    <th>Action</th>
                </tr>
                <c:set var="o" value="${sessionScope.cart}"/>
                <c:set var="q" value="0"/>
                <c:forEach items="${sessionScope.cart.items}" var="cart">
                    <c:set var="t" value="${(q+1)}"/>
                    <tr>
                        <td>${t}</td>
                        <td>${cart.product.name}</td>
                        <td>
                            <button><a href="process?num=-1&id=${cart.product.id}">-</a></button>
                            <input type="number" name="" value="${cart.quantity}">
                            <button><a href="process?num=1&id=${cart.product.id}">+</a></button>
                        </td>
                        <td><fmt:formatNumber pattern="##.#" value="${cart.product.price}"/></td>
                        <td><fmt:formatNumber pattern="##.#" value="${cart.quantity*cart.product.price}"/></td>
                        <td>
                            <form action="process" method="POST">
                                <input type="hidden" name="id" value="${cart.product.id}"/>
                                <input class="btn btn-warning" type="submit" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <form action="check-out" method="POST">
                <input type="submit" value="Check out" class="btn btn-info">
            </form>
        </div>
    </body>
</html>
