package handler;

import java.io.Closeable;

public interface SqlSession extends Closeable {

    <T> T selectOne(String statement);
}
