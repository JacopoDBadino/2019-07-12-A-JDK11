package it.polito.tdp.food.model;

public class FoodPeso implements Comparable<FoodPeso> {

	private Food food;
	private int peso;

	public FoodPeso(Food food, int peso) {
		super();
		this.food = food;
		this.peso = peso;
	}

	public Food getFood() {
		return food;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public int compareTo(FoodPeso o) {
		// TODO Auto-generated method stub
		return -(this.peso - o.getPeso());
	}

}
