package it.polito.tdp.food.model;

public class Adiacenze implements Comparable<Adiacenze> {

	private int id1;
	private int id2;
	private double peso;

	public Adiacenze(int id1, int id2, double peso) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.peso = peso;
	}

	public int getId1() {
		return id1;
	}

	public int getId2() {
		return id2;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public int compareTo(Adiacenze o) {
		// TODO Auto-generated method stub
		return (int) (this.peso - o.getPeso());
	}

}
