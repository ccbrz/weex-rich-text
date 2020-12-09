package com.eros.framework.extend.comoponents.richtext.view;


import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.eros.framework.extend.comoponents.richtext.view.ToolType.ALIGN_CENTER;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.ALIGN_JUSTIFY;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.ALIGN_LEFT;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.ALIGN_RIGHT;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.BOLD;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.CLEAR;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.CODE;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.EDIT_HTML;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.H1;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.H2;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.H3;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.H4;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.H5;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.H6;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.HORIZONTAL_RULE;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.INDENT;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.ITALIC;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.LINK;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.NONE;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.NORMAL;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.ORDERED_LIST;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.OUTDENT;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.QUOTE;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.REMOVE_FORMAT;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.STRIKETHROUGH;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.SUBSCRIPT;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.SUPERSCRIPT;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.TABLE;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.TEXT_BACK_COLOR;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.TEXT_FORE_COLOR;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.UNDERLINE;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.UNLINK;
import static com.eros.framework.extend.comoponents.richtext.view.ToolType.UNORDERED_LIST;

@IntDef({
        NONE, BOLD, ITALIC, UNDERLINE, STRIKETHROUGH, REMOVE_FORMAT, NORMAL, H1, H2, H3, H4, H5, H6,
        SUPERSCRIPT, SUBSCRIPT, TEXT_FORE_COLOR, TEXT_BACK_COLOR, CODE, UNORDERED_LIST,
        ORDERED_LIST, QUOTE, ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, HORIZONTAL_RULE,
        INDENT, OUTDENT, TABLE, LINK, UNLINK, CLEAR, EDIT_HTML
})
@Retention(RetentionPolicy.SOURCE)
public @interface ToolType {
    int NONE = 0;
    int BOLD = 1;
    int ITALIC = 2;
    int UNDERLINE = 3;
    int STRIKETHROUGH = 4;
    int REMOVE_FORMAT = 5;
    int NORMAL = 6;
    int H1 = 7;
    int H2 = 8;
    int H3 = 9;
    int H4 = 10;
    int H5 = 11;
    int H6 = 12;
    int SUPERSCRIPT = 13;
    int SUBSCRIPT = 14;
    int TEXT_FORE_COLOR = 15;
    int TEXT_BACK_COLOR = 16;
    int CODE = 17;
    int UNORDERED_LIST = 18;
    int ORDERED_LIST = 19;
    int QUOTE = 20;
    int ALIGN_LEFT = 21;
    int ALIGN_CENTER = 22;
    int ALIGN_RIGHT = 23;
    int ALIGN_JUSTIFY = 24;
    int HORIZONTAL_RULE = 25;
    int INDENT = 26;
    int OUTDENT = 27;
    int TABLE = 28;
    int LINK = 29;
    int UNLINK = 30;
    int CLEAR = 31;
    int EDIT_HTML = 32;
}
