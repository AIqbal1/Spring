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

package com.joshlong.lazyblogger.service;

import com.joshlong.lazyblogger.model.BlogPost;
import com.joshlong.lazyblogger.utils.GoogleBloggerUtils;
import com.joshlong.lazyblogger.utils.Utilities;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * @author Josh Long ( josh@joshlong.com)
 *         <p/>
 *         Actually talks to the blogging application.
 */
public class BlogService implements IBlogService {


    public void publish(BlogPost blogPost) {
        this.publish(blogPost.getAuthor(), blogPost.getSubject(), blogPost.getBody());
    }

    private GoogleBloggerUtils googleBloggerUtils;
    private String user, password;
    private Utilities utilities;

    public GoogleBloggerUtils getGoogleBloggerUtils() {
        return googleBloggerUtils;
    }

    public void setGoogleBloggerUtils(GoogleBloggerUtils googleBloggerUtils) {
        this.googleBloggerUtils = googleBloggerUtils;
    }


    private String blogId;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = StringUtils.defaultString(blogId).trim();
    }


    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = StringUtils.defaultString(user).trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.defaultString(password).trim();

    }

    private String blogUrl;

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public void publish(String author, String title, String body) {
        try {
            googleBloggerUtils.createPost(this.blogUrl, this.user, this.password,
                    this.blogId, title, body);
        } catch (Throwable e) {
            utilities.log(ExceptionUtils.getFullStackTrace(e));
        }
    }
}

