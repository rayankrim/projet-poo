package projet;

public class Ln extends OperationUnaire {

	public Ln(ExpressionArithmetique ea) {
		super(ea);
	}

	@Override
	public double calculer() {

		return Math.log(this.ea.calculer());
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
		
		int comparaison = ((Ln) expr2).afficher().compareTo(this.afficher());

		if (comparaison == 0) {
			return true;
		}
		return false;

	}

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique nb) {
		// TODO Auto-generated method stub
		return super.simplifie(nb);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere nb) {
		
		return isNeutre(nb);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle nb) {
		// TODO Auto-generated method stub
		return super.simplifie(nb);
	}

	@Override
	public String afficher() {
		return "ln(" + ea.afficher() + ")";
	}

	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere ce) {
		if (ce.getEntier() == 1) {
			return new ConstEntiere(0);

		}
		return new Ln(ce);
	}

}
