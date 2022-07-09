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
<form class="container" action="/schools/create" method="post">
    <input class="form-control" type="text" name="name" placeholder="Enter school name">
    <input type="text" name="address" placeholder="Enter school name" >
    <button type="submit">save</button>
</form>

</body>
</html>