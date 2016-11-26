import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.lexer.JavaHighlightingLexer;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.impl.source.tree.ElementType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public final class AirFileHighlighter extends SyntaxHighlighterBase {

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTE_SETTINGS = new HashMap();

    private static final IElementType[] I_ELEMENT = {
            JavaTokenType.INTEGER_LITERAL, JavaTokenType.DOUBLE_LITERAL, JavaTokenType.STRING_LITERAL,
            JavaTokenType.CHARACTER_LITERAL, JavaTokenType.LPARENTH, JavaTokenType.RPARENTH, JavaTokenType.LBRACE,
            JavaTokenType.RBRACE, JavaTokenType.LBRACKET, JavaTokenType.RBRACKET, JavaTokenType.COMMA,
            JavaTokenType.SEMICOLON, JavaTokenType.C_STYLE_COMMENT, JavaTokenType.END_OF_LINE_COMMENT
    };

    private static final TextAttributesKey[] ATTRIBUTE_KEY = {
            JavaHighlightingColors.NUMBER, JavaHighlightingColors.NUMBER, JavaHighlightingColors.STRING,
            JavaHighlightingColors.STRING, JavaHighlightingColors.PARENTHESES, JavaHighlightingColors.PARENTHESES,
            JavaHighlightingColors.BRACES, JavaHighlightingColors.BRACES, JavaHighlightingColors.BRACKETS,
            JavaHighlightingColors.BRACKETS, JavaHighlightingColors.COMMA, JavaHighlightingColors.JAVA_SEMICOLON,
            JavaHighlightingColors.DOC_COMMENT_TAG_VALUE, JavaHighlightingColors.DOC_COMMENT_TAG_VALUE
    };

    protected final LanguageLevel level;

    public AirFileHighlighter() {
        this(LanguageLevel.HIGHEST);
    }

    public AirFileHighlighter(@NotNull LanguageLevel value) {
        this.level = value;
    }

    @NotNull @Override
    public Lexer getHighlightingLexer() {
        return new JavaHighlightingLexer(this.level);
    }

    @NotNull @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
        return pack(ATTRIBUTE_SETTINGS.get(type));
    }

    static {
        fillMap(ATTRIBUTE_SETTINGS, ElementType.OPERATION_BIT_SET, JavaHighlightingColors.OPERATION_SIGN);
        for (int i = 0; i < ATTRIBUTE_KEY.length; i++) {
            ATTRIBUTE_SETTINGS.put(I_ELEMENT[i], ATTRIBUTE_KEY[i]);
        }
    }
}
