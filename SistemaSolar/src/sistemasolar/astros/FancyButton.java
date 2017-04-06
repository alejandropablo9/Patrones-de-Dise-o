package sistemasolar.astros;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro
 */
public class FancyButton extends JButton {
    
  public FancyButton(Icon icon, Icon pressed, Icon rollover) {
    super(icon);
    super.setFocusPainted(false);
    super.setRolloverEnabled(true);
    super.setRolloverIcon(rollover);
    super.setPressedIcon(pressed);
    super.setBorderPainted(false);
    super.setContentAreaFilled(false);
  }
  
  public FancyButton(String src_icon, String src_pressed, String src_rollover){
      this( new ImageIcon(src_icon), new ImageIcon(src_pressed), new ImageIcon(src_rollover) );
  }  
}
