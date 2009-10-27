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

/**
 *
 * @author Kasbeel
 */
public class MapField {

    private ArrayList<GameObject> mapObjects;

    public MapField() {
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
                //If obj is a ship eval pos to pos.
                if (Obj.getClass().getName().equals(Ship.class.getName())) {
                    Point currentPos = element.getPosition();
                    if (((Ship) element).evalCollision(Obj.getPosition())) {
                        return element;
                    }
                }else{ //else if a impact eval only actual pos.
                    if (((Ship) element).evalCollision(Obj.getPosition())) {
                        return element;
                    }
                }
            }
        }
        return null;
    }
}
