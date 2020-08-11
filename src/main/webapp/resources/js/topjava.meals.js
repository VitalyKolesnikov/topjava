var mealAjaxUrl = "profile/meals/";

function updateFilteredTable() {
    $.ajax({
        type: "GET",
        url: "profile/meals/filter",
        data: $("#filter").serialize()
    }).done(updateTableByData);
}

function clearFilter() {
    $("#filter")[0].reset();
    $.get("profile/meals/", updateTableByData);
}

// http://api.jquery.com/jQuery.ajax/#using-converters
$.ajaxSetup({
    converters: {
        "text json": function (stringData) {
            var json = JSON.parse(stringData);
            $(json).each(function () {
                this.dateTime = this.dateTime.replace('T', ' ').substr(0, 16);
            });
            return json;
        }
    }
});

$(function () {
    makeEditable({
            ajaxUrl: mealAjaxUrl,
            datatableApi: $("#datatable").DataTable({
                "ajax": {
                    "url": mealAjaxUrl,
                    "dataSrc": ""
                },
                "paging": false,
                "info": true,
                "columns": [
                    {
                        "data": "dateTime"
                    },
                    {
                        "data": "description"
                    },
                    {
                        "data": "calories"
                    },
                    {
                        "render": renderEditBtn,
                        "defaultContent": "",
                        "orderable": false
                    },
                    {
                        "render": renderDeleteBtn,
                        "defaultContent": "",
                        "orderable": false
                    }
                ],
                "order": [
                    [
                        0,
                        "desc"
                    ]
                ],
                "createdRow": function (row, data, dataIndex) {
                    $(row).attr("data-mealExcess", data.excess);
                }
            }),
            updateTable: function () {
                $.get(mealAjaxUrl, updateFilteredTable);
            }
        });
});