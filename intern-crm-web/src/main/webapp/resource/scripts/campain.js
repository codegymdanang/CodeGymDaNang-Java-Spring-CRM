var data  = {};
document.getElementById('btnSubmit').addEventListener("click", submit)

function prepareData() {
    // var file = getFileFromInput();
    //
    // console.log(file);
    // var base64 = getBase64(file);
    //
    // console.log(base64)

    var fileData = $('#fileData').val();
    console.log(fileData);

    data["compain"] = $('#compain').val();
    data["description"] = $('#description').val();
    data["from"] = $('#from').val();
    data["to"] = $('#to').val();
    data["file"] = fileData;
    return data;
}

function submit() {
    var path = this.getAttribute("data-path");
    var data = prepareData();
    console.log(data);
    $.ajax({
        type: "post",
        contentType: "application/json",
        url: path+"/manager_crm/upload",
        data: JSON.stringify(data),
        dataType: "json",
        timeout: 600000,
        success: function (resp) {
            console.log(resp);
            if(resp.customerCampaigns != null) {
                if (typeof resp.customerCampaigns !== 'undefined' && resp.customerCampaigns.length > 0) {
                    append(resp.customerCampaigns);
                    resetForm();
                    return;
                }
            }

            console.log("ERROR");
            showErrors(resp)
        },
        error: function () {
            console.log("ERROR!!!");
        }
    });
}
function resetForm() {
    $('#error-name').remove();
    $('#error-description').remove();
    $('#error-from').remove();
    $('#error-to').remove();
    $('#error-file').remove();
}
function getFileFromInput() {
    var inputFiles = document.getElementById("file");
    console.log("in get file: " + inputFiles.files);
    var file = inputFiles.files[0];
    console.log(inputFiles.files[0]);
    console.log("new log: " + file);
    return file;
}

// function getBase64(file) {
//     console.log("in get base64: " + file);
//     var reader = new FileReader();
//     reader.readAsDataURL(file);
//     console.log(reader.result)
//     return reader.result;
// }

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#fileData').val(e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

function showErrors(data) {
    if (typeof data !== 'undefined') {
        $('#error-name').text(data.nameError);
        $('#error-description').text(data.descriptionError);
        $('#error-from').text(data.fromError);
        $('#error-to').text(data.toError);
        $('#error-file').text(data.fileError);
    }
}
function append(customers) {
    var html = "";
    for (var i = 0; i < customers.length; ++i) {
        html += "<tr><td>" + customers[i].name + "</td><td>"+customers[i].company +
            "</td><td>" +customers[i].age+ "</td><td>" +customers[i].phone + "</td><td>"+customers[i].mail+"</td></tr>";
    }

    $('#table-body').html(html);


}
