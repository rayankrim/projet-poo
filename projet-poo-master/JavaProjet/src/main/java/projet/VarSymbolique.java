package projet;

import java.util.Map;
import java.util.TreeMap;

// import javax.swing.text.html.parser.ParserDelegator;

public final class VarSymbolique implements ExpressionArithmetique {

	private final String variable;
	private int partInt=0;

	public VarSymbolique(String variable) {
		Map<String, String> tableauAssociatifVarS = new TreeMap<>();
		// Map<String, String> tableauAssociatifVarS = new TreeMap<String, String>();
		tableauAssociatifVarS.put("x", "x");
		tableauAssociatifVarS.put("y", "y");
		tableauAssociatifVarS.put("z", "z");
		this.variable = tableauAssociatifVarS.get(variable);
	}

	public String getVariable() {
		return this.variable;
	}
	
	public int getVariableEntier() {
    	return this.partInt;
    }

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() throws VarSymboliqueException {
		try {
			if (partInt==0)
				throw new VarSymboliqueException();
			else
				return getVariableEntier();
		} catch (Exception e) {

			throw new VarSymboliqueException();

		}

	}
	
	 public int modifierVariable(int nb) {
	    	
	    	this.partInt=nb;
	    	return this.partInt;
	    }

	// _______________ Why??? _______________________

	// 	@Override
	// public double calculer() {
	// 	return Double.parseDouble(this.getVariable());

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		return false;
	}
	@Override
	public String afficher() {
		return this.variable;
	}
}