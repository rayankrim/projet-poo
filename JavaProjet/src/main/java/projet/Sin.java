package projet;

public class Sin extends OperationUnaire {

	
	@Override
	protected ExpressionArithmetique simplifie(Division div) {
		double int1 = Math.sin(div.calculer());
		long long1 = Math.round(int1); 
		int int2 = (int)long1; 
		return new ConstEntiere(int2);
	}
	

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere nb) {
		return this.isNeutre();
	}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle nb) {
		
		return super.simplifie(nb);
	}

	public Sin(ExpressionArithmetique ea) {
		super(ea);
	}

	@Override
	public double calculer() {

		return Math.sin(this.ea.calculer());
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
		int comparaison = ((Sin) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}
	
	@Override
    public ExpressionArithmetique isNeutre() {
        if(this.ea.equals(new ConstEntiere(0))) {
            return new ConstEntiere(0);
        }
        return this;
    } 

	@Override
	public String afficher() {
		return "sin(" + ea.afficher() + ")";
	}



	

}
