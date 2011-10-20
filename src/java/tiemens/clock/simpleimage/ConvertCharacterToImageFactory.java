/*========================================================================
 * Clock.java
 * May 16, 2011 11:05:47 PM | ttiemens
 * Copyright (c) 2011 Tim Tiememsn
 *========================================================================
 * This file is part of ClockInJava.
 *
 *    ClockInJava is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    ClockInJava is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with ClockInJava.  If not, see <http://www.gnu.org/licenses/>.
 */
package tiemens.clock.simpleimage;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ConvertCharacterToImageFactory
{
    private static Logger logger = Logger.getLogger("ConvertCharacterToImageFactory");
    private static Color forBlack = Color.LIGHT_GRAY;
    private static Color forOther = Color.DARK_GRAY;
    
    public static enum Types
    {
        hand_26x31(null,            null),
        lcd_14x23("gray",           null),
        led_12x21__black("black",   forBlack),
        led_12x21__blue("blue",     forOther),
        led_12x21__green("green",   forOther),
        led_12x21__red("red",       forOther),
        led_12x21__white("white",   forOther),
        led_12x21__yellow("yellow", forOther),
        led_9x15__black("black",    forBlack),
        led_9x15__blue("blue",      forOther),
        led_9x15__green("green",    forOther),
        led_9x15__red("red",        forOther),
        led_9x15__white("white",    forOther),
        led_9x15__yellow("yellow",  forOther),
        small_6x9__black("black",   forBlack),
        small_6x9__white("white",   forOther);
        
        private final String extraPath;
        private final Color prefBackgroundColor;
        private Types(String inextra)
        {
        	this(inextra, null);
        }
        private Types(String inextra, Color pref)
        {
            extraPath = inextra;
        	prefBackgroundColor = pref;
        }
        
        public String getPath(final String prefix)
        {
            String extra = 
                    (getExtraPath() == null) 
                    ? "" 
                    : "/" + getExtraPath();
            String name = this.name();
            name = name.replaceAll("__.*", "");
            
            return prefix + name + extra;
        }
        public String getExtraPath()
        {
            return extraPath;
        }
        public Color getPreferBackgroundColor()
        {
        	return prefBackgroundColor;
        }
    }
    
    public static enum ImgSlot
    {
        zero("0"),
        one("1"),
        two("2"),
        three("3"),
        four("4"),
        five("5"),
        six("6"),
        seven("7"),
        eight("8"),
        nine("9"),
        blank(" ", "blk"),
        decimal(".", "dec"),
        negative("-", "neg"),
        positive("+", "pos"),
        colon(":", "sep");
        private final Character thechar;
        private final String filename;
        private ImgSlot(final String both)
        {
            this(both, both);
        }
        private ImgSlot(final String inTheChar,
                     final String inTheFileName)
        {
            thechar = inTheChar.charAt(0);
            filename = inTheFileName;
        }
        public Character getCharacter()
        {
            return thechar;
        }
        public String getFilename()
        {
            return filename;
        }
        
        public String getPath(final String prefix,
                              final Types type,
                              final String extension)
        {
            return type.getPath(prefix) + "/" + filename + extension;
        }
    }

    public static ConvertCharacterToImage getDefault()
    {
        //return privateCreate(Types.led_12x21__green);
        return privateCreate(Types.lcd_14x23);
    }
    
    public static ConvertCharacterToImage getHand26x31()
    {
        return privateCreate(Types.hand_26x31);
    }
    
    private static ConvertCharacterToImage privateCreate(final Types intype)
    {
        Map<Character, Image> map = new HashMap<Character, Image>();
        
        for (ImgSlot img : ImgSlot.values())
        {
            String path = img.getPath("images/", intype, ".gif");
            if (! new File(path).exists())
            {
                path = "src/" + path;
            }
            Image image = loadImage(path);
            
            logger.info("Image load [" + path + "] x=" + image.getWidth(null) + 
                        "  y=" + image.getHeight(null));
            
            map.put(img.getCharacter(), image);
        }
        
        ConvertCharacterToImage ret = 
        		new ConvertCharacterToImage(map,
        		                            intype.getPreferBackgroundColor());
        return ret;
    }

    private static Image loadImage(String path)
    {
        logger.info("Loading image: [" + path + "]");
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File(path));
            return img;
        }
        catch (IOException e) 
        {
            logger.severe("Failed to load image");
        }

        return null;
    }

    public static Iterator<ConvertCharacterToImage> iterateAll()
    {
        List<ConvertCharacterToImage> all = getAll();
        return all.iterator();
    }

    private static List<ConvertCharacterToImage> all;
    private static synchronized List<ConvertCharacterToImage> getAll()
    {
        if (all == null)
        {
            List<ConvertCharacterToImage> list = new ArrayList<ConvertCharacterToImage>();
            
            for (Types type : Types.values())
            {
                list.add(privateCreate(type));
            }
            all = list;
        }
        return all;
    }
}
