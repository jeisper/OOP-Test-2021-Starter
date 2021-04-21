package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet {
	String score = "DEFGABcd";
	ArrayList<Note> note;
	// String score = "D2E2F2G2A2B2c2d2";
	// String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

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
		printScore();

	}

	public void draw() {
		background(255);
		drawLines();

	}

	void drawNotes() {
	}

	void loadNotes() {
		for (int i = 0; i < score.length(); i++) {
			char currNote = score.charAt(i);
			int currDuration = 1;
			if (i + 1 != score.length()) {
				char nextChar = score.charAt(i + 1);
				if (Character.isDigit(nextChar)) {
					currDuration = nextChar - '0';
					i++;
				}
			}

			Note notes = new Note(currNote, currDuration);
			note.add(notes);
		}
	}

	void printScore() {
		for (Note notes : note) {
			if (notes.getDuration() == 1) {
				println(notes.getNote() + "-" + notes.getDuration() + "-" + "Quaver");
			} else {
				println(notes.getNote() + "-" + notes.getDuration() + "-" + "Crotchet");
			}
		}
	}

	void drawLines() {
		stroke(0);
		line(200, 150, 800, 150);
		line(200, 200, 800, 200);
		line(200, 250, 800, 250);
		line(200, 300, 800, 300);
		line(200, 350, 800, 350);
	}

}
