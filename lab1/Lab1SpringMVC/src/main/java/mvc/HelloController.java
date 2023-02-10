package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello( @RequestParam(value="firstname") String firstName,
                        @RequestParam(value="lastname") String lastName) {

        String message=firstName+" "+lastName;

        Map<String, Object> params = new HashMap<>();
        params.put("message", message);

        return new ModelAndView("hello",params);
    }

    @RequestMapping("/calc")
    public ModelAndView calculate(@RequestParam(value = "num1") int num1,
                                  @RequestParam(value = "num2") int num2, @RequestParam(value = "op") String op) {

        double result = 0;
        Calculation calculation = new Calculation();
        result = calculation.calculate(num1,num2,op);
        Map<String, Object> params = new HashMap<>();
        params.put("num1", num1);
        params.put("num2", num2);
        params.put("op", op);
        params.put("result", result);
        return new ModelAndView("calculation", params);
    }
}

