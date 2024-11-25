package Screen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import Alert.UserAlert;
import java.util.ArrayList;

public class CameraModifiedScreen extends Screen{

    private JLabel cameraLabel;

    public CameraModifiedScreen(int posX, int posY){
        super("Tela de Câmera Modificada", 640 + 13, 480 + 35);

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

    public Mat refreshImage(Mat frame, HomeScreen homeScreen){

        String actions = homeScreen.getHomeScreenContent().getVideoChange();
        if(actions != null){
            String[] listOfActions = actions.split(";");
            for(int i = 0; i < listOfActions.length; i++){
                
                String actionPerformed = listOfActions[i].split(":")[0];
                String valueAction;
                if(listOfActions[i].split(":").length > 1){
                    valueAction = listOfActions[i].split(":")[1];
                }else{
                    valueAction = "";
                }

                //======================================== CLEAN ===============================================
                if(actionPerformed.equals("")){
                    homeScreen.getHomeScreenContent().setFlipedV(false);
                    homeScreen.getHomeScreenContent().setFlipedH(false);

                //==================================== GAUSSIAN ===============================================
                }else if(actionPerformed.equals("gaussian")){
                    int gaussian_size;
                    try{
                        gaussian_size = Integer.parseInt(valueAction);
                    }catch(Exception e){
                        gaussian_size = 1;
                    }
                    
                    if(gaussian_size % 2 == 0){
                        gaussian_size--;
                    }
                    Imgproc.GaussianBlur(frame, frame, new Size(gaussian_size, gaussian_size), 0);

                //==================================== BRILHO ===============================================
                }else if(actionPerformed.equals("brightness")){
                    String bright = valueAction;

                    int bright_int = 0;
                    try{
                        bright_int = Integer.parseInt(bright);
                    }catch(Exception e){
                        bright_int = 0;
                    }

                    frame.convertTo(frame, 0,1,bright_int);

                //==================================== CONTRASTE ===============================================
                }else if(actionPerformed.equals("contrast")){
                    String contrast = valueAction;

                    int contrast_int = 1;
                    try{
                        contrast_int = Integer.parseInt(contrast);
                    }catch(Exception e){
                        contrast_int = 1;
                    }

                    frame.convertTo(frame, 0, contrast_int, 0);
                
                //==================================== SOBEL ===============================================
                }else if(actionPerformed.equals("sobel")){
                    if(frame.channels() != 1){
                        Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
                    }
                    Imgproc.Sobel(frame, frame, -1, 0, 1);
                    frame.convertTo(frame, 0, 1, 127);

                //==================================== CANNY ===============================================
                }else if(actionPerformed.equals("canny")){
                    Mat src_img = frame;

                    // Matrizes auxiliares
                    Mat gray_img = new Mat(src_img.rows(), src_img.cols(), src_img.type());
                    Mat edges_img = new Mat(src_img.rows(), src_img.cols(), src_img.type());
                    Mat dst_img = new Mat(src_img.rows(), src_img.cols(), src_img.type(), new Scalar(0));

                    // Conversao para cinza
                    if(frame.channels() != 1){
                        Imgproc.cvtColor(src_img, gray_img, Imgproc.COLOR_RGB2GRAY);
                    }

                    // borramento para elhor resultado (detecta menos ruido como borda)
                    Imgproc.blur(gray_img, edges_img, new Size(3, 3));

                    // Deteção das bordas
                    Imgproc.Canny(edges_img, edges_img, 60, 60*3);

                    // Copia do resultado
                    src_img.copyTo(dst_img, edges_img); 
                    frame = dst_img;

                //==================================== CINZA ===============================================
                }else if(actionPerformed.equals("gray")){
                    if(frame.channels() != 1){
                        Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
                    }

                //==================================== NEGATIVE ============================================
                }else if(actionPerformed.equals("negative")){
                    frame.convertTo(frame, 0, -1, 255);

                //==================================== RESIZE ===============================================
                }else if(actionPerformed.equals("resize")){
                    int newWidth = Math.abs(frame.width() / 2);
                    int newHeight = Math.abs(frame.height() / 2);

                    Imgproc.resize(frame, frame, new Size(newWidth, newHeight));

                //================================= FLIP VERTICAL ===========================================
                }else if(actionPerformed.equals("flipV")){
                    Core.flip(frame, frame, 0);
                    homeScreen.getHomeScreenContent().setFlipedV(true);

                //================================= FLIP HORIZONTAL ===========================================
                }else if(actionPerformed.equals("flipH")){
                    Core.flip(frame, frame, 1);
                    homeScreen.getHomeScreenContent().setFlipedH(true);
                //================================= ROTAÇÃO ===========================================
                }else if(actionPerformed.equals("rotation")){
                    String rotation_angle = valueAction;

                    int rotation_angle_int = 0;
                    try{
                        rotation_angle_int = Integer.parseInt(rotation_angle);
                    }catch(Exception e){
                        rotation_angle_int = 0;
                    }

                    Point center = new Point(frame.width() / 2.0, frame.height() / 2.0);
                    Mat rotationMatrix = Imgproc.getRotationMatrix2D(center, rotation_angle_int, 1.0);
                    Size size = new Size(frame.width(), frame.height());

                    Imgproc.warpAffine(frame, frame, rotationMatrix, size, Imgproc.INTER_LINEAR, Core.BORDER_CONSTANT);
                }
            }

        }

        if(frame.channels() == 1){
            Imgproc.cvtColor(frame, frame, Imgproc.COLOR_GRAY2RGB);
        }
        return frame;
        
    }



}
