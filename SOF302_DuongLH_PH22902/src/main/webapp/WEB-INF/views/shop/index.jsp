<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/shop/view-add" style="margin-left: 210px">
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
                    <th scope="col">địa chỉ</th>
                    <th scope="col">thành phố</th>
                    <th scope="col">quốc gia</th>
                    <th scope="col">action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listShop.content }" var="shop" varStatus="stt">
                    <tr>
                        <td>${stt.index+1}</td>
                        <td>${shop.code}</td>
                        <td>${shop.name}</td>
                        <td>${shop.address}</td>
                        <td>${shop.city}</td>
                        <td>${shop.nation}</td>
                        <td>
                            <a class="btn btn-default" href="/shop/detail?id=${shop.id}">detail</a>
                            <a class="btn btn-default" href="/shop/view-update?id=${shop.id}">update</a>
                            <a class="btn btn-default" href="/shop/delete?id=${shop.id}"
                               onclick="if(!confirm('Bạn có muốn xoá?')){return false}else{alert('xoá thành công');}" >delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation example" style="margin-left: 500px">
                <ul class="pagination" >
                    <c:forEach begin="0" end="${ listShop.totalPages -1}" varStatus="loop" >
                        <li class="page-item"  >
                            <a class="page-link" href="/shop/index?page=${loop.begin + loop.count - 1}" >
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
