//Rectangle Class
class Rectangle {
	//LOCAL VARIABLES
	private double length = 0; 
	private double width = 0;    	
	
	//0 arg-Rectangle Constructor
	public Rectangle() {
		length = 0;
		width = 0;
	}
	
	//2-arg Length and width Rectangle Constructor
    public Rectangle(double l, double w) {
			length = l;
			width = w;
		}
   
    	//GETTERS
		public double getLength() {
			return length;
		}


		public void setLength(double length) {
			this.length = length;
		}

		//SETTERS
		public double getWidth() {
			return width;
		}

		public void setWidth(double width) {
			this.width = width;
		}

		//COMPUTE RECTANGLE'S AREA
		double computeArea() {
    		double area;
    		area = length * width;
    		return area;
    	}
		//PRINT STATEMENTS FOR RECTANGLE 1
		public String toString() {
			String rect1Area = null;
			rect1Area = "Rectangle with sides " + length + " and "  + width + " has area " + computeArea();
			return rect1Area;
		}
		//PRINT STATEMENTS FOR RECTANGLE 2
		public String toString2() {
			String rect2Area = null;
			rect2Area = "Rectangle with sides " + length + " and "  + width + " has area " + computeArea();
			return rect2Area;
		}
}