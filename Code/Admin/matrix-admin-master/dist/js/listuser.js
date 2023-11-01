$(document).ready(function () {
    loadData()
    function loadData() {
    $.ajax({
        url: "http://localhost:8080/user/list",
        type : "GET",
        contentType: "application/json;charset=utf-8",
            dataType: "json",
      }).done(function(result) {
        var userHtml = ``;
        
        $.each(result.data,function(index,items){
           
            userHtml += `<tr>
                                <td>${items.id}</td>
                                <td>${items.fullName}</td>
                                <td>${items.userName}</td>
                                <td>${items.phone}</td>
                                <td>${items.email}</td>
                            </tr>`
        }) 

            $("#listUser").append(userHtml)
      });
    }
});


