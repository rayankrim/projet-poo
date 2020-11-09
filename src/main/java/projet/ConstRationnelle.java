package projet;

public final class ConstRationnelle implements ExpressionArithmetique {

	@Override
	public String toString() {
		return "ConstRationnelle [numerateur=" + numerateur + ", denominateur=" + denominateur + "]";
	}

	public ConstRationnelle(double num, double denom) {
		this.numerateur = num;
		this.denominateur = denom;
	}

	public double getNumerateur() {
		return numerateur;
	}

	public double getDenominateur() {
		return denominateur;
	}

	private final double numerateur;
	private final double denominateur;

	@Override
	public ExpressionArithmetique simplifier() {
		double pgcd = gcd(this.numerateur, this.denominateur);
		return new ConstRationnelle(this.numerateur / pgcd, this.denominateur / pgcd);
	}

	private static double gcd(double a, double b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	@Override
	public double calculer() {
		double a = getNumerateur();
		double b = getDenominateur();

		return a / b;
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		return false;
	}

	@Override
	public String afficher() {
		return this.getNumerateur() + "/" + this.getDenominateur();
	}

}
