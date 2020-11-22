package projet;

public class Cos extends OperationUnaire {

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique nb) {
		return super.simplifie(nb);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere nb) {
		return super.simplifie(nb);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle nb) {
		return super.simplifie(nb);
	}

	public Cos(ExpressionArithmetique ea) {
		super(ea);

	}

	@Override
	public double calculer() {

		return Math.cos(this.ea.calculer());
	}

	@Override
	public boolean equals(Object expr2) {
		
		if (this == expr2) {
			return true;

		}

		if (expr2 == null) {
			return false;
		}

		if (getClass() != expr2.getClass()) {

			return false;

		}
		
		int comparaison = ((Cos) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

	@Override
	public String afficher() {
		return "cos(" + ea.afficher() + ")";
	}


	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere ce) {
		
		
		
		return null;
	}


	

}
