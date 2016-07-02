package com.example.l.pulltordemo.view;

/**
 * Created by l on 2016/7/2.
 */
public interface PtrView <T> {
    void showContentView();
    void showErrorView();
    void showEmptyView();
    void refreshData(T t);
    void stopRefresh();
}
