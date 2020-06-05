package it.polito.tdp.food.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		model.creaGrafo(2);

		System.out.println(model.getGrafo().vertexSet().size());
		System.out.println(model.getGrafo().edgeSet().size());

		Food l = null;

		for (Food f : model.getGrafo().vertexSet())
			l = f;
		
		System.out.println(model.getCalorie(l).size());
	}

}
