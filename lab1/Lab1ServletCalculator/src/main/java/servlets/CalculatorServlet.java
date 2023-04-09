package servlets;

import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

    List<LastOperation> sessionList = new ArrayList<>();
    List<HttpSession> sessionL = new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show calculator page
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("Enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("Enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("Enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show result page
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));
        String op = request.getParameter("op");

        CalculatorHelper calculatorHelper = new CalculatorHelper();
        int result = 0;
        switch (op) {
            case "+":
                result = calculatorHelper.sum(num1,num2);
                break;
            case "-":
                result = calculatorHelper.minus(num1, num2);
                break;
            case "*":
                result= calculatorHelper.mul(num1, num2);
                break;
            case "/":
                result = calculatorHelper.div(num1,num2);
                break;
            default:
                break;
        }

        HttpSession session = request.getSession();
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("op", op);
        session.setAttribute("result", result);
        LastOperation lastOperation = new LastOperation(num1, num2, op, result);
        sessionL.add(session);
        sessionList.add(lastOperation);

        PrintWriter out = response.getWriter();
//        out.println("doPost is called");
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");
        out.println("<h3> The Result of " + num1 +  op  + num2 + " = "+ result +"</h3><br>");
        out.println("<table style='border: 1px solid black'>");
        out.println("<tr >");
        out.println("<th style='border: 1px solid black'>First</th>");
        out.println("<th style='border: 1px solid black'>Operation</th>");
        out.println("<th style='border: 1px solid black'>Second</th>");
        out.println("<th style='border: 1px solid black'>Result</th>");
        out.println("</tr>");
        for (int i = 0; i<sessionList.size();i++) {
            out.println("<tr>");
            out.println("<td style='border: 1px solid black'>"+sessionList.get(i).getNum1()+"</td>");
            out.println("<td style='border: 1px solid black'>"+sessionList.get(i).getOperation()+"</td>");
            out.println("<td style='border: 1px solid black'>"+sessionList.get(i).getNum2()+"</td>");
            out.println("<td style='border: 1px solid black'>"+sessionList.get(i).getResult()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

}
