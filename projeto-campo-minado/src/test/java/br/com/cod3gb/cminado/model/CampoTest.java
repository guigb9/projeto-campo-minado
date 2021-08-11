package br.com.cod3gb.cminado.model;

import br.com.cod3gb.cminado.exception.ExplosaoException;
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

    @Test
    void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());
    }


    @Test
    void testeAlternarMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacaoDuasChamadas(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAbrirCampoNaoMinadoNaoMarcado(){
        assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirNaoMinadoMarcado(){
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoNaoMarcado(){
        campo.minar();
        assertThrows(ExplosaoException.class, () -> campo.abrir());
    }

    @Test
    void testeAbrirComVizinhos(){
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);

        campo22.adicionarVizinhos(campo11);

        campo.adicionarVizinhos(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testeAbrirComVizinhosMinado(){
        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 2);
        Campo campo22 = new Campo(2, 2);
        campo12.minar();

        campo22.adicionarVizinhos(campo11);
        campo22.adicionarVizinhos(campo12);

        campo.adicionarVizinhos(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && !campo11.isAberto());
    }

    //Testes do tostring
    @Test
    void testeCampoMarcadoToString(){
        campo.alternarMarcacao();
        assertEquals("x", campo.toString());
    }

}