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
<div>

    <div class="container text-center">
        <div class="row">
            <div class="col-2 col-sm-3">
                <form action="/invoice/view-add" style="margin-left: 1035px">
                    <button type="submit" class="btn btn-default" style="border: 1px solid darkgray">Tạo hoá đơn
                    </button>
                </form>
            </div>
            <div class="col-6 col-sm-3">
                <form action="/product-details/view-add" style="margin-left: 600px">
                    <button type="submit" class="btn btn-default" style="border: 1px solid darkgray">Tạo giỏ hàng
                    </button>
                </form>
            </div>

        </div>
    </div>


</div>

<main>
    <section>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">sản phẩm</th>
                    <th scope="col">nhà sản xuất</th>
                    <th scope="col">màu sắc</th>
                    <th scope="col">dòng sp</th>
                    <th scope="col">giá bán</th>
                    <th scope="col">số lượng</th>
                    <th scope="col">action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listProductDetails}" var="productDetails" varStatus="stt">
                    <tr>
                        <td>${stt.index+1}</td>
                        <td>${productDetails.product.name}</td>
                        <td>${productDetails.producer.name}</td>
                        <td>${productDetails.color.name}</td>
                        <td>${productDetails.productLine.name}</td>
                        <td>${productDetails.price}</td>
                            <%--                        <td>--%>
                            <%--                            <c:forEach items="${ listInvoice}" var="invoid" >--%>
                            <%--                                ${invoid.quantity}--%>
                            <%--                            </c:forEach>--%>
                            <%--                        </td>--%>
                        <td>
                            <input type="number" style="width: 50px" name="quantity">
                        </td>
                        <td>

                            <button onclick="handleClick('${productDetails.id}')" class="btn btn-default" type="button"
                                    data-toggle="modal" data-target="#myModal"
                                    style="border: 1px solid darkgray">
                                xem chi tiết
                            </button>

                            <a class="btn btn-default" href="/product-details/delete?id=${productDetails.id}"
                               onclick="if(!confirm('Bạn có muốn xoá?')){return false}else{alert('xoá thành công');}">delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</main>
<div class="container">

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <form:form modelAttribute="productDetails">

                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">sản phẩm</label>
                                <select name="position" ${productDetails.product.name}>
                                    <option> ${productDetails.product.name}</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">nhà sản xuất</label>
                                <select name="position" ${productDetails.producer.name}>
                                    <option> ${productDetails.producer.name}</option>
                                </select><br>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">màu sắc</label>
                                <select name="position" ${productDetails.color.name}>
                                    <option> ${productDetails.color.name}</option>
                                </select><br>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">dòng sản phẩm</label>
                                <select name="position" ${productDetails.productLine.name}>
                                    <option> ${productDetails.productLine.name}</option>
                                </select><br>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">năm bảo hành</label> <br>
                                <form:input path="year" class="form-control"/>
                                <form:errors path="year" cssClass="errors"/><br>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">mô tả</label>
                                <form:input path="describe" class="form-control"/>
                                <form:errors path="describe" cssClass="errors"/><br>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">số lượng tồn</label> <br>
                                <form:input path="inventory" class="form-control"/>
                                <form:errors path="inventory" cssClass="errors"/><br>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="mb-3">
                                <label class="form-label">giá nhập</label>
                                <form:input path="importPrice" class="form-control"/>
                                <form:errors path="importPrice" cssClass="errors"/><br>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label class="form-label">giá bán</label> <br>
                                <form:input path="price" class="form-control"/>
                                <form:errors path="price" cssClass="errors"/><br>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                </form:form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>

<%--<script>--%>
<%--    function handleClick(productDetails) {--%>
<%--        // Xử lý hành động khi nút được nhấp--%>
<%--        alert("id: " + productDetails);--%>

<%--        <% HomeController.myJavaMethod("productDetails-------------"); %>--%>
<%--    }--%>
<%--</script>--%>


</body>
</html>
