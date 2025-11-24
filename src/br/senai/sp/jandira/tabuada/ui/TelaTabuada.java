package br.senai.sp.jandira.tabuada.ui;

import br.senai.sp.jandira.tabuada.model.Tabuada;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /* Definir o tamanho da tela */
        //stage.setHeight(550);
        stage.setResizable(false);
        stage.setTitle("Tabuada");

        //criando o cabeçalho
        VBox header = new VBox();
        header.setPadding(new Insets(10, 8, 10, 10));
        //header.setPrefHeight(50);

        //criando o  conteúdo do cabeçalho
        Label lbltitulo = new Label();
        lbltitulo.setText("Tabuada");
        lbltitulo.setStyle("-fx-font-size: 20; -fx-text-fill: red; -fx-font-weight: bold;");

        Label lblsubtitulo = new Label();
        lblsubtitulo.setText("Crie a tabuada que sua imaginação mandar");
        lblsubtitulo.setPadding(new Insets(0, 0, 10, 0));
        lblsubtitulo.setStyle("-fx-font-size: 10; -fx-text-fill: white; -fx-font-weight: bold;");

        //colocar o conteúdo do cabeçalho
        header.setStyle("-fx-background-color: #cdcdcd;");
        header.getChildren().addAll(lbltitulo,  lblsubtitulo);


        //criando o grid de formulário
        GridPane gridFormulario = new GridPane();
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        gridFormulario.setPadding(new Insets(8, 20, 8, 8));
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
        Pane paneButtons = new Pane();


        HBox boxBotoes = new HBox();
        boxBotoes.setSpacing(10);
        paneButtons.setPadding(new Insets( 8));
        boxBotoes.setStyle("-fx-alignment: center;");

        //boxBotoes.setPrefHeight(200);
        //boxBotoes.setStyle("-fx-background-color: #a86363;");

        //Criar os botões

        Button btnCalcular = new Button("Calcular");
        Button btnLimpar = new Button("Limpar");
        Button btnSair = new Button("Sair");


        //colocando os conteúdos na Hbox e no paneButtons
        boxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);
        paneButtons.getChildren().addAll(boxBotoes);

        //Criar a caixa de resultado
        VBox boxResultados = new VBox();
        boxResultados.setPrefHeight(50);
        //boxResultados.setStyle("-fx-background-color: #0026ff;");

        //Criando os contéúdos da box resultados
        Label lblResultados = new Label("Resultados:");
        lblResultados.setPadding(new Insets(8));
        lblResultados.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-font-weight: bold;");

        ListView listaTabuada = new ListView();
        listaTabuada.setPadding(new Insets(8));
        listaTabuada.setPrefHeight(300);

        //Colocando os conteúdos na caixa resultados
        boxResultados.getChildren().addAll(lblResultados);

        //DEFININDO A AÇÃO DOS BOTÕES
        /*Botão Calcular*/
        btnCalcular.setOnAction(e -> {
            Tabuada tabuada = new Tabuada();

            tabuada.multiplicando = Integer.parseInt(txfMultiplicando.getText());
            tabuada.multiplicadorInicial = Integer.parseInt(txfMultiplicadorInicial.getText());
            tabuada.multiplicadorFinal = Integer.parseInt(txfMultiplicadorFinal.getText());

            String[] resultado = tabuada.calcularTabuada();

            listaTabuada.getItems().addAll(resultado);
        });

        /*Botão Limpar*/
        btnLimpar.setOnAction(e -> {
            txfMultiplicando.clear();
            txfMultiplicadorInicial.clear();
            txfMultiplicadorFinal.clear();

            listaTabuada.getItems().clear();
            txfMultiplicando.requestFocus();
        });

        /*Botão Sair*/
        btnSair.setOnAction(e -> {
            String mensagem = "Deseja Sair do programa?";
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, mensagem, ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> resposta = alerta.showAndWait();

            if (resposta.get() == ButtonType.YES) {
                System.exit(0);
            }

        });

        //Criar o root - componente do layout principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #ffc500;");
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(paneButtons);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultados);
        root.getChildren().add(listaTabuada);


        Scene scene = new Scene(root);//colocando o root na cena


        stage.setScene(scene);//Colocando a cena no stage
        stage.show();
    }
}
