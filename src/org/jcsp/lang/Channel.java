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

package org.jcsp.lang;

import org.jcsp.util.ChannelDataStore;

/**
 * <p>This class provides static factory methods for constructing
 * various different types of channel objects. There are also methods
 * for constructing arrays of identical channels.
 * </p>
 *
 * <p>The current implementation constructs "safe" channels which have separate
 * delegate objects for their read and write ends. This stops a
 * <code>ChannelInput</code> from being cast into a <code>ChannelOutput</code>
 * object. The <code>StandardChannelFactory</code> class is used to construct the
 * channels.
 * </p>
 *
 * <p>Non-safe channels can be constructed by using an instance of the
 * <code>RiskyChannelFactory</code> class. The channels produced by this
 * factory have read and write ends implemented by the same object. This is
 * is more efficient (there are two less objects and delegate method calls)
 * but could lead to errors if users make incorrect casts.
 * </p>
 *
 * @author Quickstone Technologies Limited
 */
public class Channel
{

    /**
     * Private constructor to stop users from instantiating this class.
     */
    private Channel()
    {
        //this class should not be instantiated
    }

    /**
     * The factory to be used by this class. The class should implement
     * ChannelFactory, ChannelArrayFactory, BufferedChannelFactory and BufferedChannelArrayFactory.
     */
    private static final StandardChannelFactory factory = new StandardChannelFactory();


    /* Methods that are the same as the Factory Methods */

    /**
     * Constructs and returns a <code>One2OneChannel</code> object.
     *
     * @return the channel object.
     *
     * @see org.jcsp.lang.ChannelFactory#createOne2One()
     */
    public static One2OneChannel createOne2One()
    {
        return factory.createOne2One();
    }

    /**
     * Constructs and returns an <code>Any2OneChannel</code> object.
     *
     * @return the channel object.
     *
     * @see org.jcsp.lang.ChannelFactory#createAny2One()
     */
    public static Any2OneChannel createAny2One()
    {
        return factory.createAny2One();
    }

    /**
     * Constructs and returns a <code>One2AnyChannel</code> object.
     *
     * @return the channel object.
     *
     * @see org.jcsp.lang.ChannelFactory#createOne2Any()
     */
    public static One2AnyChannel createOne2Any()
    {
        return factory.createOne2Any();
    }

    /**
     * Constructs and returns an <code>Any2AnyChannel</code> object.
     *
     * @return the channel object.
     *
     * @see org.jcsp.lang.ChannelFactory#createAny2Any()
     */
    public static Any2AnyChannel createAny2Any()
    {
        return factory.createAny2Any();
    }

    /**
     * Constructs and returns an array of <code>One2OneChannel</code>
     * objects.
     *
     * @param	n	the size of the array of channels.
     * @return the array of channels.
     *
     * @see org.jcsp.lang.ChannelArrayFactory#createOne2One(int)
     */
    public static One2OneChannel[] createOne2One(int n)
    {
        return factory.createOne2One(n);
    }

    /**
     * Constructs and returns an array of <code>Any2OneChannel</code>
     * objects.
     *
     * @param	n	the size of the array of channels.
     * @return the array of channels.
     *
     * @see org.jcsp.lang.ChannelArrayFactory#createAny2One(int)
     */
    public static Any2OneChannel[] createAny2One(int n)
    {
        return factory.createAny2One(n);
    }

    /**
     * Constructs and returns an array of <code>One2AnyChannel</code>
     * objects.
     *
     * @param	n	the size of the array of channels.
     * @return the array of channels.
     *
     * @see org.jcsp.lang.ChannelArrayFactory#createOne2Any(int)
     */
    public static One2AnyChannel[] createOne2Any(int n)
    {
        return factory.createOne2Any(n);
    }

    /**
     * Constructs and returns an array of <code>Any2AnyChannel</code>
     * objects.
     *
     * @param	n	the size of the array of channels.
     * @return the array of channels.
     *
     * @see org.jcsp.lang.ChannelArrayFactory#createAny2Any(int)
     */
    public static Any2AnyChannel[] createAny2Any(int n)
    {
        return factory.createAny2Any(n);
    }

