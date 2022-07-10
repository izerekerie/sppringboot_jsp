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
<div class='navbar navbar-expand-lg  text-light navbar-dark bg-primary' >

    <div class="container">
        <a  href="/" class="navbar-brand">
            <p class='text-light'> T-WEB</p>
        </a>
        <button class="navbar-toggler"
                type='button'
                data-bs-toggle="collapse"
                data-bs-target="#navbarContent"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class='collapse navbar-collapse' id="navbarContent">
            <ul class='navbar-nav ms-auto'>

                <li class="nav-item">
                    <a href="/" class="nav-link active link-light">Home</a>
                </li>
                <li class="nav-item">
                    <a href="/students" class="nav-link link-light">Students</a>
                </li>
                <li class="nav-item">
                    <a href="/schools" class="nav-link link-light">schools</a>
                </li>
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link  link-light dropdown-toggle" id="sublinks" role="button" data-bs-toggle="dropdown">dropdown link</a>
                    <ul class='dropdown-menu' aria-labelledby="navbarDropdownMenuLink">
                        <li class='dropdown-item '> <a class='link' href="#">item1</a></li>
                        <li class='dropdown-item'> <a class='link' href="#">item1</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a href="#"  onclick="window.location.href='/logout'" class="nav-link link-primary text-primary bg-white p-2 rounded">Logout</a>
                </li>
            </ul>
        </div>

    </div>



</div>
</body>
</html>