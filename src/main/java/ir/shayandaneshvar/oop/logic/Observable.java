package ir.shayandaneshvar.oop.logic;

import ir.shayandaneshvar.oop.graphics.Observer;

public interface Observable<SELF extends Observable<?>> {
    void addObserver(Observer<SELF> observer);

    void updateAllObservers();
}
