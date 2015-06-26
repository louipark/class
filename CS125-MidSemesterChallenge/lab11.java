
public class lab11 {

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {
		
		int x=Zen.getZenWidth();
		int y=Zen.getZenHeight();
		lab(x,y);
	}
		public static void lab(int w,int h){
			
	    if (w<=0||h<=0) return; 
	   
	    else{
	   
	        Zen.drawImage("siebel.jpg", 0, 0, w, h);
	        
	        lab(w/4,h/4);
				}
	       }
        }
		
	


