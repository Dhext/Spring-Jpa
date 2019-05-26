package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.dao;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteDaoImpl {
   /* @PersistenceContext
    private EntityManager em;
    @SuppressWarnings("unchecked")

    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public void save(Cliente cliente) {
        if(cliente.getId()!=null&&cliente.getId()>0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }

    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void delete(Long id) {
        Cliente cliente = findOne(id);
        em.remove(cliente);
    }*/
}
