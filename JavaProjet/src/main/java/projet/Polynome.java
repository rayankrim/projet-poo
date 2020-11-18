package projet;

import java.util.ArrayList;
import java.util.Collections;

public class Polynome implements ExpressionArithmetique {

	private final ArrayList<ExpressionArithmetique> liste = new ArrayList<ExpressionArithmetique>();

	// constructeur EA
	public Polynome(ExpressionArithmetique... ea) {

		for (ExpressionArithmetique membre : ea) {
			liste.add(membre);

		}
		Collections.reverse(liste);

	}
	/*
	 * public Polynome(ExpressionArithmetique ea,ExpressionArithmetique
	 * ea2,ExpressionArithmetique ea3,ExpressionArithmetique
	 * ea4,ExpressionArithmetique ea5) { this.ea=ea; this.ea=ea2; this.ea=ea3;
	 * this.ea=ea4; this.ea=ea5; }
	 * 
	 */

	public ExpressionArithmetique deriveMembre(ExpressionArithmetique ea) {

		if (ea instanceof Multiplication) {

			Multiplication m1 = (Multiplication) ea;
			ConstEntiere membre1 = (ConstEntiere) m1.eaLeft;

			if (m1.eaRight instanceof Puissance) {

				Puissance xPuissance = (Puissance) m1.eaRight;

				VarSymbolique vs = (VarSymbolique) xPuissance.eaLeft;

				ConstEntiere puissance = (ConstEntiere) xPuissance.eaRight;

				if (puissance.getEntier() >= 1) {

					return new Multiplication(new Multiplication(membre1, puissance).simplifier(),
							new Puissance(vs, new ConstEntiere(puissance.getEntier() - 1))).simplifier();

				} else {
					return new Multiplication(new Multiplication(membre1, puissance).simplifier(), vs);

				}

			}

			else {

				return membre1;
			}

		} else {

			return new ConstEntiere(0);

		}

	}

	public ExpressionArithmetique derivation(int nbDerivation) {

		ArrayList<ExpressionArithmetique> listeDerivation = liste;

		for (int i = 0; i < nbDerivation; i++) {
			for (int j = 0; j < listeDerivation.size(); j++) {

				listeDerivation.set(j, deriveMembre(listeDerivation.get(j)));

			}

		}
		ConstEntiere zero = new ConstEntiere(0);
		Addition add = new Addition(zero, zero);

		for (int j = 0; j < listeDerivation.size(); j++) {

			ExpressionArithmetique intermediaire = add.simplifier();

			Addition add2 = new Addition(listeDerivation.get(j), intermediaire);
			add = add2;

		}

		return add.simplifier();
	}

	@Override
	public ExpressionArithmetique simplifier() { // il faut pv la simplifier
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculer() { // calculer l'égalité
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object expr2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void derive() {
		// TODO Auto-generated method stub

	}

	@Override
	public ExpressionArithmetique getFonctionDerivee() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cinq = new ConstEntiere(5);
		ExpressionArithmetique dix = new ConstEntiere(10);
		ExpressionArithmetique quatre = new ConstEntiere(4);

		ExpressionArithmetique vs = new VarSymbolique("x");

		ExpressionArithmetique puissance = new Puissance(vs, deux);
		ExpressionArithmetique multiplication = new Multiplication(trois, puissance);

		ExpressionArithmetique puissance3 = new Puissance(vs, trois);
		ExpressionArithmetique puissance2 = new Puissance(vs, quatre);

		ExpressionArithmetique cinqx = new Multiplication(cinq, vs);

		Multiplication nombre1 = new Multiplication(cinq, puissance2);

		Multiplication nombre2 = new Multiplication(quatre, puissance3);
		Multiplication nombre3 = new Multiplication(trois, puissance);

		// ExpressionArithmetique cinqxpuissance = new Puissance(cinq, deux);

		Polynome poly1 = new Polynome(nombre1, nombre2, nombre3, cinqx, dix);

		System.out.println(poly1.derivation(3).afficher());

//puissance 0, q15 a finir 

	}

}
