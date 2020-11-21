package projet;

//A peu prêt sur le même model que "Operation Binaire".
public abstract class OperationUnaire implements ExpressionArithmetique {
	protected ExpressionArithmetique ea;

	public OperationUnaire(ExpressionArithmetique ea) {
		this.ea = ea;
	}

	public abstract ExpressionArithmetique isNeutre(ConstEntiere ce);
	
	
	protected ExpressionArithmetique simplifie(ExpressionArithmetique nb) {
		return this;
	}

	protected ExpressionArithmetique simplifie(Division div) {
		return this;
	}
	
	protected ExpressionArithmetique simplifie(ConstEntiere nb) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstRationnelle nb) {
		return this;
	}

	protected ExpressionArithmetique simplifie(Pi pi) {
		return this;
	}

	public ExpressionArithmetique simplifier() {
		this.ea = this.ea.simplifier();

		if (this.ea instanceof ConstEntiere) {
			ConstEntiere nb = (ConstEntiere) this.ea;
			return simplifie(nb);
		} else if (this.ea instanceof ConstRationnelle) {
			ConstRationnelle nb = (ConstRationnelle) this.ea;
			return simplifie(nb);
		} else if (this.ea instanceof Pi) {
			Pi pi = (Pi) this.ea;
			return simplifie(pi);
			
		} else if (this.ea instanceof Division) {
		Division div = (Division) this.ea;
		return simplifie(div);

		}else {
			return this;
		}
		
		
		
	}
	
	@Override
	public boolean equals(Object expr2) {
		return this == expr2;

	}
}
