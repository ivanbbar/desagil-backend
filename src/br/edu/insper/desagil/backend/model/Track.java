package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private int duration;
	
	public Track(Artist artist, String name, int duration) {
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}
	
	public String getDurationString() {
		// se a duração é 5, devolve a string "0:05"
		int min = (int) duration/60;
		int sec = duration - min*60;
		if (sec > 10) {
			return Integer.toString(min) + ":" + Integer.toString(sec);
		}
		else {
			return Integer.toString(min) + ":0" + Integer.toString(sec);
		}
	}
	
	public String getFullArtistName() {
		// simplesmente devolver o nome do artista
		return artist.getName();
	}

}
