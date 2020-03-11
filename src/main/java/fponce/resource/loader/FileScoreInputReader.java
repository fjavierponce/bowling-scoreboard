package fponce.resource.loader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javafx.util.Pair;

public class FileScoreInputReader implements ScoreInputReader {

    @Override
    public List<Pair> readScores() {
        try {
            Path path = Paths.get("src/main/resources/scores.txt");
            List<String> data = Files.readAllLines(path);
            if (!data.isEmpty()) {
                List<Pair> orderedScores = data.stream().map(this::createPair).collect(Collectors.toList());
                return orderedScores;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Pair<String, Integer> createPair(String s) {
        String[] a = s.split(" ");
        String name = a[0];
        Integer score = "F".equals(a[1]) ? -1 : Integer.valueOf(a[1]);
        return new Pair<>(name, score);
    }
}
