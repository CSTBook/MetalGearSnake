package Game;

import Utilities.Rendering.RenderObject;

public class GameObject {
    private RenderObject ro;
    private int id;
    private String objName;
    private int x, y;
    private int interactionType;
    private int tag;
    public GameObject(int id, String objName, int x, int y, String fileName,int layer, int interactionType, int tag) {
        this.id=id;
        this.objName=objName;
        this.x=x;
        this.y=y;
        this.interactionType=interactionType;
        this.tag=tag;
        this.ro = new RenderObject(x, y, fileName, id, layer);
    }

    public String toString() {
        return "Name: %s\nPos: (%d, %d)\nInteraction Type: %d\nTag: %d".formatted(this.objName, this.x, this.y , this.interactionType, this.tag);
    }

    //omg hi bestie all of this is such a slay for you
    //p.s. - im illiterate and do not know how to code :/
}
