package de.droidenschmiede.sbahnboard.helper;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;

import de.droidenschmiede.sbahnboard.config.ApiKey;
import de.droidenschmiede.sbahnboard.interfaces.VolleyInterface;
import de.droidenschmiede.sbahnboard.objects.CustomError;
import de.droidenschmiede.sbahnboard.objects.Departures;

/**
 * Created by bene on 27.07.2017.
 * Helper class for API requests
 */

public class ApiHelper {

    public void testRequest(Context c, final VolleyInterface callback){
        String url = "https://demo.hafas.de/openapi/vbb-proxy/departureBoard?id=9066101&direction=009049202&format=json&accessId=";
        url += ApiKey.API_KEY;
        doRequest(c, callback,url, Departures.class, Request.Method.GET,null);
    }

    /**
     * Do network Request
     * @param c - Calling Context
     * @param callback - Callback Interface
     * @param url - URL
     * @param responseType - corresponding Class for the expected response
     * @param requestMethod - Request method, e.g. GET,POST,PUT,...
     * @param requestBody - JsonObject to be used as a request Body
     */
    private void doRequest(Context c, final VolleyInterface callback, String url, final Class responseType, int requestMethod, final String requestBody) {

        RequestQueue queue = Volley.newRequestQueue(c);
        StringRequest jsonObjectRequest = new StringRequest(requestMethod, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onResponse(response, responseType);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    if (error.networkResponse != null) {
                        String responseContent = new String(error.networkResponse.data, "UTF-8");
                        callback.onResponse(responseContent, CustomError.class);
                    } else {
                        Log.d("VolleyHelper", "Network CustomError 1");
                    }

                } catch (UnsupportedEncodingException e) {
                    Log.d("VolleyHelper", "Network CustomError 2");
                    e.printStackTrace();
                }
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };

        queue.add(jsonObjectRequest);

    }
}
