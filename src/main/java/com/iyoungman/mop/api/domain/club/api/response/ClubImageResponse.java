package com.iyoungman.mop.api.domain.club.api.response;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 * Created by iyoungman on 2020-07-30.
 */

@Getter
public class ClubImageResponse {

    private Map<String, String> response = new HashMap<>();

    public void setImageUri(String imageUri) {
        response.put("imageUri", imageUri);
    }
}
