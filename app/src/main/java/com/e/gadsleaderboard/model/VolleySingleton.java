package com.e.gadsleaderboard.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static Context mContexxt;
    private RequestQueue requestQueue;
    public static VolleySingleton minstance;

    public VolleySingleton(Context mContexxt) {
        this.mContexxt = mContexxt;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context){
        if(minstance==null){
            minstance = new VolleySingleton(context);
        }
        return minstance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(mContexxt.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
