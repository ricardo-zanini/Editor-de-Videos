import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

import org.opencv.core.Core;

import Alert.UserAlert;
import Screen.CameraScreen;
import Screen.HomeScreen;

public class Index {
   
    public static void main(String[] args){
      try{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Tela Inicial
        HomeScreen homeScreen = new HomeScreen();

        // Adição da Câmera
        CameraScreen cameraScreen = new CameraScreen(440, 20, homeScreen);
        cameraScreen.startCamera();
      }catch(Exception e){
        UserAlert userAlert = new UserAlert("ERRO - Erro ao criar tela inicial"); 
      }
    }

}
