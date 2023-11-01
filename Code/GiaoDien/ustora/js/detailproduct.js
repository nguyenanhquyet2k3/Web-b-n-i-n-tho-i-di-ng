$(document).ready(function(){

    let searchParams = new URLSearchParams(window.location.search)
    var restid = searchParams.get('id')
    var linkProduct = "http://localhost:8080/product"
    var token = localStorage.getItem("token")
    console.log(restid)

    $.ajax({
        method: "GET",
        url: `${linkProduct}/detail?id=${restid}`,
       headers : {
        'Authorization' : `Bearer ${token}`
       }
      })
       .done(function( msg ) {
        console.log(msg)
        if(msg.success){
            var value = msg.data
            var html = ` <div  class="product-content-right">
                            <div class="product-breadcroumb">
                                <a href="index.html">Home</a>
                                <a>${value.nameProduct}</a>
                            </div>

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="product-images">
                                        <div class="product-main-img">
                                            <img src="${linkProduct}/file/${value.image}" alt="">
                                        </div>

                                       
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <div class="product-inner">
                                        <h2 class="product-name">${value.nameProduct}</h2>
                                        <div class="product-inner-price">
                                            <ins>${value.price}đ</ins>
                                        </div>

                                        <form action="cart.html" class="cart">
                                            <div class="quantity">
                                                <input type="number" size="4" class="input-text qty text" title="Qty"
                                                    value="1" name="quantity" min="1" step="1">
                                            </div>
                                            <button class="add_to_cart_button" type="submit">Add to cart</button>
                                        </form>


                                        <div role="tabpanel">
                                            <ul class="product-tab" role="tablist">
                                                <li role="presentation" class="active"><a href="#home" aria-controls="home"
                                                        role="tab" data-toggle="tab">Description</a></li>
                                                <li role="presentation"><a href="#profile" aria-controls="profile"
                                                        role="tab" data-toggle="tab">Reviews</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                    <h2>Product Description</h2>
                                                    <p>${value.information}</p>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade" id="profile">
                                                    <h2>Reviews</h2>
                                                    <div class="submit-review">
                                                        <p><label for="name">Name</label> <input name="name" type="text">
                                                        </p>
                                                        <p><label for="email">Email</label> <input name="email"
                                                                type="email"></p>
                                                        <div class="rating-chooser">
                                                            <p>Your rating</p>

                                                            <div class="rating-wrap-post">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                            </div>
                                                        </div>
                                                        <p><label for="review">Your review</label> <textarea name="review"
                                                                id="" cols="30" rows="10"></textarea></p>
                                                        <p><input type="submit" value="Submit"></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>



                        </div>`

                $("#detailproduct").append(html)
        }
           
            });

})