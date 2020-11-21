package projet;

public class Puissance extends OperationBinaire {

    public Puissance(ExpressionArithmetique x,ExpressionArithmetique n) {
        super(x,n);
    }

    public double calculer() {
    	if(this.eaLeft instanceof VarSymbolique && this.eaRight.calculer()==0)
    		return 1;
    	else {
            double a = this.eaLeft.calculer();
            double b= this.eaRight.calculer();
            return Math.pow(a, b);
    	}
    }

    @Override
    protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
        return super.simplifie(gauche, droite);
    }
    
    @Override
    protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
        int simp = (int) Math.pow(gauche.getEntier(), droite.getEntier());
        return new ConstEntiere(simp).simplifier();
    }
    
    @Override
    protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
        int num= (int) Math.pow(gauche.getNumerateur(),droite.getEntier());
        int deno = (int) Math.pow(gauche.getDenominateur(),droite.getEntier());
        return new ConstRationnelle(num,deno).simplifier();
    }

    @Override
    protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
        int simp = (int)Math.pow(gauche.getEntier(), droite.calculer());
        return new ConstEntiere(simp).simplifier();
    }
    
    // je rajoute le cas de la puissance d'une VarSymbolique à la puissance pour les questions 11 et 12
    @Override
    protected ExpressionArithmetique simplifie(VarSymbolique gauche, VarSymbolique droite) {
    	if(gauche.isValueNull() || droite.isValueNull())
    		return this;
    	else {
    		int simp = (int) Math.pow(gauche.getValue(),droite.getValue());
    		return new ConstEntiere(simp).simplifier();
    	}
    }
    //quelle est l'utilité de la méthode ci-dessous?
   /* @Override
    public ExpressionArithmetique simplifier() {
        return super.simplifier();
    }*/
    
	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String afficher() {
		return this.eaLeft.afficher() + "^" + this.eaRight.afficher();
	}


}