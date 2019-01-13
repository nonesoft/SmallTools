package nonesoftApp;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.*;

public class FirstApp extends Application {

	@Override
	public void start(Stage primaryStage)
	{
		TextField nameFld = new TextField("Enter something");
		Button btn = new Button("Say hello");
		Button exitBtn = new Button("Exit");
		exitBtn.setOnAction(e->Platform.exit());
		
		btn.setOnAction(e->{
			String name = nameFld.getText();
			if(name.trim().length() > 0) {
				System.out.println(name);
			}
			else {
				System.out.println("Hello something");
			}			
		});
		
		VBox root = new VBox();         
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nameFld,btn,exitBtn);
        
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
