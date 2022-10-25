package ru.isupden.lab2.util;

import jakarta.servlet.http.HttpServletRequest;
import ru.isupden.lab2.model.Point;
import ru.isupden.lab2.repo.HitStorage;

import java.time.LocalDateTime;

public class AreaChecker {
    public HitStorage checkPoint(HttpServletRequest req, HitStorage storage) {
        LocalDateTime startTime = (LocalDateTime) (req.getAttribute("time"));
        double x = Double.parseDouble(req.getParameter("x"));
        double y = Double.parseDouble(req.getParameter("y"));
        double r = Double.parseDouble(req.getParameter("r"));
        Point point = new Point(x, y, r,
                checkArea(x, y, r),
                startTime.minusMinutes(Long.parseLong(req.getParameter("time-zone"))),
                LocalDateTime.now().minusNanos(startTime.getNano()).getNano());
        if (storage == null) {
            storage = new HitStorage();
        }
        storage.addPoint(point);
        req.getSession().setAttribute("hit", point);
        return storage;
    }

    private boolean checkArea(double x, double y, double r) {
        return inTriangle(x, y, r) || inSquare(x, y, r) || inCircle(x, y, r);
    }

    private boolean inTriangle(double x, double y, double r) {
        return x >= 0 && y <= 0 && y > 2 * x - r;
    }
    private boolean inSquare(double x, double y, double r) {
        return x <= 0 && y <= 0 && x >= -r && y >= -r;
    }
    private boolean inCircle(double x, double y, double r) {
        return x >= 0 && y >= 0 && x * x + y * y <= 0.25 * r * r;
    }
}
