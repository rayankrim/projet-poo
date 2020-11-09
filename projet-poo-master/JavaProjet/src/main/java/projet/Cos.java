package projet;

public class Cos extends OperationUnaire {

	public Cos(ExpressionArithmetique ea) {
		super(ea);

	}

	@Override
	public double calculer() throws VarSymboliqueException {

		return Math.cos(this.ea.calculer());
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {

		return false;
	}

}
