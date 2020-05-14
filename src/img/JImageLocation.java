package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;


import org.apache.commons.io.FilenameUtils;

class JImageLocation extends JPanel implements ActionListener{

final private String[] extensions = {"jpg", "jpeg", "png"};

Dimension dims = new Dimension(0,28);

    JLabel imgL;
    JTextField tfL;
    JButton butL;
    JLabel icon;


    File file;

    int n;

    public JImageLocation(int n){
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        this.n = n;


        imgL = new JLabel("Imagen " + n + ":");

        tfL = new JTextField(20);
        tfL.setPreferredSize(dims);
        tfL.setMaximumSize(new Dimension(1000,28));
        // tfL.setEnabled(false);
        tfL.setEditable(false);

        butL = new JButton("...");
        butL.addActionListener(this);

        icon = new JLabel(new ImageIcon());
        icon.setPreferredSize(new Dimension(50,50));

        add(imgL);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(tfL);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(butL);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(icon);
    }

    public boolean fileExists(){
        if(file == null){return false;}
        else{return true;}
    }

    public File getFile(){
        if(fileExists()){
            return file;
        } else {
            return null;
        }
    }

    public boolean checkImg(){
        if(fileExists()){
            String ext = FilenameUtils.getExtension(file.getName());
            for(int i = 0; i < extensions.length; i++){
                if(ext.toLowerCase().equals(extensions[i])){return true;}
            }

            return false;
        } else {return false;}
    }

    public void loadImg(File img){
        this.file = img;
        if(checkImg()){
            tfL.setText(file.getName());
            setIcon();
        } else {
            this.file = null;
            JOptionPane.showMessageDialog(this,
                        "El archivo no tiene formato de imagen",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setIcon(){
        ImageIcon iconImg = new ImageIcon(file.getAbsolutePath(), "imagen" + n);
        iconImg = new ImageIcon(getScaledImage(iconImg.getImage(), 50, 50));
        icon.setIcon(iconImg);
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == butL){
            final String userDir = System.getProperty("user.dir");
            final JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(userDir));

            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION){
                loadImg(fc.getSelectedFile());
            }

        }
    }
}
