/**
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package tiemens.util.resources.antlr;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

public class InstancerCode
{
    public static Object create(final String command,
                                final String clzname,
                                final Object argobj)
    {
        Object ret;
        ret = new String("Instancer[cmd='" + command + 
                         "' clzname='" + clzname + 
                         "' arg='" + argobj + "']");

        if ("new".equals(command))
        {
            ret =  createNew(clzname, argobj);
        }
        
        return ret;
    }
    
    private static Object createNew(String clzname, 
                                    Object argobj) 
    {
        System.out.println("clzname='" + clzname + "'");
        System.out.println("argobj.class=" + argobj.getClass().getName());
        System.out.println("argobj=" + argobj);
        
        Object ret = null;
        try 
        {
            Class<?> c = Class.forName(clzname);
            Object[] parameters       = getParametersFromArgObj(argobj);
            Class<?>[] parameterTypes = getParameterTypesFromArgObj(parameters, argobj);
            
            
            Constructor<?> cons = getConstructor(c, parameterTypes);
            ret = cons.newInstance(parameters);
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("Could not find class '" + clzname + "'");
            ret = null;
        } 
        catch (SecurityException e) 
        {
            System.out.println("SecurityException on constructor for class '" + clzname + "'");
            ret = null;
        } 
        catch (NoSuchMethodException e) 
        {
            System.out.println("Could not find constructor for class '" + clzname + "'");
            ret = null;
        } catch (IllegalArgumentException e) 
        {
            System.out.println("Coulnd not invoke newInstance, IllegalArgument: " + e);
            ret = null;
        } catch (InstantiationException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return ret;
    }

    private static Constructor<?> getConstructor(Class<?> dclz,
                                                 Class<?>[] parameterTypes)
        throws NoSuchMethodException
    {
        Constructor<?> ret = null;
        try
        {
            ret = dclz.getConstructor(parameterTypes);
        } 
        catch (SecurityException e) 
        {
            throw e;
        }
        catch (NoSuchMethodException e) 
        {
            //
            // try to correct java.lang.Long into java.lang.Type.long
            //  i.e. Long to long
            //
            for (int i = 0, n = parameterTypes.length; i < n; i++)
            {
                Class<?> c = parameterTypes[i];
                if (c.equals(Long.class))
                {
                    c = java.lang.Long.TYPE;
                }
                else if (c.equals(Integer.class))
                {
                    c = java.lang.Integer.TYPE;
                }
                else if (c.equals(Double.class))
                {
                    c = java.lang.Double.TYPE;
                }
                else if (c.equals(java.lang.Float.class))
                {
                    c = java.lang.Float.TYPE;
                }
                parameterTypes[i] = c;
            }
            
            ret = dclz.getConstructor(parameterTypes);
        }
        finally
        {
            
        }
        return ret;
    }

    private static Object[] getParametersFromArgObj(Object argobj) 
    {
        List<Object> ret = new ArrayList<Object>();
        
        if (argobj instanceof Array)
        {
            
        }
        else
        {
            ret.add(argobj);
        }

            
        return ret.toArray(new Object[0]);
    }

    private static Class<?>[] getParameterTypesFromArgObj(Object[] parameters,
                                                          Object argobj) 
    {
        List<Class<?>> ret = new ArrayList<Class<?>>();
        for (Object p : parameters)
        {
            ret.add(p.getClass());
        }
        return ret.toArray(new Class[0]);
    }

    public static String unescape(final String input)
    {
        String ret = StringEscapeUtils.unescapeJava(input);
        
        return ret;
    }
}

