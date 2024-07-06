package com.ecommerce.clothes.app.services.contracts;

import com.ecommerce.clothes.app.components.interfaces.ICrud;
import com.ecommerce.clothes.app.repositories.entities.Cliente;

public interface IClienteService extends ICrud<Cliente, Long> {
    Cliente fetchByIdWithFacturas(Long id);
}
