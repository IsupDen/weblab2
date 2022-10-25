package ru.isupden.lab2.util;

import jakarta.servlet.http.HttpServletRequest;
import ru.isupden.lab2.repo.HitStorage;

public class StorageCleaner {
    private StorageCleaner() {}
    public static void cleanStorage(HttpServletRequest req) {
        req.getSession().setAttribute("storage", new HitStorage());
    }
}
