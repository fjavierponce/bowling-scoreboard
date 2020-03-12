package fponce;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fponce.resource.loader.FileScoreInputReader;
import fponce.resource.loader.ScoreInputReader;
import fponce.resource.writter.ConsoleScoreOutputWriter;
import fponce.resource.writter.ScoreOutputWriter;
import fponce.scoreboard.entity.Score;
import fponce.scoreboard.entity.ScoreBoard;
import fponce.scoreboard.process.BowlingScoreboard;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        List scores = readFile();
        List players = readPlayers();
        BowlingScoreboard bowlingScoreboard = new BowlingScoreboard();
        Map<String, ScoreBoard> calculatedScores = bowlingScoreboard.process(scores);
        printScores(calculatedScores);
    }

    private static void printScores(Map<String, ScoreBoard> calculatedScores) {
        ScoreOutputWriter consoleScoreOutputWriter = new ConsoleScoreOutputWriter();
        calculatedScores.forEach(consoleScoreOutputWriter::printOnePlayerScore);
    }

    private static List<Score> readFile() {
        ScoreInputReader scoreInputReader = new FileScoreInputReader();
        System.out.println("Scores" + scoreInputReader.readScores());
        return scoreInputReader.readScores();
    }

    private static List<String> readPlayers() {
        ScoreInputReader scoreInputReader = new FileScoreInputReader();
        System.out.println("Players" + scoreInputReader.readPlayers());
        return scoreInputReader.readPlayers();
    }


}
