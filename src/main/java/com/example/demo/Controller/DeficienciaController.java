package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import com.example.demo.Form.Deficiencia.DeficienciaForm;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.DeficienciaRepository;


    @Controller
public class DeficienciaController {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @GetMapping("/deficiencia")
    public String index(Model model, @RequestParam("display") Optional<String> display){
        String finalDisplay = display.orElse("true");


        List<Deficiencia> deficiencias = deficienciaRepository.findByAtivo(Boolean.valueOf(finalDisplay));

        model.addAttribute("deficiencias", deficiencias);
        

        return "deficiencia/listar";
    }

    @GetMapping("/deficiencia/create")
    public String create(Model model) {
        DeficienciaForm deficienciaForm = new DeficienciaForm();

        List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();
        deficienciaForm.setListDeficiencias(listaDeficiencias);

        model.addAttribute("deficienciaForm",deficienciaForm);

        return "deficiencia/create";
    }

    
    @PostMapping("/deficiencia/create")
    public String create(@Validated DeficienciaForm deficienciaForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        
        List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();
        deficienciaForm.setListDeficiencias(listaDeficiencias);


        model.addAttribute("deficienciaForm",deficienciaForm);
        
        if(bindingResult.hasErrors()){
            ((RedirectAttributes) model).addAttribute("errors", bindingResult.getAllErrors());
            return "/deficiencia/create";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Salvo com sucesso!");
        
        /*deficienciaRepository.save(deficienciaForm.toEntity());*/
        
        return "redirect:/deficiencia";
    }

    @GetMapping("/deficiencia/update/{id}")
    public String update(@PathVariable Long id, Model model ){
        Optional<Deficiencia> deficiencia = deficienciaRepository.findById(id);

        DeficienciaForm deficienciaForm = new DeficienciaForm(deficiencia.get());

        model.addAttribute("deficienciaForm", deficienciaForm);
        model.addAttribute("id", deficiencia.get().getId());

        
        return "/deficiencia/update";

    }

    @GetMapping("/deficiencia/visualizar/{id}")
    public String visualizar(@PathVariable Long id, Model model ){
        Optional<Deficiencia> deficiencia = deficienciaRepository.findById(id);

        DeficienciaForm deficienciaForm = new DeficienciaForm(deficiencia.get());

        model.addAttribute("deficienciaForm", deficienciaForm);
        model.addAttribute("id", deficiencia.get().getId());

        
        return "/deficiencia/visualizar";
    }

    @PostMapping("/deficiencia/update/{id}")
    public String update(
    @PathVariable Long id, 
    @Valid DeficienciaForm deficienciaForm, 
    BindingResult bindingResult, 
    Model model,
    RedirectAttributes redirectAttributes
    ){

        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/deficiencia/update";
        }

        /*Deficiencia deficiencia = deficienciaForm.toEntity();
        deficiencia.setId(id);*/

        /*redirectAttributes.addFlashAttribute("successMessage","Alterado com sucesso");
        this.deficienciaRepository.save(deficiencia);*/

        return "redirect:/deficiencia";
    }

    @GetMapping("/deficiencia/remover/{id}")
        public String remover(@PathVariable Long id, RedirectAttributes redirectAttributes){
            Optional<Deficiencia> deficiencia = this.deficienciaRepository.findById(id);
            Deficiencia deficienciaModel = deficiencia.get();

            if(deficienciaModel.isAtivo()){
                deficienciaModel.setAtivo(false);
                redirectAttributes.addFlashAttribute("successMessage", "Excluido com sucesso");
            }else{deficienciaModel.setAtivo((true));
            redirectAttributes.addFlashAttribute("succesMessage","Excluido com sucesso");
        }

            deficienciaModel.setAtivo(false);

            this.deficienciaRepository.save(deficienciaModel);

            redirectAttributes.addFlashAttribute("successMessage","Excluido com sucesso");

            return "redirect:/deficiencia";
        }
    
}
