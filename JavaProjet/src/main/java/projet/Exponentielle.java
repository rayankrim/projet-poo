package projet;

public class Exponentielle extends OperationUnaire {

	public Exponentielle(ExpressionArithmetique ea) {
		super(ea);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculer()  {

		return Math.exp(this.ea.calculer());
	}
	
	//simplifier

	@Override
	public boolean equals(Object expr2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return null;
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
