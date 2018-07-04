

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Advisory customer</title>

</head>
<body>


<h2 class="text-center my-5 text-muted"> ADVISORY CUSTOMER <br/><span class="text-uppercase">${getItemCustomer.name} </span> </h2>

    <!-- Body Seller Manager -->
    <div class="row">
        <div class="col-5 pl-5">
            <h2 class="font-weight-light mb-3">Persional Informations</h2>

            <p>
                <span class="font-weight-bold">Name: </span> ${getItemCustomer.name}
            </p>
            <p>
                <span class="font-weight-bold">Facebook: </span> ${getItemCustomer.facebook}
            </p>
            <p>
                <span class="font-weight-bold">Age: </span> ${getItemCustomer.age}
            </p>
            <p>
                <span class="font-weight-bold">Company: </span> ${getItemCustomer.company}
            </p>
            <p>
                <span class="font-weight-bold">Mail: </span> ${getItemCustomer.mail}
            </p>
            <p>
                <span class="font-weight-bold">Phone: </span> 0${getItemCustomer.phone}
            </p>
            <p>
                <c:choose>
                    <c:when test="${getItemCustomer.productType=='1'}">
                        <span class="font-weight-bold">Product attending: </span> outsouting
                    </c:when>
                    <c:otherwise>
                        <span class="font-weight-bold">Product attending: </span> odc
                    </c:otherwise>
                </c:choose>

            </p>
        </div>
        <div class="col-7 pr-5">
            <h2 class="font-weight-light mb-3">History advisoried</h2>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Comment</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${historyAdvisories}">
                <tr>
                    <td>${c.date} </td>
                    <td>${c.statusByStatusId.name}</td>
                    <td>${c.comment} </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="mt-5">
<form:form action="saveHistoryAdvisory" modelAttribute="history" method="post">
    <form:hidden path="customerId"/>
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <div class="row text-center mb-4">
                <div class="col-3 pl-5">
                    <h4>Date</h4>
                    <form:input path="date" readonly="true"/>
                </div>
                <div class="col-3">
                    <h4>Status</h4>
                    <form:select path="status" class="custom-select">
                        <c:forEach var="c" items="${listStatus}">

                            <form:option value="${c.id}">${c.name}</form:option>

                        </c:forEach>
                    </form:select>
                </div>
                <div class="col-6 pr-5">
                    <h4>Comment</h4>
                    <form:textarea path="comment" class="form-control"/>
                </div>


            </div>
            <div class="text-center">
                <input type="submit" value="SAVE"  name="saveadvisory" class="btn btn-primary btn-lg mt-3 px-3">
            </div>

    </form>
</form:form>
    </div>
