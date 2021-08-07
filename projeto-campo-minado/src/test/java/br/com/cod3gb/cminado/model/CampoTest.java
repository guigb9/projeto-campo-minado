package br.com.cod3gb.cminado.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTest {
    private Campo campo;

    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3, 3);
    }
    @Test
    void testeVizinhoRealDistancia1Esquerda(){
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Direita(){
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Cima(){
        Campo vizinho = new Campo(2, 3);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Baixo(){
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2DiagonalCimaDireita(){
        Campo vizinho = new Campo(2, 4);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2DiagonalCimaEsquerda(){
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2DiagonalBaixoDireita(){
        Campo vizinho = new Campo(4, 4);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2DiagonalBaixoEsquerda(){
        Campo vizinho = new Campo(4, 2);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoFalso(){
        Campo vizinho = new Campo(1, 2);
        boolean resultado = campo.adicionarVizinhos(vizinho);
        assertFalse(resultado);
    }
}