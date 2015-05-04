/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static Gfx.Artist.*;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Vovaxs
 */
public class Tile
{
    private float x;
    private float y;
    private float width;
    private float height;
    private Texture texture;
    private TileType type;
    private float SCALE;
    
    public Tile(int x, int y, int width, int height, TileType type, float SCALE)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = quickLoadTexture(type.textureName);
        this.SCALE = SCALE;
    }
    
    public void draw()
    {
       drawRectTexture(texture, x * SCALE, y * SCALE, width * SCALE, height * SCALE);
    }
    
    public float getX() {
        return x;
    }
    
    public int getXPos()
    {
        return (int) x / 64;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public int getYPos()
    {
        return (int) y / 64;
    }
    
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }
    
    
    
}
