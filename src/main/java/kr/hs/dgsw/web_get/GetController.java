package kr.hs.dgsw.web_get;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetController {

    // ex) /greeting?say=안녕&to=준혁
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(required = false, defaultValue = "Hello") String say,
            @RequestParam(required = false, defaultValue = "NoName") String to
    ){
        return say + " " + to + "!";
    }

    // ex) /greeting1/안녕/준혁
    @GetMapping(value = {"/greeting1/{say}/{to}", "/greeting1/{say}", "/greeting1//{to}", "/greeting1"})
    public String greeting1(
            @PathVariable Optional<String> say,
            @PathVariable Optional<String> to
    ) {
        String tmp = say.isPresent() ? say.get() : "HELLO";
        String tmp2 = to.isPresent() ? to.get() : "NONAME";
        return tmp + " " + tmp2 + "!";
    }
}
