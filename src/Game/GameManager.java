package Game;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class GameManager {
    private static ArrayList<GameObject> loadedObjs = new ArrayList<GameObject>();
    public static void loadObjs(int roomNum) throws FileNotFoundException {
        loadedObjs = new ArrayList<GameObject>();
        Scanner in  = new Scanner(new File("src/Resources/Rooms/"+roomNum));
        while (in.hasNextLine()) {
            loadedObjs.add(new GameObject(loadedObjs.size(), in.next(), in.nextInt(), in.nextInt(), in.next(), in.nextInt(), in.nextInt(), in.nextInt()));
        }
        for (GameObject g: loadedObjs) System.out.println(g.toString()+"\n\n");
    }

    public static void main(String[] args) throws FileNotFoundException {
        loadObjs(1);
    }
}
