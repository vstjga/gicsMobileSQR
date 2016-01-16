
package com.proyectodam.gicsmobile.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Response implements Parcelable {

    @SerializedName("venues")
    @Expose
    private List<Venue> venues = new ArrayList<Venue>();
    @SerializedName("confident")
    @Expose
    private Boolean confident;

    /**
     * 
     * @return
     *     The venues
     */
    public List<Venue> getVenues() {
        return venues;
    }

    /**
     * 
     * @param venues
     *     The venues
     */
    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    /**
     * 
     * @return
     *     The confident
     */
    public Boolean getConfident() {
        return confident;
    }

    /**
     * 
     * @param confident
     *     The confident
     */
    public void setConfident(Boolean confident) {
        this.confident = confident;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.venues);
        dest.writeValue(this.confident);
    }

    public Response() {
    }

    protected Response(Parcel in) {
        this.venues = new ArrayList<Venue>();
        in.readList(this.venues, List.class.getClassLoader());
        this.confident = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Response> CREATOR = new Parcelable.Creator<Response>() {
        public Response createFromParcel(Parcel source) {
            return new Response(source);
        }

        public Response[] newArray(int size) {
            return new Response[size];
        }
    };
}
