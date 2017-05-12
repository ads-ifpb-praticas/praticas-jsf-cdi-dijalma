package br.ifpb.edu.br.repository;

import br.ifpb.edu.br.interfaces.Dao;
import br.ifpb.edu.br.models.Cliente;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank">dijalma</a> on 11/05/17.
 */
@RequestScoped
public class RepositorioCliente implements Dao<Cliente> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Cliente save(Cliente obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public Cliente edit(Cliente obj) {
        return em.merge(obj);
    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);
        return query.getResultList();
    }

    @Override
    public boolean remove(Cliente obj) {
        try {
            em.remove(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
