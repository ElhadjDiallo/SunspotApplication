/*
 * SunSpotApplication.java
 *
 * Created on Nov 9, 2017 4:04:42 PM;
 */

package org.sunspotworld;


import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 * The startApp method of this class is called by the VM to start the
 * application.
 * 
 * The manifest specifies this class as MIDlet-1, which means it will
 * be selected for execution.
 */
public class SunSpotApplication extends MIDlet {

  

    protected void startApp() throws MIDletStateChangeException {
                    // cause the MIDlet to exit
      

      SinkSensor seconReception=new SinkSensor();
    

      Thread t1=new Thread(seconReception);
    
      t1.start();
    }

    protected void pauseApp() {
        // This is not currently called by the Squawk VM
    }

    /**
     * Called if the MIDlet is terminated by the system.
     * It is not called if MIDlet.notifyDestroyed() was called.
     *
     * @param unconditional If true the MIDlet must cleanup and release all resources.
     */
    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
    }
}
