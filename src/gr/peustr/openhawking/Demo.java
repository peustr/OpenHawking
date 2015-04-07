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

import gr.peustr.openhawking.core.guicomponents.ResourceFrame;
import gr.peustr.openhawking.gui.Menu;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 * Main function that runs the application GUI (MenuScreen).
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
        // Create a new application instance
        ResourceFrame rf = new Menu();
        rf.setLocationRelativeTo(null);
        rf.setAlwaysOnTop(true);
        rf.setVisible(true);
    }

}
