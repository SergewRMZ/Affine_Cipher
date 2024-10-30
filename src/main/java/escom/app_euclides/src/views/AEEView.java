package escom.app_euclides.src.views;

import escom.app_euclides.src.components.ImageLoader;
import escom.app_euclides.src.modules.EncryptionService;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AEEView extends javax.swing.JFrame {
  private static AEEView instance;
  private static String pathBG = "/BackgroundAEE.jpg";
  public AEEView() {
    initComponents();
    setLocationRelativeTo(null);
    setupBackground();
    addClick(this.InputAlpha);
    addClick(this.InputBeta);
    addClick(this.Input_N);
  }
  
  public static AEEView getInstanceAEEView () {
    if (instance == null) {
      instance = new AEEView();
    }
    return instance;
  }
  
  private void setupBackground () {
    Icon icon = ImageLoader.loadImage(pathBG, this.getWidth(), this.getHeight());
    this.LabelBackground.setIcon(icon);
  }
  
  private void addClick (JTextField textField) {
    textField.setForeground(Color.GRAY);
    textField.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed (MouseEvent e) {
        if (textField.getForeground() == Color.GRAY) {
          textField.setText("");
          textField.setForeground(Color.WHITE);
        }
      }
    });
  }
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    InputAlpha = new javax.swing.JTextField();
    InputBeta = new javax.swing.JTextField();
    Input_N = new javax.swing.JTextField();
    BtnCalculate = new javax.swing.JButton();
    LabelBackground = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    InputAlpha.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
    InputAlpha.setText("Ingresar el valor de alpha");
    InputAlpha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        InputAlphaActionPerformed(evt);
      }
    });
    getContentPane().add(InputAlpha, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 93, 250, 45));

    InputBeta.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
    InputBeta.setText("Ingresa el valor de beta");
    InputBeta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        InputBetaActionPerformed(evt);
      }
    });
    getContentPane().add(InputBeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 162, 250, 45));

    Input_N.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
    Input_N.setText("Ingresa el valor de n");
    Input_N.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        Input_NActionPerformed(evt);
      }
    });
    getContentPane().add(Input_N, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 233, 250, 45));

    BtnCalculate.setBackground(new java.awt.Color(102, 153, 255));
    BtnCalculate.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
    BtnCalculate.setForeground(new java.awt.Color(255, 255, 255));
    BtnCalculate.setText("Calcular");
    BtnCalculate.setPreferredSize(new java.awt.Dimension(100, 50));
    BtnCalculate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BtnCalculateActionPerformed(evt);
      }
    });
    getContentPane().add(BtnCalculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 316, 150, -1));
    getContentPane().add(LabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 498, 400));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void InputAlphaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputAlphaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_InputAlphaActionPerformed

  private void InputBetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputBetaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_InputBetaActionPerformed

  private void Input_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Input_NActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_Input_NActionPerformed

  private void BtnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalculateActionPerformed
    try {
        int alpha = Integer.parseInt(InputAlpha.getText().trim());
        int beta = Integer.parseInt(InputBeta.getText().trim());
        int n = Integer.parseInt(Input_N.getText().trim());
        
        // Llamar el método de cifrado
        String cipherResult = EncryptionService.cipherFunction(alpha, beta, n);
        String decipherResult = EncryptionService.decipherFunction(alpha, beta, n);
        
        if (decipherResult != null) {
          JOptionPane.showMessageDialog(this, 
            "Función de Cifrado: " + 
            cipherResult, 
            "Cifrado", 
            JOptionPane.INFORMATION_MESSAGE);
        
          JOptionPane.showMessageDialog(this, 
            "Función de Descifrado: " + 
            decipherResult, 
            "Descifrado", 
            JOptionPane.INFORMATION_MESSAGE);
        }
        
        else {
          JOptionPane.showMessageDialog(this, 
            "El inverso modular no existe para " + alpha + " mod " + n,
            "Error",
            JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (NumberFormatException e) {
        // Mostrar un mensaje de error en caso de que algún campo no contenga un número entero
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Por favor, asegúrese de que todos los campos contengan números enteros válidos.", 
            "Error de entrada", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
  }//GEN-LAST:event_BtnCalculateActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton BtnCalculate;
  private javax.swing.JTextField InputAlpha;
  private javax.swing.JTextField InputBeta;
  private javax.swing.JTextField Input_N;
  private javax.swing.JLabel LabelBackground;
  // End of variables declaration//GEN-END:variables
}
