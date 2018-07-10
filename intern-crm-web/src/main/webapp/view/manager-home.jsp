<%--
  Created by IntelliJ IDEA.
  User: minhnhat
  Date: 6/18/18
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:url var="url" value="/resource/css/"/>
    <title>Manager Home</title>
    <link rel="stylesheet" href="${url}/manager-home.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resource/scripts/home-manager.js" type="text/javascript"></script>
</head>
<body onload="getData()">
<div class="container">

    <div class="form-inline">
        <div class="form-group">
            <label for="year">Year: </label>
            <select class="form-control" id="year" onchange="getData()">
                <c:forEach items="${years}" var="year">
                    <option value="${year}">${year}</>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="month">Month: </label>
            <select class="form-control" id="month" onchange="getData()">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
        </div>
    </div>

    <div class="row">

        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 id="prospect" class="ssb-title">10</h1>
                    <h2 class="ssb-title">Prospect</h2>
                </a>
            </div>
        </div>

        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 id="lead" class="ssb-title">30</h1>
                    <h2 class="ssb-title">Lead</h2>
                </a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 id="potential-lead" class="ssb-title">20</h1>
                    <h2 class="ssb-title">Potential Lead</h2>
                </a>
            </div>
        </div>

        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 id="active-lead" class="ssb-title">11</h1>
                    <h2 class="ssb-title">Active Lead</h2>
                </a>
            </div>
        </div>
    </div>

    <%--<div class="customer-info">--%>
        <%--<h2 class="number-customer">Customer: 10</h2>--%>
    <%--</div>--%>
</div>
</body>


</html>
