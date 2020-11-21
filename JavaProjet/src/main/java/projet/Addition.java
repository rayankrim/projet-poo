
package projet;

public class Addition extends OperationBinaire {

	public Addition(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}
	
	@Override
	public double calculer() {
		return this.eaLeft.calculer() + this.eaRight.calculer();
	}

	@Override
    protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		 return super.simplifie(gauche, droite);
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
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, VarSymbolique droite) {
		if(gauche.isValueNull()==false && droite.isValueNull()==false)
			return new ConstEntiere(gauche.getValue() + droite.getValue()).simplifier();
		else if(gauche.isValueNull()==false && droite.isValueNull())
			return gauche.simplifier();
		else if(gauche.isValueNull() && droite.isValueNull()==false)
			return droite.simplifier();
		else
			return this;
	}
	
	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return this;
			
	}
	
	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return this.eaLeft.afficher()+"+"+this.eaRight.afficher();
	}

}