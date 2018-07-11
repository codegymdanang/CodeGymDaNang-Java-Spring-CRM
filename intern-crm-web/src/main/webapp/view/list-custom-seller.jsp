<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer</h2>
    </div>
    <form class="" action="${pageContext.request.contextPath}/seller/searchSeller" method="post">
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

                </select>
            </div>
        </div>
        <div class="col-4">
            <div class="input-group">

                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                    <input class="form-control" name="search" value="${key}" type="text" placeholder="Search">
                    <button class="btn btn-success " type="submit">Search</button>

            </div>
        </div>

    </div>
    </form>

    <!-- Add and Search -->


    <c:url var="addCustomerURL" value="${pageContext.request.contextPath}/seller/addcustomer"/>
    <div class="parent">
            <a href="${addCustomerURL}" class="btn btn-success mx-5 my-3" >
                <i class="fa fa-plus-circle"></i> Add Customer</a>


    </div>
    <!-- Table list seller -->
    <c:choose>
    <c:when test="${customers.totalElements ==0}">
        <p class="text-danger text-center">Không có kết quả tìm kiếm</p>
    </c:when>
    <c:otherwise>

    <div class="table-seller mx-5">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Work Place</th>
                <th>Phone</th>
                <th>Status</th>
                <th>Create date</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${customers.content}" var="c">
                <c:url var="upDateLink" value="/seller/advisory">
                    <c:param name="customer" value="${c.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/seller/delete">
                    <c:param name="customer" value="${c.id}"/>
                </c:url>
            <tr>
                <td>${c.name}</td>
                <td>${c.company}</td>
                <td>${c.phone}</td>
                <td>${c.statusByStatusId.name}</td>
                <td>${map.get(c).getDate()}</td>
                <td><a href="${upDateLink}" class="btn btn-info">UpDate Status</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/seller/editcustomer/${c.id}"><button class="btn btn-info btn btn-primary" value="">EDIT</button></a>
                </td>
                <td><a href="${deleteLink}"
                       onclick="if (!confirm('Are you sure??')) return false" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <%--paging--%>
        <div class="nav-pagination">
            <nav aria-label="pagination">
                <ul class="pagination">
                    <li class="page-item ${customers.hasPreviousPage()==true?"":"disabled"}"
                        data-page="${customers.number}" onclick="customerForSellerPage(this)">
                        <p class="page-link">Previous</p>
                    </li>
                    <c:forEach var="page" begin="1" end="${customers.totalPages}">
                        <c:choose>
                            <c:when test="${customers.number+1 == page}">
                                <li class="page-item active" data-page="-1" onclick="customerForSellerPage(this)">
                                    <p class="page-link" >${page} <span class="sr-only">(current)</span></p>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item" data-page="${page}" onclick="customerForSellerPage(this)">
                                    <p class="page-link">${page}</p>
                                </li>
                            </c:otherwise>
                        </c:choose>
                        </li>
                    </c:forEach>
                    <li class="page-item ${customers.hasNextPage()?"":"disabled"}"
                        data-page="${customers.number+2}" onclick="${customers.hasNextPage()?"customerForSellerPage(this)":""}" >
                        <p class="page-link">Next</p>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    </div>
    </c:otherwise>
    </c:choose>
