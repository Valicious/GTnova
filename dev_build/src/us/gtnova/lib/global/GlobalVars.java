package us.gtnova.lib.global;

import processing.core.PApplet;
import us.gtnova.lib.utils.Property;

import java.util.HashMap;

/**
 * <h1> Global Variables</h1>
 * <p>A container that is accessible Application wide.</p>
 *
 * <h3>Usage</h3>
 * <p>
 *     GlobalVars.put("unique name", < any variable of any type >);
 *     <br/>
 *     GlobalVars.get("any name");
 * </p>
 *
 * <h3>Special Variables</h3>
 * <span style="font-style: italics;">Variables that will be access often at different places. Main purpose is to reduce casting.</span>
 * <p>getContext() --> gets the application context. aka ' this '</p>
 *
 * <h3>Methods</h3>
 * <table>
 *     <tr>
 *         <th>Method Name</th>
 *         <th>Description</th>
 *     </tr>
 *     <tr>
 *         <td>put</td>
 *         <td>Add variable to container</td>
 *     </tr>
 *     <tr>
 *         <td>get</td>
 *         <td>Gets variable from container</td>
 *     </tr>
 *     <tr>
 *         <td>getP</td>
 *         <td>Gets variable from container of type property</td>
 *     </tr>
 *     <tr>
 *         <td>clear</td>
 *         <td>Clears the container of all variables</td>
 *     </tr>
 *     <tr>
 *         <td>print</td>
 *         <td>Prints out a list of all the variables stored in the containers</td>
 *     </tr>
 *
 * </table>
 * @author gertp
 */
public class GlobalVars {
    private static HashMap<String, Object> list = new HashMap<>();

    static {
        put("printAllVars", print());
    }

    public static <G> boolean put(String name, G value) {
        return list.put(name, value) == null;
    }

    public static <G extends Object> G get(String name) {
        return (G) list.get(name);
    }

    public static Property<?> getP(String name) {
        Object value = list.get(name);
        if (value instanceof Property<?>)
            return (Property<?>) value;
        return null;
    }

    @Deprecated
    public static void clear() {
        list = new HashMap<>();
    }

    public static String print() {
        StringBuilder bob = new StringBuilder();
        list.forEach((key, value) -> bob.append(value.toString()).append("\n"));
        return bob.toString();
    }

    //Special variables

    public static PApplet getContext() {
        return (PApplet) getP("app").value();
    }

}
