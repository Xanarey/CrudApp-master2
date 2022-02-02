import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public interface FileOperation {

    default <T> void create(T collection, String path) throws IOException {
        FileOutputStream f = new FileOutputStream(path);
        ObjectOutputStream s = new ObjectOutputStream(f);
        s.writeObject(collection);
        s.flush();
    }

    default <T> void save(T collection, String path) throws IOException {
        FileOutputStream f = new FileOutputStream(path);
        ObjectOutputStream s = new ObjectOutputStream(f);
        s.writeObject(collection);
        s.flush();
    }

}
