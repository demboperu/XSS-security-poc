package com.springapp.mvc;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/rest/repairs")
public class RestController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public List<Integer> listRepairs() {
        List<Integer> list = new ArrayList();
        list.add(12);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json", value = "/new/{pin}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String save(@PathVariable(value = "pin") Integer pin) throws PolicyException {
        return "ok";
    }
}
