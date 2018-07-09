    <%--
      Created by IntelliJ IDEA.
      User: Ha Nguyen
      Date: 6/14/2018
      Time: 3:46 PM
      To change this template use File | Settings | File Templates.
    --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <!DOCTYPE html>
        <html lang="en">

        <head>
            <c:url var="url" value="/resource/css/style.css"/>
            <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>CRM System</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
        integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
        integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
        crossorigin="anonymous">
        <link rel="stylesheet" href="${url}">

        </head>

        <body>
        <%--header here--%>
        <tiles:insertAttribute name="header"/>
        <div class="container-fluid p-0">

            <div class="row no-gutters">
                 <div class="col-3 col-lg-2">
        <%--menubar here--%>
        <tiles:insertAttribute name="menu"/>
                </div>
                <div class="col-9 col-lg-10 relative">
        <%--body here--%>
        <tiles:insertAttribute name="body"/>

        <%--footer here--%>
        <tiles:insertAttribute name="footer"/>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/customerFilters.js"></script>


            </body>

        </html>