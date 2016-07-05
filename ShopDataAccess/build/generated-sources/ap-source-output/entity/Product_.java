package entity;

import entity.Genre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T09:57:28")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Long> id;
    public static volatile SingularAttribute<Product, Genre> genre;
    public static volatile SingularAttribute<Product, String> imageFileName;
    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, String> productName;

}