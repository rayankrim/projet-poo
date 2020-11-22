package projet;

import java.util.Map;
import java.util.TreeMap;

public final class VarSymbolique implements ExpressionArithmetique {

	private final String variable;
	private ExpressionArithmetique value;

	public VarSymbolique(String variable) {
		Map<String, String> tableauAssociatifVarS = new TreeMap<String, String>();
		tableauAssociatifVarS.put("x", "x");
		tableauAssociatifVarS.put("y", "y");
		tableauAssociatifVarS.put("z", "z");
		tableauAssociatifVarS.put("a", "a");
		tableauAssociatifVarS.put("i","i");
		this.variable = tableauAssociatifVarS.get(variable);
	}

	public String getVariable() {
		return this.variable;
	}

	public int getValue() {
		if (isValueNull())
			throw new RuntimeException("Impossible de donner la valeur d'un x qui n'a pas de valeur.");
		else
			return (int) this.value.calculer();
	}

	public void setValue(int nb) {
		this.value = new ConstEntiere(nb);
	}

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	public boolean isValueNull() {
		return this.value == null ? true : false;
	}

	@Override
	public double calculer() {
		if (isValueNull())
			throw new RuntimeException("Impossible de calculer un x qui n'a pas de valeur.");
		else
			return this.value.calculer();

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
		int comparaison = ((VarSymbolique) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}
	
	@Override
	public String afficher() {
		if(this.isValueNull())
			return this.getVariable();
		else
			return this.getValue()+"";
	}

}