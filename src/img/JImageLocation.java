package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


import org.apache.commons.io.FilenameUtils;

class JImageLocation extends JPanel implements ActionListener{

final private String[] extensions = {"jpg", "jpeg", "png"};

Dimension dims = new Dimension(0,28);

    JLabel imgL;
    JTextField tfL;
    JButton butL;

    File file;

    int n;

    public JImageLocation(int n){
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        this.n = n;


        imgL = new JLabel("Imagen " + n + ":");

        tfL = new JTextField(15);
        tfL.setPreferredSize(dims);
        tfL.setEnabled(false);

        butL = new JButton("...");
        butL.addActionListener(this);

        add(imgL);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(tfL);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(butL);
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

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == butL){
            final String userDir = System.getProperty("user.dir");
            final JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(userDir));

            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION){
                this.file = fc.getSelectedFile();
                if(checkImg()){
                    tfL.setText(file.getName());
                } else {
                    JOptionPane.showMessageDialog(this,
                                "El archivo no tiene formato de imagen",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }
}
