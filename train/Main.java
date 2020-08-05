package train;

import train.railway.Point;
import train.railway.Switch;

public class Main {

	public static void main(String[] args) {
	    Sys.ln(new Switch(new Point(1,1), new Point(1,2), new Point(2,1)));
	}
}
