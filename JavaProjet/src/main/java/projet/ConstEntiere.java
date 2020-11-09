package projet;

public final class ConstEntiere implements ExpressionArithmetique {

	public ConstEntiere(int value) {
		this.entier = value;
	}

	public int getEntier() {
		return entier;
	}

	private final int entier;

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() {
		return this.getEntier();
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		return false;
	}
	@Override
	public String afficher() {
		return this.getEntier() + "";
	}
}
