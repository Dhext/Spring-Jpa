package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.controllers;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.dao.IClienteDao;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.entity.Cliente;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.models.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo","listado clientes");
        model.addAttribute("clientes",clienteService.findAll());
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
        clienteService.save(cliente);
        return "redirect:listar";
    }
    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") long id, Model model){
        Cliente cliente=null;
        if(id>0){
            cliente =clienteService.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.addAttribute(cliente);

        return "form";
    }
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if (id>0){
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }

}
