package projet;

import java.util.Map;
import java.util.TreeMap;

public final class VarSymbolique implements ExpressionArithmetique {

	private final String variable;

	public VarSymbolique(String variable) {
		Map<String, String> tableauAssociatifVarS = new TreeMap<>();
		tableauAssociatifVarS.put("x", "x");
		tableauAssociatifVarS.put("y", "y");
		tableauAssociatifVarS.put("z", "z");
		this.variable = tableauAssociatifVarS.get(variable);
	}

	public String getVariable() {
		return this.variable;
	}

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() throws VarSymboliqueException {
		try {
			throw new VarSymboliqueException();

		} catch (Exception e) {

			throw new VarSymboliqueException();

		}

	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		return false;
	}

}