package com.seveniu.util;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Request;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * url and html utils.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
public class UrlUtils {

    /**
     * canonicalizeUrl
     * <br>
     * Borrowed from Jsoup.
     *
     * @param url   url
     * @param refer refer
     * @return canonicalizeUrl
     */
    public static String canonicalizeUrl(String url, String refer) {
        URL base;
        try {
            try {
                base = new URL(refer);
            } catch (MalformedURLException e) {
                // the base is unsuitable, but the attribute may be abs on its own, so try that
                URL abs = new URL(refer);
                return abs.toExternalForm();
            }
            // workaround: java resolves '//path/file + ?foo' to '//path/?foo', not '//path/file?foo' as desired
            if (url.startsWith("?"))
                url = base.getPath() + url;
            URL abs = new URL(base, url);
            return encodeIllegalCharacterInUrl(abs.toExternalForm());
        } catch (MalformedURLException e) {
            return "";
        }
    }

    /**
     * @param url url
     * @return new url
     */
    public static String encodeIllegalCharacterInUrl(String url) {
        //TODO more charator support
        return url.replace(" ", "%20");
    }

    public static String getHost(String url) {
        String host = url;
        int i = StringUtils.ordinalIndexOf(url, "/", 3);
        if (i > 0) {
            host = StringUtils.substring(url, 0, i);
        }
        return host;
    }

    private static Pattern patternForProtocal = Pattern.compile("[\\w]+://");

    public static String removeProtocol(String url) {
        return patternForProtocal.matcher(url).replaceAll("");
    }

    public static String getDomain(String url) {
        String domain = removeProtocol(url);
        int i = StringUtils.indexOf(domain, "/", 1);
        if (i > 0) {
            domain = StringUtils.substring(domain, 0, i);
        }
        return domain;
    }

    /**
     * link allow blank space in quote
     */
    private static Pattern patternForHrefWithQuoteLink = Pattern.compile("(<[ ]*?link[^<>]*href=)[\"']([^\"'<>]*)[\"']", Pattern.CASE_INSENSITIVE);
    /**
     * img allow blank space in quote
     */
    private static Pattern patternForHrefWithQuoteImg = Pattern.compile("(<[ ]*?img[\\s\\S]*? src=)[\"']([^\"'<>]*)[\"']", Pattern.CASE_INSENSITIVE);

    /**
     * iframe allow blank space in quote
     */
    private static Pattern patternForHrefWithQuoteIframe = Pattern.compile("(<[ ]*?iframe[^<>]*?[ ]src=)[\"']([^\"'<>]*)[\"']", Pattern.CASE_INSENSITIVE);
    /**
     * img disallow blank space without quote
     */
    private static Pattern patternForHrefWithoutQuoteImg = Pattern.compile("(<[ ]*?img[\\s\\S]*? src=)([^\"'<>\\s]+)", Pattern.CASE_INSENSITIVE);

    /**
     * allow blank space in quote
     */
    private static Pattern patternForHrefWithQuote = Pattern.compile("(<[ ]*?a[^<>]*href=)[\"']([^\"'<>]*)[\"']", Pattern.CASE_INSENSITIVE);

    /**
     * disallow blank space without quote
     */
    private static Pattern patternForHrefWithoutQuote = Pattern.compile("(<[ ]*?a[^<>]*href=)([^\"'<>\\s]+)", Pattern.CASE_INSENSITIVE);

    public static String fixAllRelativeHrefs(String html, String url) {
        html = replaceByPattern(html, url, patternForHrefWithQuote);
        html = replaceByPattern(html, url, patternForHrefWithoutQuote);
        html = replaceByPattern(html, url, patternForHrefWithQuoteImg);
        html = replaceByPattern(html, url, patternForHrefWithoutQuoteImg);
        html = replaceByPattern(html, url, patternForHrefWithQuoteLink);
        html = replaceByPattern(html, url, patternForHrefWithQuoteIframe);
        return html;
    }

    public static String replaceByPattern(String html, String url, Pattern pattern) {
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = pattern.matcher(html);
        int lastEnd = 0;
        boolean modified = false;
        while (matcher.find()) {
            modified = true;
            stringBuilder.append(StringUtils.substring(html, lastEnd, matcher.start()));
            stringBuilder.append(matcher.group(1));
            stringBuilder.append("\"").append(canonicalizeUrl(matcher.group(2), url)).append("\"");
            lastEnd = matcher.end();
        }
        if (!modified) {
            return html;
        }
        stringBuilder.append(StringUtils.substring(html, lastEnd));
        return stringBuilder.toString();
    }

    public static List<Request> convertToRequests(Collection<String> urls) {
        List<Request> requestList = new ArrayList<Request>(urls.size());
        for (String url : urls) {
            requestList.add(new Request(url));
        }
        return requestList;
    }

    public static List<String> convertToUrls(Collection<Request> requests) {
        List<String> urlList = new ArrayList<String>(requests.size());
        for (Request request : requests) {
            urlList.add(request.getUrl());
        }
        return urlList;
    }

    private static final Pattern patternForCharset = Pattern.compile("charset\\s*=\\s*['\"]*([^\\s;'\"]*)");

    public static String getCharset(String contentType) {
        Matcher matcher = patternForCharset.matcher(contentType);
        if (matcher.find()) {
            String charset = matcher.group(1);
            if (Charset.isSupported(charset)) {
                return charset;
            }
        }
        return null;
    }

    public static String getBaseUrl(String html) {
        String baseUrl = null;
        Pattern baseTagPattern = Pattern.compile("<[ ]*?base[\\s\\S]*?>");
        Pattern baseUrlPattern = Pattern.compile("href=\"([\\s\\S]*?)\"[\\s\\S]*?>");
        Matcher matcher = baseTagPattern.matcher(html);
        if (matcher.find()) {
            matcher = baseUrlPattern.matcher(matcher.group(0));
            if (matcher.find())
                baseUrl = matcher.group(1);
        }
        return baseUrl;
    }

}
