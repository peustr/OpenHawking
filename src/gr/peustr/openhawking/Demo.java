/*
 Copyright (C) 2015 Panagiotis Eustratiadis
 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 3 of the License, or
 (at your option) any later version.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package gr.peustr.openhawking;

import gr.peustr.openhawking.core.DefaultSwitchingPolicy;
import gr.peustr.openhawking.gui.MenuScreen;
import javax.swing.UIManager;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

/**
 *
 * @author peustr
 */
public class Demo {

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            ex.printStackTrace(System.err);
        }
        GlobalScreen gs = GlobalScreen.getInstance();
        gs.addNativeMouseListener(new GlobalMouseListener());
        MenuScreen ms = new MenuScreen();
        ms.setLocationRelativeTo(null);
        ms.setAlwaysOnTop(true);
        ms.setVisible(true);
    }

    private static class GlobalMouseListener implements NativeMouseInputListener {

        public GlobalMouseListener() {
        }

        @Override
        public void nativeMouseClicked(NativeMouseEvent nme) {
            if (nme.getButton() == NativeMouseEvent.BUTTON1) {
                DefaultSwitchingPolicy.getInstance().select();
            } else if (nme.getButton() == NativeMouseEvent.BUTTON2) {
                DefaultSwitchingPolicy.getInstance().next();
            }
        }

        @Override
        public void nativeMousePressed(NativeMouseEvent nme) {

        }

        @Override
        public void nativeMouseReleased(NativeMouseEvent nme) {

        }

        @Override
        public void nativeMouseMoved(NativeMouseEvent nme) {

        }

        @Override
        public void nativeMouseDragged(NativeMouseEvent nme) {

        }

    }

}
