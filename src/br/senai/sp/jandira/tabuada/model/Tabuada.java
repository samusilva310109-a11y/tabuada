package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class Tabuada {
    public int multiplicando;
    public int multiplicadorInicial;
    public int multiplicadorFinal;
    String[] tabuada;

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
    }
    public String[] calcularTabuada(){
        int apoio = 0;

        if (multiplicadorInicial > multiplicadorFinal){
            apoio = multiplicadorFinal;
            multiplicadorFinal = multiplicadorInicial;
            multiplicadorInicial = apoio;

        }

        int tamanho = multiplicadorFinal - multiplicadorInicial + 1;
        tabuada = new String[tamanho];

        int i = 0;
        while (tamanho > i){
            int resultado = multiplicando * multiplicadorInicial;

            tabuada[i] = multiplicando + " X " + multiplicadorInicial + " = " + resultado;
            multiplicadorInicial++;
            i++;
        };

        return tabuada;
    }
}
