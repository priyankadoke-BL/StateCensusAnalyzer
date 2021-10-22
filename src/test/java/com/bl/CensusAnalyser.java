package com.bl;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CensusAnalyser {
    @Test
    public void checkToEnsure_NumberOfRecordsMatches() throws CSVCensusException {
        CensusAnalyser stateCensusAnalyser = new CensusAnalyser("StateCensus.csv");
        assertEquals(37, CensusAnalyser.readStateData());
    }

    private void readStateData() {
    }

    @Test
    public void givenWrongFileName_ShouldThrowNoSuchFileException() {
        CensusAnalyser stateCensusAnalyser = new CensusAnalyser("StateCensus.csv");
        try {
            int value = CensusAnalyser.readStateData();
            assertEquals(37, value);

        } catch (CSVCensusException e) {
            System.out.println(e.getMessage());
            assertEquals("Please enter proper file name", e.getMessage());
        }
    }
    @Test
    public void givenWrongFilePath_ShouldThrowRunTimeException() {
        try {
            CensusAnalyser stateCensusAnalyser = new CensusAnalyser("gradlew.bat");
            int checkNumberOfRecords =CensusAnalyser.readStateData();
            assertEquals(37, checkNumberOfRecords);

        } catch (CSVCensusException e) {
            e.printStackTrace();
            assertEquals("binding of file to failed", e.getMessage());
        }
    }
    @Test
    public void givenMethod_ifFoundIncorrectDelimiterPosition_ShouldReturnException() throws IOException, CSVCensusException {
        try {
            CensusAnalyser stateCensusAnalyser = new CensusAnalyser("StateCensus.csv");
            int value = CensusAnalyser.readStateData();
            assertEquals(37, value);
        } catch (CSVCensusException e) {
            System.out.println(e.getMessage());
            assertEquals("Exception due to incorrect delimiter position", e.getMessage());
        }
    }
    @Test
    public void givenMethod_ifFoundNoHeader_ShouldReturnException()
    {

        try {
            CensusAnalyser stateCensusAnalyser = new CensusAnalyser("StateCensus.csv");
            int value = CensusAnalyser.readStateData();
            assertEquals(37, value);
        }
        catch (CSVCensusException e)
        {
            System.out.println(e.getMessage());
            assertEquals("Exception due to Header", e.getMessage());
        }

    }

}
