/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.dotmaui.api.cssmin;

import static com.dotmaui.api.cssmin.Interface.apiRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @see https://api.dotmaui.com/cssmin/
 * @version 1.0
 * @author .Maui
 */
public class DotMauiCSSMinifyClient {

    private final String endpoint = "https://api.dotmaui.com/client/1.2/cssmin/";

    public DotMauiCSSMinifyClient(String apiKey) throws Exception {
        if (apiKey == null || apiKey.trim().equals("")) {
            throw new Exception("Specify the apikey. To get an apikey visit https://api.dotmaui.com");
        }
        this.apiKey = apiKey;
    }

    public String minifyCSSFromUrl(String url) throws UnsupportedEncodingException, Exception {

        String urlParameters = "apikey=" + this.apiKey + "&url=" + URLEncoder.encode(url, "UTF-8");
        urlParameters += setUrlParameters();

        return apiRequest(this.endpoint, urlParameters);
    }

    public String minifyCSSFromUrls(List<String> urls) throws UnsupportedEncodingException, Exception {

        String urlParameters = "apikey=" + this.apiKey;

        for (String url : urls) {
            urlParameters += "&url[]=" + URLEncoder.encode(url, "UTF-8");
        }

        urlParameters += setUrlParameters();

        return apiRequest(this.endpoint, urlParameters);
    }

    public String minifyCSSFromString(String css) throws UnsupportedEncodingException, Exception {

        String urlParameters = "apikey=" + this.apiKey + "&css=" + URLEncoder.encode(css, "UTF-8");
        urlParameters += setUrlParameters();

        return apiRequest(this.endpoint, urlParameters);
    }

    private String setUrlParameters() throws Exception {

        String otherParams = "";

        if (!this.removeUrlQuotes) {
            otherParams += "&removeurlquotes=false";
        }

        if (!this.removeComments) {
            otherParams += "&removecomments=false";
        }

        if (this.sortProperties) {
            otherParams += "&sortproperties=true";
        }

        if (this.wrapCSSLines) {
            otherParams += "&wrapcsslines=true";
        }

        if (this.mode == 1) {

            otherParams += "&mode=cdn";

            if (this.name == null || !this.name.toLowerCase().endsWith(".css")) {
                throw new Exception("The file name is mandatory and must end with '.css'");
            } else {
                otherParams += "&name=" + this.name;
            }

        }

        return otherParams;

    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    private int mode;

    /**
     * Get the value of mode
     *
     * @return the value of mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * Set the value of mode
     *
     * @param mode new value of mode
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    private boolean wrapCSSLines;

    /**
     * Get the value of wrapCSSLines
     *
     * @return the value of wrapCSSLines
     */
    public boolean isWrapCSSLines() {
        return wrapCSSLines;
    }

    /**
     * Set the value of wrapCSSLines
     *
     * @param wrapCSSLines new value of wrapCSSLines
     */
    public void setWrapCSSLines(boolean wrapCSSLines) {
        this.wrapCSSLines = wrapCSSLines;
    }

    private boolean sortProperties;

    /**
     * Get the value of sortProperties
     *
     * @return the value of sortProperties
     */
    public boolean isSortProperties() {
        return sortProperties;
    }

    /**
     * Set the value of sortProperties
     *
     * @param sortProperties new value of sortProperties
     */
    public void setSortProperties(boolean sortProperties) {
        this.sortProperties = sortProperties;
    }

    private boolean removeComments = true;

    /**
     * Get the value of removeComments
     *
     * @return the value of removeComments
     */
    public boolean isRemoveComments() {
        return removeComments;
    }

    /**
     * Set the value of removeComments
     *
     * @param removeComments new value of removeComments
     */
    public void setRemoveComments(boolean removeComments) {
        this.removeComments = removeComments;
    }

    private boolean removeUrlQuotes = true;

    /**
     * Get the value of removeUrlQuotes
     *
     * @return the value of removeUrlQuotes
     */
    public boolean isRemoveUrlQuotes() {
        return removeUrlQuotes;
    }

    /**
     * Set the value of removeUrlQuotes
     *
     * @param removeUrlQuotes new value of removeUrlQuotes
     */
    public void setRemoveUrlQuotes(boolean removeUrlQuotes) {
        this.removeUrlQuotes = removeUrlQuotes;
    }

    private String apiKey;

    /**
     * Get the value of apiKey
     *
     * @return the value of apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Set the value of apiKey
     *
     * @param apiKey new value of apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
