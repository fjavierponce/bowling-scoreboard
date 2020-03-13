package fponce.run;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fponce.domain.BowlingScoreboard;
import fponce.io.reader.ScoreInputReaderService;
import fponce.io.writer.ScoreOutputWriterService;
import fponce.domain.Shot;
import fponce.scoreboard.ScoreProcessorService;

@Component
class CommandLineAppStartupRunner implements CommandLineRunner {

    private ScoreInputReaderService reader;
    private ScoreOutputWriterService writer;
    private ScoreProcessorService scoreProcessorService;

    public CommandLineAppStartupRunner(ScoreInputReaderService reader,
                                       ScoreOutputWriterService writer,
                                       ScoreProcessorService scoreProcessorService) {
        this.reader = reader;
        this.writer = writer;
        this.scoreProcessorService = scoreProcessorService;
    }

    @Override
    public void run(String...args) {
        List<Shot> shots = reader.readScores();
        //writer.printScores(shots);
        List<String> players = reader.readPlayers();
        //writer.printPlayers(players);
        List<BowlingScoreboard> bowlingScoreboards = scoreProcessorService.calculateScores(players, shots);
        writer.printBoards(bowlingScoreboards);
    }

}
