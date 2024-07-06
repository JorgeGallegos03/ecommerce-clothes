package com.ecommerce.clothes.app.view.xml;

import com.ecommerce.clothes.app.repositories.entities.Cliente;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "clientes")
public class ClienteList {

    @XmlElement(name = "cliente")
    public List<Cliente> clientes;

    public ClienteList() {
    }


    public ClienteList(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }


}
