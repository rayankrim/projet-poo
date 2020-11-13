package projet;

public class Indice extends OperationBinaire{

	public Indice(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);
	}

	@Override
	public double calculer() {
		return 0;
	}
	
	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return this;
	}
	
	@Override
	public String afficher() {
		return this.eaLeft.afficher()+"("+this.eaRight.afficher()+")";
	}

	
}
