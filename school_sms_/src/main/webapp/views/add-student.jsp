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
<p class="h3 text-primary text-bold text-center p-5 ">Add new student</p>
<form action="/students/create" method="post">

<input class="form-control my-2 col-md-6 col " type="text" name="firstname" placeholder="Enter firstName"/>
<input class="form-control my-2 col-md-6 col"  type="text" name="lastname" placeholder="Enter lastName"/>
<input class="form-control my-2 col-md-6 col"  type="text" name="year" placeholder="Enter class year"/>
<input class="form-control my-2 col-md-6 col"  type="number" name="age" placeholder="Enter age"/>
 <button class="btn btn-primary my-2">save</button>
</form>
</div>
</body>
</html>