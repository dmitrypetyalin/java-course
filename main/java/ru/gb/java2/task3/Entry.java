package ru.gb.java2.task3;

/**
 * 13.05.2022 21:05
 *
 * @author PetSoft
 */
public class Entry<N, P> {
    N n;
    P p;

    public Entry(N n, P p) {
        this.n = n;
        this.p = p;
    }

    public N getN() {
        return n;
    }

    public P getP() {
        return p;
    }

    public void setN(N n) {
        this.n = n;
    }

    public void setP(P p) {
        this.p = p;
    }
}
