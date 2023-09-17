/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.struts.tiles.definition;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.struts.tiles.ComponentDefinition;
import org.apache.struts.tiles.DefinitionsFactoryException;
import org.apache.struts.tiles.FactoryNotFoundException;
import org.apache.struts.tiles.xmlDefinition.I18nFactorySet;
import org.apache.struts.util.RequestUtils;

/**
 * A reloadable factory.
 * This factory is the main entrance to any factory implementation. It takes in
 * charge real implementation instance, and allows reloading by creating a new
 * instance.
 *
 * @since Struts 1.1
 * @version $Rev$ $Date$
 */
@SuppressWarnings("deprecation")
public class ReloadableDefinitionsFactory implements org.apache.struts.tiles.ComponentDefinitionsFactory {
    private static final long serialVersionUID = 1432127365659932325L;

    /**
     * The real factory instance.
     */
    protected org.apache.struts.tiles.ComponentDefinitionsFactory factory = null;

    /**
     * Initialization parameters.
     */
    protected Map<String, Object> properties = null;

    /**
     * Name of init property carrying factory class name.
     */
    public static final String DEFINITIONS_FACTORY_CLASSNAME =
        "definitions-factory-class";

    /**
     * Constructor.
     * Create a factory according to servlet settings.
     * @param servletContext Our servlet context.
     * @param servletConfig Our servlet config.
     * @throws DefinitionsFactoryException If factory creation fail.
     */
    public ReloadableDefinitionsFactory(
        ServletContext servletContext,
        ServletConfig servletConfig)
        throws DefinitionsFactoryException {

        properties = new ServletPropertiesMap(servletConfig);
        factory = createFactory(servletContext, properties);
    }

    /**
     * Constructor.
     * Create a factory according to servlet settings.
     * @param servletContext Our servlet context.
     * @param properties Map containing all properties.
     * @throws DefinitionsFactoryException If factory creation fail.
     */
    public ReloadableDefinitionsFactory(
        ServletContext servletContext,
        Map<String, Object> properties)
        throws DefinitionsFactoryException {

        this.properties = properties;
        factory = createFactory(servletContext, properties);
    }

    /**
    * Create Definition factory from provided classname.
    * If a factory class name is provided, a factory of this class is created. Otherwise,
    * a default factory is created.
    * Factory must have a constructor taking ServletContext and Map as parameter.
    * @param classname Class name of the factory to create.
    * @param servletContext Servlet Context passed to newly created factory.
    * @param properties Map of name/property passed to newly created factory.
    * @return newly created factory.
    * @throws DefinitionsFactoryException If an error occur while initializing factory
    */
    public org.apache.struts.tiles.ComponentDefinitionsFactory createFactoryFromClassname(
        ServletContext servletContext,
        Map<String, Object> properties,
        String classname)
        throws DefinitionsFactoryException {

        if (classname == null) {
            return createFactory(servletContext, properties);
        }

        // Try to create from classname
        try {
            Class<?> factoryClass = RequestUtils.applicationClass(classname);
            org.apache.struts.tiles.ComponentDefinitionsFactory factory =
                (org.apache.struts.tiles.ComponentDefinitionsFactory) factoryClass.newInstance();
            factory.initFactory(servletContext, properties);
            return factory;

        } catch (ClassCastException ex) { // Bad classname
            throw new DefinitionsFactoryException(
                "Error - createDefinitionsFactory : Factory class '"
                    + classname
                    + " must implements 'ComponentDefinitionsFactory'.",
                ex);

        } catch (ClassNotFoundException ex) { // Bad classname
            throw new DefinitionsFactoryException(
                "Error - createDefinitionsFactory : Bad class name '"
                    + classname
                    + "'.",
                ex);

        } catch (InstantiationException ex) { // Bad constructor or error
            throw new DefinitionsFactoryException(ex);

        } catch (IllegalAccessException ex) {
            throw new DefinitionsFactoryException(ex);
        }

    }

