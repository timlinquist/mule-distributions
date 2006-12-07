/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the BSD style
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.providers.bpm;

import org.mule.umo.UMOException;
import org.mule.umo.endpoint.UMOImmutableEndpoint;
import org.mule.umo.provider.UMOMessageDispatcher;
import org.mule.umo.provider.UMOMessageDispatcherFactory;

/**
 * Creates a WorkflowMessageDispatcher instance.
 *
 * @author <a href="mailto:carlson@hotpop.com">Travis Carlson</a>
 */
public class ProcessMessageDispatcherFactory implements UMOMessageDispatcherFactory
 {
    public UMOMessageDispatcher create(UMOImmutableEndpoint endpoint) throws UMOException {
        return new ProcessMessageDispatcher(endpoint);
    }
}
