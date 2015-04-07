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
package gr.peustr.openhawking.core;

import gr.peustr.openhawking.gui.VisualActionComponent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peustr
 */
public abstract class SwitchingPolicy {

    protected List<? extends VisualActionComponent> actionComponents;
    protected int selectedIndex;

    // It's a singleton
    protected SwitchingPolicy() {
        actionComponents = new ArrayList<>();
        selectedIndex = 0;
    }

    public void apply(List<? extends VisualActionComponent> actionComponents) {
        if (!this.actionComponents.isEmpty()) {
            this.actionComponents.get(selectedIndex).setBackgroundColor(Color.white);
        }
        this.actionComponents = actionComponents;
        selectedIndex = 0;
        this.actionComponents.get(selectedIndex).setBackgroundColor(Color.orange);
    }

    public void select() {
        actionComponents.get(selectedIndex).act();
    }

    public abstract void next();

}
