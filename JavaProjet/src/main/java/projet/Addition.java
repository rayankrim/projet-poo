
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
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		if(gauche.isValueNull())
			return this;
		else// dans le cas où on connait la valeur de x.
			return new ConstEntiere(gauche.getValue() + droite.getEntier()).simplifier();
	}
	
	/*static String doSomme(VarSymbolique left, VarSymbolique right, ConstEntiere iDebut, ConstEntiere iFin) {
		String s="";
		for(int i= iDebut.getEntier(); i<=iFin.getEntier(); i++) {
			s+="+"+Addition(left,right);
		}
	}*/

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return this.eaLeft.afficher()+"+"+this.eaRight.afficher();
	}

}