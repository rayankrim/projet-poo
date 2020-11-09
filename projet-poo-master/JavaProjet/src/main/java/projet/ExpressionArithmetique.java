package projet;

public interface ExpressionArithmetique {
	public ExpressionArithmetique simplifier();

	public double calculer() throws VarSymboliqueException;

	boolean egaliteAr(ExpressionArithmetique expr2);
}
