
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author comp15
 */
public class Semantico {

    private List<String> nome = new ArrayList<>();
    private List<String> nomeFuncaoRecebe = new ArrayList<>();
    private List<String> ParamFuncaoRecebe = new ArrayList<>();
    private List<String> tipoFuncaoRetorna = new ArrayList<>();
    private List<String> categoria = new ArrayList<>();
    private List<String> tipo = new ArrayList<>();
    private List<String> nivel = new ArrayList<>();

    public List<String> getTipoFuncaoRetorna() {
        return tipoFuncaoRetorna;
    }

    public void setTipoFuncaoRetorna(List<String> tipoFuncaoRetorna) {
        this.tipoFuncaoRetorna = tipoFuncaoRetorna;
    }

    
    
    
    public List<String> getNomeFuncaoRecebe() {
        return nomeFuncaoRecebe;
    }

    public void setNomeFuncaoRecebe(String nomeFuncaoRecebe) {
        this.nomeFuncaoRecebe.add(nomeFuncaoRecebe);
    }

    public void setParamFuncaoRecebe(List<String> ParamFuncaoRecebe) {
        this.ParamFuncaoRecebe = ParamFuncaoRecebe;
    }

    public List<String> getParamFuncaoRecebe() {
        return ParamFuncaoRecebe;
    }

    public Semantico() {
    }




    public List<String> getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.add(nome);
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria.add(categoria);
    }

    public List<String> getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.add(tipo);
    }

    public List<String> getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel.add(nivel);
    }

}
