package com.github.damianmcdonald.eurid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EuridController {

    @Autowired
    EuridService euridService;

    @RequestMapping(value = "/lookup", method = RequestMethod.GET)
    public @ResponseBody WhoIsLookup getWhoIsData(@RequestParam(value="domainname") final String domainName) throws Exception {
        return euridService.getWhoIsDataByDomainName(domainName);
    }

}
