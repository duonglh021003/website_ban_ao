<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form:form action="/staff/add" method="POST" modelAttribute="staff">


    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">mã</label>
                <form:input path="code" class="form-control"/>
                <form:errors path="code" cssClass="errors"/><br>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">họ</label>
                <form:input path="surname" class="form-control"/>
                <form:errors path="surname"  cssClass="errors"/><br>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">tên đệm</label>
                <form:input path="middleName" class="form-control"/>
                <form:errors path="middleName"  cssClass="errors"/><br>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">tên</label>
                <form:input path="name" class="form-control"/>
                <form:errors path="name"  cssClass="errors"/><br>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">ngày sinh</label> <br>
                <input type="date" name="dateOfBirth" value="${staff.dateOfBirth}" />
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">địa chỉ</label>
                <form:input path="address" class="form-control"/>
                <form:errors path="address"  cssClass="errors"/><br>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">số điện thoại</label>
                <form:input path="phoneNumber" class="form-control"/>
                <form:errors path="phoneNumber"  cssClass="errors"/><br>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">password</label>
                <form:input path="password" class="form-control"/>
                <form:errors path="password"  cssClass="errors"/><br>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">giới tính</label>
                <input type="radio" name="gender" value="true" ${staff.gender == "true" ? "checked" : ""} checked=""/>nam
                <input type="radio" name="gender" value="false" ${staff.gender == "false" ? "checked" : ""}/>nữ
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">trạng thái</label>
                <input type="radio" name="status" value="0" ${staff.status == "0" ? "checked" : ""} checked=""/>đang
                hoạt động
                <input type="radio" name="status" value="1" ${staff.status == "1" ? "checked" : ""}/>ngừng hoạt dộng
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>


    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">chức vụ</label>
                <select name="position" ${staff.position.name}>
                    <c:forEach items="${listPosition}" var="position">
                        <option value="${position.id}">${position.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-3">
            <div class="mb-3">
                <label class="form-label">cửa hàng</label>
                <select name="shop" ${staff.shop.name}>
                    <c:forEach items="${listShop}" var="shop">
                        <option value="${shop.id}">${shop.name}</option>
                    </c:forEach>
                </select>
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
    function add(){
        if(!confirm('Bạn có muốn thêm?')){
            return false
        }else{
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
