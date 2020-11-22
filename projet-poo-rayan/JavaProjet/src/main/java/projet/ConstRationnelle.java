package projet;

public final class ConstRationnelle implements ExpressionArithmetique {

	@Override
	public String toString() {
		return "ConstRationnelle [numerateur=" + numerateur + ", denominateur=" + denominateur + "]";
	}

	public ConstRationnelle(int num, int denom) {
		this.numerateur = num;
		this.denominateur = denom;
	}

	public int getNumerateur() {
		return numerateur;
	}

	public int getDenominateur() {
		return denominateur;
	}

	private final int numerateur;
	private final int denominateur;

	@Override
	public ExpressionArithmetique simplifier() {
		if(this.numerateur == this.denominateur) {
            return new ConstEntiere(numerateur);
        }
		int pgcd = gcd(this.numerateur, this.denominateur);
		return new ConstRationnelle(this.numerateur / pgcd, this.denominateur / pgcd);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	@Override
	public double calculer() {
		int a = getNumerateur();
		int b = getDenominateur();

		return (double) a / b;
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
		
		int comparaison = ((ConstRationnelle) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}
	

	
	
	public String afficher() {
        if (numerateur == denominateur) {
        return ""+numerateur;
    }
        return "(" + numerateur + "/" + denominateur + ")";

}

}
