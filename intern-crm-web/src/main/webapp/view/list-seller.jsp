<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>

    <!-- Body Seller Manager -->
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">Seller Manager</h2>
    </div>


    <!-- Table list seller -->

    <div class="table-seller mx-5">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Status</th>
                <th>Username</th>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Phone</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sellerDetails}" var="sellerDetail">

                        <tr>
                        <c:choose>
                            <c:when test="${sellerDetail.userByUserName.isDelete==0}">
                            <td><i class="fa fa-circle text-success"></i></td>
                            </c:when>
                            <c:otherwise>
                             <td><i class="fa fa-circle text-danger"></i></td>
                            </c:otherwise>
                        </c:choose>
                            <td>${sellerDetail.userName}</td>
                            <td>${sellerDetail.name}</td>
                            <td>${sellerDetail.age}</td>
                            <td>${sellerDetail.mail}</td>
                            <td>${sellerDetail.phone}</td>
                            <td><button class="btn btn-danger">DELETE</button></td>
                        </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>




</div>