import java.net.*;
import java.io.*;

public class HttpUrlConnection {

        public static void main(String[] args) throws IOException 
        {
            URL url = new URL("https://www.mormon.org/");
            URLConnection conn = url.openConnection();
            BufferedReader buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String s = buff.readLine();
            while (s != null)
            {
                System.out.println(s);
                s = buff.readLine();
            }

           // Attempt to load a page that doesn't exist and show code for page not found
            try 
            {
                URL url2 = new URL("http://www.mormon.org/cit360");
                URLConnection conn2 = url2.openConnection();
                BufferedReader buff2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                String s2 = buff2.readLine();
                while (s2 != null) 
                {
                    System.out.println(s2);
                    s2 = buff2.readLine();
                }
            }
            catch (Exception e)
            {
                System.out.print("Sorry, the page does not exist.\n");
            }

        
            // Test a fake URL
            try 
            {
                URL url3 = new URL("www.cit360spring2018.com");
                URLConnection conn3 = url3.openConnection();
                BufferedReader buff3 = new BufferedReader(new InputStreamReader(conn3.getInputStream()));
                String s3 = buff3.readLine();
                while (s3 != null) 
                {
                    System.out.println(s3);
                    s3 = buff3.readLine();
                }
            }
            catch (Exception e)
            {
                System.out.print("Please enter a valid URL.\n");
            }

          


        }


}