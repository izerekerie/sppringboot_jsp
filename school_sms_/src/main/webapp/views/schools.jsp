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

    <div class="navbar navbar-expand-lg text-light navbar-dark bg-primary">
      <div class="container">
          <a class="navbar-brand">
              <p>SMS</p>
          </a>
          <div class="collapse navbar-collapse">
              <ul class="navbar-nav ms-auto">
                  <li class="nav-item">
                      <a href="#" class="nav-link active link-light">Home</a>
                  </li>
                  <li class="nav-item">
                      <a href="#" class="nav-link active link-light">Schools</a>
                  </li>
                  <li class="nav-item">
                      <a href="#" class="nav-link active link-light">Students</a>
                  </li>

              </ul>
          </div>
      </div>
    </div>
    <div class="container">
        <div class="container">
            <button class="btn btn-primary" onclick="window.location.href='/schools/add-page'">Add student</button>
        </div>
    <div class=" mt-5">
        <div class="row g-4">
            <c:forEach items="${schools}" var="school">
                <div  class="col-4">
                    <div class=" card shadow  " style="width: 500px" >
                        <div class="card-body bg-dark text-light">
                            <div class="">
                                <p>name: ${school.name}</p>
                                <div class="mt-5">address: ${school.address}</div>
                                <p> id :${school.id}</p>
                                <div>
                                    <button class="btn btn-primary" onclick="">View</button>
                                    <input class="btn btn-warning" type="button" value="Update" name="${school.id}" onclick="window.location.href='/schools/edit-page?id=${school.id}'"/>
                                    <input type="button" name="${school.id}" class="btn btn-danger"  value="Delete" onclick="window.location.href='/schools/delete?id=${school.id}'"/>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>

    </div>

</div>

</body>
</html>