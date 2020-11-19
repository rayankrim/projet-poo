package projet;

public final class ConstEntiere implements ExpressionArithmetique {

	private final int entier;

	public ConstEntiere(int value) {
		this.entier = value;
	}

	public int getEntier() {
		return entier;
	}

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() {
		return this.getEntier();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {

			return false;

		}
		// System.out.println("v1= "+ this.getEntier());
		// System.out.println("v2= " );
		// System.out.println(((ConstEntiere) obj).getEntier() == this.getEntier());
		return ((ConstEntiere) obj).getEntier() == this.getEntier();
	}

	@Override
	public String afficher() {
		return Integer.toString(this.getEntier());
	}

	@Override
	public void derive() {
		// TODO Auto-generated method stub

	}

}
