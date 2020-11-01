package td3;

import java.util.Map;
import java.util.TreeMap;

public final class VarSymbolique implements ExpressionArithmetique {
	
	private final char variable; 
	
	
	public VarSymbolique(char variable) {
		Map<Character,Character> tableauAssociatifVarS = new TreeMap<Character,Character>();
		tableauAssociatifVarS.put('x','x');
		tableauAssociatifVarS.put('y','y');
		tableauAssociatifVarS.put('z','z');
		this.variable = tableauAssociatifVarS.get(variable);
	}
	
		
	public char getVariable() {
		return this.variable;
	}


	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}


	@Override
	public double calculer() {
		return 0;
	}


}
