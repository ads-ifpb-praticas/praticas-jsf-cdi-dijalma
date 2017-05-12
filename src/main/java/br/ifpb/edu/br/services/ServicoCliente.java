package br.ifpb.edu.br.services;

import br.ifpb.edu.br.models.Cliente;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank">dijalma</a> on 11/05/17.
 */
@RequestScoped
public class ServicoCliente {

    @Inject
    private ServicoCliente servicoCliente;

    public Cliente salvar(Cliente cliente) {
        return servicoCliente.salvar(cliente);
    }

    public Cliente editar(Cliente cliente) {
        return servicoCliente.editar(cliente);
    }

    public Cliente findOne(Long id) {
        return servicoCliente.findOne(id);
    }

    public List<Cliente> findAll() {
        return servicoCliente.findAll();
    }

    public boolean remove(Cliente cliente) {
        return servicoCliente.remove(cliente);
    }
}
