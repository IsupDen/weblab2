package ru.isupden.lab2.repo;

import lombok.NoArgsConstructor;
import ru.isupden.lab2.model.Point;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class HitStorage {
    private final List<Point> storage = Collections.synchronizedList(new LinkedList<>());

    public void addPoint(Point point) {
        storage.add(0, point);
    }

    public List<Point> getPoints() {
        return storage;
    }
}
