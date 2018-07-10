<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer block</h2>
    </div>
    <form class="" action="${pageContext.request.contextPath}/search-block" method="post">
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
    <c:when test="${itemsBlock.totalElements ==0}">
    <p class="text-danger text-center">Không có k?t qu? tìm ki?m</p>
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
                        <th>Product type</th>
                        <th>Company</th>
                    </tr>
                    </thead>
                    <tbody id="listCus-body">
                    <c:forEach var="c" items="${itemsBlock.content}">
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
                    <%------------------------------------------------------------
                    <%--------------------Pagination for table --------------------&ndash;%&gt;--%>

                <div class="nav-pagination">
                    <nav aria-label="pagination">
                        <ul class="pagination">
                            <li class="page-item ${itemsBlock.hasPreviousPage()==true?"":"disabled"}"
                                data-page="${itemsBlock.number}" onclick="redirectPage(this)">
                                <p class="page-link">Previous</p>
                            </li>
                            <c:forEach var="page" begin="1" end="${itemsBlock.totalPages}">
                                <c:choose>
                                    <c:when test="${itemsBlock.number+1 == page}">
                                        <li class="page-item active" data-page="-1" onclick="redirectPage(this)">
                                            <p class="page-link" >${page} <span class="sr-only">(current)</span></p>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item" data-page="${page}" onclick="redirectPage(this)">
                                            <p class="page-link">${page}</p>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                                </li>
                            </c:forEach>
                            <li class="page-item ${itemsBlock.hasNextPage()?"":"disabled"}"
                                data-page="${itemsBlock.number+2}" onclick="${itemsBlock.hasNextPage()?"redirectPage(this)":""}" >
                                <p class="page-link">Next</p>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
    </c:otherwise>
    </c:choose>
</div>
<div id="result" style="clear: both"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/customerFilters.js"></script>
