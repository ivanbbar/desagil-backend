package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track{
	private List<Artist> collaborators;
	
	public CollaborationTrack(Artist artist, String name, int duration, List<Artist> collaborators) {
		super(artist, name, duration);
		this.collaborators = new ArrayList<>();
	}
	
	public String getFullArtistName() {
		// se a faixa tem “Anitta” como artista e “Ludmilla” e “Snoop Dog” 
		// como colaboradores, o método deve devolver "Anitta (feat. Ludmilla, Snoop Dog)"

		String cantor = this.getArtist().getName();
		List<String> l = new ArrayList<>();
		for (Artist artist: collaborators) {
		    l.add(artist.getName());
		}
		
		return cantor + " (feat. ".join(",", l) + ")";
	}

}
