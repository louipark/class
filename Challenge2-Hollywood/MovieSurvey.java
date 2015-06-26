//UIUC CS125 FALL 2012 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2012-09-14T17:11:15-0500.186579000
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author lzhou8
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		// TODO: Write your program here
		System.out.println("Welcome. We're interested in how people are watching movies this year.\nThanks for your time. - The WRITERS GUILD OF AMERICA.\nPlease tell us about how you've watched movies in the last month.");
	
		System.out.println("How many movies have you seen at the cinema?");
		int cinemaMovie = TextIO.getlnInt();
		
		System.out.println("How many movies have you seen using a DVD or VHS player?");
		int DVDVHSmovie = TextIO.getlnInt();

		System.out.println("How many movies have you seen using a Computer?");
		int ComputerMovie = TextIO.getlnInt();
		
		System.out.println("Summary: "+cinemaMovie+" Cinema movies, "+DVDVHSmovie+" DVD/VHS movies, "+ComputerMovie+" Computer movies");
		
		int total = 0;
		/* total: the sum of three methods */
        total=cinemaMovie+DVDVHSmovie+ComputerMovie;
        System.out.println("Total: "+total+" movies");
        
        double percenCinema,percenOutCinema;
        /* percenCinema:the percent of movies seen at the cinema to two decimal places
        /* percenOutCinema:the percent of movies seen outside of the cinema to two decimal places */
        percenCinema=((double)cinemaMovie/total)*100;
        percenOutCinema=100-percenCinema;
        TextIO.put("Fraction of movies seen at a cinema: ");
        TextIO.putf("%.2f", percenCinema);
        TextIO.put("%");
        TextIO.putln();		
        TextIO.put("Fraction of movies seen outside of a cinema: ");
        TextIO.putf("%.2f", percenOutCinema);
        TextIO.put("%");
	}
}
