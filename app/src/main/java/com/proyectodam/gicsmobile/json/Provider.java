
package com.proyectodam.gicsmobile.json;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Provider implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Provider() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected Provider(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<Provider> CREATOR = new Creator<Provider>() {
        public Provider createFromParcel(Parcel source) {
            return new Provider(source);
        }

        public Provider[] newArray(int size) {
            return new Provider[size];
        }
    };
}
