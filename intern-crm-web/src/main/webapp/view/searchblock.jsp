<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer</h2>
    </div>
    <form class="" action="/search-block" method="post">
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
        <c:when test="${itemsBlock.size()==0}">
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
                        <th>Status</th>
                        <th>Product Type</th>
                        <th>Company</th>
                    </tr>
                    </thead>
                    <tbody id="listCus-body">
                    <c:forEach var="c" items="${itemsBlock}">
                        <tr>
                            <td id="name">${c.name}</td>
                            <td id="age">${c.age}</td>
                            <td id="phone">${c.phone}</td>
                            <td id="seller-name">${c.userBySeller.sellerDetailByUserName.name}</td>
                            <td id="status-name">${c.statusByStatusId.name}</td>
                            <td id="product-type">
                                <c:choose>
                                    <c:when test="${c.productType == 1}">
                                        Off Source
                                    </c:when>
                                    <c:otherwise>
                                        ODC
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
