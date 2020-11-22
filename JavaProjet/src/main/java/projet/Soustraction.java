package projet;

public class Soustraction extends OperationBinaire {

	public Soustraction(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	@Override
	public double calculer() {

		double approximation = this.eaLeft.calculer() - this.eaRight.calculer();

		approximation = Math.round(approximation * 10000);

		return approximation / 10000;

	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return new ConstRationnelle(gauche.getNumerateur() * droite.getEntier() - gauche.getDenominateur() * 1,
				1 * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(
				gauche.getNumerateur() * droite.getDenominateur() - gauche.getDenominateur() * droite.getNumerateur(),
				droite.getDenominateur() * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstEntiere(gauche.getEntier() - droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return new ConstRationnelle(droite.getDenominateur() * gauche.getEntier() - droite.getNumerateur() * 1,
				1 * droite.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return isNeutre(gauche, droite);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VarSymbolique droite) {
		return isNeutre(gauche, droite);
	}

	@Override
	public ExpressionArithmetique isNeutre(VarSymbolique gauche, ConstEntiere droite) {
		if (droite.getEntier() == 0) {
			return gauche;
		}
		return new ConstEntiere(gauche.getValue() - droite.getEntier()).simplifier();
	}

	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere gauche, VarSymbolique droite) {
		return new ConstEntiere(gauche.getEntier() - droite.getValue()).simplifier();
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
		int comparaison = ((Soustraction) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

	@Override
	public String afficher() {
		return "(" + eaLeft.afficher() + "-" + eaRight.afficher() + ")";
	}

	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere gauche, ExpressionArithmetique droite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpressionArithmetique isNeutre(ExpressionArithmetique gauche, ConstEntiere droite) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
