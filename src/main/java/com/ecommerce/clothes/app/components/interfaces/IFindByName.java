package com.ecommerce.clothes.app.components.interfaces;

import java.util.List;


public interface IFindByName<E, I> {
    List<E> findByName(I name);

}