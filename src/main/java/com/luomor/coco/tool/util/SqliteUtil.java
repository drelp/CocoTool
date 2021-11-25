package com.luomor.coco.tool.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * <pre>
 * Sqlite相关工具
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Peter Zhang</a>
 * @since 2019/3/14.
 */
public class SqliteUtil {

    public static String nowDateForSqlite() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }
}
