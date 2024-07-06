package com.ecommerce.clothes.app.services.contracts;

import com.ecommerce.clothes.app.components.interfaces.ICrud;
import com.ecommerce.clothes.app.repositories.entities.Factura;

public interface IFacturaService extends ICrud<Factura, Long> {
    Factura fetchFacturaByIdWithClienteWithItemFacturaWithProducto(Long id);


}
