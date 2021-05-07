$(document).ready(function () {
    updateCart();
});


function addToCart(pId, pName, pDetail, pPrice) {
    let cart = localStorage.getItem("cart");
    if (cart == null) {
        // make new cart
        let products = [];
        let product = {productId: pId, productName: pName, productDetail: pDetail, productPrice: pPrice, productQuantity: 1};
        products.push(product);
        console.log("cart created and product added");
        localStorage.setItem("cart", JSON.stringify(products));

    } else {
        //cart exists
        let pCart = JSON.parse(cart);

        let oldProduct = pCart.find((item) => item.productId == pId);
        if (oldProduct) {
            //increase quantity if product exists
            oldProduct.productQuantity = oldProduct.productQuantity + 1;
            pCart.map((item) => {
                if (item.productId == oldProduct.productId) {
                    item.productQuantity = oldProduct.productQuantity;
                }
            });
            localStorage.setItem("cart", JSON.stringify(pCart));
            console.log("quantity increased");


        } else {
            //add the new product as it doesn't exist
            let product = {productId: pId, productName: pName, productDetail: pDetail, productPrice: pPrice, productQuantity: 1};
            pCart.push(product);
            localStorage.setItem("cart", JSON.stringify(pCart));
            console.log("new product added to cart");
        }

    }
    updateCart();
}

function updateCart() {
    let cart = JSON.parse(localStorage.getItem("cart"));
    if (cart === null || cart.length === 0) {
        console.log("cartIsEmpty");
//        $(".cart-items").html("(0)");
        $(".cart-body").html("<h4>No items in cart<i></i></h4>");
        console.log("cartnotnull");
        $(".checkout-btn").attr('disabled', true);
    } else {
        $(".cart-items").html(`(${cart.length})`);
        let count = 1, totalPrice = 0;
        let table = `
        <div class="table-responsive-lg checkot-tbl" style="overflow-x:auto">
<table class="table">
        <thead  class="thead-light">
            <tr>
                <th>S.N.</th>
                <th>Product Name</th>
                <th>Detail</th>
                <th>Price(Rs)</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>Action</th>
            </tr>
        </thead>


`;

        cart.map((item) => {
            table += `
<tr>
<td> ${count++} </td>
<td> ${item.productName} </td>
<td> ${item.productDetail} </td>
<td> ${item.productPrice} </td>
<td> ${item.productQuantity} </td>
<td> ${item.productQuantity * item.productPrice} </td>
<td> <button type="button" class="btn btn-danger" onclick="deleteFromCart(${item.productId})"> Remove </button> </td>
</tr>`;

            totalPrice += item.productPrice * item.productQuantity;

        });

        table = table + `
<tr>
<td colspan="7" class="text-right font-weight-bold"> Total Price : Rs. ${totalPrice}/- </td>
</tr>
</table>
</div>`;
        $(".cart-body").html(table);
        $(".checkout-btn").attr('disabled', false);



    }
}

//delete with the product ID
function deleteFromCart(pId) {
    let cart = JSON.parse(localStorage.getItem("cart"));
    let newCart = cart.filter((item) => item.productId != pId);

    localStorage.setItem("cart", JSON.stringify(newCart));
    updateCart();
}


function checkout() {
    window.location = "checkout";
}