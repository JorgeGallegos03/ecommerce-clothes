package com.ecommerce.clothes.app.components.interfaces;


public interface ICrud<E, I> extends
        IDeleteById<I>,
        IFindAll<E>,
        ISave<E>,
        IFindById<E, I> {
}