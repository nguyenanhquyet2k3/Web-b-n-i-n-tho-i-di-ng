$(document).ready(function () {

    $("#btn-submit").click(function(){
        
        var name = $("#name").val()
        var statusinput = $("#status").val()
        
        $.ajax({
            url: "http://localhost:8080/category/add",
            type: "POST",
            data: {
                name_cate: $("#name").val(),
                status : statusinput
            }
            
        }).done(function(resp){
            alert("Thành công !")
            window.location.href = './index.html'
        });
    })        
        
});


