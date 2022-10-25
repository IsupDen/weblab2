package ru.isupden.lab2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "controller", value = "/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "clear":
                req.getRequestDispatcher("./clear").forward(req, resp);
                break;
            case "check":
                req.getRequestDispatcher("./check").forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
