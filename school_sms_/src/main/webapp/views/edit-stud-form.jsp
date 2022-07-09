<jsp:include page="../components/header.jsp"/>

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
<p>add new student</p>
<form action="/students/edit?id=${student.id}" method="post">
    <input type="text" name="firstname" value="${student.firstname}" placeholder="Enter firstName"/>
    <input type="text" name="lastname" value="${student.lastname}" placeholder="Enter lastName"/>
    <input type="text" name="year" value="${student.year}" placeholder="Enter class year"/>
    <input type="number" name="age" value="${student.age}" placeholder="Enter age"/>
    <button class="btn btn-primary">save</button>
</form>
</body>
</html>