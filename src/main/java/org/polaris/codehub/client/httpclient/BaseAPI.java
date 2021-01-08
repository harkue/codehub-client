package org.polaris.codehub.client.httpclient;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.polaris.codehub.client.util.Config;

import java.io.IOException;
import java.util.Objects;

public class BaseAPI {
    public static final MediaType JSON_TYPE = MediaType.get(Config.CONTENT_TYPE);

    public String get(String url) {
        Request request = new Request.Builder().url(url).build();

        try (Response response = DefaultHttpClient.execute(request)) {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String delete(String url) {
        Request request = new Request.Builder().url(url).delete().build();

        try (Response response = DefaultHttpClient.execute(request)) {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String post(String url, String json) {
        Request request = new Request.Builder().url(url).post(RequestBody.create(json, JSON_TYPE)).build();

        try (Response response = DefaultHttpClient.execute(request)) {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String put(String url, String json) {
        Request request = new Request.Builder().url(url).put(RequestBody.create(json, JSON_TYPE)).build();

        try (Response response = DefaultHttpClient.execute(request)) {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
