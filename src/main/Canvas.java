package main;

public class Canvas {
	private static final char LINE_CHAR = 'x';
	private static final char HORIZONTAL_BOUND = '-';
	private static final char VERTICAL_BOUND = '|';
	int height,width;
	char[][] canvas;
	public Canvas(int width, int height) {
		this.height = height;
		this.width = width;
		this.canvas = new char[height+2][width+2];
		setCanvas();
	}
	
	private void setCanvas() {
		for(int i=0;i<height+2;i++) {
			for(int j=0;j<width+2;j++) {
				if(i==0 || i==height+1) {
					canvas[i][j]=HORIZONTAL_BOUND;
				}else if(j==0 || j==width+1) {
					canvas[i][j]=VERTICAL_BOUND;
				}else {
					canvas[i][j]=' ';
				}
			}
		}
		
	}
	
	public void printCanvas() {
		for(int i=0;i<height+2;i++) {
			for(int j=0;j<width+2;j++){
				System.out.print(canvas[i][j]);
			}
			System.out.println();
		}
	}
	public char[][] getCanvas() {
		return canvas;
	}

	public void setCanvas(char[][] canvas) {
		this.canvas = canvas;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void drawLine(int x1, int y1, int x2, int y2) throws Exception {
		checkBoundaries(x1,y1,x2,y2);
		if(x1==x2) {
			for(int i=y1;i<=y2;i++) {
				canvas[i][x1]=LINE_CHAR;
			}
		}else if(y1==y2){
			for(int i=x1;i<=x2;i++) {
				canvas[y1][i]=LINE_CHAR;
			}
		}else {
			throw new Exception("Only vertical or horizontal lines");
		}
		
	}
	
	//Checks if the coordinates are inside the canvas
	private void checkBoundaries(int x1, int y1, int x2, int y2) throws Exception {
		if(x1 <1 || x1>width || x2<1 || x2>width || y1< 1 || y1>height || y2<1 || y2>height) {
			throw new Exception("Coordinates should be inside canvas");
		}
		
	}
	
	public void drawRectangle(int x1, int y1, int x2, int y2) throws Exception {
		checkBoundaries(x1,y1,x2,y2);
		if(x1==x2 || y1==y2) {
			throw new Exception("Cannot draw rectangle with these coordinates");
		}
		for(int i=x1;i<=x2;i++) {
			canvas[y1][i]= LINE_CHAR;
			canvas[y2][i]=LINE_CHAR;
		}
		for(int i=y1;i<=y2;i++) {
			canvas[i][x1]=LINE_CHAR;
			canvas[i][x2]=LINE_CHAR;
		}
	}
	
	public void fillColor(int x1, int y1, char c) throws Exception {
		checkBoundaries(x1,y1,1,1);
		char oldColor = canvas[x1][y1];
		System.out.println("oldcolor  "+oldColor);
		boolean[][] isColored = new boolean[height+2][width+2];
		fillColorCoordinate(x1,y1,c,oldColor,isColored);
	}
	
	// Recursive function to fill color in a coordinate
	private void fillColorCoordinate(int x1, int y1, char c, char oldColor, boolean[][] isColored) throws Exception {
		try {
		checkBoundaries(x1, y1, 1, 1);
		}catch(Exception e) {
			return;
		}
		if(canvas[x1][y1]!=oldColor) {
			return;
		}
		canvas[x1][y1]=c;
		if(!isColored[x1-1][y1]) {
			fillColorCoordinate(x1-1,y1,c,oldColor,isColored);
		}
		if(!isColored[x1+1][y1]) {
			fillColorCoordinate(x1+1,y1,c,oldColor,isColored);
		}
		if(!isColored[x1][y1-1]) {
			fillColorCoordinate(x1,y1-1,c,oldColor,isColored);
		}
		if(!isColored[x1][y1+1]) {
			fillColorCoordinate(x1,y1+1,c,oldColor,isColored);
		}
		
	}

}
