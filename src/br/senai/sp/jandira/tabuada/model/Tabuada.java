package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class Tabuada {
    int multiplicando;
    int multiplicadorInicial;
    int multiplicadorFinal;

    public void receberDadosDoUsuario(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("*****INSIRA OS SEGUINTES DADOS*****");

        System.out.print("Número a ser multiplicado: " );
        multiplicando = leitor.nextInt();

        System.out.print("Multiplicador inicial: " );
        multiplicadorInicial = leitor.nextInt();

        System.out.print("Multiplicador final: " );
        multiplicadorFinal = leitor.nextInt();

        leitor.close();
        System.out.println("RESULTADO");
        validarDadosDoUsuario();
    }
    public void validarDadosDoUsuario(){
        int apoio = 0;

        if (multiplicadorInicial > multiplicadorFinal){
            apoio = multiplicadorFinal;
            multiplicadorFinal = multiplicadorInicial;
            multiplicadorInicial = apoio;
            calcularTabuada();
        }else{
            calcularTabuada();
        }
    }
    public void calcularTabuada(){
        int[] multiplicadores = new int[multiplicadorFinal];

        while (multiplicadorInicial <= multiplicadores.length){
            int resultado = multiplicando * multiplicadorInicial;

            System.out.println(multiplicando + " X " + multiplicadorInicial + " = " + resultado);
            multiplicadorInicial++;
        };
    }
}
