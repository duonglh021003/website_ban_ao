<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/staff/view-add" style="margin-left: 210px">
    <button type="submit" class="btn btn-default" style="border: 1px solid darkgray">Thêm mới</button>
</form>

<main>
    <section>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">mã</th>
                    <th scope="col">tên</th>
                    <th scope="col">giới tính</th>
                    <th scope="col">ngày sinh</th>
                    <th scope="col">địa chỉ</th>
                    <th scope="col">status</th>
                    <th scope="col">chức vụ</th>
                    <th scope="col">cửa hàng</th>
                    <th scope="col">action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listStaff.content }" var="staff" varStatus="stt">
                    <tr>
                        <td>${stt.index+1}</td>
                        <td>${staff.code}</td>
                        <td>${staff.surname} ${staff.middleName} ${staff.name}</td>
                        <td>${staff.gender == true ? "nam" : "nữ"}</td>
                        <td>${staff.dateOfBirth}</td>
                        <td>${staff.address}</td>
                        <td>${staff.status == 0 ? "đang hoạt động" : "ngừng hoạt động"}</td>
                        <td>${staff.position.name}</td>
                        <td>${staff.shop.name}</td>

                        <td>
                            <a class="btn btn-default" href="/staff/detail?id=${staff.id}">detail</a>
                            <a class="btn btn-default" href="/staff/view-update?id=${staff.id}">update</a>
<%--                            <a class="btn btn-default" href="/staff/delete?id=${staff.id}"--%>
<%--                               onclick="if(!confirm('Bạn có muốn xoá?')){return false}else{alert('xoá thành công');}" >delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation example" style="margin-left: 500px">
                <ul class="pagination" >
                    <c:forEach begin="0" end="${ listStaff.totalPages -1}" varStatus="loop" >
                        <li class="page-item"  >
                            <a class="page-link" href="/staff/index?page=${loop.begin + loop.count - 1}" >
                                    ${loop.begin + loop.count }
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </section>
</main>


</body>
</html>
