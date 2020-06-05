/**
 * Classe permettant de gérer tout ce qui concerne les phases de la partie.
 * 
 * 2 attributs de type joueur
 * 1 attribut de type int comptabilisant le nombre total de tours de tous les joueurs
 */

public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private int numTour;

/**
 * Méthode permettant de vérifier si un joueur a perdu.
 * Affiche le nom du perdant.
 */

    public void partieEstTerminee (Joueur joueura, Joueur joueurb) {
        if(joueura.getPV()<=0){
            System.out.println(joueura.getNomJoueur() + " a perdu, I hear CHEH in my oreillette");
        }
        else if(joueurb.getPV()<=0){
            System.out.println(joueurb.getNomJoueur() + " a perdu, I hear CHEH in my oreillette");
        }
    }

/**
 * Méthode initialisant la partie:
 * Crée les 2 joueurs
 * Définit leurs adversaires réciproques
 * Gènère leur main (pioche) de départ
 * 
 * Permet de commencer la partie
 */

    public Partie (){

        this.joueur1=new Joueur(); 
        this.joueur2=new Joueur();

        this.joueur1.setAdversaire(joueur2);
        this.joueur2.setAdversaire(joueur1);

        this.joueur1.genereMainDepart();
        this.joueur2.genereMainDepart();

        clearTerminal();
        
        this.lancerPartie();

    }

/**
 * Méthode déterminant à quel joueur c'est le tour de jouer
 */

    public void tourPartie (double chance) { // double chance sert à déterminer qui commence la partie 
				
			if (chance<0.5){		
				if(this.numTour%2==0){
					tour(joueur1);
				}
				else{
					tour(joueur2);
				}
			}	
			else{
				if(this.numTour%2==0){
					tour(joueur2);
				}
				else{
					tour(joueur1);
				}
			}		
    }

    /**
     * Méthode qui fait tourner la partie tant qu'aucun joueur n'a perdu
     */
    
    public void lancerPartie() {
		
		double quiCommence=Math.random();
        while (this.getJoueur1().getPV() >0 && this.getJoueur2().getPV()>0){
            this.tourPartie(quiCommence);
        }

        this.partieEstTerminee(this.getJoueur1(), this.getJoueur2());
	}

/**
 * Méthode qui gère l'organisation générale d'un tour
 */

    public void tour (Joueur joueur){

        printNomJoueur(joueur);
        System.out.print("MES PV: ");
        joueur.printPV();
        System.out.println();

        this.numTour=this.numTour+1;

        joueur.setNumTour(joueur.getNumTour()+1);
        joueur.setMana(joueur.getMana()+joueur.getNumTour());

        System.out.print("MON MANA: ");
        joueur.printMana();
        System.out.println();
        
        joueur.getPioche().add(new Creature());
        joueur.printPioche();
        joueur.printChampBataille();
        
        joueur.payerCreature();
        clearTerminal();
        joueur.attaque();
        clearTerminal();

        System.out.print("MES PV: ");
        joueur.printPV();
        System.out.print(" ; PV DE MON ADVERSAIRE: ");
        joueur.getAdversaire().printPV();

        System.out.println();
        joueur.printChampBataille();
        clearTerminal();

    }

/**
 * Méthode affichant dans le terminal le nom du joueur entré en paramètre.
 */

    public void printNomJoueur(Joueur joueur){
        System.out.println();
        System.out.println("* * * TOUR DE " + joueur.getNomJoueur() + " * * *");
        System.out.println();

    }

/**
 * Méthodes get permettant d'avoir connaissance des attributs privés de la classe.
 */
    
    public Joueur getJoueur1 () {
        return this.joueur1;
    }
    
    public Joueur getJoueur2 () {
        return this.joueur2;
    }

    public void clearTerminal () {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

}
