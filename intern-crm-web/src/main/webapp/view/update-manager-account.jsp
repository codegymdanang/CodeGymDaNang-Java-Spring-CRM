<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-03
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-6 p-5 mx-auto">
        <h3 class="text-uppercase text-center mb-3 text-muted font-weight-light">Account</h3>
        <form:form action="/manager_crm/update-account" modelAttribute="user" method="post">
            <form:hidden path="username"/>
            <span class="text-danger">${passwordErrors}</span>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
                </div>
                <form:password path="password" class="form-control" placeholder="Password"/>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
                </div>
                <form:password path="confirmPassword" class="form-control" placeholder="Confirm Password"/>
            </div>
            <div class="col-12 text-center mt-5 ">
                <button type="submit" class="btn btn-primary btn-lg px-5">Save</button>
            </div>
        </form:form>
    </div>
</div>