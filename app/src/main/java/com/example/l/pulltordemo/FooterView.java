package com.example.l.pulltordemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by l on 2016/7/2.
 * 视图的三种状态 1.加载完成 2.加载错误 .3.正在加载中
 */
public class FooterView extends FrameLayout {
    //代表三种状态的静态常量
    private static final int STATE_LOADING=0;
    private static final int STATE_COMPLETE=1;
    private static final int STATE_ERROR=2;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.tv_complete)
    TextView tv_complete;
    @Bind(R.id.tv_error)
    TextView tv_error;
    //默认加载中的状态
    private int state=STATE_LOADING;

    public FooterView(Context context) {
        super(context,null);
    }

    public FooterView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public FooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //加载布局
        LayoutInflater.from(context).inflate(R.layout.content_load_footer,this,true);
        init();
    }
    //初始化 绑定控件
    private void init(){
        ButterKnife.bind(this);
    }
    public void showError(String error){
        state=STATE_ERROR;
        progressBar.setVisibility(GONE);
        tv_complete.setVisibility(GONE);
        tv_error.setVisibility(VISIBLE);
    }
    public void showComplete(){
        state=STATE_COMPLETE;
        progressBar.setVisibility(GONE);
        tv_complete.setVisibility(VISIBLE);
        tv_error.setVisibility(GONE);
    }
    public void showLoading(){
        state=STATE_LOADING;
        progressBar.setVisibility(VISIBLE);
        tv_complete.setVisibility(GONE);
        tv_error.setVisibility(GONE);
    }
    public boolean isLoading(){
        return state==STATE_LOADING;
    }
    public boolean isComplete(){
        return state==STATE_COMPLETE;
    }
    public void setErrorClickListener(OnClickListener onClickListener){
        tv_error.setOnClickListener(onClickListener);
    }
}
