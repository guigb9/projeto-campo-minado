package br.com.cod3gb.cminado.model;


import br.com.cod3gb.cminado.exception.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    private final int linha;
    private final int coluna;

    private boolean aberto;
    private boolean minado = false;
    private boolean marcado = false;


    private List<Campo> vizinhos;

    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        vizinhos = new ArrayList<>();
    }

    public boolean adicionarVizinhos(Campo vizinho){
        boolean linhaDiferente = this.linha != vizinho.linha;
        boolean colunaDiferente = this.coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(this.linha - vizinho.linha);
        int deltaColuna = Math.abs(this.coluna - vizinho.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        if(deltaGeral == 1 && !diagonal){
            vizinhos.add(vizinho);
            return true;
        }else if(deltaGeral == 2 && diagonal){
            vizinhos.add(vizinho);
            return true;
        }
        return false;
    }

    public void alternarMarcacao(){
        if(!aberto){
            marcado = !marcado;
        }
    }

    public boolean abrir(){
        if(!aberto && !marcado){
            aberto = true;

            if(minado){
                throw new ExplosaoException();
            }
            if(vizinhancaSegura()){
                vizinhos.forEach(v ->v.abrir());
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean vizinhancaSegura(){
        return vizinhos.stream().noneMatch(v -> v.minado);
    }

    public boolean isMarcado(){
        return marcado;
    }

    public void minar(){
        minado = true;
    }

    public boolean isAberto(){
        return aberto;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    boolean objetivoAlcancado(){
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    long minasNaVizinhanca(){
        return vizinhos.stream().filter(v -> v.minado).count();
    }

    void reiniciar(){
        aberto = false;
        minado = false;
        marcado = false;
    }



    public boolean isMinado(){
        return minado;
    }


    public String toString(){
        if(marcado){
            return "x";
        }else if(aberto && minado){
            return "*";
        }else if(aberto && minasNaVizinhanca() > 0){
            return Long.toString(minasNaVizinhanca());
        }else if(aberto){
            return " ";
        }else{
            return "?";
        }
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
}
