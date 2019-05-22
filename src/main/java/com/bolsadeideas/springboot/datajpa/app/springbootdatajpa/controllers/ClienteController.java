package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.controllers;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.dao.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @Autowired
    private IClienteDao clienteDao;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo","listado clientes");
        model.addAttribute("clientes",clienteDao.findAll());
        return "listar";
    }
}
