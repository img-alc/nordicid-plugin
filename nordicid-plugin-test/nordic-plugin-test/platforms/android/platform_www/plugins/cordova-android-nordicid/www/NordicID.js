cordova.define("cordova-android-nordicid.NordicID", function(require, exports, module) {
var exec = require('cordova/exec');

exports.setReadingStrength = function (success, error, level) {
    exec(success, error, 'NordicID', 'setReadingStrength', level);
};

exports.getReadingStrength = function (success, error) {
    exec(success, error, 'NordicID', 'getReadingStrength', null);
};
});
