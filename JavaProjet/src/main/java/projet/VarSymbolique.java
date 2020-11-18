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
        tableauAssociatifVarS.put("a","a");
        this.variable = tableauAssociatifVarS.get(variable);
    }

    public String getVariable() {
        return this.variable;
    }
    public int getValue() {
        if(isValueNull())
            throw new RuntimeException("Impossible de donner la valeur d'un x qui n'a pas de valeur.");
        else
            return (int) this.value.calculer();
    }

    public void setValue(int nb) {
        this.value= new ConstEntiere(nb);
    }

    @Override
    public ExpressionArithmetique simplifier() {
        return this;
    }

    public boolean isValueNull() {
        return this.value==null ? true:false;
    }
    

    @Override
    public double calculer() {
        if(isValueNull())
            throw new RuntimeException("Impossible de calculer un x qui n'a pas de valeur.");
        else
            return this.value.calculer();

    }


    

    @Override
    public String afficher() {
        return this.getVariable();
    }

	@Override
	public void derive() {
		
	}

	@Override
	public ExpressionArithmetique getFonctionDerivee() {
		// TODO Auto-generated method stub
		return null;
	}

}