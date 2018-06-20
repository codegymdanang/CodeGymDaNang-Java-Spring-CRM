<div>
    <div class="title">
        <h2 class="text-muted text-center my-5 h1 font-weight-light">List Customer</h2>
    </div>
    <div class="row  mx-5 mb-3">
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
        <div class="col-4">
            <div class="input-group">
                <form class="form-inline d-inline form-search float-right ">
                    <input class="form-control" type="text" placeholder="Search">
                    <button class="btn btn-success " type="submit">Search</button>
                </form>
            </div>
        </div>

    </div>

    <!-- Add and Search -->
    <div class="parent">
        <button class="btn btn-success mx-5 my-3 " data-toggle="modal" data-target="#createAccountModal">
            <a href="#" class="btn btn-success fa fa-plus-circle" > Add Customer</a>
        </button>
    </div>
    <!-- Table list seller -->

    <div class="table-seller mx-5">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Work Place</th>
                <th>Phone</th>

                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>John</td>
                <td>Gia Lai</td>
                <td>123456</td>

                <td>
                    <button class="btn btn-info">EDIT</button>
                </td>
                <td>
                    <button class="btn btn-danger">DELETE</button>
                </td>
            </tr>
            <tr>
                <td>Marri</td>
                <td>Gia Lai</td>
                <td>123456</td>

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
</div>