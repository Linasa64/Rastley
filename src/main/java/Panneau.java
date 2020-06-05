import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
    private static final long serialVersionUID = 1L; // Permet de gérer une erreur

/**
 * Méthode qui permet d'afficher des éléments dans le JPanel
 * Choix couleur arrière plan
 * Permet d'afficher 2 images et une ligne de texte
 */

    public void paintComponent(Graphics g) {
        Font font = new Font("TimesRoman", Font.BOLD, 60);
        g.setFont(font);
        g.setColor(Color.white);

        /**
        * Permet de choisir l'image voulue
        * Si l'image n'est pas trouvée, l'exception est gérée par le catch
        */

        try {
            Image img = ImageIO.read(ClassLoader.getSystemResource("rastley.jpg"));
            // g.drawImage(img, 300, 300, this);
            // Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
        * Permet de choisir l'image voulue
        * Si l'image n'est pas trouvée, l'exception est gérée par le catch
        */

        try {
            Image img2 = ImageIO.read(ClassLoader.getSystemResource("titre.jpg"));
            g.drawImage(img2, 80, 300, this);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("j'ai pas trouvé ton chemin d'acces");
        }
        g.drawString("Bienvenue à toi nouveau joueur !", 20, 50);
    }
}
