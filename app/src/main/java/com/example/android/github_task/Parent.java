package com.example.android.github_task;

/**
 * Created by kumnehal on 06/07/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Parent {
    @SerializedName("sha")
    @Expose
    private String sha;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    /**
     *
     * @return
     * The sha
     */
    public String getSha() {
        return sha;
    }

    /**
     *
     * @param sha
     * The sha
     */
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     *
     * @param htmlUrl
     * The html_url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }


}
