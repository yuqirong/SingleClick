package com.orange.note.singleclick;

import android.os.SystemClock;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author maomao
 * @date 2019/2/21
 */
@Aspect
public class SingleClickAspect {

    private static final String ON_CLICK_POINTCUTS = "execution(* android.view.View.OnClickListener(..))";
    // view tag unique key, must be one of resource id
    private static final int SINGLE_CLICK_KEY = R.string.com_orange_note_singleclick_tag_key;

    @Around(ON_CLICK_POINTCUTS)
    public void throttleClick(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object[] args = joinPoint.getArgs();
            View view = getViewFromArgs(args);
            // unknown click type, so skip it
            if (view == null) {
                joinPoint.proceed();
                return;
            }
            Long lastClickTime = (Long) view.getTag(SINGLE_CLICK_KEY);
            // if lastClickTime is null, means click first time
            if (lastClickTime == null) {
                joinPoint.proceed();
                return;
            }
            if (canClick(lastClickTime)) {
                joinPoint.proceed();
                view.setTag(SINGLE_CLICK_KEY, SystemClock.elapsedRealtime());
            }
        } catch (Throwable e) {
            e.printStackTrace();
            joinPoint.proceed();
        }
    }

    /**
     * 获取 view 参数
     * @param args
     * @return
     */
    private View getViewFromArgs(Object[] args) {
        if (args != null && args.length > 0) {
            Object arg = args[0];
            if (arg instanceof View) {
                return (View) arg;
            }
        }
        return null;
    }

    /**
     * 判断是否达到可以点击的时间间隔
     * @param lastClickTime
     * @return
     */
    private boolean canClick(long lastClickTime) {
        return SystemClock.elapsedRealtime() - lastClickTime
                >= SingleClickManager.getInstance().getClickTimeInterval();
    }

}
