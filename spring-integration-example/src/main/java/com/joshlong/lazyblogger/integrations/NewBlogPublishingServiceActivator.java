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

import com.joshlong.lazyblogger.model.BlogPost;
import com.joshlong.lazyblogger.service.IBlogService;
import com.joshlong.lazyblogger.utils.Utilities;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;


/**
 * @author Josh Long ( josh@joshlong.com)
 *         <p/>
 *         This will continuously monitor an email addresss and pull
 *         messages off for consumption by a activator that'll publish it to a blog
 */
public class NewBlogPublishingServiceActivator {


    public Message<?> publishIncomingBlogEntry(Message<?> msg) {
        try {

            BlogPost payload = (BlogPost) msg.getPayload();
            utilities.log("Publishing " + payload.toString());
            blogService.publish(payload);
            return MessageBuilder.withPayload(msg)
                    .copyHeadersIfAbsent(msg.getHeaders())
                    .setReplyChannelName("filesOut")
                    .build();
        } catch (Throwable e) {
            utilities.log(ExceptionUtils.getFullStackTrace(e));
        }
        return null;
    }

    private Utilities utilities;

    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    public IBlogService getBlogService() {
        return blogService;
    }

    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }

    private IBlogService blogService;


}
