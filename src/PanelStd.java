import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class PanelStd extends JPanel{


    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(){
        this(new FlowLayout(), true);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(boolean isDoubleBuffered){
        this(new FlowLayout(), isDoubleBuffered);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(LayoutManager layout){
        this(layout, true);
    }

    // Creates a new JPanel with a double buffer and a flow layout.
    public PanelStd(LayoutManager layout, boolean isDoubleBuffered){
        super(layout, isDoubleBuffered);
    }
}
