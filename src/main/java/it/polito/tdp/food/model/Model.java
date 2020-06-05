package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {

	FoodDao dao;
	SimpleWeightedGraph<Food, DefaultWeightedEdge> grafo;
	Map<Integer, Food> databaseFood;

	public Model() {
		dao = new FoodDao();
	}

	public void creaGrafo(int qty) {

		databaseFood = new HashMap<Integer, Food>();
		grafo = new SimpleWeightedGraph<Food, DefaultWeightedEdge>(DefaultWeightedEdge.class);

		for (Food f : dao.getVertex(qty))
			databaseFood.put(f.getFood_code(), f);

		Graphs.addAllVertices(grafo, databaseFood.values());

		for (Adiacenze a : dao.getArchi()) {

			Food f1 = databaseFood.get(a.getId1());
			Food f2 = databaseFood.get(a.getId2());

			if (this.grafo.vertexSet().contains(f1) && this.grafo.vertexSet().contains(f2)) {

				DefaultWeightedEdge e = this.grafo.getEdge(f1, f2);

				if (e == null)
					Graphs.addEdge(grafo, f1, f2, a.getPeso());

				else
					this.grafo.setEdgeWeight(e, a.getPeso() + this.grafo.getEdgeWeight(e));

			}

		}
	}

	public SimpleWeightedGraph<Food, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	public Map<Integer, Food> getDatabaseFood() {
		return databaseFood;
	}

	public List<FoodPeso> getCalorie(Food source) {
		List<FoodPeso> esito = new ArrayList<FoodPeso>();

		for (Food f : Graphs.neighborListOf(this.grafo, source))
			esito.add(new FoodPeso(f, Graphs.neighborListOf(this.grafo, f).size()));

		Collections.sort(esito);

		return esito;

	}
}