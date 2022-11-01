package com.example.kids.utils;

import com.example.kids.utils.apierror.ApiError;

import org.json.JSONObject;

public class ErrorUtils {

    public static ApiError parseError(String mjson) {
        try {
            JSONObject json = new JSONObject(mjson);
            ApiError error = new ApiError(
                    json.optString("messages", ""),
                    json.optBoolean("error"),
                    json.optString("errors", "")
            );
            return error;
        }catch (Exception ex){
            return new ApiError("", null,"401");
        }
    }

    public static ApiError parseError(Throwable t) {
        try {
            return new ApiError(t.getMessage(), null,t.getLocalizedMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            return new ApiError(t.getMessage(), null,t.getLocalizedMessage());
        }
    }
}
