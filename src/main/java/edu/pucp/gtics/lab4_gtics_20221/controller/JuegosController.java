package edu.pucp.gtics.lab4_gtics_20221.controller;

import edu.pucp.gtics.lab4_gtics_20221.entity.*;
import edu.pucp.gtics.lab4_gtics_20221.repository.*;
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
@RequestMapping("/juegos")
public class JuegosController {

    @Autowired
    JuegosRepository juegosRepository;

    @Autowired
    PlataformasRepository plataformasRepository;

    @Autowired
    DistribuidorasRepository distribuidorasRepository;

    @Autowired
    GenerosRepository generosRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"","/lista"})
    public String listaJuegos (Model model){
        model.addAttribute("listaJuegos", juegosRepository.findAll());
        model.addAttribute("listaPlataforma", plataformasRepository.findAll());
        model.addAttribute("listaDistribuidora", distribuidorasRepository.findAll());
        return "juegos/lista";
    }

    @GetMapping("/vista")
    public String vistaJuegos(Model model){
        model.addAttribute("listajuegos", juegosRepository.findAll());
        return "juegos/vista";
    }

    @GetMapping("/nuevo")
    public String nuevoJuegos(@ModelAttribute ("juegos") Juegos juegos, Model model){
        model.addAttribute("listadistribuidoras", distribuidorasRepository.findAll());
        model.addAttribute("listageneros", generosRepository.findAll());
        model.addAttribute("listaplataformas", plataformasRepository.findAll());
        return "juegos/editarFrm";
    }

    @GetMapping("/editar")
    public String editarJuegos(@ModelAttribute("juegos") Juegos juegos, @RequestParam("idjuego") int idjuego, Model model){
        Optional<Juegos> juegosOptional = juegosRepository.findById(idjuego);
        if(juegosOptional.isPresent()){
            juegos = juegosOptional.get();
            model.addAttribute("juegos", juegos);
            model.addAttribute("listadistribuidoras", distribuidorasRepository.findAll());
            model.addAttribute("listageneros", generosRepository.findAll());
            model.addAttribute("listaplataformas", plataformasRepository.findAll());
            return "juegos/editarFrm";
        }else{
            return "redirect:/juegos/lista";
        }
    }

    @PostMapping("/guardar")
    public String guardarJuegos(@ModelAttribute("juegos") @Valid Juegos juegos, BindingResult bindingResult,
                                RedirectAttributes attr, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listadistribuidoras", distribuidorasRepository.findAll());
            model.addAttribute("listageneros", generosRepository.findAll());
            model.addAttribute("listaplataformas", plataformasRepository.findAll());
            return "juegos/editarFrm";
        } else {
            if (juegos.getIdjuego() == 0) {
                attr.addFlashAttribute("msg1", "Juego creado exitosamente");
                juegosRepository.save(juegos);
                return "redirect:/juegos/lista";
            } else {
                juegosRepository.save(juegos);
                attr.addFlashAttribute("msg2", "Juego actualizado exitosamente");
                return "redirect:/juegos/lista";
            }
        }
    }

    @GetMapping("/borrar")
    public String borrarJuegos(@RequestParam("idjuego") int idjuego, RedirectAttributes attr){
        Optional<Juegos> opt = juegosRepository.findById(idjuego);
        if (opt.isPresent()) {
            juegosRepository.deleteById(idjuego);
            attr.addFlashAttribute("msg3", "Juego borrado exitosamente");
        }
        return "redirect:/juegos/lista";
    }

}
