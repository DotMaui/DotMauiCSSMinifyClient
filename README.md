# DotMauiCSSMinifyClient

Small client written in java to minimize CSS files via API. 

To use this client you need to get an api key for the api.dotmaui.com service. 
You can get a free api key here:
https://api.dotmaui.com/

You can download the jar file compiled here:
https://api.dotmaui.com/download/

# Examples of use

```java
String apiKey = "YOUR_API_KEY";
DotMauiCSSMinifyClient client = new DotMauiCSSMinifyClient(apiKey);

String css_string = "";

css_string += "body {\n"
        + "\tbackground-color: #f0f0f2;\n"
        + "\tmargin: 0;\n"
        + "\tpadding: 0;\n"
        + "\tfont-family: \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n"
        + "}\n"
        + "div {\n"
        + "\twidth: 600px;\n"
        + "\tmargin: 5em auto;\n"
        + "\tpadding: 50px;\n"
        + "\tbackground-color: #fff;\n"
        + "\tborder-radius: 1em;\n"
        + "}\n"
        + "\ta:link, a:visited {\n"
        + "\tcolor: #38488f;\n"
        + "\ttext-decoration: none;\n"
        + "}\n"
        + "@media (max-width: 700px) {\n"
        + "\tbody {\n"
        + "\t\tbackground-color: #fff;\n"
        + "\t}\n"
        + "\tdiv {\n"
        + "\t\twidth: auto;\n"
        + "\t\tmargin: 0 auto;\n"
        + "\t\tborder-radius: 0;\n"
        + "\t\tpadding: 1em;\n"
        + "\t}\n"
        + "}\n";

/**
 * Example 1: Minify css from string.
 */
String minified_from_string = client.minifyCSSFromString(css_string);
System.out.println(minified_from_string);

/**
 * Example 2: Minify css from string and save it in cdn.
 */
client.setMode(1);
client.setName("test.min.css");

String responseCdn = client.minifyCSSFromString(css_string);
JSONObject obj = new JSONObject(responseCdn);

String fileUrl = obj.getString("url");
System.out.println(fileUrl);

/**
 * Example 3: Minify css from url with wrap lines.
 */
client = new DotMauiCSSMinifyClient(apiKey);
client.setWrapCSSLines(true);
String minified_from_url = client.minifyCSSFromUrl("https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css");
System.out.println(minified_from_url);

/**
 * Example 4: Minify css from urls.
 */
client.setWrapCSSLines(false);
List<String> urls = Arrays.asList("https://api.dotmaui.com/static/djmaui/css/style.css", "https://api.dotmaui.com/static/djmaui/css/simple-sidebar.css");
String minified_from_urls = client.minifyCSSFromUrls(urls);        
System.out.println(minified_from_urls);
```
