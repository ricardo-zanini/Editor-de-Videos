package Screen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import Alert.UserAlert;

public class CameraModifiedScreen extends Screen{

    private JLabel cameraLabel;

    public CameraModifiedScreen(int posX, int posY){
        super("Tela de Câmera", 640, 480);

        setLocation(posX, posY);
        setLayout(null);

        createComponents();
        configComponents();
        addComponents();

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

    public JLabel getCameraLabel() {
        return cameraLabel;
    }
    public void setCameraLabel(JLabel cameraLabel) {
        this.cameraLabel = cameraLabel;
    }

    public void refreshImage(Mat frame, HomeScreen homeScreen){
        String actionPerformed = homeScreen.getHomeScreenContent().getVideoChange();
        if(actionPerformed != null){
            if(actionPerformed.equals("")){

            }else if(actionPerformed.equals("gaussian")){
                int gaussian_size = homeScreen.getHomeScreenContent().getSliderGaussian().getValue();
                if(gaussian_size % 2 == 0){
                    gaussian_size--;
                }
                Imgproc.GaussianBlur(frame, frame, new Size(gaussian_size, gaussian_size), 0);
            }else if(actionPerformed == "brightness"){
                String bright =  homeScreen.getHomeScreenContent().getFieldBrightness().getText();

                int bright_int = 0;
                try{
                    bright_int = Integer.parseInt(bright);
                }catch(Exception e){
                    bright_int = 0;
                }

                frame.convertTo(frame, 0,1,bright_int);
            }else if(actionPerformed == "contrast"){
                String contrast =  homeScreen.getHomeScreenContent().getFieldContrast().getText();

                int contrast_int = 1;
                try{
                    contrast_int = Integer.parseInt(contrast);
                }catch(Exception e){
                    contrast_int = 1;
                }

                frame.convertTo(frame, 0, contrast_int, 0);
            }else if(actionPerformed == "sobel"){
                Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
                Imgproc.Sobel(frame, frame, -1, 0, 1);
            }else if(actionPerformed == "canny"){
                Mat src_img = frame;

                // Matrizes auxiliares
                Mat gray_img = new Mat(src_img.rows(), src_img.cols(), src_img.type());
                Mat edges_img = new Mat(src_img.rows(), src_img.cols(), src_img.type());
                Mat dst_img = new Mat(src_img.rows(), src_img.cols(), src_img.type(), new Scalar(0));

                // Conversao para cinza
                Imgproc.cvtColor(src_img, gray_img, Imgproc.COLOR_RGB2GRAY);

                // borramento para elhor resultado (detecta menos ruido como borda)
                Imgproc.blur(gray_img, edges_img, new Size(3, 3));

                // Deteção das bordas
                Imgproc.Canny(edges_img, edges_img, 40, 40*3);

                // Copia do resultado
                src_img.copyTo(dst_img, edges_img); 
                frame = dst_img;
            }else if(actionPerformed == "gray"){
                Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
            }
        }
        byte[] imgData;
        final MatOfByte buf = new MatOfByte(); 
        Imgcodecs.imencode(".jpg", frame, buf); 
        imgData = buf.toArray(); 

        getCameraLabel().setIcon(new ImageIcon(imgData)); 
    }
}
