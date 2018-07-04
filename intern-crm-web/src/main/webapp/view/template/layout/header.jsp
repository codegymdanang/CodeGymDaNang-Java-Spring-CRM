    <%--
      Created by IntelliJ IDEA.
      User: Ha Nguyen
      Date: 6/14/2018
      Time: 3:47 PM
      To change this template use File | Settings | File Templates.
    --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

        <header class="bg-main p-2 header ">
                <div class="mx-5 d-flex justify-content-between">
                        <div class="h-logo d-flex align-items-center">
                                <i class="fa fa-chart-line fa-3x text-white"></i>
                        </div>
                        <div class="h-tilte">
                                <p class=" h1 font-weight-light font-italic text-uppercase text-white p-0">CRM system </p>
                        </div>

                        <div class="account d-flex align-items-center ">
                                <a href="/edit-user" class="btn p-0">
                                        <i class="fa fa-user-circle text-warning fa-2x"></i></a>

                                    <form id="logoutForm" method="POST" action="../logout">
                                         <input type="hidden" name="${_csrf.parameterName}"
                                           value="${_csrf.token}" />
                                    </form>
                                <a onclick="document.forms['logoutForm'].submit()" class=" ml-2 btn btn-warning">Logout</a>
                        </div>
                </div>
        </header>