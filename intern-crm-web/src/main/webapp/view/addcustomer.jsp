<%--
  Created by IntelliJ IDEA.
  User: Tuyen
  Date: 6/18/2018
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Customer</title>
    <style type="text/css">
        .a{
            margin-top: 30px;
            width: 800px;
        }
        h2{
            margin-left: 20px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="a">
        <h2>Add customer</h2>
    <div class="col-auto">
        <spring:url var="addCustomerURL" value="/seller/addcustomer"/>
    <form:form method="post" modelAttribute="customer" action="${addCustomerURL}">
        <div class="form-group col-md-10">
            <form:label path="name">Name</form:label>
            <form:input path="name" cssClass="form-control" placeholder="name"/>
            <p><form:errors path="name" cssClass="error"/></p>

            <form:label path="age">Age</form:label>
            <form:input path="age" cssClass="form-control" placeholder="age"/>
            <p><form:errors path="age" cssClass="error"/></p>

            <form:label path="phone">Phone</form:label>
            <form:input path="phone" cssClass="form-control" placeholder="phone"/>
            <p><form:errors path="phone" cssClass="error"/></p>

            <form:label path="company">Company</form:label>
            <form:input path="company" cssClass="form-control" placeholder="company"/>
            <p><form:errors path="company" cssClass="error"/></p>

            <form:label path="facebook">Facebook</form:label>
            <form:input path="facebook" cssClass="form-control" placeholder="facebook"/>
            <p><form:errors path="facebook" cssClass="error"/></p>

            <form:label path="mail">Email</form:label>
            <form:input path="mail" cssClass="form-control" placeholder="email"/>
            <p><form:errors path="mail" cssClass="error"/></p>

            <form:label path="productType" cssClass="mr-sm-2">Product Type</form:label>
            <form:select path="productType" cssClass="custom-select mr-sm-2">
                <form:option value="1" label="Off source" selected="true"/>
                <form:option value="2" label="Odc"/>
            </form:select>
            <p><form:errors path="productType" cssClass="error"/></p>
            <br/>
            <div class="col-auto my-1">
                <button type="submit" class="btn btn-primary mb-2">Add</button>
            </div>
        </div>
    </form:form>
    </div>
    </div>
</body>
</html>
