package org.haftrust.verifier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleViewController {

    @RequestMapping("index.htm")
    public String index() {
        return "index";
    }

    @RequestMapping("noVerifierFound.htm")
    public String noVerifierFound() {
        return "noVerifierFound";
    }

    @RequestMapping("noDeviceFound.htm")
    public String noDeviceFound() {
        return "noDeviceFound";
    }

    @RequestMapping("noVerifierForVerification.htm")
    public String noVerifierForVerification() {
        return "noVerifierForVerification";
    }

}
