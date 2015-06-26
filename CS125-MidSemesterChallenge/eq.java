    import java.awt.BorderLayout;
    import java.awt.Image;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.URL;
    import java.net.URLConnection;
    import java.util.Scanner;
    import javax.imageio.ImageIO;
    import javax.swing.ImageIcon;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
     
    public class eq {
     
            /**
             * @param args
             */
            public static void main(String[] args) {
                    try {
                            URL url = new URL(
                                            "http://earthquake.usgs.gov/earthquakes/catalogs/eqs1day-M1.txt");
                            URLConnection yc = url.openConnection();
                            Scanner keyboard = new Scanner(System.in);
                            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                           
                            String inputLine;
                   
                            String coordinate[] = new String[200];
                           
                           
                            int count = 0;
                            while ((inputLine = in.readLine()) != null){
                                    System.out.println(count+":"+inputLine);
                                    coordinate[count] = extract2(inputLine);
                                    count++;
                                    }
                                   
                            System.out.println("Please type the line of the location to view it (-1 to exit):");
                            boolean running = true;
                           
                            JFrame frame = new JFrame();
                            frame.setVisible(false);
                            while(running)
                            {
                                   
                                    int pos = keyboard.nextInt();
                                    frame.dispose();
                                    if(pos == -1) running = false;
                                    Image image = display(coordinate[pos]);
                                   
                                   
                                    frame = new JFrame(coordinate[pos]);
                                JLabel lblimage = new JLabel(new ImageIcon(image));
                                    frame.getContentPane().add(lblimage, BorderLayout.CENTER);
                                    frame.setSize(300, 400);
                                    frame.setVisible(true);
                                   
                                   
                            }
                                   
                                   
                                   
                           
                            // would be nice to animate these on a world map...
                   
     
     
     
                   
                            in.close();
     
                    } catch (Exception e) {
                            e.printStackTrace();
                    }
            }
     
            public static String extract2(String inputString) {
                    String result = "";
                    boolean coordinate = false;
                    int commaCount = 0;
                    for (int i = 0; i < inputString.length(); i++) {
                            char c = inputString.charAt(i);
                            if (c == ',') {
                                    commaCount++;
                                    if (commaCount == 6) {
                                            coordinate = true;
                                            i++;
                                            commaCount = 0;
                                    }
                            }
     
                            while (coordinate) {
                                    c = inputString.charAt(i);
     
                                    if (c == ',') {
                                            commaCount++;
                                            if (commaCount == 2)
     
                                                    return result;
                                    }
                                    result = result + c;
                                    i++;
                            }
     
                    }
                    return result;
            }
            public static Image display(String coordinate)
            {
                    Image image = null;
                    try {
                            URL url2 = new URL("http://maps.googleapis.com/maps/api/staticmap?center="+coordinate+"&zoom=9&size=400x400&sensor=false");
                            image = ImageIO.read(url2);
                    } catch (IOException e) {
                    }
     
                    // Use a label to display the image
                   
                    return image;
     
            }
    }