    /**
     * <p>Constructs and returns a <code>One2OneChannel</code> object which
     * uses the specified <code>ChannelDataStore</code> object as a buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @return the buffered channel.
     *
     * @see org.jcsp.lang.BufferedChannelFactory#createOne2One(ChannelDataStore)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static One2OneChannel createOne2One(ChannelDataStore buffer)
    {
        return factory.createOne2One(buffer);
    }

    /**
     * <p>Constructs and returns a <code>Any2OneChannel</code> object which
     * uses the specified <code>ChannelDataStore</code> object as a buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @return the buffered channel.
     *
     * @see org.jcsp.lang.BufferedChannelFactory#createAny2One(ChannelDataStore)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static Any2OneChannel createAny2One(ChannelDataStore buffer)
    {
        return factory.createAny2One(buffer);
    }

    /**
     * <p>Constructs and returns a <code>One2AnyChannel</code> object which
     * uses the specified <code>ChannelDataStore</code> object as a buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @return the buffered channel.
     *
     * @see org.jcsp.lang.BufferedChannelFactory#createOne2Any(ChannelDataStore)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static One2AnyChannel createOne2Any(ChannelDataStore buffer)
    {
        return factory.createOne2Any(buffer);
    }

    /**
     * <p>Constructs and returns a <code>Any2AnyChannel</code> object which
     * uses the specified <code>ChannelDataStore</code> object as a buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @return the buffered channel.
     *
     * @see org.jcsp.lang.BufferedChannelFactory#createAny2Any(ChannelDataStore)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static Any2AnyChannel createAny2Any(ChannelDataStore buffer)
    {
        return factory.createAny2Any(buffer);
    }

    /**
     * <p>Constructs and returns an array of <code>One2OneChannel</code> objects
     * which use the specified <code>ChannelDataStore</code> object as a
     * buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel. This is why an array of buffers is not required.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @param	n	    the size of the array of channels.
     * @return the array of buffered channels.
     *
     * @see org.jcsp.lang.BufferedChannelArrayFactory#createOne2One(ChannelDataStore, int)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static One2OneChannel[] createOne2One(ChannelDataStore buffer, int n)
    {
        return factory.createOne2One(buffer, n);
    }

    /**
     * <p>Constructs and returns an array of <code>Any2OneChannel</code> objects
     * which use the specified <code>ChannelDataStore</code> object as a
     * buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel. This is why an array of buffers is not required.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @param	n	    the size of the array of channels.
     * @return the array of buffered channels.
     *
     * @see org.jcsp.lang.BufferedChannelArrayFactory#createAny2One(ChannelDataStore, int)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static Any2OneChannel[] createAny2One(ChannelDataStore buffer, int n)
    {
        return factory.createAny2One(buffer, n);
    }

    /**
     * <p>Constructs and returns an array of <code>One2AnyChannel</code> objects
     * which use the specified <code>ChannelDataStore</code> object as a
     * buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel. This is why an array of buffers is not required.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @param	n	    the size of the array of channels.
     * @return the array of buffered channels.
     *
     * @see org.jcsp.lang.BufferedChannelArrayFactory#createOne2Any(ChannelDataStore, int)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static One2AnyChannel[] createOne2Any(ChannelDataStore buffer, int n)
    {
        return factory.createOne2Any(buffer, n);
    }

    /**
     * <p>Constructs and returns an array of <code>Any2AnyChannel</code> objects
     * which use the specified <code>ChannelDataStore</code> object as a
     * buffer.
     * </p>
     * <p>The buffer supplied to this method is cloned before it is inserted into
     * the channel. This is why an array of buffers is not required.
     * </p>
     *
     * @param	buffer	the <code>ChannelDataStore</code> to use.
     * @param	n	    the size of the array of channels.
     * @return the array of buffered channels.
     *
     * @see org.jcsp.lang.BufferedChannelArrayFactory#createAny2Any(ChannelDataStore, int)
     * @see org.jcsp.util.ChannelDataStore
     */
    public static Any2AnyChannel[] createAny2Any(ChannelDataStore buffer, int n)
    {
        return factory.createAny2Any(buffer, n);
    }

