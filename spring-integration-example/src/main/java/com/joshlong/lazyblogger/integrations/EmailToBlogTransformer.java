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
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.integration.Message;
import org.springframework.integration.core.MessageHandler;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Josh Long ( josh@joshlong.com)
 *         <p/>
 *         This class is a Transformer. A Transformer converts the payload
 *         of the message on the inbound channel to the payload expected by the outbound channel.
 *         <p/>
 *         There are prebuilt payloads, like string-to-byte, and - as this
 *         example illustrates - you can build your own.
 */
public class EmailToBlogTransformer { //implements org.springframework.integration.transformer.Transformer {

    private String emailFromAddress(Address address) {
        if (address instanceof InternetAddress) {
            InternetAddress iaInternetAddress = (InternetAddress) address;
            return iaInternetAddress.getAddress();
        }
        return address.toString();
    }

    public Message<?> transformFromMimeMessageToBlogPost(Message<?> msg) {
        Message<?> response = null;            // if this is null, the message will just get dropped.
        BlogPost blogPost = new BlogPost();
        try {

            MimeMessage mimeMessage = (MimeMessage) msg.getPayload();
            blogPost.setSubject(mimeMessage.getSubject());
            blogPost.setDate(mimeMessage.getSentDate());
            blogPost.setBody(IOUtils.toString(mimeMessage.getInputStream()));

            if (mimeMessage.getSender() != null)
                blogPost.addSender(emailFromAddress(mimeMessage.getSender()));

            if (mimeMessage.getFrom() != null)
                for (Address address : mimeMessage.getFrom())
                    blogPost.addSender(emailFromAddress(address));

            response = MessageBuilder.withPayload(blogPost)
                    .copyHeadersIfAbsent(msg.getHeaders())
                    .build();
        } catch (Throwable e) {
            utilities.log(ExceptionUtils.getFullStackTrace(e));
        }
        return response;
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    private Utilities utilities;


}
