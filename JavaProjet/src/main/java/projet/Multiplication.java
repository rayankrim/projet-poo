package projet;

public class Multiplication extends OperationBinaire {

	public Multiplication(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return new ConstRationnelle(droite.getEntier() * gauche.getNumerateur(), gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return new ConstRationnelle(gauche.getEntier() * droite.getNumerateur(), droite.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(gauche.getNumerateur() * droite.getNumerateur(),
				droite.getDenominateur() * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstEntiere(gauche.getEntier() * droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return new Multiplication(gauche, droite).simplifier();
	}


	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return this.isNeutre();

	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VarSymbolique droite) {
		return this.isNeutre();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Addition droite) {
		return new Addition(new Multiplication(gauche, droite.eaLeft).simplifier(),
				new Multiplication(gauche, droite.eaRight).simplifier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Soustraction droite) {
		return new Soustraction(new Multiplication(gauche, droite.eaLeft).simplifier(),
				new Multiplication(gauche, droite.eaRight).simplifier()).simplifier();
	}

    protected ExpressionArithmetique simplifie(VarSymbolique gauche, VarSymbolique droite) {
        return this;
    }

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Multiplication droite) {
		return new Multiplication(new Multiplication(gauche, droite.eaLeft).simplifier(), droite.eaRight).isNeutre().simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Division droite) {
		return new Division(new Multiplication(gauche, droite.eaLeft).simplifier(), droite.eaRight).simplifier();
	}
	
	@Override
    protected ExpressionArithmetique simplifie(ConstRationnelle gauche, VarSymbolique droite) {
        return this.isNeutre();
    }

    @Override
    protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstRationnelle droite) {
        return this.isNeutre();
    }

	@Override
    public ExpressionArithmetique isNeutre() {

        if(this.eaLeft.equals(new ConstEntiere(0))) {
            return new ConstEntiere(0);
        }else if(this.eaRight.equals(new ConstEntiere(0)) ) {
            return new ConstEntiere(0);
        }
        else if(this.eaRight.equals(new ConstEntiere(1))|| this.eaRight.equals(new ConstRationnelle(1,1))  ) {
            return this.eaLeft;
        }else if(this.eaLeft.equals(new ConstEntiere(1)) || this.eaLeft.equals(new ConstRationnelle(1,1))) {
        	return this.eaRight;
        }
        
        return this;
    }

	@Override
	public double calculer() {
		double approximation = this.eaLeft.calculer() * this.eaRight.calculer();

		approximation = Math.round(approximation * 10000);

		return approximation / 10000;

	}

	@Override
	public String afficher() {
		if (eaLeft instanceof VarSymbolique) {
			return eaRight.afficher() + "" + eaLeft.afficher();
		} else if (eaRight instanceof VarSymbolique) {
			return eaLeft.afficher() + "" + eaRight.afficher();
		} else if (eaLeft == new ConstEntiere(0)) {
			return eaLeft.afficher();
		}
		return "(" + eaLeft.afficher() + "*" + eaRight.afficher() + ")";
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

		int comparaison = ((Multiplication) expr2).afficher().compareTo(this.afficher());

		if (comparaison == 0) {
			return true;
		}
		return false;

	}

}
