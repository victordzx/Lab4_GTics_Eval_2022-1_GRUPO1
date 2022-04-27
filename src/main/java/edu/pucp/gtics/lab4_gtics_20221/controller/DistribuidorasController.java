package edu.pucp.gtics.lab4_gtics_20221.controller;

import edu.pucp.gtics.lab4_gtics_20221.entity.Distribuidoras;
import edu.pucp.gtics.lab4_gtics_20221.entity.Juegos;
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


    @GetMapping("/editar")
    public String editarDistribuidoras(@ModelAttribute("distribuidoras") Distribuidoras distribuidoras , @RequestParam("iddistribuidora") int iddistribuidora, Model model){
        Optional<Distribuidoras> distribuidorasOptional = distribuidorasRepository.findById(iddistribuidora);
        if(distribuidorasOptional.isPresent()){
            distribuidoras = distribuidorasOptional.get();
            model.addAttribute("distribuidoras", distribuidoras);
            model.addAttribute("listaDistribuidoras", distribuidorasRepository.findAll());
            model.addAttribute("listaPaises", paisesRepository.findAll());
            return "distribuidoras/editarFrm";
        }else{
            return "redirect:/distribuidoras/lista";
        }
    }

    @GetMapping("/nuevo")
    public String nuevaDistribuidora(@ModelAttribute("distribuidoras") Distribuidoras distribuidoras, Model model ){
        model.addAttribute("listaDistribuidoras", distribuidorasRepository.findAll());
        model.addAttribute("listaPaises", paisesRepository.findAll());
        return "distribuidoras/editarFrm";
    }

    @PostMapping("/guardar")
    public String guardarDistribuidora(@ModelAttribute("distribuidoras") @Valid Distribuidoras distribuidoras, BindingResult bindingResult,
                                       RedirectAttributes attr, Model model ){
        if (bindingResult.hasErrors()) {
            model.addAttribute("listaDistribuidoras", distribuidorasRepository.findAll());
            model.addAttribute("listaPaises", paisesRepository.findAll());
            return "distribuidoras/editarFrm";
        } else {
            if (distribuidoras.getIddistribuidora() == 0) {
                attr.addFlashAttribute("msg1", "Distribuidora creado exitosamente");
                distribuidorasRepository.save(distribuidoras);
                return "redirect:/distribuidoras/lista";
            } else {
                distribuidorasRepository.save(distribuidoras);
                attr.addFlashAttribute("msg2", "Distribuidora actualizado exitosamente");
                return "redirect:/distribuidoras/lista";
            }
        }
    }

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("id") int id, RedirectAttributes attr){
        Optional<Distribuidoras> opt = distribuidorasRepository.findById(id);
        if (opt.isPresent()) {
            distribuidorasRepository.deleteById(id);
        }
        attr.addFlashAttribute("msg", "Distribuidora borrada exitosamente");
        return "redirect:/distribuidoras/lista";
    }

}
