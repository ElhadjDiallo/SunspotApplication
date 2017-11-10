/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sunspotworld;

import com.sun.spot.resources.Resources;
import com.sun.spot.resources.transducers.IAccelerometer3D;
import com.sun.spot.resources.transducers.IAnalogInput;
import com.sun.spot.resources.transducers.IIOPin;
import com.sun.spot.resources.transducers.ILightSensor;
import com.sun.spot.resources.transducers.IOutputPin;
import com.sun.spot.resources.transducers.ISwitch;
import com.sun.spot.resources.transducers.ITemperatureInput;
import com.sun.spot.resources.transducers.ITriColorLEDArray;
import com.sun.spot.resources.transducers.LEDColor;
import com.sun.spot.sensorboard.EDemoBoard;

/**
 *
 * @author userrsus
 */
public class SensorUtililities {
       private IOutputPin outs[] = EDemoBoard.getInstance().getOutputPins();
    private ILightSensor light = (ILightSensor)Resources.lookup(ILightSensor.class);
    private IAnalogInput analogIn = (IAnalogInput)Resources.lookup(IAnalogInput.class, "A0");
    private IIOPin d0 = (IIOPin)Resources.lookup(IIOPin.class, "D0");
    private IIOPin d1 = (IIOPin)Resources.lookup(IIOPin.class, "D1");
    private ITemperatureInput temp = (ITemperatureInput)Resources.lookup(ITemperatureInput.class, "location=eDemoboard");
    private ISwitch sw1 = (ISwitch)Resources.lookup(ISwitch.class, "SW1");
    private IAccelerometer3D accel = (IAccelerometer3D)Resources.lookup(IAccelerometer3D.class);
    private ITriColorLEDArray leds = (ITriColorLEDArray)Resources.lookup(ITriColorLEDArray.class);
    private LEDColor colors[] = { LEDColor.WHITE, LEDColor.RED, LEDColor.GREEN, LEDColor.BLUE };

    /**
     * @return the light
     */
    public ILightSensor getLight() {
        return light;
    }

    /**
     * @return the analogIn
     */
    public IAnalogInput getAnalogIn() {
        return analogIn;
    }

    /**
     * @return the d0
     */
    public IIOPin getD0() {
        return d0;
    }

    /**
     * @return the d1
     */
    public IIOPin getD1() {
        return d1;
    }

    /**
     * @return the temp
     */
    public ITemperatureInput getTemp() {
        return temp;
    }

    /**
     * @return the sw1
     */
    public ISwitch getSw1() {
        return sw1;
    }

    /**
     * @return the accel
     */
    public IAccelerometer3D getAccel() {
        return accel;
    }

    /**
     * @return the leds
     */
    public ITriColorLEDArray getLeds() {
        return leds;
    }

    /**
     * @return the colors
     */
    public LEDColor[] getColors() {
        return colors;
    }

}
