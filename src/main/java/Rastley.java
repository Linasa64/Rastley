import javax.swing.*;
import java.awt.event.*;

public class Rastley {
  public static void main(String[] args) {

    Audio musique = new Audio();
    Fenetre fen = new Fenetre();

    JButton b = new JButton("~ Commencer une partie ~");
    b.setBounds((fen.getWidth() - 300) / 2, 100, 300, 80);
    fen.add(b);

    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //fen.getContentPane().removeAll();
        //fen.repaint();
        //fen.revalidate();
        fen.dispose();
        Partie nouvellePartie = new Partie();
      }
    });
  }
}
