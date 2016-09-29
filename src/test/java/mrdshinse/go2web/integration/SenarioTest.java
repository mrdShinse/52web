package mrdshinse.go2web.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;
import mrdshinse.go2web.Main;
import mrdshinse.go2web.message.MessageReader4Console;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mrdShinse
 */
public class SenarioTest {

    private ByteArrayOutputStream outContent;

    @After
    public void after() {
        System.setOut(null);
    }

    @Before
    public void before() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void パラメータにdataとpropのいずれかが存在しない場合_コンソールにヘルプを表示する() {
        Optional<String> helpMsg = new MessageReader4Console("h001.msg").read();
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo(helpMsg.orElse("") + "\n"));
    }

    @Test
    public void パラメータdataとpropで指定されたパスに適切な拡張子のファイルが存在しない場合に_コンソールに存在しない旨を表示する() {
        Optional<String> helpMsg = new MessageReader4Console("h002.msg").read();
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo(helpMsg.orElse("") + "\n"));
    }

    @Test
    public void パラメータpropで指定されたファイルにurlとusernameとpasswordが定義されていない場合に_コンソールにキーが足りない旨を表示する() {
        Optional<String> helpMsg = new MessageReader4Console("h003.msg").read();
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo(helpMsg.orElse("") + "\n"));
    }

    @Test
    public void パラメータpropで指定されたファイルに入力された情報を元にbacklogに何らかの参照系リクエストを送信し失敗した場合_コンソールにパラメータを見直すべき旨を表示する() {
        Optional<String> helpMsg = new MessageReader4Console("h004.msg").read();
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo(helpMsg.orElse("") + "\n"));
    }

    @Test
    public void パラメータdataで指定されたファイルサイズが大きすぎる場合に_コンソールにライブラリの都合上大きすぎて処理できない旨を表示する() {
        Optional<String> helpMsg = new MessageReader4Console("h005.msg").read();
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo(helpMsg.orElse("") + "\n"));
    }

    @Test
    public void パラメータdataで指定されたファイルがtasklineらしからぬ時に_コンソールにフォーマット不備の旨を表示する() {
        Optional<String> helpMsg = new MessageReader4Console("h006.msg").read();
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo(helpMsg.orElse("") + "\n"));
    }

    @Test
    public void パラメータdataで指定されたファイルの1行目以降にtasklineらしからぬ行が存在した場合に_コンソールに該当行の行数を出力する() {
        Optional<String> helpMsg = new MessageReader4Console("h007.msg").read();
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo(helpMsg.orElse("") + "\n"));
    }

    @Test
    public void パラメータdataで指定されたファイルの1行目以降にtasklineらしからぬ行が存在しない場合に_backlogのAPIに準拠したHTTPリクエストが送信されている() {
        Main.main(new String[0]);
        assertThat(outContent.toString(), equalTo("文言\n"));
    }

}
