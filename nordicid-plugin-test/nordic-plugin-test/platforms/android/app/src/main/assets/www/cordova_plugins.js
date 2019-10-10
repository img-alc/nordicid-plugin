cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "cordova-android-nordicid.NordicID",
      "file": "plugins/cordova-android-nordicid/www/NordicID.js",
      "pluginId": "cordova-android-nordicid",
      "clobbers": [
        "NordicID"
      ]
    }
  ];
  module.exports.metadata = {
    "cordova-plugin-whitelist": "1.3.4",
    "cordova-android-nordicid": "1.0.0"
  };
});