/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sunspotworld;

import com.sun.spot.io.j2me.radiogram.Radiogram;
import com.sun.spot.io.j2me.radiogram.RadiogramConnection;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.io.Connector;

/**
 *
 * @author userrsus
 */
public class LightsensorNode {
    /**
     * attribut to get the light
     * open a connection send and receive
     * to create a packet
     */

     private SensorUtililities sensors;
    private RadiogramConnection conn;
    private Radiogram xdg;
    private int lightStatus;
            public LightsensorNode()
             {
                     sensors=new SensorUtililities();
                    
              }

            public void sendLightStatus()
          {
              Timer timer=new Timer();
  
        try {
/*
 *
 * connect to the server on port 123 the adress of the the target is 7f00.0101.0000.1002
 */
            conn = (RadiogramConnection) Connector.open("radiogram://7f00.0101.0000.1002:123");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            xdg = (Radiogram) conn.newDatagram(conn.getMaximumLength());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        timer.scheduleAtFixedRate(new TimerTask()
               {


                    public void run() {
                        try {
                            /*
                             *
                             * read the light that the node detect
                             * create a packet then send the packet
                             */
                            System.out.println("Ready to send the light Status");
                           lightStatus=sensors.getLight().getValue();

                            xdg.writeInt(lightStatus);

                        } catch (IOException ex) {

                            ex.printStackTrace();
                        }

                    try {
                        conn.send(xdg);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                           System.out.println("Error sending packet: " + ex);
                    }
                xdg.reset();

                    }

               },0,7*1000);




     }
}
