package main;
import java.util.Scanner;

public class Main {

	private static final char CREATE_CANVAS = 'C';
	private static final char DRAW_LINE = 'L';
	private static final char DRAW_RECTANGLE = 'R';
	private static final char FILL_COLOR = 'B';
	private static final char QUIT = 'Q';
	private static final int CREATE_ARG_LENGTH = 3;
	private static final int LINE_ARG_LENGTH = 5;
	private static final int RECT_ARG_LENGTH = 5;
	private static final int FILL_ARG_LENGTH = 4;
	public static Canvas c;
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String input;
        do {
        	System.out.print("enter command: "); 
        	input = scan.nextLine();
        	try {
        		processInput(input);
        	}catch(Exception e) {
        		System.out.println("Exception. Try again \n "+e.getMessage());
        	}
        }while(!input.equals(String.valueOf(QUIT)));
        scan.close();
	}

	private static void processInput(String input) throws Exception {
		char func = input.charAt(0);
		switch (func) {
			case CREATE_CANVAS:
				System.out.println("create canvas");
				createCanvas(input);
				break;
			case DRAW_LINE:
				System.out.println("Draw line");
				drawLine(input);
				break;
			case DRAW_RECTANGLE:
				System.out.println("Draw rectangle");
				drawRectangle(input);
				break;
			case FILL_COLOR:
				System.out.println("fill colors");
				fillColor(input);
				break;
			case QUIT:
				System.out.println("Quit");
				break;
			default:
				System.out.println("Wrong Input. Enter Q to exit");
		}	
	}


	
	public static void createCanvas(String input) throws Exception {
		String[] args = input.split("\\s");
		if(args.length != CREATE_ARG_LENGTH) {
			throw new Exception("Arg length incorrect");
		}
		c = new Canvas(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
		c.printCanvas();
	}
	
	public static void drawLine(String input) throws Exception {
		if(c == null) {
			throw new Exception("Canvas not created. Enter command to create canvas first");
		}
		String[] args = input.split("\\s");
		if(args.length != LINE_ARG_LENGTH) {
			throw new Exception("Arg length incorrect");
		}
		c.drawLine(Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]),Integer.parseInt(args[4]));
		c.printCanvas();
		
	}
	
	public static void drawRectangle(String input) throws Exception {
		if(c == null) {
			throw new Exception("Canvas not created. Enter command to create canvas first");
		}
		String[] args = input.split("\\s");
		if(args.length != RECT_ARG_LENGTH) {
			throw new Exception("Arg length incorrect");
		}
		c.drawRectangle(Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]),Integer.parseInt(args[4]));
		c.printCanvas();
		
	}

	public static void fillColor(String input) throws Exception {
		if(c == null) {
			throw new Exception("Canvas not created. Enter command to create canvas first");
		}
		String[] args = input.split("\\s");
		if(args.length != FILL_ARG_LENGTH) {
			throw new Exception("Arg length incorrect");
		}
		c.fillColor(Integer.parseInt(args[1]),Integer.parseInt(args[2]),args[3].charAt(0));
		c.printCanvas();
		
	}

}
