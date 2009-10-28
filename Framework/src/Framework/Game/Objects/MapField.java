/*
 * MapField.java
 * 
 * Copyright (c) 2009 (KTeam).
 * All rights reserved.
 * 
 * http://batallanaval.kasbeel.cl
 * 
 * This file is part of BatallaNaval .
 * 
 * BatallaNaval  is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * BatallaNaval  is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with BatallaNaval .  If not, see <http://www.gnu.org/licenses/>.
 */
package Framework.Game.Objects;

/*************************************
 * Internal Import                   *
 *************************************/
import Framework.Game.Types.OrientationType;

/*************************************
 * External Import                   *
 *************************************/
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Kasbeel
 */
public class MapField implements Serializable {

    private ArrayList<GameObject> mapObjects;

    public MapField() {
        //Initialize objects container.
        mapObjects = new ArrayList<GameObject>();
    }

    /**
     *
     * @param Objs
     */
    public void addObject(GameObject Objs) {
        mapObjects.add(Objs);
    }

    /**
     *
     * @param Obj
     */
    public GameObject evalCollision(GameObject Obj) {
        Iterator<GameObject> itr = mapObjects.iterator();
        while (itr.hasNext()) {
            GameObject element = itr.next();
            if (element.getClass().getName().equals(Impact.class.getName())) {
            }
            if (element.getClass().getName().equals(Ship.class.getName())) {
                //If obj is a ship eval pos by pos to complete the size.
                if (Obj.getClass().getName().equals(Ship.class.getName())) {
                    Point currentPos = element.getPosition();
                    for (int pos = 0; pos < ((Ship) Obj).getSize(); pos++) {
                        //If the ship is PORTRAIT oriented increment x pos
                        if (((Ship) Obj).getOrietation() == OrientationType.PORTRAIT) {
                            currentPos.x++;
                        }
                        //If the ship is LANDSCAPE oriented increment y pos
                        if (((Ship) Obj).getOrietation() == OrientationType.LANDSCAPE) {
                            currentPos.y++;
                        }
                        //eval collision in current position if true return object.
                        if (((Ship) element).evalCollision(currentPos)) {
                            return element;
                        }
                    }
                } else { //else if a impact eval only actual pos.
                    if (((Ship) element).evalCollision(Obj.getPosition())) {
                        return element;
                    }
                }
            }
        }
        return null;
    }
}
