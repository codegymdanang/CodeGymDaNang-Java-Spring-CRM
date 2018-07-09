<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-04
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/resource/scripts/dropzone.js" type="text/javascript"></script>
<div>
    <c:url var="uploadURL" value="/manager_crm/upload"/>
    <h5 class="h2 text-center font-weight-bold m-4 text-muted">Create New Campain</h5>
    <form action="${uploadURL}" method="post">
        <div class="col-7 mx-auto mt-5">
            <input type="text" class="form-control mb-3" placeholder="Campain name" name="compain" id="compain">
            <span id="error-name"></span>
            <textarea cols="30" rows="4" class="form-control mb-3" placeholder="Description" name="description" id="description"></textarea>
            <span id="error-description"></span>
            <div class="row">
                <div class="col-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">From</span>
                        </div>
                        <input type="date" class="form-control" name="from" id="from">
                    </div>
                    <span id="error-from"></span>
                </div>
                <div class="col-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">To</span>
                        </div>
                        <input type="date" class="form-control" name="to" id="to">
                    </div>
                    <span id="error-to"></span>
                </div>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Upload</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" onchange="readURL(this)" name="file" id="file">
                    <input type="hidden" value="" id="fileData"/>
                    <label class="custom-file-label">Choose file</label>
                </div>
            </div>
            <span id="error-file"></span>
            <button type="button" class="btn btn-primary btn-block" value="Accept" id="btnSubmit">Accept</button>
        </div>
    </form>

    <div class="m-5">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Company</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>Mark</th>
                <td>Smart Dev</td>
                <td>24</td>
                <td>0993113105</td>
                <td>email@domain</td>
            </tr>

            </tbody>
        </table>

    </div>
</div>
<script src="/resource/scripts/campain.js" type="text/javascript"></script>
