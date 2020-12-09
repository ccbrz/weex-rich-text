package com.eros.framework.extend.comoponents.richtext;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.eros.framework.R;
import com.eros.framework.adapter.router.RouterTracker;
import com.eros.framework.extend.comoponents.richtext.view.RTextEditorView;
import com.eros.framework.extend.comoponents.richtext.view.ToolType;
import com.eros.framework.extend.comoponents.richtext.view.dialog.InsertLinkDialogFragment;
import com.eros.framework.extend.comoponents.richtext.view.dialog.InsertTableDialogFragment;
import com.eros.framework.extend.comoponents.richtext.view.dialog.MyColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class RRichTextComponent extends WXComponent<RTextEditorView> implements InsertLinkDialogFragment.OnInsertClickListener, InsertTableDialogFragment.OnInsertClickListener, ColorPickerDialogListener {
    private static final int DIALOG_TEXT_FORE_COLOR_ID = 0;
    private static final int DIALOG_TEXT_BACK_COLOR_ID = 1;
    private static final String SELECT_TYPE_FOREGROUND = "textForeground";
    private static final String SELECT_TYPE_BACKGROUND = "textBackground";
    private RTextEditorView mView;
    private InsertLinkDialogFragment mInsertLinkDialogFragment = null;
    private InsertTableDialogFragment mInsertTableDialogFragment = null;
    private MyColorPickerDialog mColorPickerDialog = null;

    public RRichTextComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, String instanceId, boolean isLazy) {
        super(instance, dom, parent, instanceId, isLazy);
    }

    public RRichTextComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, boolean isLazy) {
        super(instance, dom, parent, isLazy);
    }

    public RRichTextComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
    }

    public RRichTextComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, int type) {
        super(instance, dom, parent, type);
    }

    @Override
    protected RTextEditorView initComponentHostView(@NonNull Context context) {
        mView = new RTextEditorView(context);
        mView.setIncognitoModeEnabled(true);
        return mView;
    }

    @WXComponentProp(name = "html")
    public void setHtml(String html) {
        if (mView != null) {
            mView.setHtml(html);
        }
    }

    @JSMethod(uiThread = true)
    public void setBold() {
        applyFormat(ToolType.BOLD);
    }

    @JSMethod(uiThread = true)
    public void setItalic() {
        applyFormat(ToolType.ITALIC);
    }

    @JSMethod(uiThread = true)
    public void setUnderline() {
        applyFormat(ToolType.UNDERLINE);
    }

    @JSMethod(uiThread = true)
    public void setDash() {
        applyFormat(ToolType.STRIKETHROUGH);
    }

    @JSMethod(uiThread = true)
    public void removeFormat() {
        applyFormat(ToolType.REMOVE_FORMAT);
    }

    @JSMethod(uiThread = true)
    public void setTextSize(String sizeType) {
        if (sizeType == null) return;
        applyFormat(parseTextSizeType(sizeType));
    }

    @JSMethod(uiThread = true)
    public void setSuperScript() {
        applyFormat(ToolType.SUPERSCRIPT);
    }

    @JSMethod(uiThread = true)
    public void setSubScript() {
        applyFormat(ToolType.SUBSCRIPT);
    }

    @JSMethod(uiThread = true)
    public void setOrderWithPoint() {
        applyFormat(ToolType.UNORDERED_LIST);
    }

    @JSMethod(uiThread = true)
    public void setOrderWithNumber() {
        applyFormat(ToolType.ORDERED_LIST);
    }

    @JSMethod(uiThread = true)
    public void setQuoteBlock() {
        applyFormat(ToolType.QUOTE);
    }

    @JSMethod(uiThread = true)
    public void setCodeBlock() {
        applyFormat(ToolType.CODE);
    }

    @JSMethod(uiThread = true)
    public void setTextAlign(String textAlign) {
        if (textAlign == null) {
            return;
        }
        String lowerCase = textAlign.toLowerCase(Locale.US);
        applyFormat(parseTextAlign(lowerCase));
    }

    @JSMethod(uiThread = true)
    public void setHorizontalDividingLine() {
        applyFormat(ToolType.HORIZONTAL_RULE);
    }

    @JSMethod(uiThread = true)
    public void setIndent() {
        applyFormat(ToolType.INDENT);
    }

    @JSMethod(uiThread = true)
    public void setUnIndent() {
        applyFormat(ToolType.OUTDENT);
    }

    @JSMethod(uiThread = true)
    public void setLink(String title, String url) {
        if (mView != null) {
            mView.insertLink(title, url);
        }
    }

    @JSMethod(uiThread = true)
    public void setUnLink() {
        applyFormat(ToolType.UNLINK);
    }

    @JSMethod(uiThread = true)
    public void clear() {
        applyFormat(ToolType.CLEAR);
    }

    @JSMethod(uiThread = true)
    public void editHtml() {
        applyFormat(ToolType.EDIT_HTML);
    }

    @JSMethod(uiThread = true)
    public void insertTable(int colCount, int rowCount) {
        if (mView != null) {
            mView.insertTable(colCount, rowCount);
        }
    }

    @JSMethod(uiThread = true)
    public void setTextColor(int color) {
        if (mView != null) {
            mView.setTextColor(color);
        }
    }

    @JSMethod(uiThread = true)
    public void setTextBackgroundColor(int color) {
        if (mView != null) {
            mView.setTextBackgroundColor(color);
        }
    }

    @JSMethod(uiThread = true)
    public void unDo() {
        if (mView != null) {
            mView.undo();
        }
    }

    @JSMethod(uiThread = true)
    public void reDo() {
        if (mView != null) {
            mView.redo();
        }
    }

    @JSMethod(uiThread = true)
    public void showInsertTableDialog() {
        Activity activity = RouterTracker.peekActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            mInsertTableDialogFragment = InsertTableDialogFragment.newInstance();
            mInsertTableDialogFragment.setOnInsertClickListener(this);
            mInsertTableDialogFragment.show(appCompatActivity.getSupportFragmentManager(), "insert-table-dialog");
        }
    }

    @JSMethod(uiThread = true)
    public void showInsertLinkDialog() {
        Activity activity = RouterTracker.peekActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            mInsertLinkDialogFragment = InsertLinkDialogFragment.newInstance();
            mInsertLinkDialogFragment.setOnInsertClickListener(this);
            mInsertLinkDialogFragment.show(appCompatActivity.getSupportFragmentManager(), "insert-link-dialog");
        }
    }

    @JSMethod(uiThread = true)
    public void showColorPickerDialog(String type) {
        if (type == null) return;
        Activity activity = RouterTracker.peekActivity();
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            int dialogId;
            if (type.toLowerCase(Locale.US).equals(SELECT_TYPE_FOREGROUND.toLowerCase(Locale.US))) {
                dialogId = DIALOG_TEXT_FORE_COLOR_ID;
            } else {
                dialogId = DIALOG_TEXT_BACK_COLOR_ID;
            }
            mColorPickerDialog = MyColorPickerDialog.newBuilder()
                .setDialogId(dialogId)
                .setDialogTitle(R.string.dialog_title_text_back_color)
                .setShowAlphaSlider(false)
                .setAllowCustom(true).create();
            mColorPickerDialog.setColorPickerDialogListener(this);
            mColorPickerDialog.show(appCompatActivity.getFragmentManager(), "select-color");
        }
    }


    private @ToolType
    int parseTextSizeType(String sizeType) {
        String lowerCase = sizeType.toLowerCase(Locale.US);
        if (TextUtils.equals(lowerCase, TextSize.NORMAL.textSize)) {
            return ToolType.NORMAL;
        } else if (TextUtils.equals(lowerCase, TextSize.H1.textSize)) {
            return ToolType.H1;
        } else if (TextUtils.equals(lowerCase, TextSize.H2.textSize)) {
            return ToolType.H2;
        } else if (TextUtils.equals(lowerCase, TextSize.H3.textSize)) {
            return ToolType.H3;
        } else if (TextUtils.equals(lowerCase, TextSize.H4.textSize)) {
            return ToolType.H4;
        } else if (TextUtils.equals(lowerCase, TextSize.H5.textSize)) {
            return ToolType.H5;
        } else if (TextUtils.equals(lowerCase, TextSize.H6.textSize)) {
            return ToolType.H6;
        } else {
            return ToolType.NORMAL;
        }
    }

    private @ToolType
    int parseTextAlign(String textAlign) {
        if (TextUtils.equals(textAlign, TextAlign.LEFT.textAlign)) {
            return ToolType.ALIGN_LEFT;
        } else if (TextUtils.equals(textAlign, TextAlign.RIGHT.textAlign)) {
            return ToolType.ALIGN_RIGHT;
        } else if (TextUtils.equals(textAlign, TextAlign.CENTER.textAlign)) {
            return ToolType.ALIGN_CENTER;
        } else if (TextUtils.equals(textAlign, TextAlign.JUSTIFY.textAlign)) {
            return ToolType.ALIGN_JUSTIFY;
        } else {
            return ToolType.ALIGN_LEFT;
        }
    }


    private void applyFormat(@ToolType int formatType) {
        if (mView != null) {
            mView.setFormat(formatType);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (mView != null) {
            mView.setOnTextChangeListener(null);
            mView.removeAllViews();
            mView.destroy();
        }
        if (mInsertLinkDialogFragment != null) {
            try {
                mInsertLinkDialogFragment.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (mInsertTableDialogFragment != null) {
            try {
                mInsertTableDialogFragment.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (mColorPickerDialog != null) {
            try {
                mColorPickerDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onInsertClick(@NonNull String title, @NonNull String url) {
        //fireEvent
        Map<String, Object> param = new HashMap<>();
        param.put("title", title);
        param.put("url", url);
        fireEvent("onLinkInsert", param);
    }

    @Override
    public void onInsertClick(int colCount, int rowCount) {
        //fireEvent
        Map<String, Object> param = new HashMap<>();
        param.put("colCount", colCount);
        param.put("rowCount", rowCount);
        fireEvent("onTableInsert", param);
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        Map<String, Object> param = new HashMap<>();
        if (dialogId == DIALOG_TEXT_FORE_COLOR_ID) {
            param.put("type", SELECT_TYPE_FOREGROUND);
        } else if (dialogId == DIALOG_TEXT_BACK_COLOR_ID) {
            param.put("type", SELECT_TYPE_BACKGROUND);
        }
        param.put("color", color);
        fireEvent("onColorSelected", param);
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }

    enum TextSize {
        NORMAL("normal"), H1("h1"), H2("h2"), H3("h3"), H4("h4"), H5("h5"), H6("h6");

        private String textSize;

        TextSize(String textSize) {
            this.textSize = textSize;
        }
    }

    enum TextAlign {
        LEFT("left"), RIGHT("right"), CENTER("center"), JUSTIFY("justify");

        private String textAlign;

        TextAlign(String textAlign) {
            this.textAlign = textAlign;
        }
    }
}
