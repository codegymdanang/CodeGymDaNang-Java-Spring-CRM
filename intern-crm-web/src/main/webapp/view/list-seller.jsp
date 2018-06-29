<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>

    <!-- Body Seller Manager -->
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">Seller Manager</h2>
    </div>


    <!-- Filter -->
    <div class="row  mx-5 mb-3">
        <div class="col-3">
            <h4 class="text-muted">Filter</h4>
        </div>
        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Options</label>
                </div>
                <select class="custom-select" id="inputGroupSelect01">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect02">Options</label>
                </div>
                <select class="custom-select" id="inputGroupSelect02">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect03">Options</label>
                </div>
                <select class="custom-select" id="inputGroupSelect03">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
    </div>

    <!-- Add and Search -->
    <div class="parent">
        <a class="btn btn-success mx-5 my-3 " href="/manager_crm/create-seller-form">
            <i class="fa fa-plus-circle"></i> Create Seller</a>

        <form class="form-inline d-inline form-search mx-5 my-3 float-right ">
            <input class="form-control" type="text" placeholder="Search">
            <button class="btn btn-success " type="submit">Search</button>
        </form>
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
                            <td> <button class="btn btn-info">EDIT</button></td>
                            <td><button class="btn btn-danger">DELETE</button></td>
                        </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>




</div>