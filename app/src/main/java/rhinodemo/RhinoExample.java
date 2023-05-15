package rhinodemo;
 
import rhinodemo.ConsoleRunner;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;


/**
 * https://99x.io/blog/lets-build-your-own-server-side-javascript-run-time-with-rhino/
 */
public class RhinoExample {
    public static void main(String[] args) {
        String code =  "var a=[2,8,5]; a[1] + a[0];";
        // String code =  "var cr = new ConsoleRunner();"
        //         + " cr.exec('python --version');";
        try {
            Context cx = Context.enter();
            Scriptable scope = cx.initStandardObjects();
            ScriptableObject.defineClass(scope, ConsoleRunner.class);
            Object ob = cx.evaluateString(scope, code, "rhinodemojs", 1, null);
            System.out.println(Context.toObject(ob, scope));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}