package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet {
	ArrayList<Note> note;
	// String score = "DEFGABcd";
	// String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

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
		drawNotes();

	}

	void drawNotes() {
		float textX = 0;
		float textY = 150;
		float ellipseX = 0;
		float ellipseY = 0;
		float lineX = 0;
		float lineY1 = 0;
		float lineY2 = 0;

		for (int i = 0; i < note.size(); i++) {
			textX = map(i, 0, note.size(), 210, 790);
			ellipseX = map(i, 0, note.size(), 210, 790);
			ellipseY = map(i, 0, note.size(), 290, 190);
			lineX = map(i, 0, note.size(), 220, 800);
			lineY1 = map(i, 0, note.size(), 285, 195);
			lineY2 = map(i, 0, note.size(), 240, 150);

			textSize(30);

			text(note.get(i).getNote(), textX, textY);
			fill(0);
			ellipse(ellipseX, ellipseY, 20, 20);
			fill(0);
			line(lineX, lineY1, lineX, lineY2);
			// line(220, 240, 230, 250);
			strokeWeight(2);
		}
		// ellipse(210, 290, 20, 20);
		// fill(0);
		// line(220, 290, 220, 240);
		// line(220, 240, 230, 250);
		// strokeWeight(2);
		if (mouseX > 200 && mouseX < 220) {
			fill(255, 0, 0);
		}

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
		line(200, 200, 800, 200);
		line(200, 220, 800, 220);
		line(200, 240, 800, 240);
		line(200, 260, 800, 260);
		line(200, 280, 800, 280);
	}

}
