
    function getData() {
        jQuery.ajax({
            url: window.location.href + "-info" + "?year=" + 2018 + "&month=" + getMonth(),
            type: "GET",
            dataType: "JSON",
            success: function(response) {
                $('#prospect').html(response.prospect);
                $('#lead').html(response.lead);
                $('#potential-lead').html(response.potentialLead);
                $('#active-lead').html(response.activeLead);
                console.log(response)
                console.log("success");
                console.log(window.location.href + "?year=" + getYear() + "&month=" + getMonth());
            },
            error: function (xhr, textStatus, errorThrow) {
                console.log(textStatus + " " + errorThrow);
                console.log(xhr.responseText);
                console.log("error");
                console.log(window.location.href + "?year=" + getYear() + "&month=" + getMonth());
            }
        });
    }

    function getYear() {
        return $("#year").val();
    }

    function getMonth() {
        return $("#month").val();
    }

