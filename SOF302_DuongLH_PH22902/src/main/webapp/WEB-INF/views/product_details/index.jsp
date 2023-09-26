<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/product-details/view-add" style="margin-left: 210px">
    <button type="submit" class="btn btn-default" style="border: 1px solid darkgray">Thêm mới</button>
</form>

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
                    <th scope="col">năm bảo hành</th>
                    <th scope="col">mô tả</th>
                    <th scope="col">số lượng</th>
                    <th scope="col">giá nhập</th>
                    <th scope="col">giá bán</th>
                    <th scope="col">action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listProductDetails.content }" var="productDetails" varStatus="stt">
                    <tr>
                        <td>${stt.index+1}</td>
                        <td>${productDetails.product.name}</td>
                        <td>${productDetails.producer.name}</td>
                        <td>${productDetails.color.name}</td>
                        <td>${productDetails.productLine.name}</td>
                        <td>${productDetails.year}</td>
                        <td>${productDetails.describe}</td>
                        <td>${productDetails.inventory}</td>
                        <td>${productDetails.importPrice}</td>
                        <td>${productDetails.price}</td>

                        <td>
                            <a class="btn btn-default" href="/product-details/detail?id=${productDetails.id}">detail</a>
                            <a class="btn btn-default" href="/product-details/view-update?id=${productDetails.id}">update</a>
<%--                            <a class="btn btn-default" href="/product-details/delete?id=${productDetails.id}"--%>
<%--                               onclick="if(!confirm('Bạn có muốn xoá?')){return false}else{alert('xoá thành công');}" >delete</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation example" style="margin-left: 500px">
                <ul class="pagination" >
                    <c:forEach begin="0" end="${ listProductDetails.totalPages -1}" varStatus="loop" >
                        <li class="page-item"  >
                            <a class="page-link" href="/product-details/index?page=${loop.begin + loop.count - 1}" >
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
