/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Product(id, name, genre, description, price, imageFileName){
    var self = this;
    self.id = id;
    self.name = name;
    self.genre = genre;
    self.description = description;
    self.price = price;
    self.imageFileName = imageFileName;
}

function CartItem(product, quantity){
    var self = this;
    self.p = ko.observable(product);
    self.quantity = ko.observable(quantity);
    self.total = ko.computed(function(){
        var price = self.p().price;
        return self.quantity() * price;
    });
}


function IndexViewModel(){
    var self = this;
    self.lstProduct = ko.observableArray([
        new Product(1,'test1', 'test1', 'test1', 10, 'http://placehold.it/350x260'),
        new Product(2,'test2', 'test2', 'test2', 11, 'http://placehold.it/350x260'),
        new Product(3,'test3', 'test3', 'test3', 12, 'http://placehold.it/350x260'),
        new Product(4,'test4', 'test4', 'test4', 13, 'http://placehold.it/350x260'),
        new Product(5,'test5', 'test5', 'test5', 14, 'http://placehold.it/350x260'),
        new Product(6,'test6', 'test6', 'test6', 15, 'http://placehold.it/350x260')
    ]);
    self.featuredProducts1 = ko.observableArray([
        self.lstProduct()[0],
        self.lstProduct()[1],
        self.lstProduct()[2]
    ]);
    self.featuredProducts2 = ko.observableArray([
        self.lstProduct()[3],
        self.lstProduct()[4],
        self.lstProduct()[5]
    ]);
    self.lstCartItem = ko.observableArray([
        new CartItem(self.featuredProducts1()[0], 1),
        new CartItem(self.featuredProducts2()[2], 2), 
        new CartItem(self.featuredProducts1()[2], 3)
    ]);
    self.countCartItems = ko.computed(function(){
        var count = self.lstCartItem().length;
        return count;
    });
    
    self.lstProductSearchResult = ko.observableArray([
        
    ]);
    self.countProductSearchResult = ko.computed(function(){
        return self.lstProductSearchResult().length;
    });
    self.totalAll = ko.computed(function(){
       var total = 0;
       for (var i = 0; i < self.lstCartItem.length; i++)
           total += self.lstCartItem[i].cartItem().total;
       return total;
    });
    self.addToCart = function(product){
        self.lstCartItem.push(new CartItem(product, 1));
    };
    self.removeCart = function(cartitem){
        self.lstCartItem.remove(cartitem);
    }
}
ko.applyBindings(new IndexViewModel());