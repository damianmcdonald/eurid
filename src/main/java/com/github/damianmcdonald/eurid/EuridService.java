package com.github.damianmcdonald.eurid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EuridService {

    private static final String LOOKUP_API_USERNAME ="tmview-test";
    private static final String LOOKUP_API_PASSWORD ="West4side";
    private static final String LOOKUP_API_URL = "https://www.whoisxmlapi.com/whoisserver/WhoisService?domainName=%s&username=%s&password=%s&outputFormat=JSON";

    protected WhoIsLookup getWhoIsDataByDomainName(final String domainName) {
        final String formattedUrl = String.format(LOOKUP_API_URL, domainName, LOOKUP_API_USERNAME, LOOKUP_API_PASSWORD);
        return new WhoIsLookup(new RestTemplate().getForEntity(formattedUrl, String.class).getBody());
    }
}
