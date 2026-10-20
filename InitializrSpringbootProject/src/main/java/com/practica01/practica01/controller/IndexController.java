package com.practica01.practica01.controller;

import com.practica01.practica01.service.SuculentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class IndexController {
    
    // Las últimas versiones de Spring, recomiendan utilziar final y contructor en lugar de @autowired
    private final SuculentaService suculentaService;
    
    // (Spring inyecta automáticamente)
    public IndexController(SuculentaService suculentaService) {
        this.suculentaService = suculentaService;
    }
    
    @GetMapping("/")
    public String cargarPaginaInicio(Model model) {
        var lista = suculentaService.getSuculentas();
        model.addAttribute("suculentas", lista);
        model.addAttribute("totalSuculentas", lista.size());
        var familias = suculentaService.getFamilias();
        model.addAttribute("familias", familias);
        return "/index";
    }
    
     @GetMapping("/consultas/{familia}")
    public String listado(@PathVariable("familia") String familia, Model model) {
        model.addAttribute("familiaActual", familia);
        var lista = suculentaService.getSuculentasPorFamilia(familia);
        model.addAttribute("suculentas", lista);
        model.addAttribute("totalSuculentas", suculentaService.getSuculentas().size());
        var familias = suculentaService.getFamilias();
        model.addAttribute("familias", familias);
        return "/index";
    }
}
