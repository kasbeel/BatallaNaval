/*
 * GameObject.java
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
import java.awt.Point;
/**
 *
 * @author Kasbeel
 */
public class GameObject {

    private String name;
	private java.awt.Point position;

	public GameObject(){
		        this.name="";
		        this.position= new Point(-1,-1);
	}

	/**
	 *
	 * @param name
	 * @param position
	 */
	public GameObject(String name, Point position){
		        this.name = name;
		        this.position = position;
	}

	public String getName(){
		return name;
	}

	public Point getPosition(){
		return position;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 *
	 * @param position 
	 */
	public void setPosition(Point position){
		this.position = position;
	}
}
