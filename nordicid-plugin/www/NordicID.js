var exec = require('cordova/exec');

exports.setReadingStrength = function (success, error, level) {
    exec(success, error, 'NordicID', 'setReadingStrength', level);
};

exports.getReadingStrength = function (success, error) {
    exec(success, error, 'NordicID', 'getReadingStrength', null);
};

exports.setReadingStrength = function (success, error, hostname) {
    exec(success, error, 'NordicID', 'connectViaTCP', hostname);
};

