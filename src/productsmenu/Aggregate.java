/*
 * Aggregate 집합체
 * 모든 상품의 집합체
 */
package productsmenu;

import java.util.Iterator;

/**
 * @author Ahn Junhong
 */
public interface Aggregate {
    public abstract Iterator createIterator();
}
