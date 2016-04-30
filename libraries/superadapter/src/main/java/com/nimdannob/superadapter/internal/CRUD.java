package com.nimdannob.superadapter.internal;

import java.util.List;

/**
 * Created by Zousfu on 2016/4/29.
 * Email:nimdanoob@163.com
 */
public interface CRUD<T> {
    void add(T item);
    void insert(int index, T item);
    void addAll(List<T> items);
    void remove(T item);
    void remove(int index);
    void set(T oldItem, T newItem);
    void set(int index, T item);
    void replaceAll(List<T> imtes);
    boolean contains(T item);
    void clear();
}
