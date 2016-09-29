package mrdshinse.go2web.message;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String fileContentStr = null;

        try {
            byte[] fileContentBytes = Files.readAllBytes(getMsgParentDir().resolve(Paths.get(msgCode)));
            fileContentStr = new String(fileContentBytes, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(MessageReaderBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Optional.ofNullable(fileContentStr);
    }

    protected abstract Path getMsgParentDir();
}
