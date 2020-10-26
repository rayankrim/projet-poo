package Partie1;

public class Puissance extends OperationBinaire {
	// il y a deux paramètre x le nombre et n la puissance 
	// utiliser multiplicaion pour le membre  
	// utiliser soustraction pour soustraire le membre de droite entre lui utiliser la méthode soustraction
	
	
	public Puissance(ExpressionArithmetique x,ExpressionArithmetique n) {
		super(x,n);
		}
	
	@Override
	public double calculer() {
		// l'element de d
		// calculer le membre de droite par lui meme 
		while(eaRight>0) {
			eaLeft *= eaLeft;
			
		}
		return this.eaLeft.calculer() * this.eaLeft.calculer();
	}
	
	
}
