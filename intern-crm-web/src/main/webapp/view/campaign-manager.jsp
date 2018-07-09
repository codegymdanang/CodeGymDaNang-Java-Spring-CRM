<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-04
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h5 class="h2 text-center font-weight-bold m-4 text-muted">Campain Management</h5>
    <form action="/manager_crm/search" method="get" class="form-inline d-inline form-search mx-5 my-3 float-right ">
        <input class="form-control" name="key" type="text" placeholder="Search">
        <button class="btn btn-success " type="submit">Search</button>
    </form>
<c:choose>
    <c:when test="${campaigns.size()==0}">
        <p class="text-danger text-center">Không co kết quả</p>
    </c:when>
    <c:otherwise>

    <div class="m-5">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th class="w-50">Description</th>
                <th>Start</th>
                <th>End</th>
                <th>Detail</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="c" items="${campaigns}">
                <c:url var="listCustomersLink" value="/manager_crm/campaign-customer">
                    <c:param name="campaignId" value="${c.id}"></c:param>
                </c:url>
                <tr>
                    <td>${c.name}</td>
                    <td>${c.description}</td>
                    <td>${c.dateStart}</td>
                    <td>${c.dateEnd}</td>
                    <td>
                        <a href="${listCustomersLink}" class="btn btn-success"><i class="fa fa-arrow-right"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    </c:otherwise>

</c:choose>
</div>
