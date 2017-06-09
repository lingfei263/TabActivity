package cn.ffb.library;

import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2017/6/9.
 */

public class MessageEvent {
    private ThreadMode threadMode;
    private Object obj;
    private int what;


    public MessageEvent(int what) {
        this.what = what;
    }

}
