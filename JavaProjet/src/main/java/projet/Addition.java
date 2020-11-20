
package projet;

public class Addition extends OperationBinaire {
	

	public Addition(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	@Override
	public double calculer() {

		double approximation = this.eaLeft.calculer() + this.eaRight.calculer();

		approximation = Math.round(approximation * 10000);

		return approximation / 10000;

	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return new ConstRationnelle(gauche.getNumerateur() * droite.getEntier() + gauche.getDenominateur() * 1,
				1 * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(
				gauche.getNumerateur() * droite.getDenominateur() + gauche.getDenominateur() * droite.getNumerateur(),
				droite.getDenominateur() * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstEntiere(gauche.getEntier() + droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {

		return simplifie(droite, gauche).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Addition droite) {
		return new Addition(new Addition(gauche, droite.eaLeft).simplifier(), droite.eaRight);
	}

	@Override
	protected ExpressionArithmetique simplifie(Addition gauche, ConstEntiere droite) {
		return new Addition(gauche.eaRight, new Addition(gauche.eaLeft, droite).simplifier());
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Multiplication droite) {
		return new Multiplication(gauche, new Multiplication(gauche, droite.eaRight).simplifier());
	}

	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return isNeutre(gauche, droite);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere eaLeft, VarSymbolique droite) {
		return isNeutre(eaLeft, droite);
	}

	@Override
	public ExpressionArithmetique isNeutre(VarSymbolique gauche, ConstEntiere droite) {
		if (droite.getEntier() == 0) {
			return gauche;
		}
		return new ConstEntiere(gauche.getValue() + droite.getEntier()).simplifier();
	}

	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere gauche, VarSymbolique droite) {
		if (gauche.getEntier() == 0) {
			return droite;
		}
		return new ConstEntiere(gauche.getEntier() + droite.getValue()).simplifier();
	}

	@Override
	public String afficher() {
		
		return "(" + eaLeft.afficher() + "+" + eaRight.afficher() + ")";

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
		//System.out.println(((Addition) expr2).afficher());
		//System.out.println(this.afficher());
		String result = ((Addition) expr2).afficher();
		String result2 = this.afficher();
		int comparaison = result.compareTo(result2);
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}
	
	

}