    //////////////////////////////////////////////////////////////////////
    //                                                                  //
    //  JCSP ("CSP for Java") Libraries                                 //
    //  Copyright (C) 1996-2006 Peter Welch and Paul Austin.            //
    //                2001-2004 Quickstone Technologies Limited.        //
    //                                                                  //
    //  This library is free software; you can redistribute it and/or   //
    //  modify it under the terms of the GNU Lesser General Public      //
    //  License as published by the Free Software Foundation; either    //
    //  version 2.1 of the License, or (at your option) any later       //
    //  version.                                                        //
    //                                                                  //
    //  This library is distributed in the hope that it will be         //
    //  useful, but WITHOUT ANY WARRANTY; without even the implied      //
    //  warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR         //
    //  PURPOSE. See the GNU Lesser General Public License for more     //
    //  details.                                                        //
    //                                                                  //
    //  You should have received a copy of the GNU Lesser General       //
    //  Public License along with this library; if not, write to the    //
    //  Free Software Foundation, Inc., 59 Temple Place, Suite 330,     //
    //  Boston, MA 02111-1307, USA.                                     //
    //                                                                  //
    //  Author contact: P.H.Welch@ukc.ac.uk                             //
    //                                                                  //
    //                                                                  //
    //////////////////////////////////////////////////////////////////////

package org.jcsp.demos.missionControl;

import org.jcsp.lang.*;
import org.jcsp.awt.*;
import java.awt.*;
import org.jcsp.demos.util.Ask;

/**
 * @author P.H.Welch
 */
public class MissionControl {

  public static final String TITLE = "Mission Control";
  public static final String DESCR = "Demonstrates the handling of AWT button and timer events.";

  public static final int minStart = 10;
  public static final int maxStart = 1000;
  public static final int defaultStart = 300;

  public static final int minInterval = 10;
  public static final int maxInterval = 1000;
  public static final int defaultInterval = 10;

  public static void main(String[] args) {

  	Ask.app (TITLE, DESCR);
  	Ask.addPrompt ("start", minStart, maxStart, defaultStart);
  	Ask.addPrompt ("interval", minInterval, maxInterval, defaultInterval);
  	Ask.show ();
  	final int start = Ask.readInt ("start");
  	final int interval = Ask.readInt ("interval");
  	Ask.blank ();

    final ActiveClosingFrame activeClosingframe = new ActiveClosingFrame (TITLE);
    final ActiveFrame activeFrame = activeClosingframe.getActiveFrame ();
    final MissionControlNetwork net =
      new MissionControlNetwork (interval, start, activeFrame);

    activeFrame.pack ();
    activeFrame.setVisible (true);
    activeFrame.toFront ();

    new Parallel (
      new CSProcess[] {
        activeClosingframe,
        net
      }
    ).run ();

  }

}