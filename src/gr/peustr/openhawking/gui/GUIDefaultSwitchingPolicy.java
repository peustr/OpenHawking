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
package gr.peustr.openhawking.gui;

import gr.peustr.openhawking.core.SwitchingPolicy;
import gr.peustr.openhawking.core.guicomponents.ActionComponent;
import gr.peustr.openhawking.core.guicomponents.VisualComponent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The default implementation of SwitchingPolicy for our sample application. The
 * main idea is switching focus between groups of letters and individual
 * letters. When calling the select() method, we take advantage of the act()
 * method of ActionComponents so that a certain action happens (e.g typing a
 * letter). The next() method iterates the elements of a given list, and changes
 * the background color of the selected element, utilizing the VisualComponent
 * interface. This class implements the Singleton design pattern.
 *
 * @author peustr
 * @param <T extends VisualComponent & ActionComponent> Panels of buttons
 * (groups of letters), and buttons themselves (letters).
 */
public class GUIDefaultSwitchingPolicy<T extends VisualComponent & ActionComponent> extends SwitchingPolicy<T> {

    private static final SwitchingPolicy SINGLETON = new GUIDefaultSwitchingPolicy();

    private List<T> components;
    private int selectedIndex;

    private GUIDefaultSwitchingPolicy() {
        components = new ArrayList<>();
        selectedIndex = 0;
    }

    public static final SwitchingPolicy getInstance() {
        return SINGLETON;
    }

    @Override
    public void apply(List<T> components) {
        if (!this.components.isEmpty()) {
            this.components.get(selectedIndex).setBackgroundColor(Color.decode("#F0F1EE"));
            this.components.get(selectedIndex).setForegroundColor(Color.decode("#4C4C4C")); // RGB: 76, 76, 76 - GUI Builder default
        }
        this.components = components;
        selectedIndex = 0;
        this.components.get(selectedIndex).setBackgroundColor(Color.decode("#FB6964"));
        this.components.get(selectedIndex).setForegroundColor(Color.decode("#F0F1EE"));
    }

    @Override
    public void select() {
        components.get(selectedIndex).act();
    }

    @Override
    public void next() {
        components.get(selectedIndex).setBackgroundColor(Color.decode("#F0F1EE"));
        components.get(selectedIndex).setForegroundColor(Color.decode("#4C4C4C")); // RGB: 76, 76, 76 - GUI Builder default
        selectedIndex++;
        if (selectedIndex >= components.size()) {
            selectedIndex = 0;
        }
        components.get(selectedIndex).setBackgroundColor(Color.decode("#FB6964"));
        components.get(selectedIndex).setForegroundColor(Color.decode("#F0F1EE"));
    }

}
