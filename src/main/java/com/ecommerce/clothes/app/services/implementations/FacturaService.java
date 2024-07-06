package com.ecommerce.clothes.app.services.implementations;

import com.ecommerce.clothes.app.repositories.IFacturaRepository;
import com.ecommerce.clothes.app.repositories.entities.Factura;
import com.ecommerce.clothes.app.services.contracts.IFacturaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class FacturaService extends BaseService implements IFacturaService {

    private final IFacturaRepository repository;

    public FacturaService(IFacturaRepository repository) {
        super(FacturaService.class.getName());
        this.repository = repository;
    }

    @Override
    public Factura fetchFacturaByIdWithClienteWithItemFacturaWithProducto(Long id) {
        return this.repository.fetchByIdWithClienteWhithItemFacturaWithProducto(id);
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Page<Factura> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public List<Factura> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Factura findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Factura findOne(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void save(Factura factura) {
        this.repository.save(factura);
    }
}


