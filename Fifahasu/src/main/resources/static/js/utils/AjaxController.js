var AjaxController = {

    call: function (url, type, data) {
        console.log(url);
        $.ajax({
            url: url,
            dataType: "json",
            type: type,
            contentType: "application/json",
        }).done(function (data) {
            console.log(data);
            $("#searchInfo").replaceWith(data);
        });
    },
    jsonCall: function () {

    }
}