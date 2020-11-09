package projet;

public class Puissance extends OperationBinaire {

	public Puissance(ExpressionArithmetique x, ExpressionArithmetique n) {
		super(x, n);
	}

	public double calculer() throws VarSymboliqueException {
		double a = this.eaLeft.calculer();
		double b = this.eaRight.calculer();
		return Math.pow(a, b);
	}

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return super.simplifie(gauche, droite);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		int num = (int) Math.pow(gauche.getNumerateur(), droite.getEntier());
		int deno = (int) Math.pow(gauche.getDenominateur(), droite.getEntier());
		return new ConstRationnelle(num, deno).simplifier();
	}

	/*
	 * @Override protected ExpressionArithmetique simplifie(ConstRationnelle gauche,
	 * ConstRationnelle droite) {
	 * 
	 * return new ConstRationnelle(num,deno).simplifier(); }
	 */
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		int simp = (int) Math.pow(gauche.getEntier(), droite.getEntier());
		return new ConstEntiere(simp).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		int simp = (int) Math.pow(gauche.getEntier(), droite.calculer());
		return new ConstEntiere(simp).simplifier();
	}

	@Override
	public ExpressionArithmetique simplifier() {
		return super.simplifier();
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String afficher() {
		return eaLeft.afficher() + "^" + eaRight.afficher();
	}
}