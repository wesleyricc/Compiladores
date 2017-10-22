/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wesley Ricardo
 */

import java.util.ArrayList;
import java.util.List;


public class NaoTerminais {
    
    private Integer NaoTerminais;
    
    private List<Integer> producao =  new ArrayList<>();

    public Integer getNaoTerminais() {
        return NaoTerminais;
    }

    public void setNaoTerminais(Integer NaoTerminais) {
        this.NaoTerminais = NaoTerminais;
    }

    public List<Integer> getProducao() {
        return producao;
    }

    public void setProducao(Integer producao) {
        this.producao.add(producao);
    }
}

