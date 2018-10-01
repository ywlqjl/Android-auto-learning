package com.example.yanwenli.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;




/* 基于回调的事件处理机制

你周五放学回家,你问你老妈煮好饭没,你妈说还没煮;然后你跟她说: 老妈,我看下喜羊羊,你煮好饭叫我哈!
分析:你和老妈约定了一个接口,你通过这个接口叫老妈煮饭,当饭煮好了的时候,你老妈 又通过这个接口来反馈你,"饭煮好了"！

常见View组件的回调方法：
android为GUI组件提供了一些事件处理的回调方法,以View为例,有以下几个方法
①在该组件上触发屏幕事件: boolean onTouchEvent(MotionEvent event);
②在该组件上按下某个按钮时: boolean onKeyDown(int keyCode,KeyEvent event);
③松开组件上的某个按钮时: boolean onKeyUp(int keyCode,KeyEvent event);
④长按组件某个按钮时: boolean onKeyLongPress(int keyCode,KeyEvent event);
⑤键盘快捷键事件发生: boolean onKeyShortcut(int keyCode,KeyEvent event);
⑥在组件上触发轨迹球屏事件: boolean onTrackballEvent(MotionEvent event);
⑦当组件的焦点发生改变,和前面的6个不同,这个方法只能够在View中重写哦！
* protected void onFocusChanged(boolean gainFocus, int direction, Rect previously FocusedRect)

 */



/*
 用于情况2
 结果分析： 从上面的运行结果,我们就可以知道,传播的顺序是:
 监听器--->view组件的回调方法--->Activity的回调方法了;
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.qingkuang2);
        btn.setOnKeyListener(new View.OnKeyListener(){

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    Log.i("呵呵", "监听器的onKeyDown方法被调用");
                }
                return false;
            }
        });
    }


        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            super.onKeyDown(keyCode, event);
            Log.i("呵呵","Activity的onKeyDown方法被调用");
            return false;
        }

}
