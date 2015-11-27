package com.modify.pib.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Sampler;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class RequestManager {

    private static final int CACHE_SIZE = 20;
    private static Context context;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private RequestManager() {
        requestQueue = getRequestQueue();
        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(CACHE_SIZE);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });

    }

    private static class RequestManagerHolder {
        public static final RequestManager INSTANCE = new RequestManager();
    }

    public static RequestManager getInstance(Context context) {
        if(RequestManager.context == null) {
            RequestManager.context = context;
        }
        return RequestManagerHolder.INSTANCE;
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

}
