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
package gr.peustr.openhawking.core.guicomponents;

import java.util.List;
import javax.swing.JFrame;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseListener;

/**
 * A class that defines a GUI frame that provides ActionPanels and a text
 * resource (in order to convert it to speech).
 *
 * @author peustr
 */
public abstract class ResourceFrame extends JFrame {

    public ResourceFrame() {
        GlobalScreen gs = GlobalScreen.getInstance();
        if (getNativeMouseListener() != null) {
            gs.addNativeMouseListener(getNativeMouseListener());
        }
        if (getNativeKeyListener() != null) {
            gs.addNativeKeyListener(getNativeKeyListener());
        }
    }

    /**
     * Get the action panels of this ResourceFrame (ActionPanel is an abstract
     * class that implements the ActionComponent interface).
     *
     * @return The action panels of this ResourceFrame
     */
    public abstract List<ActionPanel> getActionPanels();

    /**
     * Get the string resource we need to convert into speech.
     *
     * @return The string resource we need to convert into speech
     */
    public abstract String getTextResource();

    /**
     * Set the string resource we need to convert into speech.
     *
     * @param resource The string resource we need to convert into speech
     */
    public abstract void setTextResource(String resource);

    /**
     * Define the mouse controls of this frame. Should always be implemented on
     * instantiation.
     *
     * @return listener a key listener, or null if none specified
     */
    protected abstract NativeMouseListener getNativeMouseListener();

    /**
     * Define the key controls of this frame. Should always be implemented on
     * instantiation.
     *
     * @return listener a key listener, or null if none specified
     */
    protected abstract NativeKeyListener getNativeKeyListener();

}
