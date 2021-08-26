let foundProduct = []
let productsAuto = null;


function getListProduct() {   
    for (let j = 1; j < 4; j++) {
        let a = ["children-bicycles", "comfort-bicycles", "cruisers-bicycles"]
        var settings = {
            "url": "http://localhost:8080/products?q=" + j,
            "method": "GET",
            "timeout": 0,
          };
    
          $.ajax(settings).done(function (pros) {
            for(let i = 0; i < 8; i++) {
                let productNameReformat = pros[i].productName.replace("'", "\\'");

                let b = '<div class="col-4 mt-1">';
                b += '<div class="card border-0 align-content-lg-center" style="width: 18rem, height: 20rem">';
                b += '<a class="nav-link link-dark" target="_blank" href="product.html?id=' + pros[i].productId + '">';
                b += '<img src="'+ pros[i].imageId +'" class="card-img-top img-fluid" alt="..." style="height: 15rem; >'
                b += '<a/>';
                b += '<div class="card-body">';
                b += '<p class="card-title text-center">'+ pros[i].productName +'</p>';
                b += '<p class="card-text text-center">$'+ pros[i].listPrice +'</p>';
                b += '<a type="button" onclick="addProduct2Cart(' + pros[i].productId + ', \'' + productNameReformat +'\', ' + pros[i].listPrice + ', \'' + pros[i].imageId +'\', 1)" class="btn btn-outline-secondary">ADD TO CART</a>';
                b += '<div/>';
                b += '<div/>';
                b += '<div/>';
                jQuery('#'+ a[j-1] +'').append(b)
            }
            
        });
    }
    
}

function getAndDisplayProduct(id) {
    var settings = {
        "url": "http://localhost:8080/products/" + id,
        "method": "GET",
        "timeout": 0,
      };
      
      $.ajax(settings).done(function (product) {
        displayProduct(product);
        
    });
}

function displayProduct(product) {
    let zoomId = "zoom-" + product.productId;
    let productNameReformat = product.productName.replace("'", "\\'");

    let b = '<div class="card mb-3 border-0" style="max-width: 1000px;">';
    b += '<div class="row g-0">';
    b += '<div class="col-md-6">';
    b += '<img id="' + zoomId +'" src="'+ product.imageId +'" class="img-fluid rounded-start" data-zoom-image="'+ product.imageId +'">';
    b += '</div>';
    b += '<div class="col-md-6 p-3">';
    b += '<div class="card-body">';
    b += '<h4 class="card-title mt-4">'+ product.productName +'</h4>';
    b += '<hr>';
    b += '<p class="card-text"><i class="bi bi-star-fill"></i> Model-year: '+ product.modelYear +'</p>';
    b += '<p class="card-text"><i class="bi bi-star-fill"></i> Price: '+ product.listPrice +'</p>';
    b += '<div class="buttons_added mb-4">';
    b += '<input class="minus is-form" style="width: 1.8rem;" type="button" value="-">';
    b += '<input id="soluong" style="width: 3rem;" aria-label="quantity" class="input-qty text-center" max="100" min="1" name="" type="number" value="1">';
    b += '<input class="plus is-form" style="width: 1.8rem;" type="button" value="+">';
    b += '</div>';
    b += '<a href="#" onclick="addProduct2Cart(' + product.productId + ', \'' + productNameReformat +'\', ' + product.listPrice + ', \'' + product.imageId +'\', null)" class="btn btn-outline-secondary">ADD TO CART</a>';
    b += '</div>';
    b += '</div>';
    b += '</div>';
    b += '</div>';
    console.log(product)

    jQuery('#display-product').append(b)

    setTimeout(() => {
        $('input.input-qty').each(function() {
            var $this = $(this),
                qty = $this.parent().find('.is-form'),
                min = Number($this.attr('min')),
                max = Number($this.attr('max'))
            if (min == 0) {
                var d = 0
            } else d = min
            $(qty).on('click', function() {
                if ($(this).hasClass('minus')) {
                if (d > min) d += -1
                } else if ($(this).hasClass('plus')) {
                var x = Number($this.val()) + 1
                if (x <= max) d += 1
                }
                $this.attr('value', d).val(d)
            })
            });
    }, 100)

    setTimeout(() => {
        $('#' + zoomId).elevateZoom({
            zoomType: "inner",
            cursor: "crosshair",
            zoomWindowFadeIn: 500,
            zoomWindowFadeOut: 750
        }); 
    }, 200)    
}

function getUrlParam(paramName) {
    let searchParams = new URLSearchParams(window.location.search)
    return searchParams.get(paramName);
}

function addProduct2Cart(id, name, price, image, quantity) {
    let order = getOrderFromLocalStorage();
    if(quantity == null) {
        quantity = Number(jQuery('#soluong').val())
    }

    let orderDetail = {
        'productId': id,
        'productName': name,
        'listPrice': price,
        'imageId': image,
        'quantity': quantity
    }

    let cartString = localStorage.getItem('cart')

    if(cartString != null) {
        for(let b of order.orderDetails) {
            if(b['productId'] == id) {
                b['quantity'] += quantity;
                storeOrder2LocalStorage(order);
                displayCartNumber();
                return 0;
            }
        }
    }

    order.orderDetails.push(orderDetail);
    storeOrder2LocalStorage(order);
    displayCartNumber();
}

