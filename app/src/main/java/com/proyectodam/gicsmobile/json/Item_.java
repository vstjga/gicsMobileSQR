
package com.proyectodam.gicsmobile.json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Item_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("likes")
    @Expose
    private Likes likes;
    @SerializedName("like")
    @Expose
    private Boolean like;
    @SerializedName("logView")
    @Expose
    private Boolean logView;
    @SerializedName("todo")
    @Expose
    private Todo todo;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("photo")
    @Expose
    private Photo_ photo;
    @SerializedName("photourl")
    @Expose
    private String photourl;
    @SerializedName("lang")
    @Expose
    private String lang;

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
     *     The createdAt
     */
    public Integer getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The createdAt
     */
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     * 
     * @param canonicalUrl
     *     The canonicalUrl
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     * 
     * @return
     *     The likes
     */
    public Likes getLikes() {
        return likes;
    }

    /**
     * 
     * @param likes
     *     The likes
     */
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    /**
     * 
     * @return
     *     The like
     */
    public Boolean getLike() {
        return like;
    }

    /**
     * 
     * @param like
     *     The like
     */
    public void setLike(Boolean like) {
        this.like = like;
    }

    /**
     * 
     * @return
     *     The logView
     */
    public Boolean getLogView() {
        return logView;
    }

    /**
     * 
     * @param logView
     *     The logView
     */
    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    /**
     * 
     * @return
     *     The todo
     */
    public Todo getTodo() {
        return todo;
    }

    /**
     * 
     * @param todo
     *     The todo
     */
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The photo
     */
    public Photo_ getPhoto() {
        return photo;
    }

    /**
     * 
     * @param photo
     *     The photo
     */
    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }

    /**
     * 
     * @return
     *     The photourl
     */
    public String getPhotourl() {
        return photourl;
    }

    /**
     * 
     * @param photourl
     *     The photourl
     */
    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    /**
     * 
     * @return
     *     The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * 
     * @param lang
     *     The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

}
