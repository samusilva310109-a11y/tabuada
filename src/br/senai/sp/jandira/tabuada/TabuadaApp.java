package br.senai.sp.jandira.tabuada;

import br.senai.sp.jandira.tabuada.model.Tabuada;

public class TabuadaApp {
    public static void main(String[] args) {
        System.out.println("Inicializando...");

        Tabuada starter = new Tabuada();
        starter.receberDadosDoUsuario();
    }
}
