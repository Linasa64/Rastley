import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner; 
import java.util.InputMismatchException;

/**
 * Classe gérant tout ce qui concerne les joueurs, et ce avec quoi ils interagissent.
 * Points de vie
 */

public class Joueur {
    /**
     * Points de vie du joueur
     */
    private int pv;

    /**
     * Nom choisi par le joueur avec un scanner
     *  */ 
    private String nomJoueur;

    /**
     * Le mana équivaut à la monnaie nécessaire pour payer les créatures
     */
    private int mana;

    /**
     * Numéro de tour joué par le joueur
     * Sert pour ajouter du mana à la réserve du joueur
     */
    private int numTour;

    /**
     * Listes contenant les cartes présentes dans la main (=pioche) du joueur et sur leur champ de bataille
     */
    private ArrayList<Creature> pioche;
    private ArrayList<Creature> champBataille;

    /**
     * Définit l'adversaire du joueur
     */
    private Joueur adversaire;
    
/**
 * Constructeur de l'objet Joueur
 * Affiche une phrase expliquant au joueur ce qu'il doit entrer dans le scanner
 */
    public Joueur(){
        System.out.println("Bien le bonjour, preux aventurier ! Quel est ton nom ?");
        this.pv=20;
        Scanner monNom = new Scanner(System.in);
        this.nomJoueur=monNom.nextLine();
        this.pioche = new ArrayList<Creature>();
        this.champBataille = new ArrayList<Creature>();
        this.numTour=0;
    }
    
    /**
     * Méthode permettant de payer une créature.
     * Cela a pour effet de déplacer la créature de la liste pioche vers la liste champDeBataille.
     * Le joueur est débité du mana correspondant au prix de la créature.
     * Il est possible de lancer un maximum de 3 créatures par tour, tant que la réserve de mana est suffisante, ou passer cette étape.
     * 
     * On a anticipé des exceptions possibles en cas de saisie erronée du joueur.
     */
   
    public void payerCreature () {

        System.out.println("* * * PAYER CREATURE * * *");
        System.out.println();
        System.out.println("SI VOUS VOULEZ PAYER UNE CREATURE, SAISISSEZ SON N°");					
		System.out.println("SINON PASSEZ EN TAPANT ENTREE");
					

		Scanner scan = new Scanner(System.in);
		int valeurNumCreaturePayee;
		String numCreaturePayee;
		int NombreCreaturesPayees=1; // pour s'assurer qu'un joueur ne paye pas plus de 3 Créatures par tour
		
        try{
        numCreaturePayee = scan.nextLine();
        valeurNumCreaturePayee = Integer.parseInt(numCreaturePayee); // Stocke sous forme d'entier la valeur rentrée dans 
																	//la string de numCreaturePayee
		}
		catch(NumberFormatException e){ // En cas de saisie erronée (lettre ou "entrée") l'exception attribue la valeur -1
			valeurNumCreaturePayee= -1; // ce qui va faire sortir le joueur de la boucle while et passer à la suite de la partie
		}
		
        while (valeurNumCreaturePayee != -1 && NombreCreaturesPayees<3){
			
			
		
				
				if(valeurNumCreaturePayee >=this.pioche.size() || valeurNumCreaturePayee <-1){ // y a un défaut de numéro
					this.printPioche();
					System.out.println("ENTREZ UN N° VALIDE SVP");
					System.out.println("SI VOUS VOULEZ PAYER UNE CREATURE, SAISISSEZ SON N°");					
					System.out.println("SINON PASSEZ EN TAPANT ENTREE");
					System.out.println();
					System.out.print("MON MANA: ");
					this.printMana();
					System.out.println();
					
					try{
						numCreaturePayee = scan.nextLine();
						valeurNumCreaturePayee = Integer.parseInt(numCreaturePayee); // stocke sous forme d'entier la valeur rentrée dans 
																							//la string de numCreaturePayee
					}
					catch(NumberFormatException e){
							valeurNumCreaturePayee= -1;
					}
					
				}else { // soit ça marche, soit y a un défaut de prix
					int prix = this.pioche.get(valeurNumCreaturePayee).getPrix();
            
					if(prix<=this.mana && prix>=0){ // ici ça marche

						Creature creaturePayee=this.pioche.get(valeurNumCreaturePayee);

						this.champBataille.add(creaturePayee);
						this.pioche.remove(valeurNumCreaturePayee);
						this.printPioche();
						this.mana=this.mana - creaturePayee.getPrix();
						System.out.println();
						System.out.print("MON MANA: ");
						this.printMana();
						System.out.println();
						System.out.println("SI VOUS VOULEZ PAYER UNE CREATURE, SAISISSEZ SON N°");					
						System.out.println("SINON PASSEZ EN TAPANT ENTREE");
						
						try{ // gère l'exception de "ce qui est rentré n'est pas un int"
							numCreaturePayee = scan.nextLine();
							valeurNumCreaturePayee = Integer.parseInt(numCreaturePayee); // stocke sous forme d'entier la valeur rentrée dans 
																								//la string de numCreaturePayee
						}
						catch(NumberFormatException e){
							valeurNumCreaturePayee= -1;
						}
						NombreCreaturesPayees++;
					}

            
					else{ // ici ça marche pas parce que problème de Prix 
							this.printPioche();
							System.out.println("VOUS N'AVEZ PAS ASSEZ DE MANA POUR PAYER CETTE CREATURE.");
							System.out.println();
							System.out.print("MON MANA: ");
							this.printMana();
							System.out.println();
							System.out.println("SI VOUS VOULEZ PAYER UNE CREATURE, SAISISSEZ SON N°");					
							System.out.println("SINON PASSEZ EN TAPANT ENTREE");
							
							try{
								numCreaturePayee = scan.nextLine();
								valeurNumCreaturePayee = Integer.parseInt(numCreaturePayee); // stocke sous forme d'entier la valeur rentrée dans 
																							//la string de numCreaturePayee
							}
							catch(NumberFormatException e){
								valeurNumCreaturePayee= -1;
							}
					}
				} 
				
			}

        System.out.println();
        System.out.println("* * * PHASE D'ATTAQUE * * *");
        System.out.println();
        
    }

/**
 * Méthode ajoutant 7 créatures à la main (pioche) du joueur
 */
  
