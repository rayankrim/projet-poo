package td3;

public class Cos extends OperationUnaire {

	public Cos(ExpressionArithmetique ea) {
	super(ea);
	
	
	
	}
	
	@Override
	public double calculer() {
	
		return Math.cos(this.ea.calculer());
	}



}
