package com.orange.note.singleclick;

import android.content.Context;

/**
 * @author maomao
 * @date 2019/4/26
 */
class ResourceUtil {

    static String getResourceName(Context context, int id) {
        try {
            return context.getResources().getResourceName(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
