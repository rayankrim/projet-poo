package projet;

public class Division extends OperationBinaire {

	public Division(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);
	}

	@Override
	public double calculer() {
		if(this.eaRight.calculer() == 0)
			throw new RuntimeException("Impossible d'effectuer une division par 0");
		else
			return this.eaLeft.calculer() / this.eaRight.calculer();
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
		if(gauche.getEntier()==0)
			throw new RuntimeException("Division par 0 impossible.");
		else
			return new ConstRationnelle(gauche.getEntier(), droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		if(droite.getEntier()==0)
			throw new RuntimeException("Division par 0 impossible.");
		else
			return new ConstRationnelle(gauche.getValue(), droite.getEntier()).simplifier();
	}

	@Override
	public String afficher() {
		return eaLeft.afficher() + "/" + eaRight.afficher();
	}
}
