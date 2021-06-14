package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Track t0;
	private Track t5;
	private Track t25;
	private Track t60;
	private Track t65;
	private Track t85;
	private Track t120;
	private Track t125;
	private Track t145;
	private Artist a;
	private Artist b;
	private Artist c;
	private Artist d;
	private CollaborationTrack c1;
	private CollaborationTrack c2;
	private List<Artist> l1 = new ArrayList<Artist>();
	private List<Artist> l2 = new ArrayList<Artist>();
			
	@BeforeEach
	void setUp() {
		a = new Artist("Anitta");
		b = new Artist("Becky G");
		c = new Artist("Ludmilla");
		d = new Artist("Snoop Dog");
		
		l1.add(b);
		l2.add(c);
		l2.add(d);
		
		t0 = new Track(a, "zero", 0);
		t5 = new Track(a, "cinco", 5);
		t25 = new Track(a, "vinte e cinco", 25);
		t60 = new Track(a, "sessenta", 60);
		t65 = new Track(a, "sessenta e cinco", 65);
		t85 = new Track(a, "oitenta e cinco", 85);
		t120 = new Track(a, "cento e vinte", 120);
		t125 = new Track(a, "cento e vinte e cinco", 125);
		t145 = new Track(a, "cento e quarenta e cinco", 145);

		c1 = new CollaborationTrack(a, null, 0, l1);
		c2 = new CollaborationTrack(a, null, 0, l2);
	}

	@Test
	void testZeroSeconds() {
		assertEquals("0:00", t0.getDurationString());
	}

	@Test
	void testFiveSeconds() {
		assertEquals("0:05", t5.getDurationString());
	}

	@Test
	void testTwentyFiveSeconds() {
		assertEquals("0:25", t25.getDurationString());
	}

	@Test
	void testOneMinuteZeroSeconds() {
		assertEquals("1:00", t60.getDurationString());
	}

	@Test
	void testOneMinuteFiveSeconds() {
		assertEquals("1:05", t65.getDurationString());
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		assertEquals("1:25", t85.getDurationString());
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		assertEquals("2:00", t120.getDurationString());
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		assertEquals("2:05", t125.getDurationString());
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		assertEquals("2:25", t145.getDurationString());
	}

	@Test
	void testOneCollaborator() {
		assertEquals("Anitta (feat. Becky G)", c1.getFullArtistName());
	}

	@Test
	void testTwoCollaborators() {
		assertEquals("Anitta (feat. Ludmilla, Snoop Dog)", c2.getFullArtistName());
	}
}
