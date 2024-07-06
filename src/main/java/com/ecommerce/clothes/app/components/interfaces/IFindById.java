package com.ecommerce.clothes.app.components.interfaces;


public interface IFindById<E, I> {
    E findById(I id);
    E findOne(I id);
}