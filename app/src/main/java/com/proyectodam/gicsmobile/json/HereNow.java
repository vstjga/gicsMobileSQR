
package com.proyectodam.gicsmobile.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class HereNow implements Parcelable {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("groups")
    @Expose
    private List<Object> groups = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 
     * @return
     *     The groups
     */
    public List<Object> getGroups() {
        return groups;
    }

    /**
     * 
     * @param groups
     *     The groups
     */
    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.count);
        dest.writeString(this.summary);
        dest.writeList(this.groups);
    }

    public HereNow() {
    }

    protected HereNow(Parcel in) {
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
        this.summary = in.readString();
        this.groups = new ArrayList<Object>();
        in.readList(this.groups, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<HereNow> CREATOR = new Parcelable.Creator<HereNow>() {
        public HereNow createFromParcel(Parcel source) {
            return new HereNow(source);
        }

        public HereNow[] newArray(int size) {
            return new HereNow[size];
        }
    };
}