function getOrderFromLocalStorage() {
    let cartString = localStorage.getItem('cart');
    let order = {
        storeId: '',
        customer: {
            'firstName': '',
            'lastName': '',
            'phone': '',
            'email': '',
            'street': '',
            'city': '',
        },
        orderDetails: []
    }
    if(cartString != null) {
        order = JSON.parse(cartString);

    }
    return order
}

function storeOrder2LocalStorage(order) {
    cartString = JSON.stringify(order);
    localStorage.setItem('cart', cartString);
}

function updateCustomer() {
    let order = getOrderFromLocalStorage();
    order.storeId = parseInt($('#store-id option:selected').val())
    order.customer.firstName = jQuery('#first-name').val();
    order.customer.lastName = jQuery('#last-name').val();
    order.customer.phone = jQuery('#phone').val();
    order.customer.email = jQuery('#email').val();
    order.customer.street = jQuery('#street').val();
    order.customer.city = jQuery('#city').val();
    storeOrder2LocalStorage(order);

    $.ajax(order).done(function () {
        jQuery('#alertSuccess').removeClass('d-none');
    
        setTimeout(() => {
            jQuery('#alertSuccess').addClass('d-none');
        }, 3 * 1000)
      });
}

function clearAllDetail() {
    let order = getOrderFromLocalStorage();
    order.orderDetails = []
    storeOrder2LocalStorage(order);
}

function removeProductFromOrder(productId) {
    let order = getOrderFromLocalStorage();
    let indexOfOrderDetail = order.orderDetails.findIndex(o => o.productId == productId);
    order.orderDetails.splice(indexOfOrderDetail, 1);
    storeOrder2LocalStorage(order);
    jQuery('#'+ productId +'').remove();
    displayCartNumber();
}

function displayOrderDetail() {
    let order = getOrderFromLocalStorage();
    let a = 0;

    for(let b of order.orderDetails) {
    let total = b.listPrice*b.quantity
    let ele = '<tr id="'+ b.productId +'">'
    ele += '<td>';
    ele += '<button type="button" onclick="removeProductFromOrder('+ b.productId +')" class="btn-close" aria-label="Close"></button>'
    ele += '</td>';
    ele += '<td>';
    ele += '<div class="row mx-auto align-items-center">';
    ele += '<div class="col-md-4">';
    ele += '<img src="'+ b.imageId +'" class="img-fluid" alt="...">';
    ele += '</div>';
    ele += '<div class="col-md-8">';
    ele += '<p>'+ b.productName +'</p>';
    ele += '</div>';
    ele += '</div>';
    ele += '</td>';
    ele += '<td>$' + b.listPrice +  '</td>';
    ele += '<td class="text-center">' + b.quantity +  '</td>';
    ele += '<td>$' + total.toFixed(2) +  '</td>';
    ele += '</tr>';
    jQuery('#list-order-detail').append(ele)
    a += b.quantity*b.listPrice;
    }
    let ele1 = '<tr>';
    ele1 += '<td>Total</td>';
    ele1 += '<td>$'+ a.toFixed(2) +'</td>';
    ele1 += '</tr>';
    jQuery('#cart-total').append(ele1)
}

function displayCartNumber() {
    let order = getOrderFromLocalStorage();
    let quantityProduct = 0;
    for (let b of order.orderDetails) {
        quantityProduct += b['quantity'];
    }
    jQuery('.icon__item span').text(quantityProduct);
}

function buy() {
    let order = getOrderFromLocalStorage();
    let orderDetails = []
    for(let i = 0; i < order.orderDetails.length; i++) {
        orderDetails.push({
            'itemId': i + 1,
            'productId': order.orderDetails[i].productId,
            'quantity': order.orderDetails[i].quantity,
            'listPrice': order.orderDetails[i].listPrice,
            'discount': 0
        })
    }
    var settings = {
        "url": "http://localhost:8080/orders",
        "method": "POST",
        "timeout": 0,
        "headers": {
          "Content-Type": "application/json",
        },
        "data": JSON.stringify({
            'storeId': order.storeId,
            'customer': order.customer,
            'orderDetails': orderDetails
        }),
    };

    $.ajax(settings).done( function () {
        jQuery('#alertSuccess').removeClass('d-none');
    
        setTimeout(() => {
            jQuery('#alertSuccess').addClass('d-none');
        }, 10 * 1000)
      });

      clearAllDetail();
      displayCartNumber();

}

displayOrderDetail();

displayCartNumber();


function getInput() {
    const field = document.getElementById('input-products');
    productsAuto = new Autocomplete(field, {
          data: [],
          maximumItems: 5,
          treshold: 1,
          onSelectItem: ({label, value}) => {
            console.log(value);
            $("#search-products").attr("href", "product.html?id=" + value);
          }
      });
    var settings = {
      "url": "http://localhost:8080/products",
      "method": "GET",
      "timeout": 0,
    };
    
    $.ajax(settings).done(function (pros) {
      var autoCompletData = [];
      for(let i of pros) {
        autoCompletData.push({
            label: i.productName,
            value: i.productId
      })
      }
      foundProduct = pros;
      productsAuto.setData(autoCompletData);
    });
}



