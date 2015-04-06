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

import java.awt.Color;

/**
 *
 * @author peustr
 */
public class DefaultSwitchingPolicy extends SwitchingPolicy {

    private static final SwitchingPolicy SINGLETON = new DefaultSwitchingPolicy();

    public static final SwitchingPolicy getInstance() {
        return SINGLETON;
    }

    @Override
    public void next() {
        actionComponents.get(selectedIndex).setBackgroundColor(Color.white);
        selectedIndex++;
        if (selectedIndex >= actionComponents.size()) {
            selectedIndex = 0;
        }
        actionComponents.get(selectedIndex).setBackgroundColor(Color.orange);
    }

}
