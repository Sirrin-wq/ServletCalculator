package by.tms.controller;

import by.tms.validation.Check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.tms.service.ArithmeticOperations.*;

@WebServlet("/calc")
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();

        String firstNumber = req.getParameter("firstNumber");
        if (check.isDouble(firstNumber)) {
            double num1 = Double.parseDouble(firstNumber);

            String secondNumber = req.getParameter("secondNumber");
            if (check.isDouble(secondNumber)) {
                double num2 = Double.parseDouble(secondNumber);

                String operation = req.getParameter("operation");
                if (check.isValidOperation(operation)) {
                    double res = 0;

                    switch (operation) {
                        case "sum":
                            res = sum(num1, num2);
                            break;
                        case "sub":
                            res = sub(num1, num2);
                            break;
                        case "mul":
                            res = mul(num1, num2);
                            break;
                        case "div":
                            res = div(num1, num2);
                            break;
                    }
                    resp.getWriter().println("Result = " + res);
                } else {
                    resp.getWriter().println("This operation does not exist");
                }
            } else {
                resp.getWriter().println("The second number is not a double value");
            }
        } else {
            resp.getWriter().println("The first number is not a double value");
        }
    }

}