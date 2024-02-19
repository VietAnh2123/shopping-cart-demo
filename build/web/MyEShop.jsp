<%-- 
    Document   : MyEShop
    Created on : Jan 24, 2024, 6:45:08 PM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
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
            table{
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <div class="container bag">
            <a href="MyECart.jsp" class="cart-btn">
                <div class="btn btn-success mt-3">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5M3.102 4l1.313 7h8.17l1.313-7zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4m7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4m-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2m7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2"/>
                    </svg>
                    <label class="cart-label">My Cart</label><br>
                    <label class="cart-label">${sessionScope.size}</label>

                </div>
            </a>
        </div>
        <div class="container">
            <h1>The list of products</h1>
            <form name="f" action="add-to-cart" method="GET">
<!--                Enter the number of items to buy:-->
<!--                <input class="form-control input-width" type="number" name="num" value="1">-->
                <br><br>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>QUANTITY</th>
                        <th>Action</th>
                    </tr>
                    <jsp:useBean id="db" class="dal.ProductDAO"/>
                    <c:forEach items="${db.all}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.name}</td>
                            <td>${p.quantity}</td>
                            <td>
                                <a href="add-to-cart?id=${p.id}&quantity=1" class="btn btn-success" onclick="go()">Add to Cart</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </body>
    <script>
        function go(){
            document.f.submit();
        }
    </script>
</html>
