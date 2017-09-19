

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
                consultaVariavel(palavra);  //variaveis
            } else if (Character.isLetter(palavra.charAt(i))) {
                i++;
                consultaReservada(palavra);  //palavras reservadas

            } else if (palavra.charAt(i) == '#') {
                i++;

                if (palavra.charAt(i) == '#') {
                    i++;
                    comentarioBloco(palavra);
                } else {
                    comentarioLinha(palavra);
                }

            }

        }
    }

    public void comentarioBloco(String palavra) {

        int contaux = 0;
        while (palavra.charAt(i) != '#' && palavra.charAt(i) != '$') {
            
            if(palavra.charAt(i) == '\n'){
                contaux++;
            }
            i++;
        }

        cont = cont + contaux;
        int aux = i + 1;

        if (palavra.charAt(i) == '$') {
            objToken.setLinhaErro(cont);
            objToken.setErro("Erro em comentário de bloco, faltou o fechamento com cerquilhas!");

        } else if (palavra.charAt(aux) != '#') {
            objToken.setLinhaErro(cont);
            objToken.setErro("Erro em comentário de bloco, faltou uma cerquilha!");
            //i++;
            //automato(palavra);
            
            while(palavra.charAt(i) != '$'){
                i++;
            }
            
        }
        
        automato(palavra);

    }

    public void comentarioLinha(String palavra) {

        while (palavra.charAt(i) != '\n') {
            i++;
        }

        cont++;
        i++;

        automato(palavra);

    }

    public void consultaReservada(String palavra) {

        if (Character.isLetter(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;
            proxCaracterReservada(palavra);

        } else {
            identificaTokens(palavra);
        }
    }

    public void consultaVariavel(String palavra) {

        if (Character.isLetter(palavra.charAt(i))) { //variavel deve começar com letra
            token += String.valueOf(palavra.charAt(i));
            i++;
            proxCaracterVariavel(palavra);
        } else {

            objToken.setLinhaErro(cont);
            objToken.setErro("Declaração de variável errada!");
            i++;

            while (Character.isDigit(palavra.charAt(i)) || Character.isLetter(palavra.charAt(i))) {
                i++;
            }

            automato(palavra);
        }
    }

    public void proxCaracterReservada(String palavra) {

        while (Character.isDigit(palavra.charAt(i)) || Character.isLetter(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;
        }

        identificaTokens(palavra);

        automato(palavra);

    }

    public void proxCaracterVariavel(String palavra) {

        while (Character.isDigit(palavra.charAt(i)) || Character.isLetter(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;
        }

        if (token.length() <= 128) {
            objToken.setCodigo(7);
            objToken.setToken(token);
            objToken.setLinha(cont);
        } else {
            objToken.setLinhaErro(cont);
            objToken.setErro("Tamanho máximo da váriavel excedido!");
            i++;
        }

        automato(palavra);

    }

    public void identificaTokens(String palavra) {

        if (token.equals("while")) {

            objToken.setCodigo(1);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("void")) {

            objToken.setCodigo(2);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("string")) {

            objToken.setCodigo(3);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("return")) {

            objToken.setCodigo(4);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("main")) {

            objToken.setCodigo(10);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("integer")) {

            objToken.setCodigo(12);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("inicio")) {

            objToken.setCodigo(13);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("if")) {

            objToken.setCodigo(14);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("for")) {

            objToken.setCodigo(16);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("float")) {

            objToken.setCodigo(17);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("fim")) {

            objToken.setCodigo(18);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("else")) {

            objToken.setCodigo(19);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("do")) {

            objToken.setCodigo(20);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("cout")) {

            objToken.setCodigo(21);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("cin")) {

            objToken.setCodigo(22);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("char")) {

            objToken.setCodigo(23);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else if (token.equals("callfuncao")) {

            objToken.setCodigo(24);
            objToken.setToken(token);
            objToken.setLinha(cont);

        } else {
            objToken.setLinhaErro(cont);
            objToken.setErro("Declaração de variável errada!");
            automato(palavra);

        }

    }

}
