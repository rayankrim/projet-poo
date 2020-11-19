package projet;

public class Sin extends OperationUnaire {

	public Sin(ExpressionArithmetique ea) {

		super(ea);
	}

	@Override
	public double calculer() {


		return Math.sin(this.ea.calculer());
	}

	@Override
	public boolean equals(Object expr2) {
		return false;
	}

	@Override
	public String afficher() {
		return "sin(" + ea.afficher() + ")";
	}

	@Override
	public void derive() {
		// TODO Auto-generated method stub

	}


}
