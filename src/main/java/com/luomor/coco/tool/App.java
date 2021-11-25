package com.luomor.coco.tool;

import com.formdev.flatlaf.util.SystemInfo;
import com.luomor.coco.tool.ui.Init;
import com.luomor.coco.tool.ui.form.LoadingForm;
import com.luomor.coco.tool.ui.form.MainWindow;
import com.luomor.coco.tool.ui.frame.MainFrame;
import com.luomor.coco.tool.util.ConfigUtil;
import com.luomor.coco.tool.util.MybatisUtil;
import com.luomor.coco.tool.util.UpgradeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;

/**
 * <pre>
 * Main Enter!
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Peter Zhang</a>
 * @since 2019/8/10.
 */
@Slf4j
public class App {

    public static ConfigUtil config = ConfigUtil.getInstance();

    public static MainFrame mainFrame;

    public static SqlSession sqlSession = MybatisUtil.getSqlSession();

    public static SystemTray tray;

    public static TrayIcon trayIcon;

    public static PopupMenu popupMenu;

    public static void main(String[] args) {

        if (SystemInfo.isMacOS) {
//            java -Xdock:name="CocoTool" -Xdock:icon=CocoTool.jpg ... (whatever else you normally specify here)
//            java -Xms64m -Xmx256m -Dapple.awt.application.name="CocoTool" -Dcom.apple.mrj.application.apple.menu.about.name="CocoTool" -cp "./lib/*" com.luomor.coco.tool.App
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", "CocoTool");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "CocoTool");
        }

        Init.initTheme();
        mainFrame = new MainFrame();
        mainFrame.init();
        JPanel loadingPanel = new LoadingForm().getLoadingPanel();
        mainFrame.add(loadingPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (config.isDefaultMaxWindow() || screenSize.getWidth() <= 1366) {
            // 低分辨率下自动最大化窗口
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        UpgradeUtil.scocothUpgrade();

        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Init.initGlobalFont();
        mainFrame.setContentPane(MainWindow.getInstance().getMainPanel());
        if (App.config.getRecentTabIndex() != 3 && MainWindow.getInstance().getTabbedPane().getTabCount() > App.config.getRecentTabIndex()) {
            MainWindow.getInstance().getTabbedPane().setSelectedIndex(App.config.getRecentTabIndex());
        }
        MainWindow.getInstance().init();
        Init.initAllTab();
        Init.initOthers();
        mainFrame.addListeners();
        mainFrame.remove(loadingPanel);
        Init.fontSizeGuide();
    }
}
