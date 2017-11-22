/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.uberfire.backend.server.plugins;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.uberfire.backend.server.plugins.engine.PluginManager;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PluginServiceTest {

    @Mock
    PluginManager pluginManager;

    PluginService pluginService;

    @Test
    public void initTest() {
        String path = "/home/dorinha/";
        pluginService = createPluginsService(path);

        pluginService.init(mock(ServletContext.class));

        verify(pluginManager).init(path,
                                   path);
    }

    @Test
    public void initTestNullDirs() {
        String path = null;
        pluginService = createPluginsService(path);

        pluginService.init(mock(ServletContext.class));

        verify(pluginManager,
               never()).init(anyString(),
                             anyString());
    }

    private PluginService createPluginsService(final String validPath) {
        return new PluginService(pluginManager) {
            @Override
            String getPlugins(ServletContext servletContext,
                              String plugins) {
                return validPath;
            }

            @Override
            String getContextRootDir(ServletContext servletContext) {
                return validPath;
            }
        };
    }
}