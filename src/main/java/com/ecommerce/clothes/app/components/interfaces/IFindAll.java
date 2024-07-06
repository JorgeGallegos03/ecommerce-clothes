package com.ecommerce.clothes.app.components.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IFindAll<E> {
    Page<E> findAll(Pageable pageable);
    List<E> findAll();
}