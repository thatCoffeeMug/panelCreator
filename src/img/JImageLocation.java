package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class JImageLocation extends JPanel implements ActionListener{


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

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == butL){
            final String userDir = System.getProperty("user.dir");
            final JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(userDir));

            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION){
                System.out.println("Everything a ok!");
                this.file = fc.getSelectedFile();
                tfL.setText(file.getName());
            }

        }
    }
}
