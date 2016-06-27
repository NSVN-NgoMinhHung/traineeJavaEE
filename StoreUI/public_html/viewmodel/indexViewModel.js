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
    self.searchResult = ko.observableArray();
    self.indexScreen = ko.observable(1);//1-list product 2-search result 3-shoping cart

    $.getJSON("http://localhost:8080/StoreWebService/storeWebService/webresources/storeWebService/getListProducts").
            then(function (getListProducts) {
                $.each(getListProducts, function () {
                    self.lstProduct.push(
                            new Product(this.id, this.productName, this.genre, this.description, this.price, this.imageFileName)
                            );
                });
            });

    self.lstCartItem = ko.observableArray();

    if (typeof sessionStorage["shoppingCart"] !== "undefined"
            && sessionStorage["shoppingCart"] !== "undefined") {
        var storeShoppingCart = JSON.parse(sessionStorage.getItem("shoppingCart")) || [];
    }

    //send the items that we load from storage through the CartItem constructor
    self.lstCartItem(ko.utils.arrayMap(storeShoppingCart, function (item) {
        return new CartItem(item.p, item.quantity);
    }));

    self.countCartItems = ko.computed(function () {
        var count = self.lstCartItem().length;
        return count;
    });

    self.totalAll = ko.computed(function () {
        var total = 0;
        for (var i = 0; i < self.lstCartItem().length; i++)
            total += self.lstCartItem()[i].total();
        return total;
    });

    self.addToCart = function (product) {
        self.lstCartItem.push(new CartItem(product, 1));
    };
    self.removeCart = function (cartitem) {
        self.lstCartItem.remove(cartitem);
    };

    self.getResults = function () {
        self.searchResult.removeAll();
        $.getJSON("http://localhost:8080/StoreWebService/storeWebService/webresources/storeWebService/getProductsByName/" + self.searchProductName()).
                then(function (getProducts) {
                    $.each(getProducts, function () {
                        self.searchResult.push(
                                new Product(this.id, this.productName, this.genre, this.description, this.price, this.imageFileName)
                                );
                    });
                });
    };

    //dirty tracking
    ko.computed(function () {
        sessionStorage.setItem("shoppingCart", ko.toJSON(self.lstCartItem));
    }).extend({throttle: 1});
}
window.vm = new IndexViewModel();
ko.applyBindings(vm);
