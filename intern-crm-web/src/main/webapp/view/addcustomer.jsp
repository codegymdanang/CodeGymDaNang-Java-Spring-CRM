<%--
  Created by IntelliJ IDEA.
  User: Tuyen
  Date: 6/18/2018
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Customer</title>
    <style type="text/css">

        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="text-center my-5">
    <h2 class="text-muted text-uppercase">Add customer</h2>
</div>
<c:url var="addCustomerURL" value="/seller/addcustomer"/>
<form:form method="post" modelAttribute="customer" action="${addCustomerURL}">
    <div class="row">
        <div class="col-6 p-5">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" ><i class="fa fa-user-tie"></i></span>
                </div>
                <form:input path="name" cssClass="form-control" placeholder="Name"/>
            </div>
            <p><form:errors path="name" cssClass="error"/></p>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text " >Age</span>
                </div>
                <form:input path="age" cssClass="form-control" placeholder="Age"/>
            </div>
            <p><form:errors path="age" cssClass="error"/></p>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" ><i class="fa fa-phone"></i></span>
                </div>
            <form:input path="phone" cssClass="form-control" placeholder="Phone"/>
            </div>
            <p><form:errors path="phone" cssClass="error"/></p>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" ><i class="fa fa-envelope"></i></span>
                </div>
            <form:input path="mail" cssClass="form-control" placeholder="Email"/>
            </div>
            <p><form:errors path="mail" cssClass="error"/></p>
        </div>

        <div class="col-6 p-5 border-left">

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" ><i class="fa fa-building "></i></span>
                </div>
            <form:input path="company" cssClass="form-control" placeholder="Company"/>
            </div>
            <p><form:errors path="company" cssClass="error"/></p>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" ><i class="fa fa-facebook-square "></i></span>
                </div>
            <form:input path="facebook" cssClass="form-control" placeholder="Facebook"/>
            </div>
            <p><form:errors path="facebook" cssClass="error"/></p>


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" >Product Type</span>
                </div>
            <form:select path="productType" cssClass="custom-select">
                <form:option value="1" label="Off source" selected="true"/>
                <form:option value="2" label="Odc"/>
            </form:select>
            </div>
            <p><form:errors path="productType" cssClass="error"/></p>

        </div>

        <div class="col-12 text-center mt-5 ">
            <button type="submit" class="btn btn-primary btn-lg px-5">Save</button>
        </div>

    </div>
</form:form>

</body>
</html>
