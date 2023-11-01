$(document).ready(function () {
    loadData()
    function loadData() {
    $.ajax({
        url: "http://localhost:8080/category/list",
        type : "GET",
        contentType: "application/json;charset=utf-8",
            dataType: "json",
      }).done(function(result) {
        var categoryHtml = ``;
        var statusHtml = ``;
        $.each(result.data,function(index,items){
            if(items.status == 1){
                statusHtml = `<span class="badge badge-success">Đang hoạt động</span>`
            }else if(items.status == 0){
                statusHtml = `<span class="badge badge-danger">Tạm dừng</span>`
            }
            categoryHtml += `<tr>
                                <td>${items.id}</td>
                                <td>${items.nameCate}</td>
                                <td>${statusHtml}</td>
                                <td> <a href="" onclick="return getById(' + item.id + ')"><i class="m-r-10 mdi mdi-border-color"></i></a><a href="" onclick="return deleteCate(' + item.id + ')"><i class="m-r-10 mdi mdi-delete"></i></a></td>;

                            </tr>`
        }) 

            $("#listCategory").append(categoryHtml)
      });
    }
});


