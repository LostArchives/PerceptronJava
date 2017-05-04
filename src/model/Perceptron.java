package model;

public class Perceptron {
	
		public String pointGen(int nbPoint) {
			String data = "";
			
			for (int i = 0 ; i< nbPoint;i++) {
				double point1 = Math.random();
				double point2 = Math.random();
				
				if (point1 + point2 - 1 > 0) {
					data += point1 + " " + point2 + " 1\n";
				}
				else {
					data += point1 + " " + point2 + " -1\n";
				}
			}
			
			return data;
		}
		
}
