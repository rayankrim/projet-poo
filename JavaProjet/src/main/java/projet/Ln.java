package projet;

public class Ln extends OperationUnaire {

	public Ln(ExpressionArithmetique ea) {
		super(ea);
	}


	@Override
	public double calculer() {

		return Math.log(this.ea.calculer());
	}
	// methode siplifier

	@Override
	public boolean equals(Object expr2) {
		return false;
	}

	@Override
	public String afficher() {
		return "ln(" + ea.afficher() + ")";
	}

	@Override
	public void derive() {
		// TODO Auto-generated method stub

	}

}
