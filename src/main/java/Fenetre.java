import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public class Fenetre extends JFrame {

  /**
   * Constructeur de la fenêtre.
   * Choix nom fenêtre
   * Choix de sa taille
   * Redimensionnement impossible
   * Position de la fenêtre: centrée
   * Fenêtre visible
   */

  public Fenetre() {
    this.setTitle("RASTLEY, le jeu phénomène, noté *** au guide Michelin");
    this.setSize(1000, 800);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setContentPane(new Panneau());
    this.setVisible(true);
  }
}
