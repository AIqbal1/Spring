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
import com.joshlong.lazyblogger.utils.Utilities;


import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.Message;

/**
 * @author Josh Long ( josh@joshlong.com)
 *         <p/>
 *         A simple filter that is given a message and given a chance to veto its procession:
 *         <p/>
 *         true means proceed
 *         false means abort
 */
public class EmailsInFilterAgainstWhitelist {

    public EmailsInFilterAgainstWhitelist() {
        this.emailWhitelist = new ArrayList<String>();
    }

    public List<String> getEmailWhitelist() {
        return emailWhitelist;
    }

    public void setEmailWhitelist(List<String> emailWhitelist) {
        this.emailWhitelist = emailWhitelist;
    }

    private List<String> emailWhitelist;
    private Utilities utilities;

    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    public boolean filterAgainstWhitelist(Message<BlogPost> msg) {
        BlogPost blogPost = msg.getPayload();

        for (String sender : blogPost.getSenders())
            if (this.emailWhitelist.contains(sender))
                return true;

        return false;
    }
}
