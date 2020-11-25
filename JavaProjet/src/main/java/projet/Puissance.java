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
		return this.isNeutre();
	}

	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return this.isNeutre();
	}

	
	@Override
    public ExpressionArithmetique isNeutre() {
        if (this.eaRight.equals(new ConstEntiere(1))){
            return this.eaLeft;
        }else if (this.eaRight.equals(new ConstEntiere(0))){
            return new ConstEntiere(1);
        }
        return this;
    }

	@Override
	public ExpressionArithmetique simplifier() {
		return super.simplifier();
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
		int comparaison = ((Puissance) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

	@Override
	public String afficher() {
		if (eaRight == new ConstEntiere(1)) {
			return eaLeft.afficher();
		}
		return "("+ this.eaLeft.afficher() + "^" + this.eaRight.afficher()+")";
	}
	

}