
package com.proyectodam.gicsmobile.json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Comentarios {

    @SerializedName("meta")
    @Expose
    private MetaTips meta;
    @SerializedName("notifications")
    @Expose
    private List<Notification> notifications = new ArrayList<Notification>();
    @SerializedName("response")
    @Expose
    private ResponseTips response;

    /**
     * 
     * @return
     *     The meta
     */
    public MetaTips getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(MetaTips meta) {
        this.meta = meta;
    }

    /**
     * 
     * @return
     *     The notifications
     */
    public List<Notification> getNotifications() {
        return notifications;
    }

    /**
     * 
     * @param notifications
     *     The notifications
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    /**
     * 
     * @return
     *     The response
     */
    public ResponseTips getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    public void setResponse(ResponseTips response) {
        this.response = response;
    }

}
