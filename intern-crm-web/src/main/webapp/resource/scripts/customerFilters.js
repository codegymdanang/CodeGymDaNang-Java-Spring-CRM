var setItemStatus = 0;
var setItemProducType = 0;
var setItemMenu = 0;
window.onload = function () {
    var saveItemStatus = sessionStorage.getItem("SelItemStatus");
    setItemStatus = saveItemStatus!=null? saveItemStatus : 0;
    $('#select-filters-status').val(setItemStatus);
    var saveItemProductType = sessionStorage.getItem("SelItemProductType");
    setItemProducType = saveItemProductType!=null? saveItemProductType : 0;
    $('#select-filters-product').val(setItemProducType);

    $('.p-3').removeClass('active');
    var saveMenuElement = sessionStorage.getItem("menu-element");
    if(saveMenuElement!=null){
        setItemMenu = saveMenuElement;
    }
    $('.p-3:eq('+setItemMenu+')').addClass('active');
}

function listCustomerByFilters() {

    var status = $("#select-filters").val();
    var productType = "";
    jQuery.ajax({
        type: "GET",
        url: window.location.href + "-filter" + "?statusId=" + $("#select-filters").val() + "&productType=0",
        dataType: 'JSON',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);
        },
        done: function (e) {
            console.log("DONE");
        }
    });

}

function display(data) {
    var html = "<tr>";
    for (var i = 0; i < data.length; i++) {
        html += "<td>" + data[i].name + "</td>";
        html += "<td>" + data[i].age + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        // html+= data[i].name+ " - "+ data[i].age + " - " + data[i].phone
    }
    html += "</tr>";
    $('#listCus-body').html(html);
}

function listCusByFilters() {
    var selValStatus = $("#select-filters-status").val()!=null ?  $("#select-filters-status").val():0 ;
    sessionStorage.setItem("SelItemStatus", selValStatus);
    var selValProductType = $("#select-filters-product").val()!=null?  $("#select-filters-product").val():0;
    sessionStorage.setItem("SelItemProductType", selValProductType);

    window.location.href = window.location.pathname + "?statusId=" + selValStatus + "&productType=" + selValProductType;
}
function redirectPage(page) {
    var pageNum = page.getAttribute("data-page");
    if(pageNum>0){
        window.location.href = window.location.pathname + "?statusId="
            + setItemStatus + "&productType=" + setItemProducType + "&pageNum="+ pageNum;
    }
}
function customerForSellerPage(page) {
    var pageNum = page.getAttribute("data-page")
    if (pageNum>0) {
        window.location.href = window.location.pathname + "?pageNum="+ pageNum
    }
}
function changeActiveLi(element) {
    var saveElement = element.getAttribute("data-li")
   sessionStorage.setItem("menu-element", saveElement);
}