    public void genereMainDepart() {
        for (int i=0; i<7; i++){
            pioche.add(new Creature());
        }
    }

/**
 * Méthode permettant d'afficher chaque créature de la main (pioche) du joueur
 * A savoir son n°, son nom, son prix et sa force
 */

    public void printPioche() {
        System.out.println("MAIN JOUEUR");
        for(int i=0;i<this.pioche.size();i++){
            System.out.println("Carte n°" + i + ":"+ this.pioche.get(i).getNom()+" / Prix: " +this.pioche.get(i).getPrix() + " Force: " + this.pioche.get(i).getForce());
        }
        System.out.println();
        System.out.println("***");
        System.out.println();

    }

/**
 * Méthode permettant d'afficher chaque créature du champ de bataille du joueur
 * A savoir son numéro, son nom et sa force
 */

    public void printChampBataille() {
        System.out.println("CHAMP DE BATAILLE");
        for(int i=0;i<this.champBataille.size();i++){
            System.out.println("Carte n°" + i + ":"+ this.champBataille.get(i).getNom()+ ": Force: " + this.champBataille.get(i).getForce());
        }
        System.out.println();
        System.out.println("***");
        System.out.println();
    }

/**
 * Méthode permettant d'ajouter à la réserve de mana du joueur un nombre égal au numéro de son tour
 */

    public void addMana() {
        this.mana=numTour;
    }

/**
 * Méthode qui gère la phase d'attaque, avec
 * le choix des créatures attaquantes (maximum 3)
 * la répartition des blessures suivant une logique aléatoire, mais à partir des caractérisques de la créature
 * Gestions des exceptions possibles dûes au scanner
 */
    
