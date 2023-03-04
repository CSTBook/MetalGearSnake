package Utilities.Rendering;

/**
 * Class designed to be used as part of the renderer to store information about how to render
 */
public class RenderObject {
    private int x, y;
    private String imageFileName;
    private int layer;
    private int id;



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param x X position on screen
     * @param y Y position on screen
     * @param fileName Location of image file to render
     * @param id Object id
     * @param layer Which layer to render image on (for layered rendering);
     *             0 is background, higher numbers mean the object is rendered above those on a lower layer
     */
    public RenderObject(int x, int y, String fileName, int id, int layer) {
        this.x=x;
        this.y=y;
        this.imageFileName=fileName;
        this.id=id;
        this.layer=layer;
    }

    /**
     * @param x X position on screen
     * @param y Y position on screen
     * @param fileName Location of image file to render
     * @param id Object id
     */
    public RenderObject(int x, int y, String fileName, int id) {
        this.x=x;
        this.y=y;
        this.imageFileName=fileName;
        this.id=id;
        this.layer=0;
    }
}
