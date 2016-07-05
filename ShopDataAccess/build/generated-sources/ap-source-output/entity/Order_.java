package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T10:13:16")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SingularAttribute<Order, String> dateShipped;
    public static volatile SingularAttribute<Order, String> status;
    public static volatile SingularAttribute<Order, String> dateCreated;
    public static volatile SingularAttribute<Order, Customer> customer;

}