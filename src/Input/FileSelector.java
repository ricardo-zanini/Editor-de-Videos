package Input;

import Alert.UserAlert;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileSelector extends JPanel{

    private JButton         buttonFile;
    private JTextField      fieldFile;
    private JFileChooser    windowFile;

    public FileSelector(int textFieldWidth, FileNameExtensionFilter filter){

        createComponents();
        configComponents(textFieldWidth, filter);
        addComponents();

    }
    private void createComponents(){
        ImageIcon imageIcon = new ImageIcon("img/folder.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(30, 30, 1); // scale it the smooth way  

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setButtonFile(new JButton("", new ImageIcon(newimg)));
        buttonFile.addActionListener(event -> eventSelectFile());

        setWindowFile(new JFileChooser());

        setFieldFile(new JTextField());
    }
    private void configComponents(int textFieldWidth, FileNameExtensionFilter filter){

        setBackground(new Color(38,38,38));

        try{
            File fontStyle = new File("Fonts/pixelated_fancy_font.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle);
            
            fieldFile.setFont(font.deriveFont(12f));
        }catch(Exception e){
            UserAlert userAlert = new UserAlert("ERRO - Erro ao carregar Fonte"); 
        }

        buttonFile.setBackground(new Color(120, 90,148));
        buttonFile.setBorder(new LineBorder(new Color(33, 33, 33),0));
        buttonFile.setMaximumSize(new Dimension(60, 40));
        buttonFile.setFocusable(false);

        fieldFile.setBackground(new Color(33, 33, 33));
        fieldFile.setBorder(new LineBorder(new Color(33, 33, 33),10));
        fieldFile.setMaximumSize(new Dimension(textFieldWidth + 80, 40));
        fieldFile.setEditable(false);
        fieldFile.setFocusable(false);
        fieldFile.setForeground(new Color(204, 204, 204));

        windowFile.setVisible(false);
        
        if(filter != null){
            windowFile.setFileFilter(filter);
        }else{
            windowFile.setAcceptAllFileFilterUsed(false);
        }
    }    

    private void addComponents(){
        add(buttonFile,  BorderLayout.WEST);
        add(fieldFile,  BorderLayout.EAST);
        add(windowFile);
    }    

    public JButton getButtonFile() {
        return buttonFile;
    }
    public void setButtonFile(JButton buttonFile) {
        this.buttonFile = buttonFile;
    }


    public JTextField getFieldFile() {
        return fieldFile;
    }
    public void setFieldFile(JTextField fieldFile) {
        this.fieldFile = fieldFile;
    }


    public JFileChooser getWindowFile() {
        return windowFile;
    }
    public void setWindowFile(JFileChooser windowFile) {
        this.windowFile = windowFile;
    }


    private void eventSelectFile(){
        getWindowFile().setVisible(true);
        getWindowFile().showOpenDialog(null);
        getFieldFile().setText(getWindowFile().getSelectedFile().getPath());
    }

}