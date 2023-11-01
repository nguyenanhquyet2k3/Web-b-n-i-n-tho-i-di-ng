$(document).ready(function(){

    var linkProduct = "http://localhost:8080/product"
    var linkCategory = "http://localhost:8080/category"
    var token = localStorage.getItem("token")
    console.log(token)

    $.ajax({
        method: "GET",
        url: linkProduct,
       headers : {
        'Authorization' : `Bearer ${token}`
       }
      })
       .done(function( msg ) {

        
        if(msg.success){
            $.each(msg.data,function(index,value){
                var html = `<div style="display: inline-block; margin-right: 20px;"  class="single-product"> <div class="product-f-image">
                                <img src="${linkProduct}/file/${value.image}" alt="">
                                <div class="product-hover">
                                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                    <a href="single-product.html?id=${value.id}" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                </div>
                            </div>
                            
                            <h2>${value.nameProduct}</h2>
                            <div class="product-carousel-price">
                                <ins>${value.price}đ</ins>
                            </div> </div>`

               
                $("#product").append(html)

            })
            
        }

        
        });

        //hiển thị danh sách Category
        $.ajax({
            method: "GET",
            url: linkCategory,
           headers : {
            'Authorization' : `Bearer ${token}`
           }
          })
           .done(function( msg ) {
    
            if(msg.success){
                $.each(msg.data,function(index,value){
                    var htmlCategory = `<div class="col-md-4"><h2 class="product-wid-title">${value.nameCate}</h2>
                                            </div>`
                
                htmlCategory+=`<div >`
                $.each(value.products,function(index,data){
                    htmlCategory += `<div class="col-md-4"><div class="single-product-widget">
                                                <div class="single-wid-product">
                                                    <a href="single-product.html"><img src="${linkProduct}/file/${data.image}" alt="" class="product-thumb"></a>
                                                    <h2><a href="single-product.html">${data.nameProduct}</a></h2>
                                                    <div class="product-wid-price">
                                                        <ins>${data.price}đ</ins>
                                                    </div>                            
                                                </div>
                                        </div></div>`
    
                   
                                    })
                                    htmlCategory+=`</div`
                    $("#cateproduct").append(htmlCategory)
                })
                
            }
    
            console.log(msg)
            });

})