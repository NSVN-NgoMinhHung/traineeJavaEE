/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Genre(id, genreName, description) {
    var self = this;
    self.id = id;
    self.genreName = genreName;
    self.description = description;
}
function Product(id, name, genre, description, price, imageFileName) {
    var self = this;
    self.id = id;
    self.productName = name;
    self.genre = genre;
    self.description = description;
    self.price = price;
    self.imageFileName = imageFileName;
}

function CartItem(product, quantity) {
    var self = this;
    self.p = ko.observable(product);
    self.quantity = ko.observable(quantity);
    self.total = ko.computed(function () {
        var price = self.p().price;
        return self.quantity() * price;
    });
}


function IndexViewModel() {
    var self = this;
    self.lstProduct = ko.observableArray();
    self.searchProductName = ko.observable();

    $.getJSON("http://localhost:8080/StoreWebService/storeWebService/webresources/storeWebService/getListProducts").
            then(function (getListProducts) {
                $.each(getListProducts, function () {
                    self.lstProduct.push(
                            new Product(this.id, this.productName, this.genre, this.description, this.price, this.imageFileName)
                            );
                });
            });

    self.lstCartItem = ko.observableArray();
    self.countCartItems = ko.computed(function () {
        var count = self.lstCartItem().length;
        return count;
    });

    self.lstProductSearchResult = ko.observableArray([
    ]);
    self.countProductSearchResult = ko.computed(function () {
        return self.lstProductSearchResult().length;
    });
    self.totalAll = ko.computed(function () {
        var total = 0;
        for (var i = 0; i < self.lstCartItem.length; i++)
            total += self.lstCartItem[i].cartItem().total;
        return total;
    });
    self.addToCart = function (product) {
        self.lstCartItem.push(new CartItem(product, 1));
    };
    self.removeCart = function (cartitem) {
        self.lstCartItem.remove(cartitem);
    };
}
ko.applyBindings(new IndexViewModel());
