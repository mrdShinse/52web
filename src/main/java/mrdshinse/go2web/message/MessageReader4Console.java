package mrdshinse.go2web.message;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author mrdShinse
 */
public class MessageReader4Console extends MessageReaderBase {

    public MessageReader4Console(String msgCode) {
        super(msgCode);
    }

    @Override
    protected Path getMsgParentDir() {
        return Paths.get(System.getProperty("user.dir") + "/src/main/resources/message/console");
    }
}
