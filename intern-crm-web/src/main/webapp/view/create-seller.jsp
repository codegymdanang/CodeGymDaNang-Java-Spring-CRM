<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-27
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h5 class="h2 text-center font-weight-bold m-4 text-muted">Create Account</h5>
<div class="w-50 mx-auto">
    <form:form action="${pageContext.request.contextPath}/manager_crm/create-seller" cssclass="form-group" modelAttribute="user">

        <span class="text-danger">${existuser}</span>
        <p><form:errors path="userName" class="text-danger d-block"/></p>
        <div class="input-group mb-4">
            <div class="input-group-prepend">
                                <span class="input-group-text">
                                    <i class="fa fa-user"></i>
                                </span>
            </div>
            <form:input path="userName" class="form-control" placeholder="Username"/>
        </div>

        <p><form:errors path="passWord" class="text-danger d-block"/></p>
        <div class="input-group mb-4">
            <div class="input-group-prepend">
                                <span class="input-group-text">
                                    <i class="fa fa-lock"></i>
                                </span>

            </div>
            <form:password path="passWord" class="form-control" placeholder="Password"/>
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Create">
    </form:form>
</div>