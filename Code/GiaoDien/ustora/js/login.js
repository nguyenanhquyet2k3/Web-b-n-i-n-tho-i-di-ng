$(document).ready(function(){

    $("#btn-singin").click(function(){
        
        var userName = $('#username').val()
        var passWord = $('#password').val()

        $.ajax({
            method: "POST",
            url: 'http://localhost:8080/login/singin',
            data: {
                username : userName,
                password : passWord
            }
          })
           .done(function( msg ) {
            console.log(msg)
            if(msg.success){
                localStorage.setItem("token",msg.data)
                window.location.href = './index.html'
            }else{
                alert("failure !");
            }
              
            });
    })

})