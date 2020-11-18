package projet;

public class Cos extends OperationUnaire {

	public Cos(ExpressionArithmetique ea) {
		super(ea);

	}

	@Override
	public double calculer()  {

		return Math.cos(this.ea.calculer());
	}

	@Override
	public boolean equals(Object expr2) {
		return false;
	}
	@Override
	public String afficher() {
		return "cos(" + ea.afficher() + ")";
	}

	@Override
	public void derive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExpressionArithmetique getFonctionDerivee() {
		// TODO Auto-generated method stub
		return null;
	}
}
