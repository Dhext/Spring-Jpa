package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.dao;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
}
