package Screen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;

import java.util.concurrent.TimeUnit;

import java.awt.*;

public class CameraScreen extends Screen{

    private JLabel cameraLabel;
    private CameraModifiedScreen cameraModifiedScreen;

    private HomeScreen homeScreenProp;

    private VideoCapture cap;

    public CameraScreen(int posX, int posY, HomeScreen homeScreen){
        super("Tela de Câmera", 640 + 13, 480 + 35);

        setHomeScreenProp(homeScreen);

        setLocation(posX, posY);
        setLayout(null);

        createComponents();
        configComponents();
        addComponents();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        setCameraModifiedScreen(new CameraModifiedScreen(1100, 20));
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
    public void startCamera(HomeScreen homeScreen) 
    { 
        int camID = 0;

        setCap(new VideoCapture(0));
        homeScreen.getHomeScreenContent().setCap(getCap());

        Mat frame = new Mat();
        byte[] imgData;

        
        if(cap.open(camID))
        {
            while(true)
            {
                cap.read(frame);
                if(frame.empty())
                    break;
                //------------------------------------------------------

                final MatOfByte buf = new MatOfByte(); 
                Imgcodecs.imencode(".jpg", frame, buf); 
                imgData = buf.toArray(); 

                getCameraLabel().setIcon(new ImageIcon(imgData)); 
                
                //------------------------------------------------------

                Mat frameMod = new Mat();
                frameMod = cameraModifiedScreen.refreshImage(frame, homeScreenProp);
                
                byte[] imgDataMod;
                final MatOfByte bufMod = new MatOfByte(); 
                Imgcodecs.imencode(".jpg", frameMod, bufMod); 
                imgDataMod = bufMod.toArray(); 
                
                getCameraModifiedScreen().setSize(frameMod.width() + 13, frameMod.height() + 35);
                getCameraModifiedScreen().getCameraLabel().setBounds(0, 0, frameMod.width(), frameMod.height()); 
                
                //------------------------------------------------------

                getCameraModifiedScreen().getCameraLabel().setIcon(new ImageIcon(imgDataMod));

                //------------------------------------------------------
                if(homeScreen.getHomeScreenContent().getRecordStatus()){
                    homeScreen.getHomeScreenContent().getVideoWriter().write(frameMod);
                }
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

    public VideoCapture getCap() {
        return cap;
    }
    public void setCap(VideoCapture cap) {
        this.cap = cap;
    }
    
}
