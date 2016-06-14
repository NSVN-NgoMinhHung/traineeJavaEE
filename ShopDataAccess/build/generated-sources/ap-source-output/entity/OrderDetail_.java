package entity;

import entity.Order;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-14T09:48:23")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Product> product;
    public static volatile SingularAttribute<OrderDetail, Order> order;
    public static volatile SingularAttribute<OrderDetail, Float> unitCost;
    public static volatile SingularAttribute<OrderDetail, Float> subTotal;
    public static volatile SingularAttribute<OrderDetail, Integer> quantity;

}