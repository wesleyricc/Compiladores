
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

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

    private int i, cont, contAux;
    private String token;
    private gets_sets_Tokens objToken;
    private boolean verifica = false, confereErro = false;
    private ProducoesCodificadas prodCod = new ProducoesCodificadas();
    private NaoTerminais[] nTerminais;
    private Integer parsing[][];
    private Parsing tabParsing;
    private Stack pilha;
    Integer x, a;
    private List<Integer> prod = new ArrayList<>();

    public ManipuladorAutomato() {

        tabParsing = new Parsing();
        parsing = tabParsing.getParsing();
        pilha = new Stack();
        prodCod.IniciarLista();
        nTerminais = prodCod.getNterminal();
        confereErro = false;

    }

    public void verificaSintatico() {

        x = (Integer) pilha.peek();

        if (objToken.getCodigo().size() > 0) {
            a = objToken.getCodigo().get(objToken.getCodigo().size() - 1);

        } else {
            return;
        }

        objToken.setA(a);
        objToken.setX(x);
        objToken.setPilha(pilha.toString());

        do {

            if (x == 15) {
                pilha.pop();
                objToken.setA(a);
                objToken.setX(x);
                objToken.setPilha(pilha.toString());
                x = (Integer) pilha.peek();

            } else {
                if (x < 48) {
                    if (Objects.equals(x, a)) {

                        pilha.pop();
                        objToken.setA(a);
                        objToken.setX(x);
                        objToken.setPilha(pilha.toString());
                        break;

                    } else {

                        objToken.setLinhaErro(cont);
                        objToken.setErro("Erro Sintático!");
                        confereErro = true;
                        break;   //erro
                    }
                } else {

                    if (parsing[x][a] != null) {

                        int pos = parsing[x][a];

                        pilha.pop();
                        //objToken.setPilha(pilha.toString());

                        prod = nTerminais[pos - 1].getProducao();

                        for (int i = 0; i < prod.size(); i++) {

                            pilha.push(prod.get(i));

                        }

                        x = (Integer) pilha.peek();

                        objToken.setA(a);
                        objToken.setX(x);
                        objToken.setPilha(pilha.toString());

                    } else {

                        objToken.setLinhaErro(cont);
                        objToken.setErro("Inexistente em Parsing!");
                        confereErro = true;

                        System.out.println("Erro!");
                        break;   //erro
                    }
                }
            }
        } while (x != 44);

    }

    public gets_sets_Tokens getToken(String palavra) {

        pilha.clear();
        pilha.push(44);
        pilha.push(48);

        i = 0;
        cont = 1;
        verifica = false;
        confereErro = false;
        objToken = new gets_sets_Tokens();

        automato(palavra);

        return objToken;
    }

    public void automato(String palavra) {

        if (!confereErro) {
            if (token != "$") {
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
                            comentarioBloco(palavra);  //comentarios
                        } else {
                            comentarioLinha(palavra);
                        }

                    } else if (Character.isDigit(palavra.charAt(i))) {
                        i++;
                        consultaDigito(palavra); //inteiro e float

                    } else if (palavra.charAt(i) == '"') {
                        i++;
                        token = "";
                        contAux = cont;
                        consultaAspasDuplas(palavra);

                    } else if (String.valueOf(palavra.charAt(i)).equals("'")) {
                        token = "";
                        contAux = cont;
                        i++;
                        consultaAspas(palavra);

                    } else if (palavra.charAt(i) == '=') {
                        i++;
                        consultaIgual(palavra);

                    } else if (palavra.charAt(i) == '+') {
                        i++;
                        consultaMais(palavra);

                    } else if (palavra.charAt(i) == '-') {
                        i++;
                        consultaMenos(palavra);

                    } else if (palavra.charAt(i) == '>') {
                        i++;
                        consultaMaior(palavra);

                    } else if (palavra.charAt(i) == '<') {
                        i++;
                        consultaMenor(palavra);

                    } else if (palavra.charAt(i) == '!') {
                        i++;
                        consultaExclamacao(palavra);

                    } else if (palavra.charAt(i) == '*') {

                        objToken.setToken(token);
                        objToken.setCodigo(41);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;
                        automato(palavra);

                    } else if (palavra.charAt(i) == '/') {

                        objToken.setCodigo(39);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;
                        automato(palavra);

                    } else if (palavra.charAt(i) == '{') {

                        objToken.setCodigo(36);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;
                        automato(palavra);

                    } else if (palavra.charAt(i) == '}') {

                        objToken.setCodigo(35);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;

                        automato(palavra);

                    } else if (palavra.charAt(i) == '(') {

                        objToken.setCodigo(43);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;

                        automato(palavra);

                    } else if (palavra.charAt(i) == ')') {

                        objToken.setCodigo(42);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;

                        automato(palavra);

                    } else if (palavra.charAt(i) == ',') {

                        objToken.setCodigo(40);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;

                        automato(palavra);

                    } else if (palavra.charAt(i) == ':') {

                        objToken.setCodigo(38);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;

                        automato(palavra);

                    } else if (palavra.charAt(i) == ';') {

                        objToken.setCodigo(37);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        verificaSintatico();
                        i++;

                        automato(palavra);
                    }

                } else {

                    if (verifica) {

                    } else {
                        verifica = true;

                        objToken.setCodigo(44);
                        objToken.setToken(token);
                        objToken.setLinha(cont);
                        //verificaSintatico();
                        System.out.println("Fim");
                    }

                }

            }
        } else {
            return;
        }
    }


    public void consultaLiteral(String palavra) {

        token = "";

        while (palavra.charAt(i) != '!' && palavra.charAt(i) != '$') {

            token += String.valueOf(palavra.charAt(i));

            if (palavra.charAt(i) == '\n') {
                cont++;
            }

            i++;
        }

        if (palavra.charAt(i) == '$') {

            objToken.setLinhaErro(cont);
            objToken.setErro("Erro léxico no Literal, faltou fechamento com exclamação!");

        }
        if (palavra.charAt(i) == '!') {

            objToken.setCodigo(11);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

            i++;
            automato(palavra);
        }

    }

    public void consultaExclamacao(String palavra) {

        if (palavra.charAt(i) == '=') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(45);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else if (Character.isLetter(palavra.charAt(i))) {
            consultaLiteral(palavra);

        } else {

            objToken.setLinhaErro(cont);
            objToken.setErro("Caracter não incluso na lista de Tokens!");
            i++;

        }

    }

    public void consultaMaior(String palavra) {

        if (palavra.charAt(i) == '>') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(25);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else if (palavra.charAt(i) == '=') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(26);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else {

            objToken.setCodigo(27);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            //i++;

            automato(palavra);
        }

    }

    public void consultaMenor(String palavra) {

        if (palavra.charAt(i) == '<') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(31);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else if (palavra.charAt(i) == '=') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(30);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else {

            objToken.setCodigo(32);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            //i++;

            automato(palavra);
        }

    }

    public void consultaIgual(String palavra) {

        if (palavra.charAt(i) == '=') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(28);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else {

            objToken.setCodigo(29);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            automato(palavra);
        }

    }

    public void consultaMenos(String palavra) {

        if (palavra.charAt(i) == '-') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(46);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else {

            objToken.setCodigo(47);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            automato(palavra);
        }

    }

    public void consultaMais(String palavra) {

        if (palavra.charAt(i) == '+') {

            token += String.valueOf(palavra.charAt(i));
            objToken.setCodigo(33);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            i++;
            automato(palavra);

        } else {

            objToken.setCodigo(34);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
            automato(palavra);
        }

    }

    public void consultaAspas(String palavra) {

        if (Character.isLetter(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;

            if (String.valueOf(palavra.charAt(i)).equals("'")) {

                objToken.setCodigo(8);
                objToken.setToken(token);
                objToken.setLinha(cont);
                verificaSintatico();

                i++;
                automato(palavra);

            } else {
                objToken.setLinhaErro(cont);
                objToken.setErro("Erro em char!");

            }

        }

    }

    public void consultaAspasDuplas(String palavra) {

        if (palavra.charAt(i) == '@') {
            objToken.setLinhaErro(contAux);
            objToken.setErro("Erro em nome de String!");

        }

        while (palavra.charAt(i) != '"' && palavra.charAt(i) != '$') {
            token += String.valueOf(palavra.charAt(i));

            if (palavra.charAt(i) == '\n') {
                cont++;
            }
            i++;
        }

        if (palavra.charAt(i) == '$') {

            objToken.setLinhaErro(cont);
            objToken.setErro("Erro String! Faltou fechamento com aspas duplas!");
        }
        if (palavra.charAt(i) == '"') {

            if (token.length() < 128) {
                objToken.setCodigo(9);
                objToken.setToken(token);
                objToken.setLinha(contAux);
                verificaSintatico();

            } else {
                objToken.setLinhaErro(cont);
                objToken.setErro("Tamanho de String maior que o permitido!");
            }

            i++;
            automato(palavra);
        }

    }

    public void consultaDigito(String palavra) {

        while (Character.isDigit(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;
        }

        if (palavra.charAt(i) == ',') {
            token += String.valueOf(palavra.charAt(i));
            i++;
            consultaDigitoFloat(palavra);
        } else {

            if (token.length() < 10) {
                objToken.setCodigo(5);
                objToken.setToken(token);
                objToken.setLinha(cont);
                verificaSintatico();
            } else {
                objToken.setLinhaErro(cont);
                objToken.setErro("Tamanho do Integer maior que o permitido!");
            }

            automato(palavra);
        }

    }

    public void consultaDigitoFloat(String palavra) {

        while (Character.isDigit(palavra.charAt(i))) {
            token += String.valueOf(palavra.charAt(i));
            i++;
        }

        if (token.length() < 15) {
            objToken.setCodigo(6);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();
        } else {
            objToken.setLinhaErro(cont);
            objToken.setErro("Tamanho do Float maior que o permitido!");
        }

        automato(palavra);

    }

    public void comentarioBloco(String palavra) {

        int contaux = cont;

        while (palavra.charAt(i) != '#' && palavra.charAt(i) != '$') {

            if (palavra.charAt(i) == '\n') {
                cont++;
            }
            i++;
        }

        if (palavra.charAt(i) == '$') {
            objToken.setLinhaErro(contaux);
            objToken.setErro("Erro em comentário de bloco, faltou o fechamento com cerquilhas!");

        } else if (palavra.charAt(i + 1) == '#') {
            i++;
            automato(palavra);
        } else {

            objToken.setLinhaErro(cont);
            objToken.setErro("Erro em comentário de bloco, faltou uma cerquilha!");
            //i++;
            //automato(palavra);

            while (palavra.charAt(i) != '$') {
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
            verificaSintatico();
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
            verificaSintatico();

        } else if (token.equals("void")) {

            objToken.setCodigo(2);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("string")) {

            objToken.setCodigo(3);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("return")) {

            objToken.setCodigo(4);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("main")) {

            objToken.setCodigo(10);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("integer")) {

            objToken.setCodigo(12);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("inicio")) {

            objToken.setCodigo(13);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("if")) {

            objToken.setCodigo(14);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("for")) {

            objToken.setCodigo(16);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("float")) {

            objToken.setCodigo(17);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("fim")) {

            objToken.setCodigo(18);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("else")) {

            objToken.setCodigo(19);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("do")) {

            objToken.setCodigo(20);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("cout")) {

            objToken.setCodigo(21);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("cin")) {

            objToken.setCodigo(22);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("char")) {

            objToken.setCodigo(23);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else if (token.equals("callfuncao")) {

            objToken.setCodigo(24);
            objToken.setToken(token);
            objToken.setLinha(cont);
            verificaSintatico();

        } else {
            objToken.setLinhaErro(cont);
            objToken.setErro("Caracter não identificado!");
            automato(palavra);

        }

    }

}
