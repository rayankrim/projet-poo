package projet;

import java.util.Map;
import java.util.TreeMap;

public final class ConstanteSymbolique implements ExpressionArithmetique {

	private final Double exponentielleOrPi;

	public ConstanteSymbolique(String exponentielleOrPi) {

		Map<String, Double> tableauAssociatif = new TreeMap<>();
		tableauAssociatif.put("pi", 3.141592654);
		tableauAssociatif.put("e", 2.71828182846);

		this.exponentielleOrPi = tableauAssociatif.get(exponentielleOrPi);

	}

	public double getvalueExpoOrPi() {
		return this.exponentielleOrPi;
	}

	@Override
	public String toString() {

		return " " + exponentielleOrPi;

	}

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() {
		return getvalueExpoOrPi();
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