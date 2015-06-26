//UIUC CS125 FALL 2012 MP. File: TodaysEarthquakes.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TodaysEarthquakes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://earthquake.usgs.gov/earthquakes/catalogs/eqs1day-M1.txt");
			URLConnection yc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null){
				System.out.println(inputLine);
			  
	}
			 
			// would be nice to animate these on a world map...
			
			in.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
