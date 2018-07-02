<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<h2 align="center"> ADVISORY CUSTOMER ${getItemCustomer.name} </h2>
<hr/>
<table width="1000px" align="center">
    <tr>
        <th>Persional Informations</th>
        <th>History advisoried</th>
    </tr>
    <tr class="table-active">
        <td>
            <p>
                <span>Name: </span> ${getItemCustomer.name}
            </p>
        </td>
        <td rowspan="9">
            <div>
                    <c:forEach var="c" items="${historyAdvisories}">
                        <p>${c.date} ${c.statusByStatusId.name} ${c.comment} </p>
                    </c:forEach>
            </div>
        </td>
    </tr>
    <tr class="table-primary">
        <td>
            <p>
                <span>Facebook: </span> ${getItemCustomer.facebook}
            </p>
        </td>
    </tr>
    <tr class="table-danger">
        <td>
            <p>
                <span>Age: </span> ${getItemCustomer.age}
            </p>
        </td>
    </tr>
    <tr class="table-success">
        <td>
            <p>
                <span>Company: </span> ${getItemCustomer.company}
            </p>
        </td>
    </tr>
    <tr class="table-danger">
        <td>
            <p>
                <span>Mail: </span> ${getItemCustomer.mail}
            </p>
        </td>
    </tr>
    <tr class="table-warning">
        <td>
            <p>
                <span>Phone: </span> 0${getItemCustomer.phone}
            </p>
        </td>
    </tr>
    <tr class="table-success">
        <td>
            <p>
                <c:choose>
                    <c:when test="${getItemCustomer.productType=='1'}">
                        <span>Product attending: </span> outsouting
                    </c:when>
                    <c:otherwise>
                        <span>Product attending: </span> odc
                    </c:otherwise>
                </c:choose>

            </p>
        </td>
    </tr>

</table>
<div style="clear:both"></div>
<br/>
<br/>
<div>
    <form:form action="saveHistoryAdvisory" modelAttribute="history" method="post">
        <form:hidden path="customerId"/>
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
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
                    <input type="submit" name="saveadvisory" value="Save" />
                </td>
            </tr>
        </table>
    </form>
    </form:form>
</div>
<br/>
<br/>
</body>
</html>