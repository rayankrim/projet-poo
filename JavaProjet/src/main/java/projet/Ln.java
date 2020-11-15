package projet;

public class Ln extends OperationUnaire {

	public Ln(ExpressionArithmetique ea) {
		super(ea);
	}

	@Override
	public double calculer() throws VarSymboliqueException {

		return Math.log(this.ea.calculer());
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		return false;
	}
	@Override
	public String afficher() {
		return "ln(" + ea.afficher() + ")";
	}
}