    public void attaque(){
		
		for (int j=0; j<this.champBataille.size(); j++){
			this.champBataille.get(j).setACombattu(false);
		}

        boolean empty = this.champBataille.isEmpty();

        if (empty == true) {
            System.out.println("VOUS N'AVEZ PAS DE CREATURE SUR LE CHAMP DE BATAILLE, FIN DE VOTRE TOUR");
            entreeContinuer();
        }

        else {
			int x = this.champBataille.size();
			
			if (x>=3){ // on attaque avec max 3 créatures 
				x = 3;
			}
			
			for(int i = 0;i<x;i++){
				this.printChampBataille();
                System.out.println("CHOISISSEZ VOTRE "+(i+1)+"e CREATURE ATTAQUANTE"); // on attaque avec une carte à la fois 
           
                int numCreatureAttaquante = -1;
            
                boolean erreur=true;
            
                while (erreur=true){
                    try{
                        Scanner scan = new Scanner(System.in);
                        numCreatureAttaquante = scan.nextInt();
                        if (numCreatureAttaquante>=this.champBataille.size() || numCreatureAttaquante<0){
                            System.out.println("ENTREZ UN N° VALIDE SVP");
                        }else{
                            erreur = false;
                            break;
                        }
                    }
				catch(InputMismatchException e){
				
					System.out.println("ENTREZ UN N° VALIDE SVP");
				
				}
           }  
            
            

            System.out.println();
			Creature creatureAttaquante=this.champBataille.get(numCreatureAttaquante);
			if (creatureAttaquante.getACombattu()==true){
				System.out.println("Cette créature a déjà attaqué, veuillez en saisir une autre");
				i=i-1;
			}
			else {
				creatureAttaquante.setACombattu(true);
	
				if (Math.random()< creatureAttaquante.getReussite()){  // attaque reussit
					System.out.println("*J'ai toujours cru en votre pouvoir, aventurier !*");
					System.out.println("Votre attaque réussit !");
					this.adversaire.pv=this.adversaire.pv-creatureAttaquante.getForce();
					System.out.print("PV DE "+ this.adversaire.getNomJoueur()+" ");
					this.adversaire.printPV();
				
				}
				else if (Math.random()<0.5){ // l'attaque ne réussit pas la créature se détruit
					
					System.out.println("Oh non le bougre ! Votre créture est morte au cours de l'attaque"); // eddy malou n'est pas fier de vous
					this.champBataille.remove(numCreatureAttaquante);	
					System.out.print("PV DE "+ this.adversaire.getNomJoueur()+" ");		
					this.adversaire.printPV();
				}
				else { // il ne se passe rien
					System.out.println ("La vie est un long fleuve tranquille, il ne se passe rien, ça arrive...");
					System.out.print("PV DE "+ this.adversaire.getNomJoueur()+" ");
					this.adversaire.printPV();
				}
				
				System.out.println();
				System.out.println("***");
				System.out.println();

				entreeContinuer();
			   }
			}
           
        }
    }
    
/**
 * Méthode permettant d'appuyer sur entrée pour passer au tour de l'adversaire
 * Gain de visibilité dans l'affichage
 */
    
     public void entreeContinuer() { // méthode cool on a juste à appuyer sur Entree pour passer à l'étape d'après
        String s = "ENTREE POUR CONTINUER";
        System.out.println(s);
        Scanner passer = new Scanner(System.in);
        passer.nextLine();
    }

    /**
     * Méthodes get print et set permettant d'accéder aux attributs privés de la classe
     */
    
    public int getPV () { // methodes relatives aux PV
        return this.pv;
    }

    public void printPV () {
        System.out.print(this.pv);
    }

    public void printMana() { // methodes relatives au mana
        System.out.print(this.mana);
    }
    
    public int getMana () {
        return this.mana;
    }
    
    public void setMana (int a) {
        this.mana=a;
    }

     
    public String getNomJoueur(){ // méthode relative au nom du joueur
		return this.nomJoueur;
	}
	
	
	public int getNumTour () { // méthodes relatives au numéro du tour propre à chaque joueur 
        return this.numTour;
    }
    
         
     public void setNumTour (int b) {
        this.numTour=b;
    }
    
    public void setAdversaire (Joueur a) { // méthode relative à l'adversaire
        this.adversaire=a;
    }
    
    public Joueur getAdversaire (){
		return this.adversaire;
	}
    
    public ArrayList<Creature> getPioche() { // méthode qui renvoie la pioche d'un joueur
		return this.pioche;
	}
// Bravo ! Vous êtes *enfin* arrivé en à la fin de cette très courte classe, nous vous remercions pour votre visite !
// Et nous vous souhaitons un bon voyage sur nos routes
}
