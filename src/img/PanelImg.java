package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
public class PanelImg extends JPanel{


    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelImg(){
        this(new FlowLayout(), true);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelImg(boolean isDoubleBuffered){
        this(new FlowLayout(), isDoubleBuffered);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelImg(LayoutManager layout){
        this(layout, true);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelImg(LayoutManager layout, boolean isDoubleBuffered){
        
    }




}
