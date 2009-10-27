/*
 * Impact.java
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
import Framework.Game.Types.ImpactState;

/*************************************
 * External Import                   *
 *************************************/
import java.awt.Point;

/**
 *
 * @author Kasbeel
 */
public class Impact  extends GameObject {

    private ImpactState state;

	public Impact(){
		super();
	}

	/**
	 *
	 * @param State
	 * @param Name
	 * @param Position
	 */
	public Impact(ImpactState State, String Name, Point Position){
		super(Name, Position);
		this.state = State;
	}

	/**
	 * Devuelve el estado en que se encuentra el impacto, SPLASH signica fallido y
	 * FIRE impacto acertado.
	 */
	public ImpactState getState(){
		return state;
	}

	/**
	 * Cambia o setea el estado del impacto, SPLASH es fallido y FIRE acertado.
	 *
	 * @param State
	 */
	public void setSate(ImpactState State){
		this.state=State;
	}
}
