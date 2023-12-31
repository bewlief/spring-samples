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
package org.apache.struts.chain.commands;

import org.apache.commons.chain.Context;
import org.apache.struts.chain.contexts.ActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Simple abstract class which avoids frequent casting to
 * <code>ActionContext</code> in commands explicitly intended for use with
 * that class.</p>
 */
public abstract class ActionCommandBase implements ActionCommand {

    /**
     * The {@code Log} instance for this class.
     */
    private final Logger log =
        LoggerFactory.getLogger(ActionCommandBase.class);

    // See interface for Javadoc
    public abstract boolean execute(ActionContext actionContext)
        throws Exception;

    // See interface for Javadoc
    public boolean execute(Context context)
        throws Exception {
        log.debug("Executing {}", getClass().getName());
        return execute((ActionContext) context);
    }
}