package projet;

public class Indice extends OperationBinaire{

	public Indice(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);
	}

	@Override
	public double calculer() {
		throw new RuntimeException("Les calculs des indices ne peut se faire.");
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
