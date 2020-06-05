package it.polito.tdp.food.model;

public class FoodPeso implements Comparable<FoodPeso> {

	private Food food;
	private double peso;

	public FoodPeso(Food food, double peso) {
		super();
		this.food = food;
		this.peso = peso;
	}

	public Food getFood() {
		return food;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public int compareTo(FoodPeso o) {
		// TODO Auto-generated method stub
		return (int) -(this.peso - o.getPeso());
	}

}
