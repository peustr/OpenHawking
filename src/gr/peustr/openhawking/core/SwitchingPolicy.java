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

import java.util.List;

/**
 * Class that is responsible for switching focus between lists of components.
 * The switching of focus happens when the apply() method is called. The
 * select() method defines what happens when a certain list element is selected,
 * and the next() method is responsible for iterating between elements. For
 * example the default implementation for our GUI, switches focus between the
 * groups of letters and the individual letters. The current design of this
 * abstract class suggests that offspring should be Singletons.
 *
 * @author peustr
 * @param <T> The type of list elements.
 */
public abstract class SwitchingPolicy<T> {

    protected SwitchingPolicy() {
    }

    /**
     * Apply the switching policy to a list of components.
     *
     * @param components
     */
    public abstract void apply(List<T> components);

    /**
     * Define the behavior of the selected component.
     */
    public abstract void select();

    /**
     * Iterate to the next element in the list of components.
     */
    public abstract void next();

}
