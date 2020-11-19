package projet;

public class Puissance extends OperationBinaire {

	public Puissance(ExpressionArithmetique x, ExpressionArithmetique n) {
		super(x, n);
	}

	public double calculer() {
		double a = this.eaLeft.calculer();
		double b = this.eaRight.calculer();
		return Math.pow(a, b);
	}

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return super.simplifie(gauche, droite);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		int num = (int) Math.pow(gauche.getNumerateur(), droite.getEntier());
		int deno = (int) Math.pow(gauche.getDenominateur(), droite.getEntier());
		return new ConstRationnelle(num, deno).simplifier();
	}

	/*
	 * @Override protected ExpressionArithmetique simplifie(ConstRationnelle gauche,
	 * ConstRationnelle droite) {
	 * 
	 * return new ConstRationnelle(num,deno).simplifier(); }
	 */
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		int simp = (int) Math.pow(gauche.getEntier(), droite.getEntier());
		return new ConstEntiere(simp).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		int simp = (int) Math.pow(gauche.getEntier(), droite.calculer());
		return new ConstEntiere(simp).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VarSymbolique droite) {
		return isNeutre(gauche, droite);
	}

	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return isNeutre(gauche, droite);
	}

	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere gauche, VarSymbolique droite) {
		return this;
	}

	@Override
	public ExpressionArithmetique isNeutre(VarSymbolique gauche, ConstEntiere droite) {
		if (droite.getEntier() == 1 && gauche.isValueNull() == true) {
			return new VarSymbolique(gauche.getVariable());
		} else if (droite.getEntier() == 0 && gauche.isValueNull() == true) {
			return new ConstEntiere(1);
		} else if (gauche.isValueNull() == true) {
			return this;
		}
		int simp = (int) Math.pow(gauche.getValue(), droite.getEntier());
		return new ConstEntiere(simp).simplifier();
	}

	@Override
	public ExpressionArithmetique simplifier() {
		return super.simplifier();
	}

	@Override
	public boolean equals(Object expr2) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String afficher() {
		if (eaRight == new ConstEntiere(1)) {
			return eaLeft.afficher();
		}
		return this.eaLeft.afficher() + "^" + this.eaRight.afficher();
	}

	@Override
	public void derive() {
		// TODO Auto-generated method stub

	}

}