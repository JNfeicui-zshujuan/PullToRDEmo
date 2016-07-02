package com.example.l.pulltordemo.view;

/**
 * Created by l on 2016/7/2.
 */
public interface LoadMoreView<T> {
void addMoreData(T datas);
    void hideMoreData();
    void loadMoreLoading();
    void loadMoreError(String string );
    void loadMoreComplete();

}
