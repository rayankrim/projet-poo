package projet;

public interface ExpressionArithmetique {
	public ExpressionArithmetique simplifier();

	public double calculer();

	public String afficher();
	public boolean equals(Object expr2);

}
