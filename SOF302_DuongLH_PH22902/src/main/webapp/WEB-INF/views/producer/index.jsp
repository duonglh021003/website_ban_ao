<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/producer/view-add" style="margin-left: 210px">
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
                    <th scope="col">action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listProducer.content }" var="producer" varStatus="stt">
                    <tr>
                        <td>${stt.index+1}</td>
                        <td>${producer.code}</td>
                        <td>${producer.name}</td>
                        <td>
                            <a class="btn btn-default" href="/producer/detail?id=${producer.id}">detail</a>
                            <a class="btn btn-default" href="/producer/view-update?id=${producer.id}">update</a>
                            <a class="btn btn-default" href="/producer/delete?id=${producer.id}"
                               onclick="if(!confirm('Bạn có muốn xoá?')){return false}else{alert('xoá thành công');}" >delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation example" style="margin-left: 500px">
                <ul class="pagination" >
                    <c:forEach begin="0" end="${ listProducer.totalPages -1}" varStatus="loop" >
                        <li class="page-item"  >
                            <a class="page-link" href="/producer/index?page=${loop.begin + loop.count - 1}" >
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
