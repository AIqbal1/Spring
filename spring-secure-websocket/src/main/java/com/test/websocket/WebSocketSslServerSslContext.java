package com.test.websocket;

import java.security.KeyStore;
import java.security.Security;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;


public class WebSocketSslServerSslContext {
	
	   private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocketSslServerSslContext.class);
	    private static final String PROTOCOL = "TLS";

	    private final SSLContext _serverContext;

	    /**
	     * Returns the singleton instance for this class
	     */
	    public static WebSocketSslServerSslContext getInstance() {
	        return SingletonHolder.INSTANCE;
	    }

	    /**
	     * SingletonHolder is loaded on the first execution of Singleton.getInstance() or the first access to
	     * SingletonHolder.INSTANCE, not before.
	     *
	     * See http://en.wikipedia.org/wiki/Singleton_pattern
	     */
	    private interface SingletonHolder {
	        WebSocketSslServerSslContext INSTANCE = new WebSocketSslServerSslContext();
	    }

	    /**
	     * Constructor for singleton
	     */
	    private WebSocketSslServerSslContext() {
	        SSLContext serverContext = null;
	        try {
	            // Key store (Server side certificate)
	            String algorithm = Security.getProperty("ssl.KeyManagerFactory.algorithm");
	            if (algorithm == null) {
	                algorithm = "SunX509";
	            }

	            try {
	                KeyStore ks = KeyStore.getInstance("JKS");
	                ks.load(SecureChatKeyStore.asInputStream(), SecureChatKeyStore.getKeyStorePassword());

	                // Set up key manager factory to use our key store
	                KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
	                kmf.init(ks, SecureChatKeyStore.getCertificatePassword());

	                
	                TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	                    @Override
	                    public void checkClientTrusted( final X509Certificate[] chain, final String authType ) {
	                    	System.out.println("CLIENT TRUSTED");
	                    }
	                    @Override
	                    public void checkServerTrusted( final X509Certificate[] chain, final String authType ) {
	                    	System.out.println("SERVER TRUSTED");
	                    }
	                    @Override
	                    public X509Certificate[] getAcceptedIssuers() {
	                    	System.out.println("ACCEPTED ISSUERS");
	                        return null;
	                    }
	                } };	                
	                
	                
	                
	                // Initialise the SSLContext to work with our key managers.
	                serverContext = SSLContext.getInstance(PROTOCOL);
	                serverContext.init(kmf.getKeyManagers(), trustAllCerts, null);
	            } catch (Exception e) {
	                throw new Error("Failed to initialize the server-side SSLContext", e);
	            }
	        } catch (Exception ex) {
	            if (logger.isErrorEnabled()) {
	                logger.error("Error initializing SslContextManager. " + ex.getMessage(), ex);
	            }
	            System.exit(1);
	        } finally {
	            _serverContext = serverContext;
	        }
	    }

	    /**
	     * Returns the server context with server side key store
	     */
	    public SSLContext getServerContext() {
	        return _serverContext;
	    }
}