    /**
    * Create default Definition factory.
    * Factory must have a constructor taking ServletContext and Map as parameter.
    * In this implementation, default factory is of class I18nFactorySet
    * @param servletContext Servlet Context passed to newly created factory.
    * @param properties Map of name/property passed to newly created factory.
    * @return newly created factory.
    * @throws DefinitionsFactoryException If an error occur while initializing factory
    */
    public org.apache.struts.tiles.ComponentDefinitionsFactory createDefaultFactory(
        ServletContext servletContext,
        Map<String, Object> properties)
        throws DefinitionsFactoryException {

        org.apache.struts.tiles.ComponentDefinitionsFactory factory =
            new I18nFactorySet(servletContext, properties);

        return factory;
    }

    /**
    * Create Definition factory.
    * Convenience method. ServletConfig is wrapped into a Map allowing retrieval
    * of init parameters. Factory classname is also retrieved, as well as debug level.
    * Finally, approriate createDefinitionsFactory() is called.
    * @param servletContext Servlet Context passed to newly created factory.
    * @param properties Map containing all properties.
    */
    public org.apache.struts.tiles.ComponentDefinitionsFactory createFactory(
        ServletContext servletContext,
        Map<String, Object> properties)
        throws DefinitionsFactoryException {

        String classname = (String) properties.get(DEFINITIONS_FACTORY_CLASSNAME);

        if (classname != null) {
            return createFactoryFromClassname(servletContext, properties, classname);
        }

        return new I18nFactorySet(servletContext, properties);
    }

    /**
     * Get a definition by its name.
     * Call appropriate method on underlying factory instance.
     * Throw appropriate exception if definition or definition factory is not found.
     * @param definitionName Name of requested definition.
     * @param request Current servlet request.
     * @param servletContext Current servlet context.
     * @throws FactoryNotFoundException Can't find definition factory.
     * @throws DefinitionsFactoryException General error in factory while getting definition.
     */
    public ComponentDefinition getDefinition(
        String definitionName,
        ServletRequest request,
        ServletContext servletContext)
        throws FactoryNotFoundException, DefinitionsFactoryException {

        return factory.getDefinition(
            definitionName,
            (HttpServletRequest) request,
            servletContext);
    }

    /**
     * Reload underlying factory.
     * Reload is done by creating a new factory instance, and replacing the old instance
     * with the new one.
     * @param servletContext Current servlet context.
     * @throws DefinitionsFactoryException If factory creation fails.
     */
    public void reload(ServletContext servletContext)
        throws DefinitionsFactoryException {

        org.apache.struts.tiles.ComponentDefinitionsFactory newInstance =
            createFactory(servletContext, properties);

        factory = newInstance;
    }

    /**
     * Get underlying factory instance.
     * @return ComponentDefinitionsFactory
     */
    public org.apache.struts.tiles.ComponentDefinitionsFactory getFactory() {
        return factory;
    }

    /**
      * Init factory.
      * This method is required by interface ComponentDefinitionsFactory. It is
      * not used in this implementation, as it manages itself the underlying creation
      * and initialization.
      * @param servletContext Servlet Context passed to newly created factory.
      * @param properties Map of name/property passed to newly created factory.
      * Map can contain more properties than requested.
      * @throws DefinitionsFactoryException An error occur during initialization.
    */
    public void initFactory(ServletContext servletContext, Map<String, Object> properties)
        throws DefinitionsFactoryException {
        // do nothing
    }

    /**
     * Return String representation.
     * @return String representation.
     */
    public String toString() {
        return factory.toString();
    }

    /**
     * Inner class.
     * Wrapper for ServletContext init parameters.
     * Object of this class is an HashMap containing parameters and values
     * defined in the servlet config file (web.xml).
     */
    class ServletPropertiesMap extends HashMap<String, Object> {
        private static final long serialVersionUID = -1834721489197689992L;

        /**
         * Constructor.
         */
        ServletPropertiesMap(ServletConfig config) {
            // This implementation is very simple.
            // It is possible to avoid creation of a new structure, but this would
            // imply writing all of the Map interface.
            Enumeration<String> e = config.getInitParameterNames();
            while (e.hasMoreElements()) {
                String key = e.nextElement();
                put(key, config.getInitParameter(key));
            }
        }
    } // end inner class
}