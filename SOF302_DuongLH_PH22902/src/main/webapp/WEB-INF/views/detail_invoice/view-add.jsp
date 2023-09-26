<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<main class="container">

    <form:form action="/detail-invoice/add" method="post" modelAttribute="detailInvoice">

        <div class="form-group row">
            <div class="col-sm-4"> </div>
            <form:label path="idDetailedInvoice.invoice" class="col-sm-2 col-form-label"> Hoá đơn: </form:label>
            <div class="col-sm-4">
                <select name="idDetailedInvoice.invoice" ${detailInvoice.idDetailedInvoice.invoice} class="form-control">
                    <c:forEach items="${listInvoice}" var="invoice">
                        <option value="${invoice.id}">${invoice.code}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="col-sm-4"></div>
        </div>

        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="idDetailedInvoice.productDetails" class="col-sm-2 col-form-label"> sản phẩm: </form:label>
            <div class="col-sm-4">
                <select name="idDetailedInvoice.productDetails" ${detailInvoice.idDetailedInvoice.productDetails} class="form-control">
                    <c:forEach items="${listProductDetails}" var="productDetails">
                        <option value="${productDetails.id}">${productDetails.product.name}</option>
                    </c:forEach>
                </select>
                    ${productDetails.product.name}
            </div>
            <div class="col-sm-4"></div>
        </div>
        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="quantity" class="col-sm-2 col-form-label">Số lượng:</form:label>
            <div class="col-sm-4">
                <input type="text" name="quantity" value="${detailInvoice.quantity}" class="form-control"
                       placeholder="Nhập Số Lượng"/>
            </div>
            <div class="col-sm-4"></div>
        </div>

        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="unitPrice" class="col-sm-2 col-form-label">đơn giá:</form:label>
            <div class="col-sm-4">
                <input type="text" name="unitPrice" value="${detailInvoice.unitPrice}" class="form-control"
                       placeholder="Nhập Đơn Giá"/>
            </div>
            <div class="col-sm-4"></div>
        </div>
        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>

            <div class="col-sm-4">
                <form:button class="btn btn-success" onsubmit="add()" type="submit">Đặt hàng</form:button>

            </div>
            <div class="col-sm-4"></div>
        </div>

    </form:form>


</main>

<script>
    function add() {
        if (!confirm('Bạn có muốn thêm?')) {
            return false
        } else {
            alert('Thêm thành công');
        }
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>
