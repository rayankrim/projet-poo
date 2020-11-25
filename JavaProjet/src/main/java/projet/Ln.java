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
		return this.simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere nb) {
		
		return this.isNeutre();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle nb) {
		return this.simplifier();
	}



	@Override
    public ExpressionArithmetique isNeutre() {

        if ( this.ea.equals(new ConstEntiere(1)) ) {
            return new ConstEntiere(0);
        }else if (this.ea.equals(new ConstEntiere(0))) {
            throw new RuntimeException("Impossible de calculer ln(0)"); 
        }
        return this;
    } 
	
	@Override
	public String afficher() {
		return "ln(" + ea.afficher() + ")";
	}
}
