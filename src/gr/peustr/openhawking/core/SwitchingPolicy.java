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
