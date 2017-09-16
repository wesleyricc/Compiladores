

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wesley Ricardo
 */
public class ManipuladorAutomato {

    private int i, cont;
    private String token;
    private gets_sets_Tokens objToken;

    public gets_sets_Tokens getToken(String palavra) {

        i = 0;
        cont = 1;
        objToken = new gets_sets_Tokens();
        automato(palavra);

        return objToken;
    }

    public void automato(String palavra) {

        token = "";
        token += String.valueOf(palavra.charAt(i));

        if (palavra.charAt(i) == ' ') {
            i++;
            automato(palavra);

        } else if (palavra.charAt(i) == '\n') {
            cont++;
            i++;
            automato(palavra);

        } else if (palavra.charAt(i) == '\t') {
            i++;
            automato(palavra);

        } else if (palavra.charAt(i) != '$') {

            if (palavra.charAt(i) == '@') {
                i++;
                consultaLetras(palavra);
            }

        }

    }

    public void consultaLetras(String palavra) {

        if (Character.isLetter(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;
            proxCaracter(palavra);
        } else {

            objToken.setLinhaErro(cont);
            objToken.setErro("Declaração de variável errada!");
            i++;
            conferePalavra(palavra);
        }

    }

    public void conferePalavra(String palavra) {

        if (palavra.charAt(i) == '\n') {

            cont++;
            i++;
            automato(palavra);
        } else if (palavra.charAt(i) != ' ') {

            i++;
            conferePalavra(palavra);

        } else {

            automato(palavra);
        }
    }

    public void proxCaracter(String palavra) {

        while (Character.isDigit(palavra.charAt(i)) || Character.isLetter(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;
        }

        objToken.setCodigo(7);
        objToken.setToken(token);
        objToken.setLinha(cont);
        
        automato(palavra);

    }

    public void identificaToken(String palavra) {

    }

}
