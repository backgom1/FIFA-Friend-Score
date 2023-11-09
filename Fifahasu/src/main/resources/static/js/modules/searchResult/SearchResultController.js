var SearchResultController = {

    init: function () {
        AjaxController.call("http://localhost:8080/v1/api/match-record","GET",null,this.searchResult)
    },

    searchResult: function (status,data) {
        console.log(data);
    }
};