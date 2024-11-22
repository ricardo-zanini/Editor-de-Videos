package Screen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import java.awt.*;

public class CameraScreen extends Screen{

    private JLabel cameraLabel;
    private CameraModifiedScreen cameraModifiedScreen;

    private HomeScreen homeScreenProp;

    public CameraScreen(int posX, int posY, HomeScreen homeScreen){
        super("Tela de Câmera", 640 + 13, 480 + 35);

        setHomeScreenProp(homeScreen);

        setLocation(posX, posY);
        setLayout(null);

        createComponents();
        configComponents();
        addComponents();

        setCameraModifiedScreen(new CameraModifiedScreen(1100, 20));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createComponents(){
        setCameraLabel(new JLabel());

    }

    private void configComponents(){
        cameraLabel.setBounds(0, 0, 640, 480); 
    }

    private void addComponents(){
        add(cameraLabel);
    }

    // Inicia câmera
    public void startCamera() 
    { 
        int camID = 0;
        VideoCapture cap = new VideoCapture(0);
        Mat frame = new Mat();
        byte[] imgData;

        if(cap.open(camID))
        {
            while(true)
            {
                cap.read(frame);
                if(frame.empty())
                    break;

                // Frame -> Byes
                final MatOfByte buf = new MatOfByte(); 
                Imgcodecs.imencode(".jpg", frame, buf); 
                imgData = buf.toArray(); 
                // Imagem para JLabel
                getCameraLabel().setIcon(new ImageIcon(imgData)); 

                cameraModifiedScreen.refreshImage(frame, homeScreenProp);
            }
        }
    }

    public JLabel getCameraLabel() {
        return cameraLabel;
    }
    public void setCameraLabel(JLabel cameraLabel) {
        this.cameraLabel = cameraLabel;
    }

    public CameraModifiedScreen getCameraModifiedScreen() {
        return cameraModifiedScreen;
    }
    public void setCameraModifiedScreen(CameraModifiedScreen cameraModifiedScreen) {
        this.cameraModifiedScreen = cameraModifiedScreen;
    }

    public HomeScreen getHomeScreenProp() {
        return homeScreenProp;
    }
    public void setHomeScreenProp(HomeScreen homeScreenProp) {
        this.homeScreenProp = homeScreenProp;
    }
    
}
