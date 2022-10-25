package ru.isupden.lab2.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.isupden.lab2.repo.HitStorage;
import ru.isupden.lab2.util.AreaChecker;

import java.io.IOException;

@WebServlet(name = "checker", value = "/check")
public class AreaCheckServlet extends HttpServlet {
    private AreaChecker checker;

    @Override
    public void init() {
        checker = new AreaChecker();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        getServletContext().setAttribute("storage", checker.checkPoint(req, (HitStorage) getServletContext().getAttribute("storage")));
        resp.sendRedirect(resp.encodeRedirectURL("result.jsp"));
    }
}
