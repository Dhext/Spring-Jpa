package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.controllers;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.dao.IClienteDao;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import javax.validation.Valid;

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
    @GetMapping("/form")
    public String crear(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("titulo","Fomulario de Cliente");
        model.addAttribute("cliente",cliente);
        return "form";
    }
    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("titulo","Fomulario de Cliente");
            return "form";
        }
        clienteDao.save(cliente);
        return "redirect:listar";
    }
}
