package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Form.Deficiencia.DeficienciaForm;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;

@Service
public class DeficienciaService {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Deficiencia create(DeficienciaForm deficienciaForm){
        //ENTIDADE deficiencia
        Deficiencia deficiencia = new Deficiencia();
        
        deficiencia.setNome(deficienciaForm.getNome());
        deficiencia.setCategoria(deficienciaForm.getCategoria());

        deficienciaRepository.save(deficiencia);

        return deficiencia;
    }

    public Deficiencia update(DeficienciaForm deficienciaForm, Long id){

        Deficiencia deficiencia = this.deficienciaRepository.findById(id).orElseThrow();

        deficiencia.setNome(deficienciaForm.getNome());
        deficiencia.setCategoria(deficienciaForm.getCategoria());

        deficienciaRepository.save(deficiencia);

        return deficiencia;
    }
}
