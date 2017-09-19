

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

public class gets_sets_Tokens {

    private final List<Integer> listcod = new ArrayList<>();
    private final List<Integer> listlinha = new ArrayList<>();
    private final List<String> listtoken = new ArrayList<>();
    private final List<Integer> erro_linha = new ArrayList<>();
    private final List<String> erro_desc = new ArrayList<>();

    
    public List<Integer> getCodigo() {
        return listcod;
    }

    public List<Integer> getErro_linha() {
        return erro_linha;
    }

    public List<String> getErro_desc() {
        return erro_desc;
    }

    public void setLinhaErro(Integer linha) {

        this.erro_linha.add(linha);

    }

    public void setErro(String Token) {

        this.erro_desc.add(Token);

    }

    public void setCodigo(Integer Codigo) {

        this.listcod.add(Codigo);

    }

    public List<Integer> getLinha() {
        return listlinha;
    }

    public void setLinha(Integer Linha) {

        this.listlinha.add(Linha);

    }

    public List<String> getToken() {
        return listtoken;
    }

    public void setToken(String Token) {

        this.listtoken.add(Token);

    }
}
