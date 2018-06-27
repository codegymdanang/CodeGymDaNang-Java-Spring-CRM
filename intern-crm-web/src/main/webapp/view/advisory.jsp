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
                        <p><span>${c.date} </span> ${c.comment} </p>
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
    <form action="" name="update_advisoy">
        <table width="1000px" align="center">
            <tr>
                <th>Date</th>
                <th>Status</th>
                <th>Comment</th>
            </tr>
            <tr>
                <td><span style="color: blue">26/6/2018</span></td>
                <td>
                    <select class="custom-select" id="inputGroupSelect01">
                        <option selected>Choose...</option>
                        <option value="1">Active</option>
                        <option value="2">Lead</option>
                        <option value="3">Lead active</option>
                    </select>
                </td>
                <td>
                    <p><textarea name="textadvisory" cols="90" rows="7">Various form elements have been rebooted for simpler base styles. Here are some of the most notable changes,
            Various form elements have been rebooted for simpler base styles. Here are some of the most notable changes,
            Various form elements have been rebooted for simpler base styles. Here are some of the most notable changes.</textarea>
                    </p>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input type="submit" name="saveadvisory" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>
<br/>
<br/>
</body>
</html>