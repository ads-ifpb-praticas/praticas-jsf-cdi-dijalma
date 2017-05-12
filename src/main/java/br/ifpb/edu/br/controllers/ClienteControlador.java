package br.ifpb.edu.br.controllers;

import br.ifpb.edu.br.models.Cliente;
import br.ifpb.edu.br.services.ServicoCliente;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank">dijalma</a> on 11/05/17.
 */
@Named
@ViewScoped
public class ClienteControlador {

    private Cliente cliente;
    @Inject
    private ServicoCliente servicoCliente;

    public ClienteControlador() {
        this.cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void salvar() {
        Cliente clienteResult = servicoCliente.salvar(this.cliente);
        if (clienteResult.getId() != null) {
            showMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro cliente!", "Não foi possível cadastrar o cliente"));
        } else {
            showMessage(new FacesMessage("Cliente cadastrado"));
        }
    }

    public void atualizar(Cliente cliente) {
        Cliente clienteResult = servicoCliente.editar(cliente);

        if (clienteResult.getId() != null) {
            showMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro cliente!", "Não foi possível atualizar o cliente"));
        } else {
            showMessage(new FacesMessage("Cliente atualizado!"));
        }
    }

    public void remover(Cliente cliente) {
        boolean remove = servicoCliente.remove(cliente);
        if (remove) {
            showMessage(new FacesMessage("Cliente removido"));
        } else {
            showMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cliente!", "Não foi possível remover o cliente!"));
        }
    }

    public List<Cliente> listarTodos() {
        return servicoCliente.findAll();
    }

    public void findOne(Long id) {
        this.cliente = servicoCliente.findOne(id);
    }

    private void showMessage(FacesMessage message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }
}
