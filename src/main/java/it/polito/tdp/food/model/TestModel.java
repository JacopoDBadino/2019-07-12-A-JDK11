package it.polito.tdp.food.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		model.creaGrafo(1);

		System.out.println(model.getGrafo().vertexSet().size());
		System.out.println(model.getGrafo().edgeSet().size());

		Food l = null;
		Food beanBurrito = new Food(58100310, "Bean burrito");

		for (Food f : model.getGrafo().vertexSet())
			l = f;
		
		System.out.println(model.getCalorie(beanBurrito).size());
		for (FoodPeso f : model.getCalorie(beanBurrito))
			System.out.println(f.getFood().getDisplay_name());
	}

}
