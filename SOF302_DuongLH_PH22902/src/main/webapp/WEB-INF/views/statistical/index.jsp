<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<main>
    <section>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Ngày</th>
                    <th scope="col">Tháng</th>
                    <th scope="col">Năm</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ listStatistical }" var="statistical"  >
                    <tr>
                        <td>${statistical.salesCount}</td>
                        <td>${salesThisYear}</td>
                        <td>${statistical.salesToday}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </section>
</main>


</body>
</html>
