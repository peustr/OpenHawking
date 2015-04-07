/*
 * Copyright 2015 Panagiotis Eustratiadis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gr.peustr.openhawking;

import gr.peustr.openhawking.core.DefaultSwitchingPolicy;
import gr.peustr.openhawking.gui.MenuScreen;
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
