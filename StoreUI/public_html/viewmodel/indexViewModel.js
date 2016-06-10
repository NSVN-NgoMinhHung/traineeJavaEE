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
        return self.quantity * price;
    });
}


function IndexViewModel(){
    var self = this;
    self.featuredProducts1 = ko.observableArray([
        new Product(1,'test', 'test', 'test', 10, 'http://placehold.it/350x260'),
        new Product(2,'test', 'test', 'test', 11, 'http://placehold.it/350x260'),
        new Product(3,'test', 'test', 'test', 12, 'http://placehold.it/350x260')
    ]);
    self.featuredProducts2 = ko.observableArray([
        new Product(1,'test', 'test', 'test', 13, 'http://placehold.it/350x260'),
        new Product(2,'test', 'test', 'test', 14, 'http://placehold.it/350x260'),
        new Product(3,'test', 'test', 'test', 15, 'http://placehold.it/350x260')
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
    self.subtotal = ko.computed(function(){
       var total = 0;
       for (var i = 0; i < self.lstCartItem.length; i++)
           total += self.lstCartItem[i].cartItem().total;
       return total;
    });
}
ko.applyBindings(new IndexViewModel());