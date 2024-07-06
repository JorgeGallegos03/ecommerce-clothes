package com.ecommerce.clothes.app.services.implementations;

import com.ecommerce.clothes.app.repositories.IProductoRepository;
import com.ecommerce.clothes.app.repositories.entities.Producto;
import com.ecommerce.clothes.app.services.contracts.IProductoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductoService extends BaseService implements IProductoService {

    private final IProductoRepository repository;

    public ProductoService(IProductoRepository repository) {
        super(ProductoService.class.getName());
        this.repository = repository;
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Page<Producto> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public List<Producto> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Producto findOne(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        this.repository.save(producto);
    }

    @Override
    public List<Producto> findByName(String name) {
        return this.repository.findByNombre(name);
    }
}


