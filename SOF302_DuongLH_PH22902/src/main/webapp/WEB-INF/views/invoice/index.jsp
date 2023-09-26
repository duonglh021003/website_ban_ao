<%@ page import="com.example.demo.asm.controller.HomeController" %>
<%@ page import="com.example.demo.asm.entity.ProductDetails" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="row">
    <div class="col-md-6">
        <form:form modelAttribute="productDetails">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="mb-3">
                        <label class="form-label">sản phẩm: </label>
                        <input class="form-control" value=" ${productDetails.product.name}">
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="mb-3">
                        <label class="form-label">giá bán: </label>
                        <form:input path="price" class="form-control"/>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </form:form>

        <form:form modelAttribute="detailInvoice">

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="mb-3">
                        <label class="form-label">tổng tiền: </label>
                        <c:forEach items="${ listDetailInvoice}" var="detailInvoice" varStatus="stt">
                            ${detailInvoice.totalMoney()}
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>

        </form:form>

    </div>
    <div class="col-md-6">

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label class="form-label">Hoá Đơn</label>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>

        <form:form modelAttribute="client">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="mb-3">
                        <label class="form-label">Nhập số điện thoại</label>
                        <form action="/student/view-update" style="text-align: center">
                            id: <input name="id"/>
                            <button type="submit">update</button>
                            <br>
                            <small class="thongbao"> ${byId} </small>

                        </form>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </form:form>


    </div>
</div>


</body>
</html>
