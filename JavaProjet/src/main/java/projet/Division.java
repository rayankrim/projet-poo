package projet;

public class Division extends OperationBinaire {

	public Division(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	@Override
	public double calculer() {
		double approximation = this.eaLeft.calculer() / this.eaRight.calculer();

		approximation = Math.round(approximation * 10000);

		return approximation / 10000;

	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return new ConstRationnelle(gauche.getNumerateur(), gauche.getDenominateur() * droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return new ConstRationnelle(gauche.getEntier() * droite.getNumerateur(), droite.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(gauche.getNumerateur() * droite.getDenominateur(),
				gauche.getDenominateur() * droite.getNumerateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstRationnelle(gauche.getEntier(), droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return this;
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
	public ExpressionArithmetique isNeutre(ConstEntiere gauche, VarSymbolique droite) {
		return this;
	}

	@Override
	public ExpressionArithmetique isNeutre(VarSymbolique gauche, ConstEntiere droite) {
		if (droite.getEntier() == 1) {
			return gauche;
		}
		return new ConstRationnelle(gauche.getValue(), droite.getEntier()).simplifier();

	}

	@Override
	public String afficher() {
		return "("+ eaLeft.afficher() + "/" + eaRight.afficher() + ")";
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
		
		int comparaison = ((Division) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere gauche, ExpressionArithmetique droite) {
		
		return null;
	}

	@Override
	public ExpressionArithmetique isNeutre(ExpressionArithmetique gauche, ConstEntiere droite) {
		
		return null;
	}

}
