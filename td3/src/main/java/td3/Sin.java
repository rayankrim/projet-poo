package td3;

public class Sin extends OperationUnaire {

	public Sin(ExpressionArithmetique ea) {
	super(ea);
	}
	
	@Override
	public double calculer() {
	
		return Math.sin(this.ea.calculer());
	}



}
