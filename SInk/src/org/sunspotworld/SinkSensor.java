/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sunspotworld;
import  java.util.Hashtable;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.Datagram;
import javax.microedition.io.DatagramConnection;

/**
 *
 * @author userrsus
 */
public class SinkSensor implements Runnable {

  /* temperature to get the temperature receive 
   * lightStatus to get the temperature receive 
   * recvConn to open a connection send or receive a packet
   *   Datagram like his name to create a packet
   */
    private double temperature;
    private int lightStatus;
      private  DatagramConnection recvConn;
    private  Datagram  dg;

  
   public SinkSensor()
    {
     
   }



    /**
     * @return the recvConn
     */
    public  DatagramConnection getRecvConn() {
        return recvConn;
    }

    /**
     * @return the dg
     */
    public  Datagram getDg() {
        return dg;
    }


   public void connexion()
    {
        try {
            /**
             *
             * start the node on server mode to receive on the port 120
             */
            recvConn = (DatagramConnection) Connector.open("radiogram://:120");
            dg = recvConn.newDatagram(recvConn.getMaximumLength());

        } catch (IOException ex) {
            ex.printStackTrace();
        }


   }
   public void receive()
    {
       connexion();

        while(true)
            {
            try {
                 /**
                  * open a connection receive a temperature which type is
                  * double and the  light status int so there is
                  * to reception
                  *
                  */
                getRecvConn().receive(getDg());

                 this.temperature=getDg().readDouble();

                
                   getDg().reset();
                  getRecvConn().receive(getDg());
                  this.lightStatus=getDg().readInt();
                  getDg().reset();
                  // clear the stream
                   System.out.println("the temperature is "+temperature+"and the light status is"+lightStatus);
             


            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

   }

    public void run() {
        receive();
    }


}
