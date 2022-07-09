<jsp:include page="../components/header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p>Edit school details</p>
<form action="/schools/edit?id=${school.id}" method="post">
    <div class="container">
      <input type="text" name="name" value="${school.name}"/>
        <input type="text" name="address" value="${school.address}"/>
        <button>Edit</button>
    </div>
</form>

</body>
</html>