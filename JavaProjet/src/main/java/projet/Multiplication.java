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
        return new ConstRationnelle(gauche.getEntier()*droite.getNumerateur(),droite.getDenominateur()).simplifier();
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
		return new Multiplication(gauche, droite);
	}

	@Override
	public ExpressionArithmetique isNeutre(VarSymbolique gauche, ConstEntiere droite) {
		if (droite.getEntier() == 1) {
			return new VarSymbolique(gauche.getVariable());
		} else if (droite.getEntier() == 0) {
			return new ConstEntiere(droite.getEntier());
		}
		return new ConstEntiere(gauche.getValue() * droite.getEntier()).simplifier();
	}

	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere gauche, VarSymbolique droite) {
		if (gauche.getEntier() == 1) {
			return new VarSymbolique(droite.getVariable());
		} else if (gauche.getEntier() == 0) {
			return new ConstEntiere(gauche.getEntier());
		}
		else if(droite.isValueNull()) {
			
			return this; 
		}
		return new ConstEntiere(gauche.getEntier() * droite.getValue()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstEntiere droite) {
		return isNeutre(gauche, droite);

	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VarSymbolique droite) {
		return isNeutre(gauche, droite);
	}
	
	@Override
    protected ExpressionArithmetique simplifie(ConstEntiere gauche, Addition droite) {
        return new Addition( new Multiplication(gauche,droite.eaLeft), new Multiplication(gauche,droite.eaRight).simplifier() );
    }

    @Override
    protected ExpressionArithmetique simplifie(ConstEntiere gauche, Soustraction droite) {
        return new Soustraction(new Multiplication(gauche,droite.eaLeft),new Multiplication(gauche,droite.eaRight).simplifier());
    }
    
    @Override
    protected ExpressionArithmetique simplifie(ConstRationnelle gauche, VarSymbolique droite) {
     return super.simplifie(gauche, droite);
 }
 
 @Override
    protected ExpressionArithmetique simplifie(VarSymbolique gauche, ConstRationnelle droite) {
     return super.simplifie(gauche, droite);
 }
 
 @Override
    protected ExpressionArithmetique simplifie(ConstEntiere gauche, Multiplication droite) {
     return new Multiplication(new Multiplication(gauche, droite.eaLeft), droite.eaRight).simplifier();
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
            return eaRight.afficher()+""+eaLeft.afficher();
        }
        else if (eaRight instanceof VarSymbolique) {
            return eaLeft.afficher()+""+eaRight.afficher();
        }else if (eaLeft == new ConstEntiere(0)) {
            return eaLeft.afficher();
        }
        return "(" + eaLeft.afficher() + "*" + eaRight.afficher()+ ")";
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
		String result = ((Multiplication) expr2).afficher();
		String result2 = this.afficher();
		int comparaison = result.compareTo(result2);
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

}
