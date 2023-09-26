<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form:form action="/product-details/add" method="POST" modelAttribute="productDetails">


    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">sản phẩm</label>
                <select name="product" >
                    <c:forEach items="${listProduct}" var="product">
                        <option value="${product.id}">${product.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">nhà sản xuất</label>
                <select name="producer">
                    <c:forEach items="${listProducer}" var="producer">
                        <option value="${producer.id}">${producer.name}</option>
                    </c:forEach>
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
                <select name="color">
                    <c:forEach items="${listColor}" var="color">
                        <option value="${color.id}">${color.name}</option>
                    </c:forEach>
                </select><br>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">dòng sản phẩm</label>
                <select name="productLine">
                    <c:forEach items="${listProductLine}" var="productLine">
                        <option value="${productLine.id}">${productLine.name}</option>
                    </c:forEach>
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

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="mb-3">
                <form:button type="submit" class="btn btn-primary" onclick="add()">Add</form:button>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>


</form:form>

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
