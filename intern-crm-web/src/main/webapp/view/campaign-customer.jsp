<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-04
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h5 class="h2 text-center font-weight-bold m-4 text-muted">Campain Customer Management</h5>
    <form class="form-inline d-inline form-search mx-5 my-3 float-right ">
        <input class="form-control" type="text" placeholder="Search">
        <button class="btn btn-success " type="submit">Search</button>
    </form>
        <div class="m-5">
            <p class="mb-2 text-danger text-center">${error}</p>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Phone</th>
                    <th>Mail</th>
                    <th>Facebook</th>
                    <th>Product type</th>
                    <th>Company</th>
                    <th>Moved</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customers}">
                <form action="/manager_crm/campaign-customer" method="post">
                    <input type="hidden" name="customerId" value="${customer.id}">
                    <tr>
                        <c:choose>
                            <c:when test="${customer.isMoved==0}">
                                <td><input type="submit" value="Move" class="btn btn-primary" /></td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                            </c:otherwise>
                        </c:choose>
                        <td>${customer.name}</td>
                        <td>${customer.age}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.mail}</td>
                        <td>${customer.facebook}</td>
                        <c:choose>
                            <c:when test="${customer.productType==1}">
                                <td>Outsourcing</td>
                            </c:when>
                            <c:otherwise>
                                <td>ODC</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${customer.company}</td>
                        <c:choose>
                            <c:when test="${customer.isMoved==0}">
                                <td><i class="fa fa-circle text-success"></i></td>
                            </c:when>
                            <c:otherwise>
                                <td><i class="fa fa-circle text-secondary"></i></td>
                            </c:otherwise>
                        </c:choose>
                        <td><select class="custom-select" name="seller">
                            <option selected value="">Choose...</option>
                            <c:forEach items="${sellers}" var="seller">
                                <option value="${seller.userName}">${seller.name}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                </form>
                </c:forEach>
                </tbody>
            </table>

        </div>

</div>
