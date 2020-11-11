package projet;

public class Sin extends OperationUnaire {

	public Sin(ExpressionArithmetique ea) {
		super(ea);
	}

	@Override
	public double calculer(){

		return Math.sin(this.ea.calculer());
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		return false;
	}
	@Override
	public String afficher() {
		return "sin(" + ea.afficher() + ")";
	}
}