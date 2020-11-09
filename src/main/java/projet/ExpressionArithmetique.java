package projet;

public interface ExpressionArithmetique {
	public ExpressionArithmetique simplifier();

	public double calculer();

	boolean egaliteAr(ExpressionArithmetique expr2);

	public String afficher();
}
