package org.polaris.codehub.client.httpclient;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.polaris.codehub.client.util.Config;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.X509Certificate;

public class DefaultHttpClient {
    private static final String PRIVATE_TOKEN = "PRIVATE-TOKEN";
    private static final String CONTENT_TYPE = "Content-Type";

    public static OkHttpClient defaultClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            return new OkHttpClient.Builder().addInterceptor(new RequestInterceptor()).sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0]).hostnameVerifier((s, sslSession) -> true).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Response execute(Request request) throws IOException {
        return defaultClient().newCall(request).execute();
    }

    static class RequestInterceptor implements Interceptor {
        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request().newBuilder().addHeader(PRIVATE_TOKEN, Config.PRIVATE_TOKEN)
                    .addHeader(CONTENT_TYPE, CONTENT_TYPE).build();

            return chain.proceed(request);
        }
    }
}
