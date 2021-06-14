package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Track t0;
	private Track t1;
	private Track t2;
	private Track t3;
	private Artist a;

	private Playlist playlist0;
	private Playlist playlist1;
	private Playlist playlist2;
	private Playlist playlist3;

	private List<Track> l1 = new ArrayList<Track>();
	private List<Track> l2 = new ArrayList<Track>();
	private List<Track> l3 = new ArrayList<Track>();
	private List<Track> l4 = new ArrayList<Track>();
	
	private Map<String, Integer> avaliacoes0 = new HashMap<>();
	private Map<String, Integer> avaliacoes1 = new HashMap<>();
	private Map<String, Integer> avaliacoes2 = new HashMap<>();
	private Map<String, Integer> avaliacoes3 = new HashMap<>();

	
	@BeforeEach
	void setUp() {
		a = new Artist("Anitta");
		t0 = new Track(a, "zero", 0);
		t1 = new Track(a, "cinco", 1);
		t2 = new Track(a, "vinte e cinco", 2);
		t3 = new Track(a, "sessenta", 3);
		
		l1.add(t0);
		l1.add(t1);
		l1.add(t2);
		l1.add(t3);
		
		l2.add(t0);
		l2.add(t1);
		l2.add(t2);
		
		l3.add(t0);
		l3.add(t1);
		l3.add(t3);
		
		l4.add(t0);
		l4.add(t1);
		l4.add(t2);
		l4.add(t3);
		
		avaliacoes0.put("Gabriel", 1);
		avaliacoes0.put("Guilherme", 2);
		avaliacoes0.put("James", 3);
		avaliacoes0.put("Caio", 3);

		avaliacoes1.put("Gabriel", 1);
		avaliacoes1.put("Guilherme", 2);
		avaliacoes1.put("James", 1);
		
		avaliacoes2.put("Gabriel", 1);
		avaliacoes2.put("Guilherme", 2);
		avaliacoes2.put("James", 2);
		
		avaliacoes3.put("Gabriel", 1);
		avaliacoes3.put("Guilherme", 1);
		avaliacoes3.put("James", 2);
		avaliacoes3.put("Caio", 3);
		
		playlist0 = new Playlist(12, l1, avaliacoes0);
		playlist1 = new Playlist(13, l2, avaliacoes1);
		playlist2 = new Playlist(14, l3, avaliacoes2);
		playlist3 = new Playlist(15, l4, avaliacoes3);
		
	}

	@Test
	void testRoundDownToZero() {
		assertEquals(playlist0.averageRatings(), 2.0, DELTA);
	}

	@Test
	void testRoundUpToHalf() {
		assertEquals(playlist1.averageRatings(), 1.5, DELTA);
	}

	@Test
	void testRoundDownToHalf() {
		assertEquals(playlist2.averageRatings(), 1.5, DELTA);
	}

	@Test
	void testRoundUpToOne() {
		assertEquals(playlist3.averageRatings(), 2.0, DELTA);
	}
}
