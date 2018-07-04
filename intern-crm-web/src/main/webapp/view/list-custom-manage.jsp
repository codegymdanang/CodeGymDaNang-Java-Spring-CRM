<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer</h2>
    </div>
    <div class="row  mx-5 mb-3">
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
        <div class="col-4">
            <div class="input-group">
                <form class="form-inline d-inline form-search float-right ">
                    <input class="form-control" type="text" placeholder="Search">
                    <button class="btn btn-success " type="submit">Search</button>
                </form>
            </div>
        </div>
    </div>
    <div class="table-seller mx-5">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Seller Name</th>
                <th>Status</th>
                <th>Product</th>
                <th>Company</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${list}">
            <tr>
                <td>${c.name}</td>
                <td>${c.age}</td>
                <td>${c.phone}</td>
                <td>${c.userBySeller.userName}</td>
                <td>${c.statusByStatusId.name}</td>
                <c:choose>
                    <c:when test="${c.productType=='1'}">
                        <td>Off source</td>
                    </c:when>
                    <c:otherwise>
                         <td>Odc</td>
                    </c:otherwise>
                </c:choose>
                <td>${c.company}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>