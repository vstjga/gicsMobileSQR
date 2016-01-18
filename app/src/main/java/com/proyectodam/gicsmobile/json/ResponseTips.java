
package com.proyectodam.gicsmobile.json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ResponseTips {

    @SerializedName("tips")
    @Expose
    private Tips tips;

    /**
     * 
     * @return
     *     The tips
     */
    public Tips getTips() {
        return tips;
    }

    /**
     * 
     * @param tips
     *     The tips
     */
    public void setTips(Tips tips) {
        this.tips = tips;
    }

}
