package projet;

import java.util.Map;
import java.util.TreeMap;

public final class Pi implements ExpressionArithmetique {

	private final Double pi;

	public Pi(String pi) {

		Map<String, Double> tableauAssociatif = new TreeMap<>();
		tableauAssociatif.put("pi", 3.141592654);

		this.pi = tableauAssociatif.get(pi);

	}

	public double getPi() {
		return this.pi;
	}

	@Override
	public String toString() {

		return " " + pi;

	}

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() {
		return getPi();
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return null;
	}

}