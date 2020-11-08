package projet;

import java.util.Scanner;

public class Polynome implements ExpressionArithmetique {

	private int nbMembre;
	private int[] fonction = new int[10];
	private int[] puissance = new int[10];
	private int[] fonctionDerivee = new int[10];
	private int[] puissanceDerivee = new int[10];

	private int x;
	private int xDerivee;
	private int Px;
	private int PxDerivee;

	Scanner sc = new Scanner(System.in);

	// Constructeur de la classe Polynome

	public Polynome(int nbMembre) {
		this.nbMembre = nbMembre;
		
		/*
		this.x=x; 
		this.xDerivee=xDerivee;
		this.Px=Px;
		this.PxDerivee=PxDerivee;
		*/

	}

	public void derive() {

		System.out.println("entrez les membres de la fonction");

		for (int i = 0; i < this.nbMembre; i++) {
			
			
			System.out.println("Entrez le terme n°" +(i+1)+":");
			x = sc.nextInt();
			fonction[i] = x;
			System.out.println(fonction[i] + "^ ?"  );
			Px = sc.nextInt();
			puissance[i] = Px;

			// premier cas ou la puissance = 0

			if (Px == 0) {

				xDerivee = 0;
				PxDerivee = 0;

				fonctionDerivee[i] = xDerivee;
				puissanceDerivee[i] = PxDerivee;

			}

			// second cas ou la puissance == 1

			if (Px == 1) {

				xDerivee = x;
				PxDerivee = 0;

				fonctionDerivee[i] = xDerivee;
				puissanceDerivee[i] = PxDerivee;

			}

			// dernier cas, Px > 1

			if (Px > 1) {

				xDerivee = x * Px;
				PxDerivee = Px - 1;

				fonctionDerivee[i] = xDerivee;
				puissanceDerivee[i] = PxDerivee;

			}

		}

		System.out.print("affichage de la fonction : ");

		for (int i = 0; i < nbMembre; i++) {

			if (fonction[i] > 0) {
				System.out.print(fonction[i]);
			}

			if (puissance[i] == 1) {
				System.out.print("x ");

			}

			if (puissance[i] > 1) {
				System.out.print("x^" + puissance[i]);

			}

			if (i != nbMembre - 1) {
				System.out.print(" + ");
			}

		}
		System.out.println(" ");

		System.out.print("affichage de sa dérivée : ");

		for (int i = 0; i < nbMembre; i++) {

			if (fonctionDerivee[i] > 0) {
				System.out.print(fonctionDerivee[i]);
			}

			if (puissanceDerivee[i] == 1) {
				System.out.print("x ");

			}

			if (puissanceDerivee[i] > 1) {
				System.out.print("x^" + puissanceDerivee[i]);

			}

			if (puissanceDerivee[i] != 0) {
				if (i != nbMembre - 1) {
					System.out.print(" + ");
				}

			}

		}

	}
/*
	public static void main(String[] args) {

		Polynome poly = new Polynome(3);
		poly.derive();

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
