package projet;

import java.util.Scanner;

public class Polynome implements ExpressionArithmetique {

	private int nbMembre;
	private int[] fonction = new int[10];
	private int[] puissance = new int[10];
	private int[] fonctionDerivee = new int[10];
	private int[] puissanceDerivee = new int[10];


	
	//contruscteur vide pr kinani 
	
	public Polynome() {
		
		
		
	}
	
	

	// Constructeur de la classe Polynome

	public Polynome(int nbMembre, int fonction[], int puissance[]) {

		this.nbMembre = nbMembre;

		for (int i = 0; i < nbMembre; i++) {
			this.fonction[i] = fonction[i];
		}
		for (int i = 0; i < nbMembre; i++) {
			this.puissance[i] = puissance[i];
		}

	}
	
	
	
	public void derive() {

		for (int i = 0; i < nbMembre; i++) {

			// premier cas ou la puissance = 0

			if (puissance[i] == 0) {

				fonctionDerivee[i] = 0;
				puissanceDerivee[i] = 0;

			}

			// second cas ou la puissance == 1

			if (puissance[i] == 1) {

				fonctionDerivee[i] = fonction[i];
				puissanceDerivee[i] = 0;

			}

			// dernier cas, Px > 1

			if (puissance[i] > 1) {

				fonctionDerivee[i] = fonction[i] * puissance[i];
				puissanceDerivee[i] = puissance[i] - 1;

			}

		}
		
		
	}
	
	public void afficher() {

		System.out.println("");

		System.out.print("affiche de la fonction : ");

		// affichage

		for (int i1 = 0; i1 < nbMembre; i1++) {

			if (fonction[i1] == 0) {
				System.out.print(fonction[i1]);
			}

			if (fonction[i1] > 0) {
				System.out.print(fonction[i1]);
			}

			if (puissance[i1] == 1) {
				System.out.print("x ");

			}

			if (puissance[i1] > 1) {
				System.out.print("x^" + puissance[i1]);

			}

			if (i1 != nbMembre - 1) {
				System.out.print(" + ");
			}

		}

		

	}

	public Polynome getFonctionDerivee(){
		
	
		Polynome poly = new Polynome(this.nbMembre,this.fonctionDerivee,this.puissanceDerivee);
		
		return poly; 
		
		
		
	}
	
	/*
	public void auto() {
		
		System.out.println("tu veux deriver cb de fois? ");
		
		for()
			.derive();
		
	}
*/
	

	@Override
	public ExpressionArithmetique simplifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}
}
