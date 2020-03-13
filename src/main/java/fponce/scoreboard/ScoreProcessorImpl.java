package fponce.scoreboard;
import static fponce.domain.BowlingScoreboard.State.CONSECUTIVE_STRIKE;
import static fponce.domain.BowlingScoreboard.State.HALT_GAME;
import static fponce.domain.BowlingScoreboard.State.SECOND_SHOT_AFTER_STRIKE;
import static fponce.domain.BowlingScoreboard.State.PLAYING_FIRST_SHOT;
import static fponce.domain.BowlingScoreboard.State.PLAYING_SECOND_SHOT;
import static fponce.domain.BowlingScoreboard.State.PLAYING_STRIKE;
import static fponce.domain.BowlingScoreboard.State.PLAYING_SPARE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import fponce.domain.Shot;
import fponce.domain.BowlingScoreboard;

@Service
class ScoreProcessorImpl implements ScoreProcessorService {

    private Log log = LogFactory.getLog(ScoreProcessorImpl.class);

    @Override
    public List<BowlingScoreboard> calculateScores(List<String> players, List<Shot> shots) {
        List<BowlingScoreboard> results = new ArrayList<>();
        for (String player : players) {
            List<Shot> filteredScoresByPlayer = shots.stream()
                    .filter(score -> score.getName().equals(player))
                    .collect(Collectors.toList());

            results.add(calculateScoresForPlayer(player, filteredScoresByPlayer));
        }
        return results;
    }

    private BowlingScoreboard calculateScoresForPlayer(String player, List<Shot> filteredScoresByPlayer) {
        BowlingScoreboard board = new BowlingScoreboard(player);
        int firstShotInFrame = 0;
        int total = 0;
        for (Shot shot: filteredScoresByPlayer) {

            switch (board.getState()) {
                case PLAYING_FIRST_SHOT:
                    if (shot.getScore() == 10) { // STRIKE
                        board.setState(PLAYING_STRIKE);
                    } else {
                        firstShotInFrame = shot.getScore();
                        board.setState(PLAYING_SECOND_SHOT);
                    }
                    break;
                case PLAYING_SECOND_SHOT:
                    if (firstShotInFrame + shot.getScore() != 10) {
                        board.addFrame(firstShotInFrame + shot.getScore());
                        board.setState(PLAYING_FIRST_SHOT);
                    } else {
                        board.setState(PLAYING_SPARE);
                    }
                    break;
                case PLAYING_SPARE:
                    board.addFrame(10 + shot.getScore());
                    if(shot.getScore() != 10) {
                        firstShotInFrame = shot.getScore();
                        board.setState(PLAYING_SECOND_SHOT);
                    } else {
                        board.setState(PLAYING_STRIKE);
                    }
                    break;
                case PLAYING_STRIKE:
                    if(shot.getScore() == 10) {
                        //Consecutive strike
                        board.setState(CONSECUTIVE_STRIKE);
                    } else {
                        board.setState(SECOND_SHOT_AFTER_STRIKE);
                        firstShotInFrame = shot.getScore();
                    }
                    break;
                case SECOND_SHOT_AFTER_STRIKE:
                    // Second shot after strike, summing to strike
                    board.addFrame(10 + firstShotInFrame + shot.getScore());
                    if (firstShotInFrame + shot.getScore() == 10) {
                        board.setState(PLAYING_SPARE);
                    } else if(board.getCurrentFrame() <= 10){
                        board.addFrame(firstShotInFrame + shot.getScore());
                        board.setState(PLAYING_FIRST_SHOT);
                    }
                    break;
                case CONSECUTIVE_STRIKE:
                    // Add two strikes + shot
                    board.addFrame(20 + shot.getScore());
                    if (shot.getScore() != 10) {
                        firstShotInFrame = shot.getScore();
                        board.setState(SECOND_SHOT_AFTER_STRIKE);
                    }
                    break;
                default:
                    throw new RuntimeException("Error in game");
            }

        }
        return board;
    }
}
