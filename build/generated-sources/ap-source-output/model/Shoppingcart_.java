package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Products;
import model.ShoppingcartPK;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2566-10-27T16:31:17")
@StaticMetamodel(Shoppingcart.class)
public class Shoppingcart_ { 

    public static volatile SingularAttribute<Shoppingcart, ShoppingcartPK> shoppingcartPK;
    public static volatile SingularAttribute<Shoppingcart, Integer> quantity;
    public static volatile SingularAttribute<Shoppingcart, Products> products;

}