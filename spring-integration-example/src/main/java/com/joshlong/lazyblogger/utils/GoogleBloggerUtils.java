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

package com.joshlong.lazyblogger.utils;


import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Josh Long ( josh@joshlong.com)
 *         <p/>
 *         <p/>
 *         This uses the google data APIs. Any tutorial out there can explain more interesting
 */
public class GoogleBloggerUtils {

    public String createPost(
            String serverUrl,
            String user, String pass, String blogID, String title, String content) throws IOException {
        String ret = null;
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL(serverUrl));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("title", title);
            m.put("description", content);
            m.put("dateCreated", new Date());
            m.put("category", "Java");
            Object[] params = new Object[]{blogID, user, pass, m, true};
            ret = (String) client.execute("metaWeblog.newPost", params);
        } catch (Throwable th) {
            utilities.log(ExceptionUtils.getFullStackTrace(th));
        }
        return ret;
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    private Utilities utilities;


}