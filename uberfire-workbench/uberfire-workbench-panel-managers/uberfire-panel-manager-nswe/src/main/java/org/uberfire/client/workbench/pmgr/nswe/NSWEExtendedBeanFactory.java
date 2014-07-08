/*
 * Copyright 2012 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.uberfire.client.workbench.pmgr.nswe;

import org.uberfire.client.workbench.BeanFactory;
import org.uberfire.client.workbench.panels.WorkbenchPanelView;
import org.uberfire.client.workbench.pmgr.nswe.panels.impl.HorizontalSplitterPanel;
import org.uberfire.client.workbench.pmgr.nswe.panels.impl.VerticalSplitterPanel;
import org.uberfire.workbench.model.CompassPosition;

/**
 * A Factory definition to create new instances of managed beans.
 */
public interface NSWEExtendedBeanFactory extends BeanFactory {

    public HorizontalSplitterPanel newHorizontalSplitterPanel( final WorkbenchPanelView eastPanel,
                                                               final WorkbenchPanelView westPanel,
                                                               final CompassPosition position,
                                                               final Integer preferredSize,
                                                               final Integer preferredMinSize );

    public VerticalSplitterPanel newVerticalSplitterPanel( final WorkbenchPanelView northPanel,
                                                           final WorkbenchPanelView southPanel,
                                                           final CompassPosition position,
                                                           final Integer preferredSize,
                                                           final Integer preferredMinSize );

}