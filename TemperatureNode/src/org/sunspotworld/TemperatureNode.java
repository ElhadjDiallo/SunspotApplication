package org.sunspotworld;


import com.sun.spot.io.j2me.radiogram.Radiogram;
import com.sun.spot.io.j2me.radiogram.RadiogramConnection;
import java.io.IOException;
import java.util.Timer;
import javax.microedition.io.Connector;
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author userrsus
 */
public class TemperatureNode {


/**
 *
 * RadiagramConnection use for making a connection
 * Radiogram the packet we are going to send
*/
    private RadiogramConnection conn = null;
    private Radiogram xdg;
    /* have all the attributes from sensorchek*/
    private SensorUtililities sensors;
  public TemperatureNode()
  {
     sensors=new SensorUtililities();
  }
  public void connexion() throws IOException, InterruptedException

  {
 // set a timer to send the temperature each 5 seconds
  Timer timer=new Timer();
   
        try {
        // try to connect to the target at the adress 7f00.0101.0000.1002:125
            conn = (RadiogramConnection) Connector.open("radiogram://7f00.0101.0000.1002:125");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {

            xdg = (Radiogram) conn.newDatagram(conn.getMaximumLength());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

       // use timerTask to schedule the task we want to repeat
               timer.scheduleAtFixedRate(new TimerTask()
               {


                    public void run() {
                        try {
                            /*use the attribut temperature from the class sensors to get the temperature
                             * then write the information in a datagram then send it
                             *
                             */



                            System.out.println("Ready to send temperature");
                            double temperature =sensors.getTemp().getCelsius();
                            xdg.writeDouble(temperature);

                        } catch (IOException ex) {

                            ex.printStackTrace();
                        }

                    try {
                        conn.send(xdg);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                           System.out.println("Error sending packet: " + ex);
                    }
                        /**
                         * clear the stream
                         */
                xdg.reset();

                    }

               }, 0,5*1000);




              

         


    

  }


}
