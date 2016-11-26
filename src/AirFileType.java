import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public final class AirFileType implements FileType {

    private static final String PATH = "/icons/air.logo.png";

    public static final AirFileType INSTANCE = new AirFileType();

    @NotNull
    @Override
    public String getName() {
        return "Air";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Air file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "air";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon(PATH);
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Nullable
    @Override
    public String getCharset(@NotNull VirtualFile virtualFile, @NotNull byte[] bytes) {
        return CharsetToolkit.UTF8;
    }
}
