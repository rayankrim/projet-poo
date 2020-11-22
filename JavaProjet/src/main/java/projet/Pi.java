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
		
		int comparaison = ((Pi) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

	@Override
	public String afficher() {
		return this.getPi()+""; 
	}

	

}