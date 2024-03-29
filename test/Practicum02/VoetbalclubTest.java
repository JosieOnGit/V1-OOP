package Practicum02;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import static org.junit.jupiter.api.Assertions.*;

class VoetbalclubTest {

    // Testgeval 1: Check of de naam automatisch "FC" wordt bij "" & null.
    @Test
    public void checkNameNull() {
        System.out.println("Running name tests... Name null should be changed to \"FC\"");
        Voetbalclub testVoid = new Voetbalclub(null);
        assertEquals("FC", testVoid.getClubName(),"Expected name to automatically convert to \"FC\".");
        System.out.println("NullNameTest passed. The club name was successfully changed to " + testVoid.getClubName()+ " from null\n");
    }

    @Test
    public void checkNameBlank() {
        System.out.println("Running name test... Name \"\" should be changed to \"FC\"");
        Voetbalclub testBlank = new Voetbalclub("");
        assertEquals("FC", testBlank.getClubName(), "Expected name to automatically convert to \"FC\".");
        System.out.println("BlankNameTest passed. The club name was succesfully changed to " + testBlank.getClubName() + " from \"\"\n");
    }

    // Testgeval 2: "w", "g", "v" geven respectievelijk 3, 1, 0 punten mee. Foutieve invoer past niet aantalGespeeld() aan.
    @Test
    public void checkCorrectProcessOfInputTotalScore() {
        System.out.println("Running total score score-tests... ");
        Voetbalclub testScore = new Voetbalclub("Test");
        // In deze test worden resultaten opgeteld bij elkaar en aan het einde gecontroleerd op beide aantalGespeeld en aantalPunten.
        testScore.verwerkResultaat('w');  // +3
        testScore.verwerkResultaat('g');  // +1
        testScore.verwerkResultaat('v');  // +0
        testScore.verwerkResultaat('a');  // +0, onherkende invoer
        assertEquals(4, testScore.aantalPunten(), "Expected a score of 4 points (Unchanged score).");
        System.out.println("Total score-tests passed.\n");
    }

    @Test
    public void checkCorrectProcessOfInputMatchesPlayed() {
        System.out.println("Running playcount score-tests...");
        Voetbalclub testPlayed = new Voetbalclub("Test");
        // In deze test worden dezelfde resultaten behaald, maar wordt er gecontroleerd op aantalGespeeld.
        testPlayed.verwerkResultaat('w');  // +1
        testPlayed.verwerkResultaat('g');  // +1
        testPlayed.verwerkResultaat('v');  // +1
        testPlayed.verwerkResultaat('a');  // +0, onherkende invoer
        assertEquals(3, testPlayed.aantalGespeeld(), "Expected 3 matched played (Unchanged amount).");
        System.out.println("Playcount test passed.\n");
    }

    // Testgeval 3: "w", "g", "v" geven respectievelijk 3, 1, 0 punten mee, en dit is te zien in de toString-representatie.
    @Test
    public void checkCorrectStringOutput() {
        System.out.println("Running toString test...");
        Voetbalclub testScore = new Voetbalclub("Test");
        testScore.verwerkResultaat('w');
        testScore.verwerkResultaat('g');
        testScore.verwerkResultaat('v');
        /* Een winst, een gelijkspel en een verlies brengen het volgende op:
           3 gespeeld, 1 winst, 1 gelijkspel, 1 verlies, 4 punten,
           Deze test controleert of de output van toString() deze resultaten correct verwerkt. */
        assertEquals("Test 3 1 1 1 4", testScore.toString(), "Expected correct processing of the handled games, but instead encountered errors.");
        System.out.println("toString test passed.\n");
    }

    // Testgeval 4: Herhaaldelijk verwerken van deze resultaten moet zorgen voor een correcte optelling van wedstrijdaantallen en punten.
    @Test
    public void checkCorrectConsistentProcessOfTotalScores() {
        System.out.println("Running total score tests... Adding up 5 matches: 3w, 1g, 1v, with 2 incorrect inputs.");
        Voetbalclub testScore = new Voetbalclub("Test");
        /* Er worden 7 resultaten verwerkt: drie winsten, één gelijkspel en één verloren wedstrijd.
           Er worden ook 2 foutieve inputs verwerkt. Dit draagt niet bij aan aantalGespeeld() */
        testScore.verwerkResultaat('w');
        testScore.verwerkResultaat('3');
        testScore.verwerkResultaat('w');
        testScore.verwerkResultaat('g');
        testScore.verwerkResultaat('v');
        testScore.verwerkResultaat('w');
        testScore.verwerkResultaat('l');
        assertEquals(10, testScore.aantalPunten(), "Expected a score of 10 points (9 + 1).");
        System.out.println("Total score test passed.\n");
    }

    @Test
    public void checkCorrectConsistentProcessOfMatchesPlayed() {
        System.out.println("Running total matches played... Adding up 5 matches: 3w, 1g, 1v, with 2 incorrect inputs.");
        Voetbalclub testMatches = new Voetbalclub("Test");
        /* Er worden 7 resultaten verwerkt: drie winsten, één gelijkspel en één verloren wedstrijd.
           Er worden ook 2 foutieve inputs verwerkt. Dit draagt niet bij aan aantalGespeeld() */
        testMatches.verwerkResultaat('w');
        testMatches.verwerkResultaat('3');
        testMatches.verwerkResultaat('w');
        testMatches.verwerkResultaat('g');
        testMatches.verwerkResultaat('v');
        testMatches.verwerkResultaat('w');
        testMatches.verwerkResultaat('l');
        assertEquals(5, testMatches.aantalGespeeld(), "Expected 5 matches played.");
        System.out.println("Total matches played test passed.\n");
    }


}
