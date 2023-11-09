var AjaxController = {

    call: function (url, type, data, successParam) {
        $.ajax({
            url: url,
            async : true,
            cache : false,
            dataType: "json",
            data: (data?data:""),
            type: type,
            contentType: "application/json",
            success : successParam,
            error: function (response) {
                alert(response.responseJSON.name);
            }
        }).done(function (data) {
            console.log(data);
        });
    },
    jsonCall: function () {

    }
}