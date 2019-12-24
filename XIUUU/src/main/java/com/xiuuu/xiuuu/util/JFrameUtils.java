package com.xiuuu.xiuuu.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

public class JFrameUtils {
    
    public static void setWindowPosition(JFrame window, int screen) {        
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] allDevices = env.getScreenDevices();
        int topLeftX, topLeftY, screenX, screenY, windowPosX, windowPosY;

        if (screen < allDevices.length && screen > -1) {
            topLeftX = allDevices[screen].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[screen].getDefaultConfiguration().getBounds().y;

            screenX  = allDevices[screen].getDefaultConfiguration().getBounds().width;
            screenY  = allDevices[screen].getDefaultConfiguration().getBounds().height;
        } else {
            
            topLeftX = allDevices[0].getDefaultConfiguration().getBounds().x;
            topLeftY = allDevices[0].getDefaultConfiguration().getBounds().y;

            screenX  = allDevices[0].getDefaultConfiguration().getBounds().width;
            screenY  = allDevices[0].getDefaultConfiguration().getBounds().height;
        }

        windowPosX = ((screenX - window.getWidth())  / 2) + topLeftX;
        windowPosY = ((screenY - window.getHeight()) / 2) + topLeftY;

        window.setLocation(windowPosX, windowPosY);
    }
    
}
