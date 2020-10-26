package Partie1;

public class VarSymbolique implements ExpressionArithmetique {
	//x,y,z... c'est une variable donc ya pas à simplifier 
	
	private final char x;//quel type lui donner ?
	
	public VarSymbolique(char x) {
		this.x = x;
	}
		
	public char getX() {
		return x;
	}

	@Override
	public ExpressionArithmetique simplifier() {		
		return this;
	}

	@Override
	public double calculer() {
		return this.getX();
	}

}
