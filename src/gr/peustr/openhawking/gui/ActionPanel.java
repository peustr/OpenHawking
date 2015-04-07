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

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author peustr
 */
public abstract class ActionPanel extends JPanel implements VisualComponent, ActionComponent {

    @Override
    public void setBackgroundColor(Color c) {
        super.setBackground(c);
    }

}
