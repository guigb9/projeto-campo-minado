package br.com.cod3gb.cminado.model;

import br.com.cod3gb.cminado.view.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args){
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 4);
        System.out.println(tabuleiro.objetivoAlcancado());
        new TabuleiroConsole(tabuleiro);
    }
}
