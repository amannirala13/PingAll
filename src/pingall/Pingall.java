/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingall;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * CopyRightsReserved@2018_ASDEV
 * @author Aman Nirala
 */
public class Pingall extends Application {
   static Stage MainActivity;      //MainActivity: Set all scenes to this. >>>> eg: Stage stage = MainActivity; stage.setScene(scene);
 
    @Override
    public void start(Stage LoginActivity) throws Exception {
        MainActivity = LoginActivity;
        Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(login);
        MainActivity.initStyle(StageStyle.TRANSPARENT);
        MainActivity.setScene(scene);
        MainActivity.show();
}
    
    //Serts dashboard on the Stage
    public void setFrameView() throws Exception
    {
        Stage DashboardActivity = MainActivity;
        Parent Dashboard = FXMLLoader.load(getClass().getResource("FrameView.fxml"));
        Scene scene = new Scene(Dashboard);
        DashboardActivity.setScene(scene);
        DashboardActivity.show();
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
