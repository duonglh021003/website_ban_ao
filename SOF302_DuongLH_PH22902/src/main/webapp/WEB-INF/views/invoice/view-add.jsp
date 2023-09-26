<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<main class="container">

    <form:form action="/invoice/add" method="post" modelAttribute="invoice">

        <div class="form-group row">
            <div class="col-sm-4"> </div>
            <form:label path="code" class="col-sm-2 col-form-label"> mã hoá đơn: </form:label>
            <div class="col-sm-4">
                <input type="text" name="code" value="${invoice.code}" class="form-control"
                       placeholder="Nhập Mã"/>
            </div>
            <div class="col-sm-4"></div>
        </div>

        <br>

        <div class="form-group row">
            <div class="col-sm-4"> </div>
            <form:label path="staff" class="col-sm-2 col-form-label"> Ten Nhan Vien: </form:label>
            <div class="col-sm-4">
                <select name="staff" ${invoice.staff} class="form-control">
                    <c:forEach items="${listStaff}" var="staff">
                        <option value="${staff.id}">${staff.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-4"></div>
        </div>

        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="client" class="col-sm-2 col-form-label"> Ten Khach Hang: </form:label>
            <div class="col-sm-4">
                <select name="client" ${invoice.client} class="form-control">
                    <c:forEach items="${listClient}" var="client">
                        <option value="${client.id}">${client.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-4"></div>
        </div>
        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="recipient" class="col-sm-2 col-form-label">Ten Nguoi Nhan:</form:label>
            <div class="col-sm-4">
                <input type="text" name="recipient" value="${invoice.recipient}" class="form-control"
                       placeholder="Nhập Tên Người Nhận"/>
            </div>
            <div class="col-sm-4"></div>
        </div>

        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="dateCreated" class="col-sm-2 col-form-label">Ngày tạo:</form:label>
            <div class="col-sm-4">
                <input type="date" name="dateCreated" value="${invoice.dateCreated}" class="form-control"
                       placeholder="Nhập ngày tạo"/>
            </div>
            <div class="col-sm-4"></div>
        </div>

        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="invoiceAddress" class="col-sm-2 col-form-label">Dia Chi:</form:label>
            <div class="col-sm-4">
                <input type="text" name="invoiceAddress" value="${invoice.invoiceAddress}" class="form-control"
                       placeholder="Nhập địa chỉ"/>
            </div>
            <div class="col-sm-4"></div>
        </div>
        <br>

        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="phoneNumber" class="col-sm-2 col-form-label">SDT:</form:label>
            <div class="col-sm-4">
                <input type="text" name="phoneNumber" value="${invoice.phoneNumber}" class="form-control"
                       placeholder="Nhập số điện thoại"/>
            </div>
            <div class="col-sm-4"></div>
        </div>
        <br>
        <div class="form-group row">
            <div class="col-sm-4"></div>
            <form:label path="status" class="col-sm-2 col-form-label">trạng thái:</form:label>
            <div class="col-sm-4">
                <input type="radio" name="status" value="0" ${staff.status == "0" ? "checked" : ""} checked=""/>đã thanh toán
                <input type="radio" name="status" value="1" ${staff.status == "1" ? "checked" : ""}/>chưa thanh toán

            </div>
            <div class="col-sm-4"></div>
        </div>
        <br>
        <div class="form-group row">
            <div class="col-sm-4"></div>

            <div class="col-sm-4">
                <form:button class="btn btn-default" type="reset">Lam Moi</form:button>
                <form:button class="btn btn-default" onsubmit="add()" type="submit">Tạo Hoa Don</form:button>

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
