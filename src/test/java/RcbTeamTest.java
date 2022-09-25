import helper.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RcbTeamTest extends Helper {
    static JSONObject testTeamJson;
    static JSONArray playerJsonArray;
    final static Logger log = LogManager.getLogger(RcbTeamTest.class);

    /**
     * Setup to initialise data and perform basic check
     */
    @BeforeTest
    public void initialTest() {
        testTeamJson = getJsonData();
        assertEquals("Check that team name is correct", "Royal Challengers Bangalore", testTeamJson.get("name"));
        assertEquals("Check that team location is correct", "Bangalore", testTeamJson.get("location"));
        playerJsonArray = (JSONArray) testTeamJson.get("player");
    }

    @Test
    public void checkForeignPlayersTest() {
        log.info("Check foreign players count in team");
        int foreignPlayerCount = 0;
        log.info("Get country for all the players");
        for (Object obj : playerJsonArray) {
            JSONObject playerJson = (JSONObject) obj;
            if (!playerJson.get("country").equals("India"))
                foreignPlayerCount += 1;
        }
        assertEquals("Check that team has only four foreign players", 4, foreignPlayerCount);
        log.info("Provided team has only four foreign players");
    }

    @Test
    public void checkWicketKeeperTest() {
        log.info("Check wicket keepers in team");
        int wicketKeeperCount = 0;
        log.info("Get role for all the players");
        for (Object obj : playerJsonArray) {
            JSONObject playerJson = (JSONObject) obj;
            if (playerJson.get("role").equals("Wicket-keeper"))
                wicketKeeperCount += 1;
        }
        assertTrue("Check that team has at least one wicket-keeper", wicketKeeperCount >= 1);
        log.info("Provided team has at least one keeper");
    }
}
