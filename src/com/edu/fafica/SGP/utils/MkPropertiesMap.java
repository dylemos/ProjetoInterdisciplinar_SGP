/*
 * Mikrotik4J, Intregrate Java and Mikrotik RouterOS
 *
 * Copyright (c) 2012, Eits It Solutions and Arthur Gregório. 
 * or third-party contributors as indicated by the @author tags or express 
 * copyright attribution statements applied by the authors.  All third-party 
 * contributions are distributed under license by Eits It Solutions.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package com.edu.fafica.SGP.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * The mapping that contains all the data of result ordered by an ID
 *
 * @author Arthur Gregorio
 *
 * @since 1.0
 * @version 1.0, 19/07/2012
 */
public class MkPropertiesMap extends HashMap<Integer, Properties> {

    /**
     * Serial version...
     */
    private static final long serialVersionUID = 666L;

    /**
     * Default constructor, just call
     * <code>super();</code>
     */
    public MkPropertiesMap() {
        super();
    }

    /**
     * Returns the size of map
     *
     * @see java.util.Map#size()
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * Check if the map is empty
     *
     * @see java.util.Map#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Check if the map contains the provided block
     *
     * @param blockId the key to check
     *
     * @return <code>true</code> if contains, <code>false</code> otherwise
     */
    public boolean containsBlock(Integer blockId) {
        return super.containsKey(blockId);
    }

    /**
     * Check if the map contains the provided Property
     *
     * @param property the property to check
     *
     * @return <code>true</code> if contains, <code>false</code> otherwise
     */
    public boolean containsValue(Properties property) {
        return super.containsValue(property);
    }

    /**
     * Get a specific property by an block id
     *
     * @param blockId the key to get the property
     *
     * @return the property
     */
    public Properties get(Integer blockId) {
        return super.get(blockId);
    }

    /**
     * Store a property with provided id
     *
     * @param blockId the id of property in map
     * @param properties the property to store
     *
     * @return the stored property
     */
    @Override
    public Properties put(Integer blockId, Properties properties) {
        return super.put(blockId, properties);
    }

    /**
     * Remove one property by block id
     *
     * @param blockId the index of property to remove
     *
     * @return the removed property
     */
    public Properties remove(Integer blockId) {
        return super.remove(blockId);
    }

    /**
     * Store one map of properties in the map
     *
     * @see java.util.Map#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends Integer, ? extends Properties> mapped) {
        super.putAll(mapped);
    }

    /**
     * Clear the mapped properties and id's
     *
     * @see java.util.Map#clear()
     */
    @Override
    public void clear() {
        super.clear();

    }

    /**
     * Return the values of mapping in one
     * <code>List<Properties></code>
     *
     * @see java.util.Map#values()
     */
    public List<Properties> values() {
        return new ArrayList<>(super.values());
    }
}