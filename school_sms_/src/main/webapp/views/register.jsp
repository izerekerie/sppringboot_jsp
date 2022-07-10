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
<form class="container m-4" action="/register" method="post">
    <input class="form-control my-2" type="text" name="names" placeholder="Enter names ">
    <input class="form-control my-2" type="text" name="email" placeholder="Enter email ">
    <input  class="form-control my-2" type="password" name="password" placeholder="Enter password " >
    <button class="btn btn-primary my-2" type="submit">save</button>
    <p>Already have account ? Register <span onclick="window.location.href='/login'" class="text-primary">here</span></p>

</form>

</body>
</html>