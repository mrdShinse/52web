package mrdshinse.go2web.message;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.MissingFormatArgumentException;
import java.util.Optional;

/**
 *
 * @author mrdShinse
 */
public abstract class MessageReaderBase implements MessageReader {

    protected final String msgCode;

    public MessageReaderBase(String msgCode) {
        this.msgCode = msgCode;
    }

    @Override
    public Optional<String> read() {
        return read("");
    }

    @Override
    public Optional<String> read(String... args) {
        String fileContentStr = null;

        try {
            byte[] fileContentBytes = Files.readAllBytes(getMsgParentDir().resolve(Paths.get(msgCode)));
            fileContentStr = String.format(new String(fileContentBytes, StandardCharsets.UTF_8), (Object[]) args);
        } catch (IOException ex) {
            throw new RuntimeException("存在しないファイルパスが指定されています。");
        } catch (MissingFormatArgumentException mfaEx) {
            throw new RuntimeException("メッセージに対するパラメータが不足しています。");
        }

        return Optional.ofNullable(fileContentStr);
    }

    protected abstract Path getMsgParentDir();
}
