
package com.proyectodam.gicsmobile.json;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Lugares implements Parcelable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("response")
    @Expose
    private Response response;

    /**
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * 
     * @return
     *     The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.meta, flags);
        dest.writeParcelable(this.response, flags);
    }

    public Lugares() {
    }

    protected Lugares(Parcel in) {
        this.meta = in.readParcelable(Meta.class.getClassLoader());
        this.response = in.readParcelable(Response.class.getClassLoader());
    }

    public static final Parcelable.Creator<Lugares> CREATOR = new Parcelable.Creator<Lugares>() {
        public Lugares createFromParcel(Parcel source) {
            return new Lugares(source);
        }

        public Lugares[] newArray(int size) {
            return new Lugares[size];
        }
    };
}
