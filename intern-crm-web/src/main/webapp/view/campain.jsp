<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-04
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h5 class="h2 text-center font-weight-bold m-4 text-muted">Create New Campain</h5>
    <form action="">
        <div class="col-7 mx-auto mt-5">
            <input type="text" class="form-control mb-3" placeholder="Campain name">
            <textarea cols="30" rows="4" class="form-control mb-3" placeholder="Decription"></textarea>
            <div class="row">
                <div class="col-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">From</span>
                        </div>
                        <input type="date" class="form-control">
                    </div>
                </div>
                <div class="col-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">To</span>
                        </div>
                        <input type="date" class="form-control">
                    </div>
                </div>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Upload</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input">
                    <label class="custom-file-label">Choose file</label>
                </div>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Accept" />
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
