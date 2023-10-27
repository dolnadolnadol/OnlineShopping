package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Shoppingcart;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2566-10-27T16:31:17")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> movie;
    public static volatile SingularAttribute<Products, Integer> price;
    public static volatile SingularAttribute<Products, String> rating;
    public static volatile CollectionAttribute<Products, Shoppingcart> shoppingcartCollection;
    public static volatile SingularAttribute<Products, Integer> id;
    public static volatile SingularAttribute<Products, String> yearcreate;

}