package projet;

public abstract class OperationBinaire implements ExpressionArithmetique {
	protected ExpressionArithmetique eaLeft;
	protected ExpressionArithmetique eaRight;

	public OperationBinaire(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		this.eaLeft = eaLeft;
		this.eaRight = eaRight;
	}

	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VarSymbolique droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Addition droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(Addition gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Soustraction droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Multiplication droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, VarSymbolique droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Exponentielle droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(Exponentielle gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstRationnelle droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(Sin gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Sin droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(Multiplication gauche, ConstEntiere droite) {

		return this;
	}

	public abstract ExpressionArithmetique isNeutre(VarSymbolique gauche, ConstEntiere droite);
	
	

	public abstract ExpressionArithmetique isNeutre(ConstEntiere gauche, VarSymbolique droite);

	public abstract ExpressionArithmetique isNeutre(ConstEntiere gauche, ExpressionArithmetique droite);
	
	public abstract ExpressionArithmetique isNeutre(ExpressionArithmetique gauche, ConstEntiere droite);
	


	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Division droite) {

		return this;
	}

	@Override
	public ExpressionArithmetique simplifier() {

		ExpressionArithmetique res;
		this.eaLeft = this.eaLeft.simplifier();
		this.eaRight = this.eaRight.simplifier();

		if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof ConstEntiere) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;
			res = simplifie(gauche, droite);
		} else if (this.eaLeft instanceof ConstRationnelle && this.eaRight instanceof ConstRationnelle) {
			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			ConstRationnelle droite = (ConstRationnelle) this.eaRight;

			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstRationnelle && this.eaRight instanceof ConstEntiere) {
			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;

			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof ConstRationnelle) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			ConstRationnelle droite = (ConstRationnelle) this.eaRight;

			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Exponentielle) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Exponentielle droite = (Exponentielle) this.eaRight;

			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof Exponentielle && this.eaRight instanceof ConstEntiere) {
			Exponentielle gauche = (Exponentielle) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;

			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof VarSymbolique && this.eaRight instanceof ConstEntiere) {
			VarSymbolique gauche = (VarSymbolique) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;
			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof VarSymbolique) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			VarSymbolique droite = (VarSymbolique) this.eaRight;
			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstRationnelle && this.eaRight instanceof VarSymbolique) {

			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			VarSymbolique droite = (VarSymbolique) this.eaRight;
			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof VarSymbolique && this.eaRight instanceof ConstRationnelle) {

			ConstRationnelle droite = (ConstRationnelle) this.eaRight;
			VarSymbolique gauche = (VarSymbolique) this.eaLeft;
			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Addition) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Addition droite = (Addition) this.eaRight;
			res = simplifie(gauche, droite);
		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Soustraction) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Soustraction droite = (Soustraction) this.eaRight;
			res = simplifie(gauche, droite);
		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Multiplication) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Multiplication droite = (Multiplication) this.eaRight;
			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof Sin && this.eaRight instanceof ConstEntiere) {
			Sin gauche = (Sin) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;
			res = simplifie(gauche, droite);
		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Sin) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Sin droite = (Sin) this.eaRight;
			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Division) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Division droite = (Division) this.eaRight;
			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof Multiplication && this.eaRight instanceof ConstEntiere) {
			Multiplication gauche = (Multiplication) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;
			res = simplifie(gauche, droite);
		}

		else {
			res = this;
		}
		return res;

	}

	@Override
	public boolean equals(Object expr2) {
		return this == expr2;

	}

	
}