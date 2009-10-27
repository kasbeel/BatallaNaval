/*
 * Ship.java
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
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Kasbeel
 */
public class Ship extends GameObject {

    private ArrayList<GameObject> impacts;
    private OrientationType orientation = OrientationType.NONE;
    private int size = 0;

    /**
     *
     * @param Name
     * @param Position
     * @param Orientation
     * @param Size
     */
    public Ship(String Name, Point Position, OrientationType Orientation, int Size) {
        super(Name, Position);
        this.orientation = Orientation;
        this.size = Size;
    }

    public Ship() {
        super();
        this.impacts = new ArrayList<GameObject>();
    }

    /**
     *
     * @param position
     */
    private Point adjustPosition(Point position) {
        position.x -= this.getPosition().x;
        position.y -= this.getPosition().y;
        return position;
    }

    /**
     *
     * @param Position
     */
    public boolean evalCollision(Point Position) {
        Point evalPoint = adjustPosition(Position);
        if (this.orientation == OrientationType.LANDSCAPE) {
            if ((evalPoint.x > 0) && (evalPoint.x < this.size)) {
                return true;
            }
        }
        if (this.orientation == OrientationType.PORTRAIT) {
            if ((evalPoint.y > 0) && (evalPoint.y < this.size)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param Obj
     */
    public void addImpact(Impact Obj){
        Obj.setPosition(adjustPosition(Obj.getPosition()));
        impacts.add(Obj);
    }

    public OrientationType getOrietation() {
        return orientation;
    }

    public int getSize() {
        return size;
    }

    /**
     *
     * @param Orientation
     */
    public void setOrietation(OrientationType Orientation) {
        this.orientation = Orientation;
    }

    /**
     *
     * @param Size
     */
    public void setSize(int Size) {
        this.size = Size;
    }
}
