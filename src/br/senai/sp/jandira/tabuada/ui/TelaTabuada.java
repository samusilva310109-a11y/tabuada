package br.senai.sp.jandira.tabuada.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /* Definir o tamanho da tela */
        stage.setWidth(500);
        stage.setHeight(550);
        stage.setTitle("Tabuada");

        //criando o cabeçalho
        VBox header = new VBox();
        header.setPadding(new Insets(10, 10, 10, 20));
        header.setPrefHeight(50);

        //criando o  conteúdo do cabeçalho
        Label lbltitulo = new Label();
        lbltitulo.setText("Tabuada");
        lbltitulo.setStyle("-fx-font-size: 20; -fx-text-fill: red; -fx-font-weight: bold;");

        Label lblsubtitulo = new Label();
        lblsubtitulo.setText("Crie a tabuada que sua imaginação mandar");
        lblsubtitulo.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-font-weight: bold;");

        //colocar o conteúdo do cabeçalho
        header.setStyle("-fx-background-color: #cdcdcd;");
        header.getChildren().addAll(lbltitulo,  lblsubtitulo);


        //criando o grid de formulário
        GridPane gridFormulario = new GridPane();
        gridFormulario.setPrefHeight(50);
        gridFormulario.setStyle("-fx-background-color: #ff0000;");

        //Criar o conteúdo do gridFormulário (tabela)
        Label lblMultiplicando = new Label();
        lblMultiplicando.setText("Multiplicando:");
        lblMultiplicando.setStyle("-fx-font-size: 10; -fx-text-fill: white");
        TextField txfMultiplicando = new TextField();

        Label lblMultiplicadorInicial = new Label();
        lblMultiplicadorInicial.setText("Multiplicador inicial:");
        lblMultiplicadorInicial.setStyle("-fx-font-size: 10; -fx-text-fill: white");
        TextField txfMultiplicadorInicial = new TextField();

        Label lblMultiplicadorFinal = new Label();
        lblMultiplicadorFinal.setText("Multiplicador final:");
        lblMultiplicadorFinal.setStyle("-fx-font-size: 10; -fx-text-fill: white");
        TextField txfMultiplicadorFinal = new TextField();


        //Colocar os componentes no grid
        gridFormulario.add(lblMultiplicando, 0, 0);
        gridFormulario.add(txfMultiplicando, 1, 0);
        gridFormulario.add(lblMultiplicadorInicial, 0, 1);
        gridFormulario.add(txfMultiplicadorInicial, 1, 1);
        gridFormulario.add(lblMultiplicadorFinal, 0, 2);
        gridFormulario.add(txfMultiplicadorFinal, 1, 2);


        //Criando a caixa dos botões
        HBox boxBotoes = new HBox();
        boxBotoes.setPrefHeight(50);
        boxBotoes.setStyle("-fx-background-color: #a86363;");

        //Criar os botões
        Button btnCalcular = new Button("Calcular");
        Button btnLimpar = new Button("Limpar");
        Button btnSair = new Button("Sair");


        //colocando os conteúdos na Hbox
        boxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);

        //Criar a caixa de resultado
        VBox boxResultados = new VBox();
        boxResultados.setStyle("-fx-background-color: #0026ff;");

        //Criando os contéúdos da box resultados
        Label lblResultados = new Label("Resultados:");
        ListView listaTabuada = new ListView();

        //Colocando os conteúdos na caixa resultados
        boxResultados.getChildren().addAll(lblResultados,listaTabuada);

        //Criar o root - componente do layout principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #fff5d5;");
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultados);


        Scene scene = new Scene(root);//colocando o root na cena


        stage.setScene(scene);//Colocando a cena no stage
        stage.show();
    }
}
