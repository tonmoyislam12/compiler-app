package com.duy.ide.editor.theme.model;

import android.graphics.Color;
import android.support.annotation.NonNull;

import com.duy.ide.editor.theme.SyntaxUtilities;
import com.jecelyin.common.utils.DLog;

import java.util.Arrays;
import java.util.Properties;


public class EditorTheme extends ColorScheme {
    private static final String TAG = "EditorTheme";

    private GutterStyle gutterStyle = new GutterStyle();
    private WhiteSpaceStyle whiteSpaceStyle = new WhiteSpaceStyle();
    private SyntaxStyle[] syntaxStyles;

    /**
     * File name in assets
     */
    private String fileName;

    private String name;

    public SyntaxStyle[] getSyntaxStyles() {
        return syntaxStyles;
    }

    public int getLineHighlightColor() {
        return getColor(Attr.VIEW_LINE_HIGHLIGHT_COLOR);
    }

    public int getSelectionColor() {
        return getColor(Attr.VIEW_SELECTION_COLOR);
    }

    public int getBgColor() {
        return getColor(Attr.VIEW_BG_COLOR);

    }

    public int getCaretColor() {
        return getColor(Attr.VIEW_CARET_COLOR);

    }

    public int getEolMarkerColor() {
        return getColor(Attr.VIEW_EOL_MARKER_COLOR);

    }

    public int getFgColor() {
        return getColor(Attr.VIEW_FG_COLOR);

    }

    public int getWrapGuideColor() {
        return getColor(Attr.VIEW_WRAP_GUIDE_COLOR);

    }

    private int getColor(Attr attr) {
        return super.getColor(attr.getKey());
    }

    public GutterStyle getGutterStyle() {
        return gutterStyle;
    }

    public WhiteSpaceStyle getWhiteSpaceStyle() {
        return whiteSpaceStyle;
    }

    @Override
    public void load(Properties properties) {
        setName(properties.getProperty(ThemeAttr.SCHEME_NAME.getKey()));
        for (Attr attr : Attr.values()) {
            try {
                String color = properties.getProperty(attr.getKey());
                put(attr.getKey(), Color.parseColor(color));
            } catch (Exception ignored) {
                if (DLog.DEBUG) DLog.w(TAG, "load: missing attr " + attr.key);
            }
        }

        gutterStyle.load(properties);
        whiteSpaceStyle.load(properties);
        syntaxStyles = SyntaxUtilities.loadStyles(properties);
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        if (name.isEmpty()){
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(name.replace("-", " "));
        builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == ' ' && i + 1 < builder.length()) {
                builder.setCharAt(i + 1, Character.toUpperCase(builder.charAt(i + 1)));
            }
        }
        this.name = builder.toString();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EditorTheme)) return false;

        EditorTheme that = (EditorTheme) o;

        if (getGutterStyle() != null ? !getGutterStyle().equals(that.getGutterStyle()) : that.getGutterStyle() != null)
            return false;
        if (getWhiteSpaceStyle() != null ? !getWhiteSpaceStyle().equals(that.getWhiteSpaceStyle()) : that.getWhiteSpaceStyle() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getSyntaxStyles(), that.getSyntaxStyles())) return false;
        if (getFileName() != null ? !getFileName().equals(that.getFileName()) : that.getFileName() != null)
            return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getGutterStyle() != null ? getGutterStyle().hashCode() : 0;
        result = 31 * result + (getWhiteSpaceStyle() != null ? getWhiteSpaceStyle().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getSyntaxStyles());
        result = 31 * result + (getFileName() != null ? getFileName().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    public enum ThemeAttr {
        SCHEME_NAME("theme.name"),
        TYPE("theme.type"),
        STATUS_BAR_BACKGROUND("theme.statusbar.background"),
        STATUS_BAR_FOREGROUND("theme.statusbar.foreground");
        private String key;

        ThemeAttr(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public enum Attr {
        VIEW_BG_COLOR("view.bgColor"),
        VIEW_CARET_COLOR("view.caretColor"),
        VIEW_EOL_MARKER_COLOR("view.eolMarkerColor"),
        VIEW_FG_COLOR("view.fgColor"),
        VIEW_LINE_HIGHLIGHT_COLOR("view.lineHighlightColor"),
        VIEW_SELECTION_COLOR("view.selectionColor"),
        VIEW_STRUCTURE_HIGHLIGHT_COLOR("view.structureHighlightColor"),
        VIEW_WRAP_GUIDE_COLOR("view.wrapGuideColor");

        private String key;

        Attr(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }
}