/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.test.integration.spring.events.async;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.tck.functional.EventCallback;
import org.mule.test.integration.spring.events.Order;
import org.mule.test.integration.spring.events.OrderManagerBean;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;

/**
 * <code>SpringEventsJmsExampleTestCase</code> is a testcase used to test the
 * example config in the docco. this test is not run when building this module as it
 * relies on Jms, it's used to verify the example config works.
 */
public class SpringEventsJmsAsyncExampleTestCase extends FunctionalTestCase
{
    final AtomicInteger eventCount = new AtomicInteger(0);

    @Override
    protected void doSetUp() throws Exception
    {
        super.doSetUp();
        eventCount.set(0);
    }

    @Override
    protected String getConfigResources()
    {
        return "org/mule/test/integration/spring/events/async/mule-events-example-async-app-context.xml";
    }

    public void testReceiveAsWebService() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        OrderManagerBean orderManager = (OrderManagerBean) muleContext.getRegistry().lookupObject("orderManagerBean");
        assertNotNull(orderManager);
        EventCallback callback = new EventCallback()
        {
            public void eventReceived(MuleEventContext context, Object o) throws Exception
            {
                eventCount.incrementAndGet();
            }
        };
        orderManager.setEventCallback(callback);

        Order order = new Order("Sausage and Mash");
        // Make an async call
        client.dispatch("axis:http://localhost:44444/mule/orderManager?method=processOrderAsync", order, null);

        MuleMessage result = client.request("jms://processed.queue", 10000);
        assertNotNull(result);
        assertEquals("Order 'Sausage and Mash' Processed Async", result.getPayload());
    }
}
