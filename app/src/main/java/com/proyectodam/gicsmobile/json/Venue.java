
package com.proyectodam.gicsmobile.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Venue implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("delivery")
    @Expose
    private Delivery delivery;
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private Boolean allowMenuUrlEdit;
    @SerializedName("specials")
    @Expose
    private Specials specials;
    @SerializedName("hereNow")
    @Expose
    private HereNow hereNow;
    @SerializedName("referralId")
    @Expose
    private String referralId;
    @SerializedName("venueChains")
    @Expose
    private List<Object> venueChains = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

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

    /**
     * 
     * @return
     *     The contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * 
     * @param contact
     *     The contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * 
     * @param verified
     *     The verified
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * 
     * @return
     *     The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The delivery
     */
    public Delivery getDelivery() {
        return delivery;
    }

    /**
     * 
     * @param delivery
     *     The delivery
     */
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    /**
     * 
     * @return
     *     The allowMenuUrlEdit
     */
    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    /**
     * 
     * @param allowMenuUrlEdit
     *     The allowMenuUrlEdit
     */
    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    /**
     * 
     * @return
     *     The specials
     */
    public Specials getSpecials() {
        return specials;
    }

    /**
     * 
     * @param specials
     *     The specials
     */
    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    /**
     * 
     * @return
     *     The hereNow
     */
    public HereNow getHereNow() {
        return hereNow;
    }

    /**
     * 
     * @param hereNow
     *     The hereNow
     */
    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    /**
     * 
     * @return
     *     The referralId
     */
    public String getReferralId() {
        return referralId;
    }

    /**
     * 
     * @param referralId
     *     The referralId
     */
    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    /**
     * 
     * @return
     *     The venueChains
     */
    public List<Object> getVenueChains() {
        return venueChains;
    }

    /**
     * 
     * @param venueChains
     *     The venueChains
     */
    public void setVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.contact, 0);
        dest.writeParcelable(this.location, 0);
        dest.writeTypedList(categories);
        dest.writeValue(this.verified);
        dest.writeParcelable(this.stats, 0);
        dest.writeString(this.url);
        dest.writeParcelable(this.delivery, 0);
        dest.writeValue(this.allowMenuUrlEdit);
        dest.writeParcelable(this.specials, 0);
        dest.writeParcelable(this.hereNow, 0);
        dest.writeString(this.referralId);
        dest.writeList(this.venueChains);
    }

    public Venue() {
    }

    protected Venue(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.contact = in.readParcelable(Contact.class.getClassLoader());
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.categories = in.createTypedArrayList(Category.CREATOR);
        this.verified = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.stats = in.readParcelable(Stats.class.getClassLoader());
        this.url = in.readString();
        this.delivery = in.readParcelable(Delivery.class.getClassLoader());
        this.allowMenuUrlEdit = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.specials = in.readParcelable(Specials.class.getClassLoader());
        this.hereNow = in.readParcelable(HereNow.class.getClassLoader());
        this.referralId = in.readString();
        this.venueChains = new ArrayList<Object>();
        in.readList(this.venueChains, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<Venue> CREATOR = new Parcelable.Creator<Venue>() {
        public Venue createFromParcel(Parcel source) {
            return new Venue(source);
        }

        public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };
}
