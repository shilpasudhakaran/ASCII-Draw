package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Main;

public class MainTest {

	@Test
	public void testCreateCanvas() throws Exception {
        String input ="C 10 10";
		Main.createCanvas(input);
		assertEquals(10, Main.c.getHeight());
		assertEquals(10, Main.c.getWidth());
	}

	@Test (expected = Exception.class) 
	public void testCreateCanvasError() throws Exception {
		
			String input ="C 10";
			Main.createCanvas(input);
	}

	@Test
	public void testDrawLine() throws Exception {
		String input ="C 10 10";
		Main.createCanvas(input);
		Main.drawLine("L 1 1 1 5");
		assertEquals('x',Main.c.getCanvas()[1][1] );
	}
	
	@Test (expected = Exception.class) 
	public void testDrawLineError() throws Exception {
		String input ="C 10 10";
		Main.createCanvas(input);
		Main.drawLine("L 1 1 1 11");
	}
	
	@Test
	public void testDrawRectngle() throws Exception {
		String input ="C 10 10";
		Main.createCanvas(input);
		Main.drawRectangle("R 1 1 5 5");
		assertEquals('x',Main.c.getCanvas()[1][1] );
	}
	
	@Test (expected = Exception.class) 
	public void testDrawRectangleError() throws Exception {
		String input ="C 10 10";
		Main.createCanvas(input);
		Main.drawLine("L 1 1 1 11");
	}
	
	@Test
	public void testFillColor() throws Exception {
		String input ="C 10 10";
		Main.createCanvas(input);
		Main.fillColor("B 2 2 t");
		assertEquals('t',Main.c.getCanvas()[1][1] );
	}
}
