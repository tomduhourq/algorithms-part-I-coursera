package week01.optional;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SocialNetwork {

    private static final String path = "src/week01/optional/friendships.txt";

    public static void main(String[] args) {
        try {
            List<Log> logs = readLogs();
            int size = logs.stream().map(log -> Math.max(log.getUserA(), log.getUserB())).max(Integer::compare).get();
            WeightedQuickUnionUF uf = new WeightedQuickUnionUF(size + 1);
            for (Log log : logs) {
                uf.union(log.getUserA(), log.getUserB());
                if (uf.count() == 1) {
                    StdOut.println(String.format("%d is the minimum timestamp to which all friends were connected. Exiting...", log.getTimestamp()));
                    System.exit(0);
                }
            }
        }
        catch (IOException e){
            StdOut.println(String.format("Couldn't read file from path: ", path));
        }
    }

    private static List<Log> readLogs() throws IOException {
        return Files.lines(Paths.get(path)).
            filter(line ->
                !line.startsWith("#")).
            map(line -> {
                String[] parts = line.split("\\s+");
                return new Log(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            }).
            collect(Collectors.toList());
    }

    private static class Log {
        private long timestamp;
        private int userA;
        private int userB;

        public Log(long timestamp, int userA, int userB) {
            this.timestamp = timestamp;
            this.userA = userA;
            this.userB = userB;
        }

        @Override
        public String toString() {
            return "Log{" +
                    "timestamp=" + timestamp +
                    ", userA=" + userA +
                    ", userB=" + userB +
                    '}';
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getUserA() {
            return userA;
        }

        public void setUserA(int userA) {
            this.userA = userA;
        }

        public int getUserB() {
            return userB;
        }

        public void setUserB(int userB) {
            this.userB = userB;
        }
    }
}
