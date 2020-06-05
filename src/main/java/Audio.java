import java.io.File;
import javax.sound.sampled.*;

public class Audio {

    /**
     * Chemin d'accès de l'emplacement du fichier audio A modifier sur chaque nouvel
     * ordinateur sur lequel le code sera lancé
     */

    private String cheminAcces;

    /**
     * Constructeur de l'objet audio
     */

    public Audio() {
        this.jouerSon("theros.wav");
    }

    /**
     * Méthode permettant de lancer le fichier audio
     * 
     * @param cheminAcces
     * 
     */

    public static void jouerSon(String cheminAcces) {

        /**
         * Si le fichier audio n'est pas trouvé, l'exception est gérée par le catch
         */

        try {
            File file = new File(cheminAcces);
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(cheminAcces));
            clip.open(ais);
            clip.loop(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
