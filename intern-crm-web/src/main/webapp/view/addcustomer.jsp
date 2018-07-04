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
            margin-bottom: 20px;
        }

        body{
            background-color: #525252;
        }
        .centered-form{
            margin-top: 60px;
        }

        .centered-form .panel{
            background: rgba(255, 255, 255, 0.8);
            box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
        }

        .size {
            height: 40px;
        }

    </style>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

    <c:url var="addCustomerURL" value="/seller/addcustomer"/>
    <div class="container">
        <div class="row centered-form">
            <div class="col-xs-10 col-sm-10 col-md-10 col-sm-offset-1 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h1 class="panel-title">Add customer <small>CRM</small></h1>
                    </div>
                    <div class="panel-body">
                        <form:form method="post" modelAttribute="customer" action="${addCustomerURL}" role="form">
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <form:input path="name" name="name" id="name" cssClass="form-control" placeholder="Name" cssStyle="height: 43px"/>
                                        <form:errors path="name" cssClass="error"/>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <form:input path="age" name="age" id="age" cssClass="form-control" placeholder="Age" cssStyle="height: 43px"/>
                                        <form:errors path="age" cssClass="error"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:input path="mail" name="email" id="email" cssClass="form-control" placeholder="email" cssStyle="height: 43px"/>
                                <form:errors path="mail" cssClass="error"/>
                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <form:input path="company" name="company" id="company" cssClass="form-control" placeholder="company" cssStyle="height: 43px"/>
                                        <form:errors path="company" cssClass="error"/>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <form:input path="facebook" name="facebook" id="facebook" cssClass="form-control" placeholder="facebook" cssStyle="height: 43px"/>
                                        <form:errors path="facebook" cssClass="error"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <form:input type="tel" path="phone" name="phone" id="phone" cssClass="form-control size" placeholder="phone" cssStyle="height: 43px"/>
                                    <form:errors path="phone" cssClass="error"/>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <form:select path="productType" cssClass="form-control" cssStyle="height: 43px">
                                            <form:option value="1" label="Off source" selected="true"/>
                                            <form:option value="2" label="Odc"/>
                                        </form:select>
                                        <form:errors path="productType" cssClass="error"/>
                                    </div>
                                </div>
                            </div>

                            <input type="submit" value="Add" class="btn btn-info btn-block" style="height: 43px">

                        </form:form>
                    </div>
                </div>

            </div>
            <p><form:errors path="productType" cssClass="error"/></p>
        </div>
    </div>

</body>
</html>
