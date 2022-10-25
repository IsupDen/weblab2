package ru.isupden.lab2.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.jbosslog.JBossLog;
import ru.isupden.lab2.util.DataValidator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@WebFilter(filterName = "ValidateFilter", urlPatterns = "*")
@JBossLog
public class ValidateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest) servletRequest).getMethod().equals("GET")) {
            servletRequest.setAttribute("time", LocalDateTime.now(ZoneOffset.UTC));
            String type = servletRequest.getParameter("type");
            if (type != null && type.equals("check")) {
                if (!(DataValidator.validateX(servletRequest.getParameter("x"))
                        && DataValidator.validateY(servletRequest.getParameter("y"))
                        && DataValidator.validateR(servletRequest.getParameter("r")))) {
                    log.info("Введены невалидные координаты");
                    ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
                try {
                    Integer.parseInt(servletRequest.getParameter("time-zone"));
                } catch (NumberFormatException e) {
                    log.info("Wrong time-zone");
                    ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
            }

        } else {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
