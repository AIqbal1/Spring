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

package com.joshlong.lazyblogger.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Josh Long ( josh@joshlong.com)
 *         <p/>
 *         This was designed to represent a blog message. This will be
 *         the canonical message format for the integrations.
 */
public class BlogPost implements Serializable {

    public BlogPost() {
        this.senders = new HashSet<String>();
    }

    public void addSender(String sender) {
        String normalizedSender = StringUtils.defaultString(sender).trim().toLowerCase();

        if (!StringUtils.isEmpty(normalizedSender))
            senders.add(normalizedSender);

    }

    private String author;

    public String getAuthor() {
        return author;
    }

    private Collection<String> senders;

    public Collection<String> getSenders() {
        Collection<String> newSenders = new HashSet<String>();
        newSenders.addAll(this.senders);
        return newSenders;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(this.date).
                append(this.subject).
                append(this.body).
                append(this.author).
                append(this.tags).toHashCode();
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

    @Override
    public boolean equals(Object obj) {
        BlogPost that = (BlogPost) obj;
        return new EqualsBuilder().
                append(this.date, that.date).
                append(this.author, that.author).
                append(this.subject, that.subject).
                append(this.tags, that.tags).
                append(this.body, that.body).
                isEquals();
    }

    private Date date;
    private String subject, tags, body;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
