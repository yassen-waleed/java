import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class main extends Application {
    static  String path = "" ;
    public static Scene mainScene(Stage primaryStage,int [] lights,int [] sources) throws FileNotFoundException {
        Label label1 = new Label("Lights") ;
        VBox v = new VBox(5) ;
        v.getChildren().add(label1) ;
        for (int i = 0; i < lights.length; i++){
            Label label = new Label(String.valueOf(lights[i])) ;
            v.getChildren().add(label) ;
        }
        Pane pane =  new Pane() ;
        pane.getChildren().add(v) ;
       Scene scene = new Scene(pane,700,600)  ;
    return  scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(new FileInputStream("lamp.png"));


        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        Button btn1 = new Button("Choose File");
        btn1.setPrefWidth(250);
        btn1.setPrefHeight(30);

        Button btn2 = new Button("Next");
        btn2.setPrefWidth(250);
        btn2.setPrefHeight(30);
        VBox v1 = new VBox(8);

        v1.setAlignment(Pos.CENTER);
        v1.setLayoutX(220);
        v1.setLayoutY(200);
        v1.getChildren().addAll(imageView,btn1, btn2);
        Pane pane = new Pane();
        pane.setPrefHeight(600);
        pane.setPrefWidth(700);
        pane.getChildren().addAll(v1);
        /* ****** Styling ********/
        pane.setStyle("-fx-background-color: #403f3f");
        btn1.setStyle("-fx-background-color: #cccccc;"
                + "-fx-font-family: 'cursive';"
                + "-fx-font-size: 18");
        btn2.setStyle("-fx-background-color: #cccccc;"
                + "-fx-font-family: 'cursive';"
                + "-fx-font-size: 18");

        /* ***********************************************/
        /* *********************event handling*********************************/
        btn1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            String path_1 = file.toString();
            path = path_1;
            System.out.println(path);
        });
        btn2.setOnAction(e->{
            try {
                int [] lights = Readfile.readfile(path);
                int [] sources = new int[lights.length] ;
                for (int i = 0; i <sources.length ; i++) {
                     sources[i] = i+1 ;
                }

                primaryStage.setScene(mainScene(primaryStage,lights,sources));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        /* *********************************************************************/
        Scene scene = new Scene(pane, 700, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
