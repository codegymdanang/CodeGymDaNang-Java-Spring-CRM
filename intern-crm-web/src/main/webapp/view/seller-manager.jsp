<div>
    <!-- Body Seller Manager -->
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">Seller Manager</h2>
    </div>


    <!-- Filter -->
    <div class="row  mx-5 mb-3">
        <div class="col-3">
            <h4 class="text-muted">Filter</h4>
        </div>
        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Options</label>
                </div>
                <select class="custom-select" id="inputGroupSelect01">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect02">Options</label>
                </div>
                <select class="custom-select" id="inputGroupSelect02">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
        <div class="col-3">
            <div class="input-group">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect03">Options</label>
                </div>
                <select class="custom-select" id="inputGroupSelect03">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
        </div>
    </div>

    <!-- Add and Search -->
    <div class="parent">
        <button class="btn btn-success mx-5 my-3 " data-toggle="modal" data-target="#createAccountModal">
            <i class="fa fa-plus-circle"></i> Create Seller</button>

        <form class="form-inline d-inline form-search mx-5 my-3 float-right ">
            <input class="form-control" type="text" placeholder="Search">
            <button class="btn btn-success " type="submit">Search</button>
        </form>
    </div>
    <!-- Table list seller -->

    <div class="table-seller mx-5">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>1</th>
                <td>Mark</td>
                <td>0993113105</td>
                <td>email@domain</td>
                <td>102 Main street city</td>
                <td>
                    <button class="btn btn-info">EDIT</button>
                </td>
                <td>
                    <button class="btn btn-danger">DELETE</button>
                </td>
            </tr>
            <tr>
                <th>2</th>
                <td>John</td>
                <td>0912333999</td>
                <td>email@domain</td>
                <td>102 Main street city</td>
                <td>
                    <button class="btn btn-info">EDIT</button>
                </td>
                <td>
                    <button class="btn btn-danger">DELETE</button>
                </td>
            </tr>
            <tr>
                <th>3</th>
                <td>Clare</td>
                <td>0993123456</td>
                <td>email@domain</td>
                <td>102 Main street city</td>
                <td>
                    <button class="btn btn-info">EDIT</button>
                </td>
                <td>
                    <button class="btn btn-danger">DELETE</button>
                </td>
            </tr>
            </tbody>
        </table>

    </div>



    <!-- Create Account Modal -->
    <div class="modal fade" id="createAccountModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Create Account</h5>
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="" class="form-group">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-user"></i>
                                            </span>
                            </div>
                            <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-lock"></i>
                                            </span>
                            </div>
                            <input type="password" class="form-control" placeholder="Password">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-lock"></i>
                                            </span>
                            </div>
                            <input type="password" class="form-control" placeholder="Confirm Password">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-phone"></i>
                                            </span>
                            </div>
                            <input type="text" class="form-control" placeholder="Phone number">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-envelope "></i>
                                            </span>
                            </div>
                            <input type="text" class="form-control" placeholder="Email">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-home"></i>
                                            </span>
                            </div>
                            <input type="text" class="form-control" placeholder="Address">
                        </div>
                        <input type="submit" class="btn btn-primary btn-block" value="Confirm">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>