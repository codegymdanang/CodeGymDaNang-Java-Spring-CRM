<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Advisory customer</title>
    <style type="text/css">
        span{
            color: #e72120;
        }
        h2{
            margin-top: 30px;
        }
        th{
            text-align: center;
        }
        p{
            padding-left: 15px;
        }
    </style>
</head>
<body>
<h2 align="center"> ADVISORY CUSTOMER A </h2>
<hr/>
<table width="1000px" align="center">
    <tr>
        <th>Persional Informations</th>
        <th>History advisoried</th>
    </tr>
    <tr class="table-active">
        <td>
            <p>
                <span>Name: </span> le nguyen thanh tuyen
            </p>
        </td>
        <td rowspan="9">
            <div>
                <p>
                    <span>01/07/2018: </span> prospect - Some example text that's free-flowing within the dropdown menu.
                </p>
            </div>
        </td>
    </tr>
    <tr class="table-primary">
        <td>
            <p>
                <span>Facebook: </span> con chó
            </p>
        </td>
    </tr>
    <tr class="table-danger">
        <td>
            <p>
                <span>Age: </span> 25/01/1997
            </p>
        </td>
    </tr>
    <tr class="table-success">
        <td>
            <p>
                <span>Company: </span> smartdev
            </p>
        </td>
    </tr>
    <tr class="table-danger">
        <td>
            <p>
                <span>Mail: </span> Lenguyenthanhtuyen97@gmail.com
            </p>
        </td>
    </tr>
    <tr class="table-warning">
        <td>
            <p>
                <span>Phone: </span> 012264552598
            </p>
        </td>
    </tr>
    <tr class="table-success">
        <td>
            <p>
                <span>Product attending: </span> outsouting
            </p>
        </td>
    </tr>

</table>
<div style="clear:both"></div>
<br/>
<br/>
<div>
    <c:set var="list" value="${listStatus}"/>
    <form:form action="saveHistoryAdvisory" modelAttribute="history" method="post">
        <form:hidden path="customerId"/>
        <table width="1000px" align="center">
            <tr>
                <th>Date</th>
                <th>Status</th>
                <th>Comment</th>
            </tr>
            <tr>

                <td>
                    <form:input path="date" readonly="true"/>
                </td>
                <td>
                    <form:select path="status" class="custom-select">
                        <c:forEach var="c" items="${listStatus}">
                         <form:option value="${c.id}">${c.name}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                   <form:textarea path="comment"/>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <button type="submit" class="btn btn-primary mb-2">Add</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<br/>
<br/>
</body>
</html>