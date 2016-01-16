
package com.proyectodam.gicsmobile.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Specials implements Parcelable {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<Object> items = new ArrayList<Object>();

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
     *     The items
     */
    public List<Object> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<Object> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.count);
        dest.writeList(this.items);
    }

    public Specials() {
    }

    protected Specials(Parcel in) {
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
        this.items = new ArrayList<Object>();
        in.readList(this.items, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<Specials> CREATOR = new Parcelable.Creator<Specials>() {
        public Specials createFromParcel(Parcel source) {
            return new Specials(source);
        }

        public Specials[] newArray(int size) {
            return new Specials[size];
        }
    };
}
