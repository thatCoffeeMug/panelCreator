package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class JImageLocation extends JPanel{


Dimension dims = new Dimension(0,28);

    JLabel imgL;
    JTextField tfL;
    JButton butL;
    int n;

    public JImageLocation(int n){
        super();
        this.setLayout(layout);

        this.setPreferredSize(new Dimension(10,10));

        this.n = n;
        // this.setLayout(new FlowLayout());
        // this.setMinimumSize(new Dimension(10,5));
        // this.setPreferredSize(new Dimension(20,10));

        imgL = new JLabel("Imagen " + n + ":");
        tfL = new JTextField(15);
        tfL.setPreferredSize(dims);
        butL = new JButton("...");

        // this.add(imgL);
        this.add(tfL);
        // layout.putConstraint(SpringLayout.EAST, imgL, 5,
        //                      SpringLayout.EAST, this);
        // layout.putConstraint(SpringLayout.SOUTH, imgL, 5,
        //                      SpringLayout.SOUTH, this);



        // layout.putConstraint(SpringLayout.WEST, tfL, 0,
        //                      SpringLayout.WEST, this);


        // layout.putConstraint(SpringLayout.EAST, imgL, 10,
        //                      SpringLayout.WEST, tfL);
        // layout.putConstraint(SpringLayout.EAST, tfL, 10,
        //                      SpringLayout.WEST, butL);

        // layout.putConstraint(SpringLayout.VERTICAL_CENTER, imgL, 0,
        //                      SpringLayout.VERTICAL_CENTER, tfL);
        // layout.putConstraint(SpringLayout.VERTICAL_CENTER, imgL, 0,
        //                      SpringLayout.VERTICAL_CENTER, tfL);
        // layout.putConstraint(SpringLayout.VERTICAL_CENTER, butL, 0,
        //                      SpringLayout.VERTICAL_CENTER, tfL);



        // this.add(butL);
        System.out.println(this.getPreferredSize());
        System.out.println(tfL.getPreferredSize());
        System.out.println(imgL.getPreferredSize());
        System.out.println(butL.getPreferredSize());
    }

}
