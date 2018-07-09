<%--
  Created by IntelliJ IDEA.
  User: Ha Nguyen
  Date: 6/14/2018
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <div class="sidebar bg-menu">
        <ul class="list-unstyled my-0">
            <li class="p-3" onclick="changeActiveLi(this)" data-li="0">
                <a href="${pageContext.request.contextPath}/manager_crm/home" class="text-white lead ">Home</a>
            </li>
            <li class="p-3" onclick="changeActiveLi(this)" data-li="1">
                <a href="${pageContext.request.contextPath}/manager_crm/list-seller" class="text-white lead ">Seller Manager</a>
            </li>
            <li class="p-3" onclick="changeActiveLi(this)" data-li="2">
                <a href="${pageContext.request.contextPath}/manager_crm/list-custom?statusId=0&productType=0" class="text-white lead">Customer Manager</a>
            </li>
            <li class="p-3" onclick="changeActiveLi(this)" data-li="3">
                <a href="${pageContext.request.contextPath}/manager_crm/campaign" class="text-white lead ">Create campain</a>
            </li>
            <li class="p-3" onclick="changeActiveLi(this)" data-li="4">
                <a href="${pageContext.request.contextPath}/manager_crm/campaign-manager" class="text-white lead ">Campain manager</a>
            </li>
            <li class="p-3" onclick="changeActiveLi(this)" data-li="5">
                <a href="${pageContext.request.contextPath}/blocklist" class="text-white lead ">Block list</a>
            </li>
        </ul>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/customerFilters.js"></script>
