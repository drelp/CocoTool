package com.luomor.coco.tool.ui.frame;

import cn.hutool.core.thread.ThreadUtil;
import com.luomor.coco.tool.ui.UiConsts;
import com.luomor.coco.tool.ui.component.TopMenuBar;
import com.luomor.coco.tool.ui.listener.FrameListener;
import com.luomor.coco.tool.ui.listener.TabListener;
import com.luomor.coco.tool.ui.listener.func.*;
import com.luomor.coco.tool.util.ComponentUtil;
import com.luomor.coco.tool.util.SystemUtil;

import javax.swing.*;

/**
 * <pre>
 * 主窗口
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Peter Zhang</a>
 * @since 2019/8/10.
 */
public class MainFrame extends JFrame {

    private static final long serialVersionUID = -332963894416012132L;

    public void init() {
        this.setName(UiConsts.APP_NAME);
        this.setTitle(UiConsts.APP_NAME);
        FrameUtil.setFrameIcon(this);
        // Mac系统Dock图标
        if (SystemUtil.isMacOs()) {
//            Application application = Application.getApplication();
//            application.setDockIconImage(UiConsts.IMAGE_LOGO_512);
//            if (!SystemUtil.isMacM1()) {
//                application.setEnabledAboutMenu(false);
//                application.setEnabledPreferencesMenu(false);
//            }
        }
        TopMenuBar topMenuBar = TopMenuBar.getInstance();
        topMenuBar.init();
        setJMenuBar(topMenuBar);
        ComponentUtil.setPreferSizeAndLocateToCenter(this, 0.8, 0.88);
    }

    /**
     * 添加事件监听
     */
    public void addListeners() {
        ThreadUtil.execute(FrameListener::addListeners);
        ThreadUtil.execute(TabListener::addListeners);
        ThreadUtil.execute(QuickNoteListener::addListeners);
        ThreadUtil.execute(TimeConvertListener::addListeners);
        ThreadUtil.execute(JsonBeautyListener::addListeners);
        ThreadUtil.execute(HostListener::addListeners);
        ThreadUtil.execute(HttpRequestListener::addListeners);
        ThreadUtil.execute(QrCodeListener::addListeners);
        ThreadUtil.execute(EnCodeListener::addListeners);
        ThreadUtil.execute(CryptoListener::addListeners);
        ThreadUtil.execute(CalculatorListener::addListeners);
        ThreadUtil.execute(NetListener::addListeners);
        ThreadUtil.execute(ColorBoardListener::addListeners);
        ThreadUtil.execute(ImageListener::addListeners);
    }
}
