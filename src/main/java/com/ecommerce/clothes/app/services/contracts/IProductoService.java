package com.ecommerce.clothes.app.services.contracts;

import com.ecommerce.clothes.app.components.interfaces.ICrud;
import com.ecommerce.clothes.app.components.interfaces.IFindByName;
import com.ecommerce.clothes.app.repositories.entities.Producto;

public interface IProductoService extends ICrud<Producto, Long>, IFindByName<Producto, String> {

}