    /**
     * <p>Constructs and returns an array of input channel ends, each of which can be shared by multiple
     * concurrent readers. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].in ()</code> for <code>0 <= i < c.length</code>.
     * </p>
     *
     * @param c the array of channel to obtain input ends from.
     * @return the array of channel input ends.
     */
    public static SharedChannelInput[] getInputArray(Any2AnyChannel[] c)
    {
        SharedChannelInput[] in = new SharedChannelInput[c.length];
        for (int i = 0; i < c.length; i++)
            in[i] = c[i].in();
        return in;
    }

    /**
     * Constructs and returns an array of input channel ends, each of which can be used as guards
     * in an <code>Alternative</code>. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].in ()</code> for <code>0 <= i < c.length</code>.
     *
     * @param c the array of channel to obtain input ends from.
     * @return the array of channel input ends.
     */
    public static AltingChannelInput[] getInputArray(Any2OneChannel[] c)
    {
        AltingChannelInput[] in = new AltingChannelInput[c.length];
        for (int i = 0; i < c.length; i++)
            in[i] = c[i].in();
        return in;
    }

    /**
     * Constructs and returns an array of input channel ends, each of which can be shared by multiple
     * concurrent readers. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].in ()</code> for <code>0 <= i < c.length</code>.
     *
     * @param c the array of channel to obtain input ends from.
     * @return the array of channel input ends.
     */
    public static SharedChannelInput[] getInputArray(One2AnyChannel[] c)
    {
        SharedChannelInput[] in = new SharedChannelInput[c.length];
        for (int i = 0; i < c.length; i++)
            in[i] = c[i].in();
        return in;
    }

    /**
     * Constructs and returns an array of input channel ends, each of which can be used as guards
     * in an <code>Alternative</code>. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].in ()</code> for <code>0 <= i < c.length</code>.
     *
     * @param c the array of channel to obtain input ends from.
     * @return the array of channel input ends.
     */
    public static AltingChannelInput[] getInputArray(One2OneChannel[] c)
    {
        AltingChannelInput[] in = new AltingChannelInput[c.length];
        for (int i = 0; i < c.length; i++)
           in[i] = c[i].in();
        return in;
    }

    /**
     * Constructs and returns an array of output channel ends, each of which can be shared by multiple
     * concurrent writers. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].out ()</code> for <code>0 <= i < c.length</code>.
     *
     * @param c the array of channel to obtain output ends from.
     * @return the array of output input ends.
     */
    public static SharedChannelOutput[] getOutputArray(Any2AnyChannel[] c)
    {
        SharedChannelOutput[] in = new SharedChannelOutput[c.length];
        for (int i = 0; i < c.length; i++)
            in[i] = c[i].out();
        return in;
    }

    /**
     * Constructs and returns an array of output channel ends, each of which can be shared by multiple
     * concurrent writers. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].out ()</code> for <code>0 <= i < c.length</code>.
     *
     * @param c the array of channel to obtain output ends from.
     * @return the array of output input ends.
     */
    public static SharedChannelOutput[] getOutputArray(Any2OneChannel[] c)
    {
        SharedChannelOutput[] in = new SharedChannelOutput[c.length];
        for (int i = 0; i < c.length; i++)
            in[i] = c[i].out();
        return in;
    }

    /**
     * Constructs and returns an array of output channel ends, each of which can only be used by a
     * single writer. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].out ()</code> for <code>0 <= i < c.length</code>.
     *
     * @param c the array of channel to obtain output ends from.
     * @return the array of output input ends.
     */
    public static ChannelOutput[] getOutputArray(One2AnyChannel[] c)
    {
        ChannelOutput[] in = new ChannelOutput[c.length];
        for (int i = 0; i < c.length; i++)
            in[i] = c[i].out();
        return in;
    }

    /**
     * Constructs and returns an array of output channel ends, each of which can only be used by a
     * single writer. The returned array, <code>r</code>, is constructed such that
     * <code>r[i] = c[i].out ()</code> for <code>0 <= i < c.length</code>.
     *
     * @param c the array of channel to obtain output ends from.
     * @return the array of output input ends.
     */
    public static ChannelOutput[] getOutputArray(One2OneChannel[] c)
    {
        ChannelOutput[] in = new ChannelOutput[c.length];
        for (int i = 0; i < c.length; i++)
            in[i] = c[i].out();
        return in;
    }
}