package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet {
	String score = "DEFGABcd";
	ArrayList<Note> note;
	// String score = "D2E2F2G2A2B2c2d2";
	// String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	public void settings() {
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48)
		println(i);
	}

	public void setup() {
		note = new ArrayList<Note>();

		loadNotes();

	}

	public void draw() {
		background(255);

	}

	void drawNotes() {
	}

	public class Note {
		private char note;
		private int duration;

		public Note(char note, int duration) {
			this.note = note;
			this.duration = duration;
		}

		public char getNote() {
			return note;
		}

		public void setNote(char note) {
			this.note = note;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}
	}

	void loadNotes() {
	}

}
