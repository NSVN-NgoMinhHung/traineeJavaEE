package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-14T16:34:00")
@StaticMetamodel(ShippingInfo.class)
public class ShippingInfo_ { 

    public static volatile SingularAttribute<ShippingInfo, Long> id;
    public static volatile SingularAttribute<ShippingInfo, String> shippingType;
    public static volatile SingularAttribute<ShippingInfo, String> shippingLocation;
    public static volatile SingularAttribute<ShippingInfo, Float> shippingCost;

}