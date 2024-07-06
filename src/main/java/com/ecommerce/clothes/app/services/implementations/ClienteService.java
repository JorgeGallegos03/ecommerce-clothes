package com.ecommerce.clothes.app.services.implementations;

import com.ecommerce.clothes.app.repositories.IClienteRepository;
import com.ecommerce.clothes.app.repositories.entities.Cliente;
import com.ecommerce.clothes.app.services.contracts.IClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ClienteService extends BaseService implements IClienteService {

    private final IClienteRepository repository;

    public ClienteService(IClienteRepository repository) {
        super(ClienteService.class.getName());
        this.repository = repository;
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) this.repository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Cliente findOne(Long id) {
        return this.findById(id);
    }

    @Override
    public void save(Cliente cliente) {
        this.repository.save(cliente);
    }

    @Override
    public Cliente fetchByIdWithFacturas(Long id) {
        return this.repository.fetchByIdWithFacturas(id);
    }
}


