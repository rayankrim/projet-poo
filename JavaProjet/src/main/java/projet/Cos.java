package projet;

public class Cos extends OperationUnaire {

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique nb) {
		return this;
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere nb) {
		return this.isNeutre();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle nb) {
		return this;
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
    public ExpressionArithmetique isNeutre() {
        if (this.ea.equals(new ConstEntiere(0)) ) {
            return new ConstEntiere(1);
        }
        return this;
    }

	

}
