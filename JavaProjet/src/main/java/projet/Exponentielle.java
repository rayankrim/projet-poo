package projet;

public class Exponentielle extends OperationUnaire {

	public Exponentielle(ExpressionArithmetique ea) {
		super(ea);
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
		
		int comparaison = ((Exponentielle) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
	}

	@Override
	public String afficher() {
		return this.calculer()+"";
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
	public ExpressionArithmetique isNeutre(ConstEntiere ce) {
	if(ce.getEntier() == 0) {
		
		return new ConstEntiere(1);
	}
	return new Exponentielle(ce);
		
	}}
