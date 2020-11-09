package projet;

import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.parser.ParserDelegator;

public final class VarSymbolique implements ExpressionArithmetique {

	private final String variable;

	public VarSymbolique(String variable) {
		Map<String, String> tableauAssociatifVarS = new TreeMap<String, String>();
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
	public double calculer() {
		return Double.parseDouble(this.getVariable());
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		return false;
	}

	@Override
	public String afficher() {
		return this.variable;
	}

}
