<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer</h2>
    </div>
    <form class="" action="/seller/searchSeller" method="post">
    <div class="row  mx-5 mb-3">

        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text">Options</label>
                </div>
                <select class="custom-select" name="thongtin">

                    <option value="Name">Name</option>
                    <option value="Mail">Mail</option>
                    <option value="Company">Company</option>

                </select>
            </div>
        </div>
        <div class="col-4">
            <div class="input-group">

                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                    <input class="form-control" name="search" value="${key}" type="text" placeholder="Search">
                    <button class="btn btn-success " type="submit">Search</button>

            </div>
        </div>

    </div>
    </form>

    <!-- Add and Search -->


    <c:url var="addCustomerURL" value="/seller/addcustomer"/>
    <div class="parent">
            <a href="${addCustomerURL}" class="btn btn-success mx-5 my-3" >
                <i class="fa fa-plus-circle"></i> Add Customer</a>


    </div>
    <!-- Table list seller -->
    <c:choose>
    <c:when test="${customers.size()==0}">
        <p class="text-danger text-center">Không có kết quả tìm kiếm</p>
    </c:when>
    <c:otherwise>

    <div class="table-seller mx-5">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Work Place</th>
                <th>Phone</th>
                <th>Status</th>
                <th>Create date</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customers}" var="c">
                <c:url var="upDateLink" value="/seller/advisory">
                    <c:param name="customer" value="${c.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/seller/delete">
                    <c:param name="customer" value="${c.id}"/>
                </c:url>
            <tr>
                <td>${c.name}</td>
                <td>${c.company}</td>
                <td>${c.phone}</td>
                <td>${c.statusByStatusId.name}</td>
                <td>2018-7-2</td>
                <td><a href="${upDateLink}" class="btn btn-info">UpDate Status</a></td>
                <td>
                    <a href="/seller/editcustomer/${c.id}"><button class="btn btn-info btn btn-primary" data-toggle="modal" data-target="#exampleModal" value="">EDIT</button></a>
                </td>
                <td><a href="${deleteLink}"
                       onclick="if (!confirm('Are you sure??')) return false" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    </c:otherwise>
    </c:choose>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">EDIT CUSTOMER</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="name" value="">
                    <br/>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="age" value="">
                    <br/>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="phone" value="">
                    <br/>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="company" value="">
                    <br/>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="facebook" value="">
                    <br/>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Email" value="">
                    <br/>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                        <option selected>Choose...</option>
                        <option value="1">offsource</option>
                        <option value="2">odc</option>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</div>
