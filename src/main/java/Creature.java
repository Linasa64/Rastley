public class Creature {

    private int nCarte;
    private int prix;
    private int force;
    private double reussite; // associé à la proba de réussite de la carte lors de l'attaque
    private String nomCreature; // pour faire plus accueillant
    private boolean aCombattu; // pour qu'une carte qui a déjà joué ne soit pas utilisée plusieurs fois au cours d'un même tour 

    public Creature (){
        this.prix=(int)(Math.random()*7)+1;
        this.force=this.prix;
        this.reussite=1-(this.force*0.1); // pour avoir une proba de réussite inversement proportionnelle à la force
          
          if (this.force==1){
			  this.nomCreature= "Gobelin serrurier";
		  }
		  else if  (this.force==2){
			  this.nomCreature= "Elfe de l'agroforesterie";
		  }
		  else if (this.force==3){
			  this.nomCreature= "Centaure busqué";
		  }
		  else if (this.force==4){
			  this.nomCreature= "Griffon hirsute";
		  }
		  else if (this.force==5){
			  this.nomCreature=  "Hydre emberlificotée";
		  }
		  else if (this.force==6){
			  this.nomCreature= "Dragon tournebroche";
		  }
		  else {
			  this.nomCreature= "licorne hypermétrope";
		  }
    }
    

    public int getPrix () {
        return this.prix;
    }
    
    public String getNom() {
		return this.nomCreature;
	}

    public int getForce() {
        return this.force;
    }
    
    public double getReussite(){
		return this.reussite;
	}
	
	public boolean getACombattu(){
		return this.aCombattu;
	}
	
	public void setACombattu(boolean b){
		this.aCombattu=b;
	}
	

}
