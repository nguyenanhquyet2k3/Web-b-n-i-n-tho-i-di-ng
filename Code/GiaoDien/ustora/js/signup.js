$(document).ready(function(){

    $("#btn-signup").click(function(){
        var fullname = $('#fullname').val()
        var username = $('#username').val()
        var password = $('#password').val()
        var phone = $('#phone').val()
        var email = $('#email').val()

        $.ajax({
            method: "POST",
            url: 'http://localhost:8080/login/signup',
            data: {
                fullname : $('#fullname').val(),
                username : $('#username').val(),
                password : $('#password').val(),
                phone : $('#phone').val(),
                email : $('#email').val()
            }
          })
           .done(function( msg ) {
            if(msg.success){
                alert("Đăng ký thành công")
                window.location.href = './login.html'
            }else{
                alert("failure !");
            }
              
            });
    })

})