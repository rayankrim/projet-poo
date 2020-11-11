package projet;

import java.util.Map;
import java.util.TreeMap;

public final class VarSymbolique implements ExpressionArithmetique {

    private final String variable;
    private ExpressionArithmetique value;


    public VarSymbolique(String variable) {
        Map<String,String> tableauAssociatifVarS = new TreeMap<String,String>();
        tableauAssociatifVarS.put("x","x");
        tableauAssociatifVarS.put("y","y");
        tableauAssociatifVarS.put("z","z");
        this.variable = tableauAssociatifVarS.get(variable);
    }
    
    public String getVariable() {
        return this.variable;
    }
    public int getValue() {
    	if(this.value==null)
    		throw new RuntimeException("Impossible de donner la valeur d'un x qui n'a pas de valeur.");
    	else
    		return (int) this.value.calculer();
    }
    
    public void modifierVariable(int nb) {
    	this.value= new ConstEntiere(nb);
    }
    
    @Override
    public ExpressionArithmetique simplifier() {
        return this;
    }

    public boolean isNull(ExpressionArithmetique v) {
    	return v==null;
    }
    @Override
    public double calculer() {
    	if(this.value==null)
    		throw new RuntimeException("Impossible de calculer un x qui n'a pas de valeur.");
    	else
    		return this.value.calculer();
    	
    }

    
    @Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}
/*
    public static void main (String [] args) throws RuntimeException{
    	ExpressionArithmetique vs=new VarSymbolique('x');
    	ExpressionArithmetique cinq= new ConstEntiere(5);
    	ConstEntiere Cinq= (ConstEntiere) cinq;
    	VarSymbolique Vs= (VarSymbolique) vs;
    	//Vs.modifierVariable(Cinq.getEntier());
    	System.out.println(Vs.getValue());
    	System.out.println(Vs.getVariable());
    	System.out.println(Vs.calculer());
    }
    */

	@Override
	public String afficher() {
		return this.getVariable();
	}
}