/*
*  Licensed to the Apache Software Foundation (ASF) under one or more
*  contributor license agreements.  See the NOTICE file distributed with
*  this work for additional information regarding copyright ownership.
*  The ASF licenses this file to You under the Apache License, Version 2.0
*  (the "License"); you may not use this file except in compliance with
*  the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*
*/

package com.joshlong.lazyblogger.integrations;

import org.springframework.integration.Message;
import org.springframework.integration.core.MessageHandler;

import com.joshlong.lazyblogger.model.BlogPost;
import com.joshlong.lazyblogger.utils.Utilities;



/**
 * @author Josh Long ( josh@joshlong.com)
 *         <p/>
 *         This class provides the functionality. The functionality takes the
 *         message payload and publishes it to a blog that's been configured.
 */
public class OutboundBlogPostHandler implements MessageHandler {

    private Utilities utilities;

    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    public void handleMessage(Message<?> message) {


        BlogPost blogPost = (BlogPost) message.getPayload();

        utilities.log("About to publish: " + blogPost.toString());


    }
}
