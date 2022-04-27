package edu.pucp.gtics.lab4_gtics_20221.controller;

import edu.pucp.gtics.lab4_gtics_20221.entity.Distribuidoras;
import edu.pucp.gtics.lab4_gtics_20221.entity.Paises;
import edu.pucp.gtics.lab4_gtics_20221.repository.DistribuidorasRepository;
import edu.pucp.gtics.lab4_gtics_20221.repository.PaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/distribuidoras")
public class DistribuidorasController {

    @Autowired
    DistribuidorasRepository distribuidorasRepository;

    @Autowired
    PaisesRepository paisesRepository;


    @GetMapping(value = {"/lista"})
    public String listaDistribuidoras(Model model) {
        model.addAttribute("listaDistribuidoras", distribuidorasRepository.findAll());
        model.addAttribute("listaPaises", paisesRepository.findAll());

        return "distribuidoras/lista";
    }



    public void editarDistribuidoras(){

    }

    public String nuevaDistribuidora(@ModelAttribute("distribuidoras") Distribuidoras distribuidoras, Model model ){
        model.addAttribute("listaDistribuidoras", distribuidorasRepository.findAll());
        model.addAttribute("listaPaises", paisesRepository.findAll());
        return "distribuidoras/form";
    }

    public void guardarDistribuidora( ){

    }

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("id") int id){
        Optional<Distribuidoras> opt = distribuidorasRepository.findById(id);
        if (opt.isPresent()) {
            distribuidorasRepository.deleteById(id);
        }
        return "redirect:/distribuidoras/lista";
    }

}
