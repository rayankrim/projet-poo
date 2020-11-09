package projet;

import java.io.IOException;

public interface ExpressionArithmetique {
	public ExpressionArithmetique simplifier();
	public double calculer() throws VarSymboliqueException;
	boolean egaliteAr(ExpressionArithmetique expr2);
}
