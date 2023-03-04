package Utilities.Rendering;
import java.awt.*;
import java.util.ArrayList;
import Utilities.*;
public class Renderer {
    private static final int numObjs=99;
    private static ArrayList<RenderObject>[] renderObjects = new ArrayList[numObjs];
    private static SceneManager sm;
    /**
     * Enters a render object into the list of objects to render, sorted by layer
     * @param ro Render Object to add to list of objects
     */
    public static void addObject(RenderObject ro) {
        ArrayList<RenderObject> ros = renderObjects[ro.getLayer()];
        for (int i=0;i<renderObjects[ro.getLayer()].size();i++) {
            if (renderObjects[ro.getLayer()].get(i).getId()>ro.getId()) {
                renderObjects[ro.getLayer()].add(ro);
            }
        }
    }

    /**
     * Resets the list of objects to be rendering
     * Eg. When entering a new screen
     */
    public static void resetList() {
        renderObjects = new ArrayList[numObjs];
    }

    /**
     * Removes an object from list of objects to render
     * @param ro Object to remove from render list
     */
    public static void removeObject(RenderObject ro) {
        for (int i=0;i<renderObjects[ro.getLayer()].size(); i++) {
            if (renderObjects[ro.getLayer()].get(i)!=null&&renderObjects[ro.getLayer()].get(i).getId()==ro.getId()) {
                renderObjects[ro.getLayer()].remove(i);
                return;
            }
        }
    }

    /**
     * Removes an object from list of objects to render
     * @param layer Layer of object to remove from render list
     * @param id Id of object to remove from render list
     */
    public static void removeObject(int layer, int id) {
        for (int i=0;i<renderObjects[layer].size(); i++) {
            if (renderObjects[layer].get(i)!=null&&renderObjects[layer].get(i).getId()==id) {
                renderObjects[layer].remove(i);
                return;
            }
        }
    }

    public static void layeredRendering(Graphics2D win) {
        for (ArrayList<RenderObject> layer: renderObjects) {
            for (RenderObject obj: layer) {
                Misc.drawImage(obj.getImageFileName(), 1, obj.getX(), obj.getY(), win, sm);
            }
        }
    }

    public static void setSm(SceneManager sm) {
        Renderer.sm = sm;
    }
}
