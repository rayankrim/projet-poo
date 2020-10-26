package Partie1;

public class ConstSymbolique implements ExpressionArithmetique{
//exponentionelle et pie 
private final char exponentielleOrPi ;
	
	public ConstSymbolique(char exponentielleOrPi) {
		this.exponentielleOrPi = exponentielleOrPi;
	}

	public double getvalueExpoOrPi() {
		return exponentielleOrPi;
	}
	
	
	//methode pr rentrer 3,14.. dans le symbole Pi 	

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() {
		return this.getvalueExpoOrPi();
	}

}
