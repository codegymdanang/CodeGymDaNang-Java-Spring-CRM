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
    <title>Manager Home</title>
    <link rel="stylesheet" href="/resource/css/manager-home.css">
</head>
<body>
<div class="container">

    <div class="form-inline">
        <div class="form-group">
            <label for="sel1">Year: </label>
            <select class="form-control" id="sel1">
                <c:forEach items="${years}" var="year">
                    <option value="${year}">${year}</>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="sel1">Month: </label>
            <select class="form-control" id="sel2">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
            </select>
        </div>
    </div>

    <div class="row">

        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 class="ssb-title">10</h1>
                    <h2 class="ssb-title">Prospect</h2>
                </a>
            </div>
        </div>

        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 class="ssb-title">30</h1>
                    <h2 class="ssb-title">Lead</h2>
                </a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 class="ssb-title">20</h1>
                    <h2 class="ssb-title">Potential Lead</h2>
                </a>
            </div>
        </div>

        <div class="col-md-6">
            <div class="square-service-block">
                <a href="#">
                    <h1 class="ssb-title">11</h1>
                    <h2 class="ssb-title">Active Lead</h2>
                </a>
            </div>
        </div>
    </div>

    <div class="customer-info">
        <h2 class="number-customer">Customer: 10</h2>
    </div>
</div>
</body>
</html>
