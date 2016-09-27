package mrdshinse.go2web.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import mrdshinse.go2web.Main;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

/**
 *
 * @author mrdShinse
 */
public class BootSteps extends Steps {

    private ByteArrayOutputStream outContent;

    @AfterStories
    public void after() {
        System.setOut(null);
    }

    @Given("初期化")
    public void initialize() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @When("パラメータ無しでMain#main()を実行する")
    public void noParamMain() throws Exception {
        Main.main(new String[0]);
    }

    @Then("コンソールにヘルプを表示する")
    public void printHelp() {
        assertThat(outContent.toString(), equalTo("文言\n"));
    }

    @When("Main#mainに-data, dummy.txt, -prop, dummy.txtを渡して実行する")
    public void withDummyPathMain() throws Exception {
        Main.main(new String[]{"-data", "dummy.txt", "-prop", "dummy.txt"});
    }

    @Then("コンソールに存在しない旨を表示する")
    public void printWrongFile() {
        assertThat(outContent.toString(), equalTo("存在しない旨\n"));
    }
}
