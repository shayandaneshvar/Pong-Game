package ir.shayandaneshvar.oop.graphics;

import ir.shayandaneshvar.oop.logic.Observable;

public interface Observer<T extends Observable<?>> {
    void update(T observable);
}
