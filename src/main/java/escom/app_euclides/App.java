package escom.app_euclides;

import escom.app_euclides.src.views.MainView;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
  public static void main (String args[]) {
    SwingUtilities.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(new FlatDarkLaf());
        MainView main = MainView.getInstanceMain();
        SwingUtilities.updateComponentTreeUI(main);
        main.setVisible(true);
      } catch (UnsupportedLookAndFeelException ex) {
        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
      }
    });
  }
}
