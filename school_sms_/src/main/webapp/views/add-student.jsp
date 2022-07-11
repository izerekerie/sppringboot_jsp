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
<div class="container p-6" >

    <div class="container d-flex justify-content-center">

<form action="/students/create" method="post">
    <p class="h4 font-bold text-center text-primary">Add student</p>
<input class="form-control my-2  " type="text" name="firstname" placeholder="Enter firstName"/>
<input class="form-control my-2 "  type="text" name="lastname" placeholder="Enter lastName"/>
<input class="form-control my-2 "  type="text" name="year" placeholder="Enter class year"/>
<input class="form-control my-2 "  type="number" name="age" placeholder="Enter age"/>
 <button class="btn btn-primary my-2">save</button>
</form>
    </div>
</div>
</body>
</html>