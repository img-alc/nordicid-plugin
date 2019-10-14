package NordicIDPlugin;

import com.nordicid.nurapi.*;
import android.content.Context;
import org.apache.cordova.*;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class NordicID extends CordovaPlugin {
    private NurApi nurApi;
    private NurApiSocketAutoConnect autoConnect;
    private Context context;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        nurApi = new NurApi();
        context = this.cordova.getActivity().getApplicationContext();
        autoConnect = new NurApiSocketAutoConnect(context, nurApi);
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("setReadingStrength".equals(action)) {
            setReadingStrength(callbackContext, args.getInt(0));
        } else if ("getReadingStrength".equals(action)) {
            getReadingStrength(callbackContext);
            return true;
        } else if ("connectViaTCP".equals(action)) {
            connectViaTCP(callbackContext, args.getString(0));
            return true;
        }
        return false;
    }

    public void setReadingStrength(CallbackContext callbackContext, int level) {

        try {
            if (level >= 0 && level <= 19) {
                nurApi.setSetupTxLevel(level);
                callbackContext.success("Strength level set to " +  level);
            } else {
                callbackContext.error("Strength level must be between 0 and 19");
            }
        } catch (Exception e) {
            callbackContext.error(e.toString());
        }
    }

    private void getReadingStrength(CallbackContext callbackContext) {
        try {
            int currentLevel = nurApi.getSetupTxLevel();
            callbackContext.success("Strength level: " + currentLevel);
        } catch (Exception e) {
            callbackContext.error(e.toString());
        }
    }

    private void connectViaTCP(CallbackContext callbackContext, String hostname) {
        try {
            autoConnect.setAddress(hostname);
            callbackContext.success("Conenction started");
        } catch(Exception e) {
            callbackContext.error(e.toString());
        }

    }
}
