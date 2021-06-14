package br.edu.insper.desagil.backend.model;

import java.util.List;
import java.util.Map;

public class Playlist {
	private int id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	public Playlist(int id, List<Track> tracks, Map<String, Integer> ratings) {
		this.id = id;
		this.tracks = tracks;
		this.ratings = ratings;
	}

	public int getId() {
		return id;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Map<String, Integer> getRatings() {
		return ratings;
	}

	public void addTrack(Track track) {
		this.tracks.add(track);
	}
	
	public void putRating(String usuario, int avaliacao) {
		this.ratings.put(usuario, avaliacao);
	}
	
	public double averageRatings() {
		// devolve a média semi arredondada 
		double s = 0;
		for (String nome: this.ratings.keySet()) {
			s += this.ratings.get(nome);
		}
		double average = s / this.ratings.size();
		int i = (int) average;
		double d = average - i;
		
		if ((d >= 0) && (d < 0.26)) {
			return i + 0.0;
		}
		if ((d >= 0.26) && (d < 0.74)) {
			return i + 0.5;
		}
		else {
			return i + 1.0;
		}

	}
}
