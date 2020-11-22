package projet;

import java.util.ArrayList;
import java.util.Collections;

public class Polynome implements ExpressionArithmetique {

	public ArrayList<ExpressionArithmetique> getListe() {
		return liste;
	}

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
	public boolean equals(Object expr2) {
		if (this == expr2) {
			return true;

		}

		if (expr2 == null) {
			return false;
		}

		if (getClass() != expr2.getClass()) {

			return false;

		}
		int comparaison = ((Polynome) expr2).afficher().compareTo(this.afficher());

		if (comparaison == 0) {
			return true;
		}
		return false;

	}

	// non utilisées car les polynomes sont composés de multiplication et d'addition

	@Override
	public String afficher() {

		return this.getListe() + "";
	}

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() {
		return 0;
	}

	public ExpressionArithmetique integraleMembre(ExpressionArithmetique ea) {

		if (ea instanceof Multiplication) {

			Multiplication m1 = (Multiplication) ea;
			ConstEntiere membre1 = (ConstEntiere) m1.eaLeft;

			if (m1.eaRight instanceof Puissance) {

				Puissance xPuissance = (Puissance) m1.eaRight;

				VarSymbolique vs = (VarSymbolique) xPuissance.eaLeft;

				ConstEntiere puissance = (ConstEntiere) xPuissance.eaRight;

				if (membre1.getEntier() != 0) {

					ConstEntiere un = new ConstEntiere(1);

					Addition const1 = new Addition(puissance, un);

					Puissance p1 = new Puissance(vs, const1);

					Division div1 = new Division(p1, const1);

					return new Multiplication(const1, div1).simplifier();

				} else if (membre1.getEntier() == 0) {

					ConstEntiere un = new ConstEntiere(1);

					Addition add2 = new Addition(puissance, un);

					Puissance p2 = new Puissance(vs, add2);

					Multiplication mult1 = new Multiplication(membre1, p2);

					return new Division(mult1, add2).simplifier();

				}

			} else {

				VarSymbolique vs = (VarSymbolique) m1.eaRight;
				ConstEntiere deux = new ConstEntiere(2);
				Puissance p2 = new Puissance(vs, deux);
				Division div1 = new Division(membre1, deux);

				return new Multiplication(div1, p2).simplifier();

			}

		}
		if (ea instanceof ConstEntiere) {
			ConstEntiere m1 = (ConstEntiere) ea;

			VarSymbolique vs = new VarSymbolique("x");
			return new Multiplication(m1, vs).simplifier();

		}
		VarSymbolique vs2 = new VarSymbolique("y");

		return vs2.simplifier();

	}

	public ExpressionArithmetique primitiver(int nbDerivation) {

		ArrayList<ExpressionArithmetique> listeDerivation = liste;

		for (int i = 0; i < nbDerivation; i++) {
			for (int j = 0; j < listeDerivation.size(); j++) {

				listeDerivation.set(j, integraleMembre(listeDerivation.get(j)));

			}

		}
		ConstEntiere zero = new ConstEntiere(0);
		VarSymbolique vs1 = new VarSymbolique("a");
		Addition add = new Addition(zero, vs1);

		for (int j = 0; j < listeDerivation.size(); j++) {
			
			ExpressionArithmetique intermediaire = add.simplifier();

			Addition add2 = new Addition(listeDerivation.get(j), intermediaire.simplifier());
			add = add2;
		}
		
		
		return add.simplifier();
	}
}
