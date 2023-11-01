$(document).ready(function () {
    loadData()
    function loadData() {
    $.ajax({
        url: "http://localhost:8080/product/list",
        type : "GET",
        contentType: "application/json;charset=utf-8",
            dataType: "json",
      }).done(function(result) {
        var productHtml = ``;
        var statusHtml = ``;
        $.each(result.data,function(index,items){
            if(items.status == 1){
                statusHtml = `<span class="badge badge-success">Còn hàng</span>`
            }else if(items.status == 0){
                statusHtml = `<span class="badge badge-danger">Hết hàng</span>`
            }
            productHtml += `<tr>
                                <td>${items.id}</td>
                                <td>${items.nameProduct}</td>
                                <td>${items.image}</td>
                                <td>${items.price}</td>
                                <td>${items.createdAt}</td>
                                <td>${items.updateAt}</td>
                                <td>${statusHtml}</td>
                                <td> <a href="" onclick="return getById(' + item.id + ')"><i class="m-r-10 mdi mdi-border-color"></i></a><a href="" onclick="return deleteCate(' + item.id + ')"><i class="m-r-10 mdi mdi-delete"></i></a></td>;
                                </tr>`
        }) 

            $("#listProduct").append(productHtml)
      });
    }
});


