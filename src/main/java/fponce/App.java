package fponce;

import fponce.resource.loader.FileScoreInputReader;
import fponce.resource.loader.ScoreInputReader;

public class App 
{

    public static void main( String[] args )
    {
        readFile();
    }

    private static void readFile() {
        ScoreInputReader scoreInputReader = new FileScoreInputReader();
        System.out.println(scoreInputReader.readScores());
    }


}
