/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Manager;

import Game.World.Level;
import Game.World.Entity.TileType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Vovaxs
 */
public class MapManager {

    private static String DEFAULT_FILE_PATH = "maps" + File.separator;
	private static BufferedReader bufferedReader;

    public static String getDEFAULT_FILE_PATH() {
        return DEFAULT_FILE_PATH;
    }

    public static void setDEFAULT_FILE_PATH(String DEFAULT_FILE_PATH) {
        MapManager.DEFAULT_FILE_PATH = DEFAULT_FILE_PATH;
    }

    public static void saveMap(String mapName, Level map) {
        String mapData = "";
        for (int i = 0; i < map.getMapWidth(); i++) {
            for (int j = 0; j < map.getMapHeight(); j++) {
                mapData += TileType.extractTileID(map.getTile(i, j));
                mapData += map.getTile(i, j).getAngleID();
            }
        }

        try {
            File file = new File(DEFAULT_FILE_PATH + mapName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(mapData);
            bw.close();
            System.out.println("File created in:" + file.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(MapManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static Level loadMap(String mapName) {
        Level map = new Level();
        try {
            bufferedReader = new BufferedReader(new FileReader(DEFAULT_FILE_PATH + mapName));
            String data = bufferedReader.readLine();
            for (int x = 0; x < map.getMapWidth(); x++) {
                for (int y = 0; y < map.getMapHeight(); y++) {
                    map.setTile(x, y, TileType.extractTileType(data.substring((x * 2) * map.getMapHeight() + (y * 2), (x * 2) * map.getMapHeight() + (y * 2) + 1)), data.substring((x * 2) * map.getMapHeight() + (y * 2) + 1, (x * 2) * map.getMapHeight() + (y * 2) + 2));
                }
            }
        } catch (Exception e) {
        }
        return map;
    }
}
