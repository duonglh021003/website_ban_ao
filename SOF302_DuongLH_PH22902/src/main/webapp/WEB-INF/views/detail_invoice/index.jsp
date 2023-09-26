<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; margin-bottom: 50px">Hoá đơn chi tiết</h1>

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
                    <th scope="col">mã hoá đơn</th>
                    <th scope="col">tên sản phẩm</th>
                    <th scope="col">số lượng</th>
                    <th scope="col">đơn giá</th>
                    <th scope="col">thành tiền</th>
                    <th scope="col">ngày tạo</th>
                    <th scope="col">trạng thái</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listDetailInvoice }" var="detailInvoice" varStatus="stt">
                    <tr>
                        <td>${stt.index+1}</td>
                        <td>${detailInvoice.idDetailedInvoice.invoice.code}</td>
                        <td>${detailInvoice.idDetailedInvoice.productDetails.product.name}</td>
                        <td>${detailInvoice.quantity}</td>
                        <td>${detailInvoice.unitPrice}</td>
                        <td>${detailInvoice.totalMoney()} <strong style="color: red">VNĐ</strong></td>
                        <td>${detailInvoice.idDetailedInvoice.invoice.dateCreated}</td>
                        <td>${detailInvoice.idDetailedInvoice.invoice.status == 0 ? "đã thanh toán" : "chưa thanh toán"}</td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</main>


</body>
</html>
