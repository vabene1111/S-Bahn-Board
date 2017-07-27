package de.droidenschmiede.sbahnboard.interfaces;

/**
 * Created by bene on 27.07.2017.
 * Callback interface for network requests
 */

public interface VolleyInterface<T> {
    void onResponse(String result, Class<T> clazz);
}
