package projet;

public class Exponentielle extends OperationUnaire {

	public Exponentielle(ExpressionArithmetique ea) {
		super(ea);
	}

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

	@Override
	public double calculer() {

		return Math.exp(this.ea.calculer());
	}

	// simplifier

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
		String result = ((Exponentielle) expr2).afficher();
		String result2 = this.afficher();
		int comparaison = result.compareTo(result2);
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
	}

	@Override
	public String afficher() {
		return this.calculer()+"";
	}


}
