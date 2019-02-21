package com.orange.note.singleclick;

/**
 * @author maomao
 * @date 2019/2/21
 */
public class SingleClickManager {

    // 默认的点击事件间隔为 500 ms
    private long clickTimeInterval = 500L;
    private static SingleClickManager instance = new SingleClickManager();

    private SingleClickManager() {
        //no instance
    }

    public static SingleClickManager getInstance() {
        return instance;
    }

    /**
     * 设置点击点击事件间隔，单位 ms
     */
    public void setClickTimeInterval(long clickTimeInterval) {
        this.clickTimeInterval = clickTimeInterval;
    }

    /**
     * 获取点击点击事件间隔，单位 ms
     */
    public long getClickTimeInterval() {
        return clickTimeInterval;
    }
}
