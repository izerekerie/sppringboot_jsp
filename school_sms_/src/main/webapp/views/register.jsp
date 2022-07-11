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
<div class="container d-flex justify-content-center">

<form class="container col-md-6 m-4" action="/register" method="post">
    <p class="h4 font-bold text-center">Register</p>
    <input class="form-control col-12  my-2" type="text" name="names" placeholder="Enter names ">
    <input class="form-control my-2 col-12" type="text" name="email" placeholder="Enter email ">
    <input  class="form-control my-2 col-12" type="password" name="password" placeholder="Enter password " >
    <button class="btn btn-primary my-2 col-12" type="submit">save</button>
    <p class="text-center">Already have account ? Register <span onclick="window.location.href='/login'" class="text-primary">here</span></p>

</form>
</div>
</body>
</html>