<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer</h2>
    </div>
    <form class="" action="/search" method="post">
        <div class="row  mx-5 mb-3">

            <div class="col-3">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <label class="input-group-text">Options</label>
                    </div>
                    <select class="custom-select" name="thongtin">

                        <option value="Name">Name</option>
                        <option value="Mail">Mail</option>
                        <option value="Company">Company</option>
                        <option value="SellerName">Seller</option>
                    </select>
                </div>
            </div>
            <div class="col-4">
                <div class="input-group">

                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                    <input class="form-control" name="search" type="text" value="${key}" placeholder="Search">
                    <button class="btn btn-success " type="submit">Search</button>

                </div>
            </div>

        </div>
    </form>
    <c:choose>
    <c:when test="${list.size()==0}">
        <p class="text-danger text-center">Không có kết quả tìm kiếm</p>
    </c:when>
    <c:otherwise>

    <div class="table-seller mx-5">
        <table class="table table-hover" id="table-customers">
            <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Seller Name</th>
                <th>
                    <select id="select-filters-status" onchange="listCusByFilters()">
                        <option selected value="0">Status</option>
                        <option value="1">Prospect</option>
                        <option value="2">Lead</option>
                        <option value="3">Potential</option>
                        <option value="4">Active</option>
                        <option value="5">Block</option>
                    </select>
                </th>
                <th>
                    <select id="select-filters-product" onchange="listCusByFilters()">
                        <option selected value="0">Product Type</option>
                        <option value="1">Out Source</option>
                        <option value="2">ODD</option>
                    </select>
                </th>
                <th>Company</th>
            </tr>
            </thead>
            <tbody id="listCus-body">
            <c:forEach var="c" items="${list}">
            <tr>
                <td id="name">${c.name}</td>
                <td id="age">${c.age}</td>
                <td id="phone">${c.phone}</td>
                <td id="seller-name">${c.userBySeller.sellerDetailByUserName.name}</td>
                <td id="status-name">${c.statusByStatusId.name}</td>
                <td id="product-type">
                    <c:choose>
                        <c:when test="${c.productType == 1}">
                            Out Source
                        </c:when>
                        <c:otherwise>
                            ODD
                        </c:otherwise>
                    </c:choose>
                </td>
                <td id="company">${c.company}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    </c:otherwise>
    </c:choose>
</div>
</div>
<div id="result"></div>

<script type="text/javascript" src="/resource/scripts/customerFilters.js"></script>
