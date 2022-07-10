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
<div class="row align-items-center justify-content-center">
<form class="container justify-content-center m-4" action="/login" method="post">
    <div class="col-md-6 col-12">
        <input class="form-control  my-2" type="text" name="email" placeholder="Enter email ">
    </div>
  <div class="col-md-6 col-12">
      <input  class="form-control col-md-6 my-2" type="password" name="password" placeholder="Enter password " >
  </div>


    <button class="btn  btn-primary col-md-6 my-2 col-12" type="submit">save</button>
    <p class="text-center">Have no account yet ? Login <span onclick="window.location.href='/register'" class="text-primary">here</span></p>
</form>

</div>
</body>
</html>