package br.com.javamagazine.clinicajm.controller;

import br.com.javamagazine.clinicajm.domain.Consulta;
import br.com.javamagazine.clinicajm.domain.Medico;
import br.com.javamagazine.clinicajm.domain.Paciente;
import br.com.javamagazine.clinicajm.domain.enums.Especialidade;
import br.com.javamagazine.clinicajm.service.ConsultaService;
import br.com.javamagazine.clinicajm.service.MedicoService;
import br.com.javamagazine.clinicajm.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("consultas", consultaService.recuperar());
        return new ModelAndView("/consulta/list_consulta", model);
    }

    @GetMapping("/atender")
    public ModelAndView atender(ModelMap model) {
        //model.addAttribute("consultas", consultaService.recuperar());
        return new ModelAndView("/consulta/atendimento_consulta", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("consulta") Consulta consulta) {
        return "/consulta/add_consulta";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("consulta") Consulta consulta, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/consulta/add_consulta";
        }

        consultaService.salvar(consulta);
        attr.addFlashAttribute("mensagem", "Consulta salva com sucesso.");
        return "redirect:/consultas/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Consulta consulta = consultaService.recuperarPorId(id);
        model.addAttribute("consulta", consulta);
        return new ModelAndView("/consulta/add", model);
    }

    @PutMapping("/salvar")
    public String atualizar(@Valid @ModelAttribute("consulta") Consulta consulta, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/consulta/add_consulta";
        }

        consultaService.atualizar(consulta);
        attr.addFlashAttribute("mensagem", "Consulta atualizada com sucesso.");
        return "redirect:/consultas/listar";
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
        consultaService.excluir(id);
        attr.addFlashAttribute("mensagem", "Consulta excluída com sucesso.");
        return "redirect:/consultas/listar";
    }

}
