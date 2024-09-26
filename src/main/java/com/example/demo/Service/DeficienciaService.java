package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.BairroRepository;
import com.example.demo.Repository.CidadeRepository;
import com.example.demo.Repository.EnderecoRepository;
import com.example.demo.Repository.DeficienciaRepository;


@Service
public class DeficienciaService {

    @Autowired
    private DeficienciaRepository deficienciaRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Deficiencia> findAll(){
        return deficienciaRepository.findAll();
    }

    /*public Deficiencia create(DeficienciaForm deficienciaForm){
        Deficiencia deficiencia = new Deficiencia();

        deficiencia.setNome(deficienciaForm.getNome());
        deficiencia.setNascimento(deficienciaForm.getNascimento());
        deficiencia.setDeficiencia(deficienciaForm.getDeficiencia());

        Sexo sexo = Sexo.fromCodigo(deficienciaForm.getSexo());
        deficiencia.setSexo(sexo);


    }*/

}
