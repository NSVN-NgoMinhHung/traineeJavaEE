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
function IndexViewModel(){
    var self = this;
    self.listProducts = ko.observableArray([
        new Product(1,'test', 'test', 'test', 10, 'http://placehold.it/350x260'),
        new Product(2,'test', 'test', 'test', 10, 'http://placehold.it/350x260'),
        new Product(3,'test', 'test', 'test', 10, 'http://placehold.it/350x260')
    ]);
}
ko.applyBindings(new IndexViewModel());