<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-02
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="text-center my-5">
        <h2 class="text-uppercase text-muted">Update Account</h2>
    </div>
    <div>
        <form:form action="${pageContext.request.contextPath}/seller/update-seller-detail" modelAttribute="userSellerDetails" method="post">
            <form:hidden path="username"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="row">
                <div class="col-6 p-5 border-right">
                    <h3 class="text-uppercase text-center mb-3 text-muted font-weight-light">Profile</h3>
                    <p><form:errors path="name" class="text-danger d-block"/></p>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-user-tie"></i>
                                            </span>
                        </div>
                        <form:input path="name" class="form-control" placeholder="Name"/>
                    </div>

                    <p><form:errors path="age" class="text-danger d-block"/></p>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text ">Age</span>
                        </div>
                        <form:input path="age" class="form-control" placeholder="Age"/>
                    </div>

                    <p><form:errors path="phone" class="text-danger d-block"/></p>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-phone"></i>
                                            </span>
                        </div>
                        <form:input path="phone" class="form-control" placeholder="Phone"/>
                    </div>

                    <p><form:errors path="mail" class="text-danger d-block"/></p>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-envelope"></i>
                                            </span>
                        </div>
                        <form:input path="mail" class="form-control" placeholder="Email"/>
                    </div>
                </div>
                <div class="col-6 p-5">
                    <h3 class="text-uppercase text-center mb-3 text-muted font-weight-light">Account</h3>
                    <p class="text-lead text-center text-warning">leave blank if do not want to change</p>
                    <span class="text-danger">${passwordErrors}</span>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-lock"></i>
                                            </span>
                        </div>
                        <form:password path="password" class="form-control" placeholder="Password"/>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-lock"></i>
                                            </span>
                        </div>
                        <form:password path="confirmPassword" class="form-control" placeholder="Confirm Password"/>
                    </div>
                </div>
            </div>
            <div class="col-12 text-center mt-5 ">
                <button type="submit" class="btn btn-primary btn-lg px-5">Save</button>
            </div>
        </form:form>
    </div>
</div>


